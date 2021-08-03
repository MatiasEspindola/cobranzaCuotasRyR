package com.ryr.models.services;

import java.util.List;

import com.ryr.models.entities.Lista_Precio;
import com.ryr.models.entities.Producto_Lista;

public interface I_Producto_Lista_Service {

	public List<Producto_Lista> listarTodo();
	
	public List<Producto_Lista> buscarPorListaDePrecios(Lista_Precio lista_precio);
	
	public List<Producto_Lista> buscarPorTerm(String term);
	
}
