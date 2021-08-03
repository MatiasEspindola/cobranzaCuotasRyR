package com.ryr.models.services;

import java.util.List;

import com.ryr.models.entities.Categoria_Producto;

public interface I_Categoria_Producto_Service {

	public List<Categoria_Producto> listarTodo();
	
	public void guardar(Categoria_Producto categoria_producto);
	
}
