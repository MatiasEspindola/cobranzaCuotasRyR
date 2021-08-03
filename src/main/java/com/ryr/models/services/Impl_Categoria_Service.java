package com.ryr.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryr.models.entities.Categoria;
import com.ryr.models.repo.I_Categoria_Repo;

@Service
public class Impl_Categoria_Service implements I_Categoria_Service {

	@Autowired
	private I_Categoria_Repo categoria_Repo;
	
	@Override
	public List<Categoria> listarTodo() {
		// TODO Auto-generated method stub
		return (List<Categoria>) categoria_Repo.findAll();
	}

	@Override
	public void guardar(Categoria categoria) {
		// TODO Auto-generated method stub
		categoria_Repo.save(categoria);
	}

	
	
}
