package com.ryr.models.services;

import java.util.List;

import com.ryr.models.entities.Factura;
import com.ryr.models.entities.Producto;

public interface I_Factura_Service {
	
	public List<Factura> listarTodo();
	
	public Factura buscarPorId(long id);
	
	public void borrar(Factura factura);
	
	public void guardar(Factura factura);
	
	public Producto buscarProductoPorId(Integer id_producto);
	
}
