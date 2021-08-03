package com.ryr.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryr.models.entities.Producto_Tipo_Pago;
import com.ryr.models.entities.Tipo_Pago;
import com.ryr.models.entities.Tipo_Pago_Lista_Precio;
import com.ryr.models.repo.I_Producto_Tipo_Pago_Repo;

@Service
public class Impl_Producto_Tipo_Pago_Service implements I_Producto_Tipo_Pago_Service{

	@Autowired
	private I_Producto_Tipo_Pago_Repo producto_tipo_pago_Repo;

	@Override
	public List<Producto_Tipo_Pago> listarTodo() {
		// TODO Auto-generated method stub
		return (List<Producto_Tipo_Pago>) producto_tipo_pago_Repo.findAll();
	}

	@Override
	public List<Producto_Tipo_Pago> buscarPorTipoDePago(Tipo_Pago tipo_pago) {
		// TODO Auto-generated method stub
		return producto_tipo_pago_Repo.buscarPorTipoDePago(tipo_pago);
	}
	
	


}
