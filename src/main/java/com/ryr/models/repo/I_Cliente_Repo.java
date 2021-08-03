package com.ryr.models.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ryr.models.entities.Cliente;

public interface I_Cliente_Repo extends CrudRepository<Cliente, Integer>{

	@Query("Select c From Cliente c where c.razon_social like %?1% or c.cli_codigo like %?1%")
	public List<Cliente> buscarPorTerm(String term);
	
	@Query("Select c From Cliente c where c.cli_codigo = ?1")
	public Cliente buscarPorCodCliente(int cli_codigo);
	
}
