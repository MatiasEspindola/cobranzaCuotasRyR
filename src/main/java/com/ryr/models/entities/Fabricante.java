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
@Table(name = "fabricantes")
public class Fabricante {

	@Id
	private long id_fabricante;

	private int fab_codigo;

	private String descripcion;

	private String url_imagen;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JoinColumn(name = "fkidfabricante")
	@JsonManagedReference
	@JsonIgnore
	private List<Producto> productos;

	public long getId_fabricante() {
		return id_fabricante;
	}

	public void setId_fabricante(long id_fabricante) {
		this.id_fabricante = id_fabricante;
	}

	public int getFab_codigo() {
		return fab_codigo;
	}

	public void setFab_codigo(int fab_codigo) {
		this.fab_codigo = fab_codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUrl_imagen() {
		return url_imagen;
	}

	public void setUrl_imagen(String url_imagen) {
		this.url_imagen = url_imagen;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

}
