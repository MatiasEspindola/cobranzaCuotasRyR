package com.ryr.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ryr.models.entities.Cliente;
import com.ryr.models.entities.Factura;
import com.ryr.models.entities.ItemFactura;
import com.ryr.models.entities.Lista_Precio;
import com.ryr.models.entities.Lista_Precio_Cliente;
import com.ryr.models.entities.Producto;
import com.ryr.models.entities.Producto_Lista;
import com.ryr.models.entities.Producto_Tipo_Pago;
import com.ryr.models.entities.Tipo_Pago;
import com.ryr.models.entities.Tipo_Pago_Lista_Precio;
import com.ryr.models.services.I_Cliente_Service;
import com.ryr.models.services.I_Factura_Service;
import com.ryr.models.services.I_Lista_Precio_Cliente_Service;
import com.ryr.models.services.I_Lista_Precio_Service;
import com.ryr.models.services.I_Producto_Lista_Service;
import com.ryr.models.services.I_Producto_Service;
import com.ryr.models.services.I_Producto_Tipo_Pago_Service;
import com.ryr.models.services.I_Tipo_Pago_Lista_Precio_Service;

@Controller
@SessionAttributes("factura")
public class pdvController {

	@Autowired
	private I_Cliente_Service clienteService;

	@Autowired
	private I_Factura_Service facturaService;

	@Autowired
	private I_Producto_Service productoService;

	@Autowired
	private I_Lista_Precio_Service listaPrecioService;

	@Autowired
	private I_Lista_Precio_Cliente_Service listaPrecioClienteService;

	@Autowired
	private I_Producto_Lista_Service productoListaService;

	@Autowired
	private I_Producto_Tipo_Pago_Service productoTipoPagoService;

	@Autowired
	private I_Tipo_Pago_Lista_Precio_Service tipoPagoListaPrecioService;

	private static final Logger log = LoggerFactory.getLogger(pdvController.class);

	private Cliente cliente;

	private Lista_Precio lista_precio;

	private Tipo_Pago_Lista_Precio tipo_pago_lista_precio;

	// Cliente
	private boolean encontrado = false;

	private boolean cargarListaPrecioCliente = false;

	private boolean cargarTiposDePago = false;

	private boolean TipoDePagoCargado = false;

	private List<Lista_Precio_Cliente> lista_precio_cliente;

	private List<Tipo_Pago_Lista_Precio> tipos_pagos_lista_precio;

	// Necesario para Autocomplete
	@GetMapping(value = "/cargar_cliente/{term}", produces = { "application/json" })
	public @ResponseBody List<Cliente> cargarCliente(@PathVariable String term) {
		return clienteService.buscarPorTerm(term);
	}
	
	@GetMapping(value = "/ingresar_cliente/{id}", produces = { "application/json" })
	public @ResponseBody Cliente ingresarCliente(Integer id) {
		log.info("funciona");
		return clienteService.buscarPorCodCliente(id);
	}

	// Necesario para Autocomplete
	@GetMapping(value = "/cargar_producto/{term}", produces = { "application/json" })
	public @ResponseBody List<Producto_Lista> cargarProducto(@PathVariable String term) {

		List<Producto_Lista> lista_actualizada = new ArrayList<>();

		for (Producto_Lista p_l : productoListaService.buscarPorTerm(term)) {
			if (p_l.getFkidlistaprecioproducto().getNombre()
					.equals(tipo_pago_lista_precio.getFkIdListaPrecio().getNombre())) {
				log.info("Iguales");
				lista_actualizada.add(p_l);
			}
		}

		return lista_actualizada;
	}

	@GetMapping("/factura")
	public String facturaController(Model model) {

		Factura factura = new Factura();

		model.addAttribute("factura", factura);

		if (encontrado) {
			model.addAttribute("cliente", cliente);

			if (cargarListaPrecioCliente) {
				model.addAttribute("lista_precio_cliente", lista_precio_cliente);

				if (cargarTiposDePago) {
					model.addAttribute("lista_precio", lista_precio);
					model.addAttribute("tipos_pagos_lista_precio", tipos_pagos_lista_precio);

					if (TipoDePagoCargado) {
						model.addAttribute("TipoDePagoCargado", TipoDePagoCargado);
						model.addAttribute("tipo_pago_lista_precio", tipo_pago_lista_precio);
					}

				}

			}

		}

		return "factura";
	}

