package com.ryr.models.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.data.annotation.Transient;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "productos")
public class Producto {

	@Id
	private int pro_codigo;

	private String pro_cod_bar;

	private String descripcion;

	private int cantidad;

	private int stock_actual;

	private String precio_costo;

	private String utilidad_v_efectivo;

	private String utilidad_v_lista;

	private String precio_neto;

	private String iva;

	private String pre_efectivo;
	
	private long pre_lista;

	private String pre_cta_cte;

	private int cant_minima;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha;

	private String perfil;

	private int SAsociado;

	private int baja;

	private int garantia;

	private int stock_service;

	private int stock_proveedor;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha_u_actualizacion;

	private boolean garantia_fabrica;

	private boolean garantia_compra;

	private boolean exige_serie;

	private boolean en_oferta;

	private String importe_descuento;

	private String porcentaje_descuento;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date descuento_desde;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date descuento_hasta;

	private String costodolares;

	private String dolarblue;

	@JoinColumn(name = "fkidfabricante", referencedColumnName = "id_fabricante")
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	private Fabricante fkidfabricante;

	@JoinColumn(name = "fkidcategoriaproducto", referencedColumnName = "id_categoria_producto")
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	private Categoria_Producto fkidcategoriaproducto;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JoinColumn(name = "fkidproductotipopago")
	@JsonManagedReference
	@JsonIgnore
	private List<Producto_Tipo_Pago> productos_tipos_pagos;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JoinColumn(name = "fkidproductolista")
	@JsonIgnore
	private List<Producto_Lista> productos_lista;

	public int getPro_codigo() {
		return pro_codigo;
	}

	public void setPro_codigo(int pro_codigo) {
		this.pro_codigo = pro_codigo;
	}

	public String getPro_cod_bar() {
		return pro_cod_bar;
	}

	public void setPro_cod_bar(String pro_cod_bar) {
		this.pro_cod_bar = pro_cod_bar;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getStock_actual() {
		return stock_actual;
	}

	public void setStock_actual(int stock_actual) {
		this.stock_actual = stock_actual;
	}

	public String getPrecio_costo() {
		return precio_costo;
	}

	public void setPrecio_costo(String precio_costo) {
		this.precio_costo = precio_costo;
	}

	public String getUtilidad_v_efectivo() {
		return utilidad_v_efectivo;
	}

	public void setUtilidad_v_efectivo(String utilidad_v_efectivo) {
		this.utilidad_v_efectivo = utilidad_v_efectivo;
	}

	public String getUtilidad_v_lista() {
		return utilidad_v_lista;
	}

	public void setUtilidad_v_lista(String utilidad_v_lista) {
		this.utilidad_v_lista = utilidad_v_lista;
	}

	public String getPrecio_neto() {
		return precio_neto;
	}

	public void setPrecio_neto(String precio_neto) {
		this.precio_neto = precio_neto;
	}

	public String getIva() {
		return iva;
	}

	public void setIva(String iva) {
		this.iva = iva;
	}

	public String getPre_efectivo() {
		return pre_efectivo;
	}

	public void setPre_efectivo(String pre_efectivo) {
		this.pre_efectivo = pre_efectivo;
	}

	public long getPre_lista() {
		return pre_lista;
	}

	public void setPre_lista(long pre_lista) {
		this.pre_lista = pre_lista;
	}

	public String getPre_cta_cte() {
		return pre_cta_cte;
	}

	public void setPre_cta_cte(String pre_cta_cte) {
		this.pre_cta_cte = pre_cta_cte;
	}

	public int getCant_minima() {
		return cant_minima;
	}

	public void setCant_minima(int cant_minima) {
		this.cant_minima = cant_minima;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public int getSAsociado() {
		return SAsociado;
	}

	public void setSAsociado(int sAsociado) {
		SAsociado = sAsociado;
	}

	public int getBaja() {
		return baja;
	}

	public void setBaja(int baja) {
		this.baja = baja;
	}

	public int getGarantia() {
		return garantia;
	}

	public void setGarantia(int garantia) {
		this.garantia = garantia;
	}

	public int getStock_service() {
		return stock_service;
	}

	public void setStock_service(int stock_service) {
		this.stock_service = stock_service;
	}

	public int getStock_proveedor() {
		return stock_proveedor;
	}

	public void setStock_proveedor(int stock_proveedor) {
		this.stock_proveedor = stock_proveedor;
	}

	public Date getFecha_u_actualizacion() {
		return fecha_u_actualizacion;
	}

	public void setFecha_u_actualizacion(Date fecha_u_actualizacion) {
		this.fecha_u_actualizacion = fecha_u_actualizacion;
	}

	public boolean isGarantia_fabrica() {
		return garantia_fabrica;
	}

	public void setGarantia_fabrica(boolean garantia_fabrica) {
		this.garantia_fabrica = garantia_fabrica;
	}

	public boolean isGarantia_compra() {
		return garantia_compra;
	}

	public void setGarantia_compra(boolean garantia_compra) {
		this.garantia_compra = garantia_compra;
	}

	public boolean isExige_serie() {
		return exige_serie;
	}

	public void setExige_serie(boolean exige_serie) {
		this.exige_serie = exige_serie;
	}

	public boolean isEn_oferta() {
		return en_oferta;
	}

	public void setEn_oferta(boolean en_oferta) {
		this.en_oferta = en_oferta;
	}

	public String getImporte_descuento() {
		return importe_descuento;
	}

	public void setImporte_descuento(String importe_descuento) {
		this.importe_descuento = importe_descuento;
	}

	public String getPorcentaje_descuento() {
		return porcentaje_descuento;
	}

	public void setPorcentaje_descuento(String porcentaje_descuento) {
		this.porcentaje_descuento = porcentaje_descuento;
	}

	public Date getDescuento_desde() {
		return descuento_desde;
	}

	public void setDescuento_desde(Date descuento_desde) {
		this.descuento_desde = descuento_desde;
	}

	public Date getDescuento_hasta() {
		return descuento_hasta;
	}

	public void setDescuento_hasta(Date descuento_hasta) {
		this.descuento_hasta = descuento_hasta;
	}

	public String getCostodolares() {
		return costodolares;
	}

	public void setCostodolares(String costodolares) {
		this.costodolares = costodolares;
	}

	public String getDolarblue() {
		return dolarblue;
	}

	public void setDolarblue(String dolarblue) {
		this.dolarblue = dolarblue;
	}

	public Fabricante getFkidfabricante() {
		return fkidfabricante;
	}

	public void setFkidfabricante(Fabricante fkidfabricante) {
		this.fkidfabricante = fkidfabricante;
	}

	public Categoria_Producto getFkidcategoriaproducto() {
		return fkidcategoriaproducto;
	}

	public void setFkidcategoriaproducto(Categoria_Producto fkidcategoriaproducto) {
		this.fkidcategoriaproducto = fkidcategoriaproducto;
	}

	public List<Producto_Tipo_Pago> getProductos_tipos_pagos() {
		return productos_tipos_pagos;
	}

	public void setProductos_tipos_pagos(List<Producto_Tipo_Pago> productos_tipos_pagos) {
		this.productos_tipos_pagos = productos_tipos_pagos;
	}

	public List<Producto_Lista> getProductos_lista() {
		return productos_lista;
	}

	public void setProductos_lista(List<Producto_Lista> productos_lista) {
		this.productos_lista = productos_lista;
	}

}
