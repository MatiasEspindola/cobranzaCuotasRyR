package com.ryr.models.services;

import java.util.List;

import com.ryr.models.entities.Cliente;
import com.ryr.models.entities.Lista_Precio_Cliente;

public interface I_Lista_Precio_Cliente_Service {

	public List<Lista_Precio_Cliente> listarTodo();
	
	public List<Lista_Precio_Cliente> buscarPorCliente(Cliente cliente);
	
	public void guardar(Lista_Precio_Cliente lista_precio_cliente);
	
}
