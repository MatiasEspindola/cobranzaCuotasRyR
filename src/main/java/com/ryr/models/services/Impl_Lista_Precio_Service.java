package com.ryr.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryr.models.entities.Lista_Precio;
import com.ryr.models.repo.I_Lista_Precio_Repo;



@Service
public class Impl_Lista_Precio_Service implements I_Lista_Precio_Service {

	@Autowired
	private I_Lista_Precio_Repo lista_precio_Repo;
	
	@Override
	public List<Lista_Precio> listarTodo() {
		// TODO Auto-generated method stub
		return (List<Lista_Precio>) lista_precio_Repo.findAll();
	}

	@Override
	public Lista_Precio buscarPorId(long id) {
		// TODO Auto-generated method stub
		return lista_precio_Repo.findById(id).orElse(null);
	}

}
