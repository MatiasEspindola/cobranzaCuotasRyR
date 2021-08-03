package com.ryr.models.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ryr.models.entities.Producto_Tipo_Pago;
import com.ryr.models.entities.Tipo_Pago;
import com.ryr.models.entities.Tipo_Pago_Lista_Precio;

public interface I_Producto_Tipo_Pago_Repo extends CrudRepository<Producto_Tipo_Pago, Long> {

	@Query("Select ptp From Producto_Tipo_Pago ptp where ptp.fkidtipopago = ?1")
	public List<Producto_Tipo_Pago> buscarPorTipoDePago(Tipo_Pago tipo_pago);
	
}
