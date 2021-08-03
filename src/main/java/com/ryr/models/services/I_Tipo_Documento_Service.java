package com.ryr.models.services;

import java.util.List;

import com.ryr.models.entities.Tipo_Documento;

public interface I_Tipo_Documento_Service {

	public List<Tipo_Documento> listarTodo();

	public Tipo_Documento buscarPorId(long id);

	public void borrar(Tipo_Documento tipo_documento);

	public void guardar(Tipo_Documento tipo_documento);
	
}
