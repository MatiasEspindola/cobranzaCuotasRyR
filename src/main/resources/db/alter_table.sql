alter table clientes add column fkIdTipoDocumento int null;
alter table clientes add constraint fkIdTipoDocumento foreign key
(fkIdTipoDocumento) references tipos_documentos(id_tipo_documento);

alter table clientes add column fkIdLocalidadCliente int null;
alter table clientes add constraint fkIdLocalidadCliente foreign key
(fkIdLocalidadCliente) references localidades(id);

alter table clientes add column fkIdTipoCliente int null;
alter table clientes add constraint fkIdTipoCliente foreign key
(fkIdTipoCliente) references tipos_clientes(id_tipo_cliente);

alter table productos add column fkIdFabricante int null;
alter table productos add constraint fkIdFabricante foreign key
(fkIdFabricante) references fabricantes(id_fabricante);

alter table productos add column fkIdCategoriaProducto int null;
alter table productos add constraint fkIdCategoriaProducto foreign key
(fkIdCategoriaProducto) references categorias_productos(id_categoria_producto);

alter table productos add column fkIdProveedor int null;
alter table productos add constraint fkIdProveedor foreign key
(fkIdProveedor) references proveedores(id_proveedor);

alter table categorias_productos add column fkIdCategoria int null;
alter table categorias_productos add constraint fkIdCategoria foreign key
(fkIdCategoria) references categorias(id_categoria);

alter table categorias_productos add column fkIdProducto int null;
alter table categorias_productos add constraint fkIdProducto foreign key
(fkIdProducto) references productos(pro_codigo);

alter table productos_tipos_pagos add column fkIdTipoPago int null;
alter table productos_tipos_pagos add constraint fkIdTipoPago foreign key
(fkIdTipoPago) references tipos_pagos(id_tipo_pago);

alter table productos_tipos_pagos add column fkIdProductoTipoPago int null;
alter table productos_tipos_pagos add constraint fkIdProductoTipoPago foreign key
(fkIdProductoTipoPago) references productos(pro_codigo);

alter table lista_productos add column fkIdListaPrecioProducto int null;
alter table lista_productos add constraint fkIdListaPrecioProducto foreign key
(fkIdListaPrecioProducto) references lista_precios(id_lista_precio);

alter table lista_productos add column fkIdProductoLista int null;
alter table lista_productos add constraint fkIdProductoLista foreign key
(fkIdProductoLista) references productos(pro_codigo);

-- EN FUTUROS SISTEMAS AGREGAR CLAVE FORANEA CLIENTE
alter table lista_precios_clientes add column fkIdLista int null;

alter table lista_precios_clientes add constraint fkIdLista foreign key
(fkIdLista) references lista_precios(id_lista_precio);

alter table lista_precios_clientes add constraint fkIdClienteLista foreign key
(fkIdClienteLista) references clientes(cli_codigo);

alter table tipos_pagos_lista_precios add column fkIdListaPrecio int null;
alter table tipos_pagos_lista_precios add column fkIdListaTipoPago int null;

alter table tipos_pagos_lista_precios add constraint fkIdListaPrecio foreign key
(fkIdListaPrecio) references lista_precios(id_lista_precio);
alter table tipos_pagos_lista_precios add constraint fkIdListaTipoPago foreign key
(fkIdListaTipoPago) references tipos_pagos(id_tipo_pago);

alter table facturas add column fkCliCodigo int null;
alter table facturas add constraint fkCliCodigo foreign key
(fkCliCodigo) references clientes(cli_codigo);

alter table facturas_items add column fkProCodigo int null;
alter table facturas_items add constraint fkProCodigo foreign key
(fkProCodigo) references productos(pro_codigo);

alter table facturas_items add column factura_id int null;
alter table facturas_items add constraint factura_id foreign key
(factura_id) references facturas(id_factura);


/*
alter table productos_tipos_pagos add constraint fkIdProductoLista foreign key
(fkIdProductoLista) references productos(id_producto);

alter table productos_tipos_pagos add constraint fkIdClienteLista foreign key
(fkIdClienteLista) references clientes(id_cliente);

*/
