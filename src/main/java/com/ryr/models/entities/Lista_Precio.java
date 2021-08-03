package com.ryr.models.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="lista_precios")
public class Lista_Precio {

	@Id
	private long id_lista_precio;
	
	private String nombre;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha_desde;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha_hasta;
	
	private double importe;
	
	private double porcentaje;
	
	private boolean defecto;
	
	private double descuento;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JoinColumn(name = "fkidlista")
	@JsonIgnore
	private List<Lista_Precio_Cliente> listas_precios_clientes;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JoinColumn(name = "fkidlistatipopago")
	@JsonIgnore
	private List<Tipo_Pago_Lista_Precio> tipos_pagos_listas;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JoinColumn(name = "fkidlistaprecioproducto")
	@JsonIgnore
	private List<Producto_Lista> productos_listas;

	public long getId_lista_precio() {
		return id_lista_precio;
	}

	public void setId_lista_precio(long id_lista_precio) {
		this.id_lista_precio = id_lista_precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Date getFecha_desde() {
		return fecha_desde;
	}

	public void setFecha_desde(Date fecha_desde) {
		this.fecha_desde = fecha_desde;
	}

	public Date getFecha_hasta() {
		return fecha_hasta;
	}

	public void setFecha_hasta(Date fecha_hasta) {
		this.fecha_hasta = fecha_hasta;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}

	public boolean isDefecto() {
		return defecto;
	}

	public void setDefecto(boolean defecto) {
		this.defecto = defecto;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public List<Lista_Precio_Cliente> getListas_precios_clientes() {
		return listas_precios_clientes;
	}

	public void setListas_precios_clientes(List<Lista_Precio_Cliente> listas_precios_clientes) {
		this.listas_precios_clientes = listas_precios_clientes;
	}

	public List<Tipo_Pago_Lista_Precio> getTipos_pagos_listas() {
		return tipos_pagos_listas;
	}

	public void setTipos_pagos_listas(List<Tipo_Pago_Lista_Precio> tipos_pagos_listas) {
		this.tipos_pagos_listas = tipos_pagos_listas;
	}

	public List<Producto_Lista> getProductos_listas() {
		return productos_listas;
	}

	public void setProductos_listas(List<Producto_Lista> productos_listas) {
		this.productos_listas = productos_listas;
	}
	
}
