package com.ryr.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryr.models.entities.Localidad;
import com.ryr.models.repo.I_Localidad_Repo;

@Service
public class Impl_Localidad_Service implements I_Localidad_Service {

	@Autowired
	private I_Localidad_Repo localidadRepo;
	
	@Override
	public List<Localidad> listarTodo() {
		// TODO Auto-generated method stub
		return (List<Localidad>) localidadRepo.findAll();
	}

}
