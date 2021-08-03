package com.ryr.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryr.models.entities.Proveedor;
import com.ryr.models.repo.I_Proveedor_Repo;

@Service
public class Impl_Proveedor_Service implements I_Proveedor_Service {

	@Autowired
	private I_Proveedor_Repo proveedorRepo;
	
	@Override
	public List<Proveedor> listarTodo() {
		// TODO Auto-generated method stub
		return (List<Proveedor>) proveedorRepo.findAll();
	}

	@Override
	public Proveedor buscarPorId(long id) {
		// TODO Auto-generated method stub
		return proveedorRepo.findById(id).orElse(null);
	}

	@Override
	public void borrar(Proveedor proveedor) {
		proveedorRepo.delete(proveedor);
	}

	@Override
	public void guardar(Proveedor proveedor) {
		// TODO Auto-generated method stub
		proveedorRepo.save(proveedor);
	}

}
