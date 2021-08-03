package com.ryr.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryr.models.entities.Cliente;
import com.ryr.models.entities.Lista_Precio_Cliente;
import com.ryr.models.repo.I_Lista_Precio_Cliente_Repo;

@Service
public class Impl_Lista_Precio_Cliente_Service implements I_Lista_Precio_Cliente_Service {

	@Autowired
	private I_Lista_Precio_Cliente_Repo lista_precio_cliente_Repo;
	
	@Override
	public List<Lista_Precio_Cliente> listarTodo() {
		// TODO Auto-generated method stub
		return (List<Lista_Precio_Cliente>) lista_precio_cliente_Repo.findAll();
	}

	@Override
	public void guardar(Lista_Precio_Cliente lista_precio_cliente) {
		// TODO Auto-generated method stub
		lista_precio_cliente_Repo.save(lista_precio_cliente);
	}

	@Override
	public List<Lista_Precio_Cliente> buscarPorCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		return lista_precio_cliente_Repo.buscarPorCliente(cliente);
	}

}
