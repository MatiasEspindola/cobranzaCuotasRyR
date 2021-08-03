package com.ryr.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryr.models.entities.Factura;
import com.ryr.models.entities.Producto;
import com.ryr.models.repo.I_Factura_Repo;
import com.ryr.models.repo.I_Producto_Repo;

@Service
public class Impl_Factura_Service implements I_Factura_Service{

	@Autowired
	private I_Factura_Repo factura_Repo;
	
	@Autowired
	private I_Producto_Repo producto_Repo;
	
	@Override
	public List<Factura> listarTodo() {
		// TODO Auto-generated method stub
		return (List<Factura>) factura_Repo.findAll();
	}

	@Override
	public Factura buscarPorId(long id) {
		// TODO Auto-generated method stub
		return factura_Repo.findById(id).orElse(null);
	}

	@Override
	public void borrar(Factura factura) {
		// TODO Auto-generated method stub
		factura_Repo.delete(factura);
	}

	@Override
	public void guardar(Factura factura) {
		// TODO Auto-generated method stub
		factura_Repo.save(factura);
	}

	@Override
	public Producto buscarProductoPorId(Integer id_producto) {
		// TODO Auto-generated method stub
		return producto_Repo.findById(id_producto).orElse(null);
	}

}
