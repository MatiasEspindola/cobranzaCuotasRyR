package com.ryr.models.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="facturas_items")
public class ItemFactura {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Integer cantidad;
	
	@JoinColumn(name = "fkprocodigo", referencedColumnName = "pro_codigo")
	@ManyToOne(fetch = FetchType.EAGER)
	private Producto fkprocodigo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	public Long calcularImporte() {
		return cantidad.longValue() * fkprocodigo.getPre_lista();
	}

	public Producto getFkprocodigo() {
		return fkprocodigo;
	}

	public void setFkprocodigo(Producto fkprocodigo) {
		this.fkprocodigo = fkprocodigo;
	}
	
}
