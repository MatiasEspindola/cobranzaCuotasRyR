CREATE VIEW listas_precios AS
SELECT lista_precios_clientes.fkIdLista as 'lista_nro', clientes.razon_social,
	   lista_precios.nombre,
	   lista_precios.fecha_desde, lista_precios.fecha_hasta,
       lista_precios.descuento, lista_precios.porcentaje,
       lista_precios.importe, lista_precios.defecto
FROM lista_precios_clientes
LEFT JOIN clientes ON clientes.cli_codigo = lista_precios_clientes.cli_codigo
LEFT JOIN lista_precios ON lista_precios.id_lista_precio = lista_precios_clientes.fkIdLista;
