package com.ryr.models.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "tipos_clientes")
public class Tipo_Cliente {

	@Id
	private long id_tipo_cliente;

	private String tipo_cliente;

	private boolean habilitado;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JoinColumn(name = "fkidtipocliente")
	@JsonManagedReference
	@JsonIgnore
	private List<Cliente> clientes;

	public long getId_tipo_cliente() {
		return id_tipo_cliente;
	}

	public void setId_tipo_cliente(long id_tipo_cliente) {
		this.id_tipo_cliente = id_tipo_cliente;
	}

	public String getTipo_cliente() {
		return tipo_cliente;
	}

	public void setTipo_cliente(String tipo_cliente) {
		this.tipo_cliente = tipo_cliente;
	}

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}

	@JsonIgnore
	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

}
