package com.ryr.models.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ryr.models.entities.Lista_Precio;
import com.ryr.models.entities.Producto_Lista;

public interface I_Producto_Lista_Repo extends CrudRepository<Producto_Lista, Long> {

	@Query("Select p_l From Producto_Lista p_l where p_l.fkidlistaprecioproducto = ?1")
	public List<Producto_Lista> buscarPorListaDePrecios(Lista_Precio lista_precio);
	
	@Query("Select p_l From Producto_Lista p_l where p_l.fkidproductolista.descripcion like %?1% or p_l.fkidproductolista.pro_codigo like %?1%")
	public List<Producto_Lista> buscarPorTerm(String term);
	
}
