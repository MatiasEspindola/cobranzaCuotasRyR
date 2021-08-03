package com.ryr.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryr.models.entities.Tipo_Documento;
import com.ryr.models.repo.I_Tipo_Documento_Repo;

@Service
public class Impl_Tipo_Documento_Service implements I_Tipo_Documento_Service{

	@Autowired
	private I_Tipo_Documento_Repo tipo_documento_Repo;
	
	@Override
	public List<Tipo_Documento> listarTodo() {
		// TODO Auto-generated method stub
		return (List<Tipo_Documento>) tipo_documento_Repo.findAll();
	}

	@Override
	public Tipo_Documento buscarPorId(long id) {
		// TODO Auto-generated method stub
		return tipo_documento_Repo.findById(id).orElse(null);
	}

	@Override
	public void borrar(Tipo_Documento tipo_documento) {
		// TODO Auto-generated method stub
		tipo_documento_Repo.delete(tipo_documento);
	}

	@Override
	public void guardar(Tipo_Documento tipo_documento) {
		// TODO Auto-generated method stub
		tipo_documento_Repo.save(tipo_documento);
	}

}
