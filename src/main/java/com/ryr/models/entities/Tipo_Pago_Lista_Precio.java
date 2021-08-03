package com.ryr.models.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tipos_pagos_lista_precios")
public class Tipo_Pago_Lista_Precio {
	
	@Id
	private long id_tipo_pago_lista_precio;
	
	@JoinColumn(name = "fkidlistaprecio", referencedColumnName = "id_lista_precio")
	@ManyToOne(fetch = FetchType.EAGER)
	private Lista_Precio fkIdListaPrecio;
	
	@JoinColumn(name = "fkidlistatipopago", referencedColumnName = "id_tipo_pago")
	@ManyToOne(fetch = FetchType.EAGER)
	private Tipo_Pago fkIdListaTipoPago;

	public long getId_tipo_pago_lista_precio() {
		return id_tipo_pago_lista_precio;
	}

	public void setId_tipo_pago_lista_precio(long id_tipo_pago_lista_precio) {
		this.id_tipo_pago_lista_precio = id_tipo_pago_lista_precio;
	}

	public Lista_Precio getFkIdListaPrecio() {
		return fkIdListaPrecio;
	}

	public void setFkIdListaPrecio(Lista_Precio fkIdListaPrecio) {
		this.fkIdListaPrecio = fkIdListaPrecio;
	}

	public Tipo_Pago getFkIdListaTipoPago() {
		return fkIdListaTipoPago;
	}

	public void setFkIdListaTipoPago(Tipo_Pago fkIdListaTipoPago) {
		this.fkIdListaTipoPago = fkIdListaTipoPago;
	}

}
