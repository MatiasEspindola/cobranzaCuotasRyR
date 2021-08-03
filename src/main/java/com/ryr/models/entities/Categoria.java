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

@Entity
@Table(name="categorias")
public class Categoria {

	@Id
	private long id_categoria;
	
	private boolean activo;
	
	private String nombre;
	
	private String descripcion;
	
	private int level_depth;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JoinColumn(name = "fkidcategoria")
	@JsonIgnore
	private List<Categoria_Producto> categorias_productos;

	public long getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(long id_categoria) {
		this.id_categoria = id_categoria;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getLevel_depth() {
		return level_depth;
	}

	public void setLevel_depth(int level_depth) {
		this.level_depth = level_depth;
	}

	public List<Categoria_Producto> getCategorias_productos() {
		return categorias_productos;
	}

	public void setCategorias_productos(List<Categoria_Producto> categorias_productos) {
		this.categorias_productos = categorias_productos;
	}
	
}
