package com.ryr.models.services;

import java.util.List;

import com.ryr.models.entities.Categoria;

public interface I_Categoria_Service {

	public List<Categoria> listarTodo();
	
	public void guardar(Categoria categoria);
	
}
