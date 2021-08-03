package com.ryr.models.services;

import java.util.List;

import com.ryr.models.entities.Cliente;

public interface I_Cliente_Service {
	
	public List<Cliente> buscarPorTerm(String term);
	
	public List<Cliente> listarTodo();
	
	public Cliente buscarPorId(Long id);
	
	public void borrar(Cliente cliente);
	
	public void guardar(Cliente cliente);
	
	public Cliente buscarPorCodCliente(int cli_codigo);
	
}
