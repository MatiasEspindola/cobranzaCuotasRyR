package com.ryr.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryr.models.entities.Tipo_Cliente;
import com.ryr.models.repo.I_Tipo_Cliente_Repo;

@Service
public class Impl_Tipo_Cliente_Service implements I_Tipo_Cliente_Service {

	@Autowired
	private I_Tipo_Cliente_Repo tipo_cliente_Repo;
	
	@Override
	public List<Tipo_Cliente> listarTodo() {
		// TODO Auto-generated method stub
		return (List<Tipo_Cliente>) tipo_cliente_Repo.findAll();
	}

	@Override
	public Tipo_Cliente buscarPorId(long id) {
		// TODO Auto-generated method stub
		return tipo_cliente_Repo.findById(id).orElse(null);
	}

	@Override
	public void borrar(Tipo_Cliente tipo_cliente) {
		// TODO Auto-generated method stub
		tipo_cliente_Repo.delete(tipo_cliente);
	}

	@Override
	public void guardar(Tipo_Cliente tipo_cliente) {
		// TODO Auto-generated method stub
		tipo_cliente_Repo.save(tipo_cliente);
	}

}
