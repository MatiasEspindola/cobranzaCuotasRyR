package com.ryr.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryr.models.entities.Lista_Precio;
import com.ryr.models.entities.Tipo_Pago_Lista_Precio;
import com.ryr.models.repo.I_Tipo_Pago_Lista_Precio_Repo;

@Service
public class Impl_Tipo_Pago_Lista_Precio_Service implements I_Tipo_Pago_Lista_Precio_Service {

	@Autowired
	private I_Tipo_Pago_Lista_Precio_Repo tipo_pago_lista_precio_Repo;
	
	@Override
	public List<Tipo_Pago_Lista_Precio> listarTodo() {
		// TODO Auto-generated method stub
		return (List<Tipo_Pago_Lista_Precio>) tipo_pago_lista_precio_Repo.findAll();
	}

	@Override
	public Tipo_Pago_Lista_Precio buscarPorId(long id) {
		// TODO Auto-generated method stub
		return tipo_pago_lista_precio_Repo.findById(id).orElse(null);
	}

	@Override
	public List<Tipo_Pago_Lista_Precio> buscarPorListaPrecio(Lista_Precio lista_precio) {
		// TODO Auto-generated method stub
		return tipo_pago_lista_precio_Repo.buscarPorListaPrecio(lista_precio);
	}

}