	@GetMapping("/cargar_tipo_de_pago")
	public String seleccionarTipoDePago(@RequestParam(name = "tipo_de_pago") Long id_tipo_pago) {

		this.tipo_pago_lista_precio = tipoPagoListaPrecioService.buscarPorId(id_tipo_pago);

		TipoDePagoCargado = true;

		return "redirect:/factura";
	}

	@GetMapping("/factura/{id_lista_precio}")
	public String cargarTiposDePago(@PathVariable long id_lista_precio, RedirectAttributes redirAttrs) {

		this.tipo_pago_lista_precio = null;

		TipoDePagoCargado = false;

		List<Tipo_Pago_Lista_Precio> tipos_pagos_lista_precio = tipoPagoListaPrecioService
				.buscarPorListaPrecio(listaPrecioService.buscarPorId(id_lista_precio));

		if (tipos_pagos_lista_precio.isEmpty()) {
			redirAttrs.addFlashAttribute("error", "Esta lista de precios no tiene cargado tipos de pago");
			cargarTiposDePago = false;
		} else {
			cargarTiposDePago = true;
			this.lista_precio = listaPrecioService.buscarPorId(id_lista_precio);
			this.tipos_pagos_lista_precio = tipos_pagos_lista_precio;
		}

		return "redirect:/factura";
	}

	@PostMapping("/factura")
	public String cargar_cliente(@RequestParam(name = "ingresar_cliente") String ingresar_cliente,
			RedirectAttributes redirAttrs) {

		if (ingresar_cliente.isEmpty()) {
			cliente = null;
			encontrado = false;
			redirAttrs.addFlashAttribute("no_encontrado", "Cliente no encontrado");
		} else {

			if (cliente != clienteService.buscarPorCodCliente(Integer.valueOf(ingresar_cliente))) {
				lista_precio = null;
				tipos_pagos_lista_precio = null;
				tipo_pago_lista_precio = null;
				cargarListaPrecioCliente = false;
				cargarTiposDePago = false;
				TipoDePagoCargado = false;
			}

			cliente = clienteService.buscarPorCodCliente(Integer.valueOf(ingresar_cliente));
			// Lista y Producto
			lista_precio_cliente = listaPrecioClienteService.buscarPorCliente(cliente);

			if (lista_precio_cliente.size() == 0) {
				redirAttrs.addFlashAttribute("error", "Este cliente no tiene asociado una lista de precios");
				return "redirect:/factura";
			} else {
				cargarListaPrecioCliente = true;
			}

			encontrado = true;
			redirAttrs.addFlashAttribute("encontrado", "Resultados desplegados con éxito");
		}

		return "redirect:/factura";
	}

	@PostMapping("/detalles_factura")
	public String guardarFactura(@Valid Factura factura,
			@RequestParam(name = "item_id[]", required = false) Integer[] itemId,
			@RequestParam(name = "cantidad[]", required = false) Integer[] cantidad, RedirectAttributes redirAttrs,
			SessionStatus status) {

		if (cliente == null || itemId == null || cantidad == null) {
			redirAttrs.addFlashAttribute("error", "¡Error!, Debe cargar al menos un producto");
			return "redirect:/factura";
		}

		for (int i = 0; i < itemId.length; i++) {
			Producto producto = facturaService.buscarProductoPorId(itemId[i]);

			ItemFactura linea = new ItemFactura();
			linea.setCantidad(cantidad[i]);
			linea.setFkprocodigo(producto);
			factura.addItemFactura(linea);

			log.info("ID: " + itemId[i].toString() + ", cantidad: " + cantidad[i].toString());
		}

		factura.setCliente(cliente);

		facturaService.guardar(factura);

		status.isComplete();
		redirAttrs.addFlashAttribute("success", "Factura creada con éxito");

		return "redirect:/factura";
	}

}
