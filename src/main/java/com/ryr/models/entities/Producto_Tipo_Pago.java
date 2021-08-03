package com.ryr.models.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="productos_tipos_pagos")
public class Producto_Tipo_Pago {

	@Id
	private long id_producto_tipo_pago;
	
	@JoinColumn(name = "fkidtipopago", referencedColumnName = "id_tipo_pago")
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	private Tipo_Pago fkidtipopago;
	
	@JoinColumn(name = "fkidproductotipopago", referencedColumnName = "pro_codigo")
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	private Producto fkidproductotipopago;

	public long getId_producto_tipo_pago() {
		return id_producto_tipo_pago;
	}

	public void setId_producto_tipo_pago(long id_producto_tipo_pago) {
		this.id_producto_tipo_pago = id_producto_tipo_pago;
	}

	public Tipo_Pago getFkidtipopago() {
		return fkidtipopago;
	}

	public void setFkidtipopago(Tipo_Pago fkidtipopago) {
		this.fkidtipopago = fkidtipopago;
	}

	public Producto getFkidproductotipopago() {
		return fkidproductotipopago;
	}

	public void setFkidproductotipopago(Producto fkidproductotipopago) {
		this.fkidproductotipopago = fkidproductotipopago;
	}
	
}
