package com.ryr.models.services;

import java.util.List;

import com.ryr.models.entities.Tipo_Cliente;

public interface I_Tipo_Cliente_Service {

	public List<Tipo_Cliente> listarTodo();

	public Tipo_Cliente buscarPorId(long id);

	public void borrar(Tipo_Cliente tipo_cliente);

	public void guardar(Tipo_Cliente tipo_cliente);
	
}
