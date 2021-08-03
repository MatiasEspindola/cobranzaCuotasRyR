package com.ryr.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryr.models.entities.Producto;
import com.ryr.models.entities.Proveedor;
import com.ryr.models.repo.I_Producto_Repo;

@Service
public class Impl_Producto_Service implements I_Producto_Service {

	@Autowired
	private I_Producto_Repo producto_Repo;

	@Override
	public List<Producto> listarTodo() {
		// TODO Auto-generated method stub
		return (List<Producto>) producto_Repo.findAll();
	}

	@Override
	public List<Producto> buscarPorTerm(String term) {
		// TODO Auto-generated method stub
		return producto_Repo.buscarPorTerm(term);
	}

}
