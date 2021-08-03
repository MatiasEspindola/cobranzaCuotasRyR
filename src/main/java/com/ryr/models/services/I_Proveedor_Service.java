package com.ryr.models.services;

import java.util.List;

import com.ryr.models.entities.Proveedor;

public interface I_Proveedor_Service {

	public List<Proveedor> listarTodo();

	public Proveedor buscarPorId(long id);

	public void borrar(Proveedor proveedor);

	public void guardar(Proveedor proveedor);

}
