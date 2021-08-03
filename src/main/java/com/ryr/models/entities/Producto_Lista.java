package com.ryr.models.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="lista_productos")
public class Producto_Lista {

	@Id
	private long id_lista_producto;
	
	@JoinColumn(name = "fkidproductolista", referencedColumnName = "pro_codigo")
	@ManyToOne(fetch = FetchType.EAGER)
	private Producto fkidproductolista;
	
	@JoinColumn(name = "fkidlistaprecioproducto", referencedColumnName = "id_lista_precio")
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	private Lista_Precio fkidlistaprecioproducto;
	
	private long importe;
	
	private int cantidadminima;
	
	private String porcentaje;


	public long getId_lista_producto() {
		return id_lista_producto;
	}

	public void setId_lista_producto(long id_lista_producto) {
		this.id_lista_producto = id_lista_producto;
	}

	public Producto getFkidproductolista() {
		return fkidproductolista;
	}

	public void setFkidproductolista(Producto fkidproductolista) {
		this.fkidproductolista = fkidproductolista;
	}

	public Lista_Precio getFkidlistaprecioproducto() {
		return fkidlistaprecioproducto;
	}

	public void setFkidlistaprecioproducto(Lista_Precio fkidlistaprecioproducto) {
		this.fkidlistaprecioproducto = fkidlistaprecioproducto;
	}

	public long getImporte() {
		return importe;
	}

	public void setImporte(long importe) {
		this.importe = importe;
	}

	public int getCantidadminima() {
		return cantidadminima;
	}

	public void setCantidadminima(int cantidadminima) {
		this.cantidadminima = cantidadminima;
	}

	public String getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(String porcentaje) {
		this.porcentaje = porcentaje;
	}
	
}
