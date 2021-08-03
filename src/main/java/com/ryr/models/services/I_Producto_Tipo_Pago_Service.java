package com.ryr.models.services;

import java.util.List;

import com.ryr.models.entities.Producto_Tipo_Pago;
import com.ryr.models.entities.Tipo_Pago;
import com.ryr.models.entities.Tipo_Pago_Lista_Precio;

public interface I_Producto_Tipo_Pago_Service{

	public List<Producto_Tipo_Pago> listarTodo();
	
	public List<Producto_Tipo_Pago> buscarPorTipoDePago(Tipo_Pago tipo_pago);
	
}
