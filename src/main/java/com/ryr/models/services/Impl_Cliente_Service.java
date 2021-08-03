package com.ryr.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryr.models.entities.Cliente;
import com.ryr.models.repo.I_Cliente_Repo;

@Service
public class Impl_Cliente_Service implements I_Cliente_Service{

	@Autowired
	private I_Cliente_Repo clienteRepo;
	
	@Override
	public List<Cliente> listarTodo() {
		// TODO Auto-generated method stub
		return (List<Cliente>) clienteRepo.findAll();
	}

	@Override
	public Cliente buscarPorId(int id) {
		// TODO Auto-generated method stub
		return clienteRepo.findById(id).orElse(null);
	}

	@Override
	public void borrar(Cliente cliente) {
		// TODO Auto-generated method stub
		clienteRepo.delete(cliente);
	}

	@Override
	public void guardar(Cliente cliente) {
		// TODO Auto-generated method stub
		clienteRepo.save(cliente);
	}

	@Override
	public List<Cliente> buscarPorTerm(String term) {
		// TODO Auto-generated method stub
		return clienteRepo.buscarPorTerm(term);
	}

	@Override
	public Cliente buscarPorCodCliente(int cli_codigo) {
		// TODO Auto-generated method stub
		return clienteRepo.buscarPorCodCliente(cli_codigo);
	}

}
