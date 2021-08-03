package com.ryr.models.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "lista_precios_clientes")
public class Lista_Precio_Cliente {

	@Id
	private long id_lista_precio_cliente;

	@JoinColumn(name = "fkidlista", referencedColumnName = "id_lista_precio")
	@ManyToOne(fetch = FetchType.EAGER)
	private Lista_Precio fkIdLista;
	
	@JoinColumn(name = "fkidclientelista", referencedColumnName = "cli_codigo")
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	private Cliente fkIdClienteLista;

	public long getId_lista_precio_cliente() {
		return id_lista_precio_cliente;
	}

	public void setId_lista_precio_cliente(long id_lista_precio_cliente) {
		this.id_lista_precio_cliente = id_lista_precio_cliente;
	}

	public Lista_Precio getFkIdLista() {
		return fkIdLista;
	}

	public void setFkIdLista(Lista_Precio fkIdLista) {
		this.fkIdLista = fkIdLista;
	}

	public Cliente getFkIdClienteLista() {
		return fkIdClienteLista;
	}

	public void setFkIdClienteLista(Cliente fkIdClienteLista) {
		this.fkIdClienteLista = fkIdClienteLista;
	}

}
