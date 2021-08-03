package com.ryr.models.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryr.models.entities.Categoria_Producto;
import com.ryr.models.repo.I_Categoria_Producto_Repo;

@Service
public class Impl_Categoria_Producto_Service implements I_Categoria_Producto_Service {

	@Autowired
	private I_Categoria_Producto_Repo categoria_producto_Repo;

	@Override
	public List<Categoria_Producto> listarTodo() {
		// TODO Auto-generated method stub
		return (List<Categoria_Producto>) categoria_producto_Repo.findAll();
	}

	@Override
	public void guardar(Categoria_Producto categoria_producto) {
		// TODO Auto-generated method stub
		categoria_producto_Repo.save(categoria_producto);
	}
	
	

}
