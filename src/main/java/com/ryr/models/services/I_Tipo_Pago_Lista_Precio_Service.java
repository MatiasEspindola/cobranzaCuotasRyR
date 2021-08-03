package com.ryr.models.services;

import java.util.List;

import com.ryr.models.entities.Lista_Precio;
import com.ryr.models.entities.Tipo_Pago_Lista_Precio;

public interface I_Tipo_Pago_Lista_Precio_Service {

	public List<Tipo_Pago_Lista_Precio> listarTodo();
	
	public Tipo_Pago_Lista_Precio buscarPorId(long id);
	
	public List<Tipo_Pago_Lista_Precio> buscarPorListaPrecio(Lista_Precio lista_precio);
	
}
