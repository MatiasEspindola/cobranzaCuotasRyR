package com.ryr.models.services;

import java.util.List;

import com.ryr.models.entities.Producto;

public interface I_Producto_Service {

	public List<Producto> listarTodo();
	
	public List<Producto> buscarPorTerm(String term);
	
}
