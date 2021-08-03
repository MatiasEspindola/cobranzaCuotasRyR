package com.ryr.models.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="categorias_productos")
public class Categoria_Producto {

	@Id
	private long id_categoria_producto;
	
	@JoinColumn(name = "fkidcategoria", referencedColumnName = "id_categoria")
	@ManyToOne(fetch = FetchType.EAGER)
	private Categoria fkidcategoria;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JoinColumn(name = "fkidcategoriaproducto")
	@JsonManagedReference
	@JsonIgnore
	private List<Producto> productos;

	public long getId_categoria_producto() {
		return id_categoria_producto;
	}

	public void setId_categoria_producto(long id_categoria_producto) {
		this.id_categoria_producto = id_categoria_producto;
	}

	public Categoria getFkidcategoria() {
		return fkidcategoria;
	}

	public void setFkidcategoria(Categoria fkidcategoria) {
		this.fkidcategoria = fkidcategoria;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
}
