package com.ryr.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryr.models.entities.Lista_Precio;
import com.ryr.models.entities.Producto_Lista;
import com.ryr.models.repo.I_Producto_Lista_Repo;

@Service
public class Impl_Producto_Lista_Service implements I_Producto_Lista_Service {

	@Autowired
	private I_Producto_Lista_Repo producto_lista_Repo;
	
	@Override
	public List<Producto_Lista> listarTodo() {
		// TODO Auto-generated method stub
		return (List<Producto_Lista>) producto_lista_Repo.findAll();
	}

	@Override
	public List<Producto_Lista> buscarPorListaDePrecios(Lista_Precio lista_precio) {
		// TODO Auto-generated method stub
		return producto_lista_Repo.buscarPorListaDePrecios(lista_precio);
	}

	@Override
	public List<Producto_Lista> buscarPorTerm(String term) {
		// TODO Auto-generated method stub
		return producto_lista_Repo.buscarPorTerm(term);
	}

}
