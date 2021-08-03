package com.ryr.models.services;

import java.util.List;

import com.ryr.models.entities.Lista_Precio;


public interface I_Lista_Precio_Service {

	public List<Lista_Precio> listarTodo();
	
	public Lista_Precio buscarPorId(long id);
	
}
