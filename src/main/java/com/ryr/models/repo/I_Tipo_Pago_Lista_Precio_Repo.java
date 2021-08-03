package com.ryr.models.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ryr.models.entities.Lista_Precio;
import com.ryr.models.entities.Tipo_Pago_Lista_Precio;

public interface I_Tipo_Pago_Lista_Precio_Repo extends CrudRepository<Tipo_Pago_Lista_Precio, Long> {

	@Query("Select tplp From Tipo_Pago_Lista_Precio tplp where tplp.fkIdListaPrecio = ?1")
	public List<Tipo_Pago_Lista_Precio> buscarPorListaPrecio(Lista_Precio lista_precio);
	
}
