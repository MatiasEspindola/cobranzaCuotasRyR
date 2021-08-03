package com.ryr.models.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ryr.models.entities.Producto;

public interface I_Producto_Repo extends CrudRepository<Producto, Integer> {

	@Query("Select p From Producto p where p.descripcion like %?1% or p.pro_codigo like %?1%")
	public List<Producto> buscarPorTerm(String term);
	
}
