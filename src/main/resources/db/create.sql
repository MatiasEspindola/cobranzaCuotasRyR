drop database cobranzaCuotas;
create database cobranzaCuotas;
use cobranzaCuotas;

create table proveedores(
	id_proveedor int not null primary key auto_increment,
    obs varchar(255) null,
    email varchar(255) null,
    razon_social varchar(255) not null,
    telefono_1 varchar(255) not null,
    telefono_2 varchar(255) null,
	direccion varchar(255) not null,
    habilitado boolean not null
);

create table clientes(
	-- id_cliente int not null primary key auto_increment
    cli_codigo int not null primary key auto_increment,
    obs varchar(255) null,
    email varchar(255) null,
	razon_social varchar(255) not null,
    fecha_alta date not null,
    habilitado boolean not null,
    iva_codigo int not null,
    cod_postal varchar(255) not null,
	piso varchar(255) null,
    dpto varchar(255) null,
	telefono_1 varchar(255) not null,
    telefono_2 varchar(255) null,
    direccion varchar(255) not null,
    nro_documento varchar(255) not null
);

ALTER TABLE clientes MODIFY cli_codigo int not null;

create table tipos_clientes(
	id_tipo_cliente int not null primary key auto_increment,
    tipo_cliente varchar(255) not null,
    habilitado boolean not null
);

create table tipos_documentos(
	id_tipo_documento int not null primary key auto_increment,
    tipo_documento varchar(255) not null
);

create table fabricantes(
	id_fabricante int not null primary key auto_increment,
    fab_codigo int not null,
    descripcion varchar(255) not null,
    url_imagen varchar(255) null
);

alter table fabricantes add column habilitado boolean; 

create table productos(
    pro_codigo int not null primary key auto_increment,
    pro_cod_bar varchar(255),
    descripcion varchar(255) not null,
    cantidad int not null,
    stock_actual int not null,
    precio_costo long not null,
    utilidad_v_efectivo long not null,
    utilidad_v_lista long not null,
    precio_neto long not null,
    iva int not null,
    pre_efectivo long not null,
    pre_lista long not null,
    pre_cta_cte long null,
    cant_minima int not null,
    fecha date not null,
    perfin varchar(255) not null,
    SAsociado int not null,
    baja int not null,
    garantia int not null,
    stock_service int not null,
    stock_proveedor int not null,
    fecha_U_Actualizacion date not null,
    garantia_fabrica boolean not null,
    garantia_compra boolean not null,
    exite_serie boolean not null,
    en_oferta boolean not null,
    importe_descuento double not null,
    porcentaje_descuento double not null,
    descuento_desde date not null,
    descuento_hasta date not null,
    costodolares long not null,
    cotizacion long not null,
    dolarblue long not null
);


alter table productos add column utilidad_v_cta_cte long null; 
alter table productos add column stock_fallado long null; 
alter table productos add column disponible_pedido boolean; 
alter table productos add column es_bundle boolean; 
ALTER TABLE productos 
CHANGE perfin perfil varchar(255) not null;
ALTER TABLE productos 
CHANGE iva iva long not null;
ALTER TABLE productos 
CHANGE porcentaje_descuento porcentaje_descuento long not null;
ALTER TABLE productos 
CHANGE exite_serie exige_serie boolean;

ALTER TABLE productos 
CHANGE precio_neto precio_neto varchar(255);


create table categorias(
	id_categoria int not null primary key auto_increment,
    activo boolean not null,
    nombre varchar(255),
    descripcion varchar(255)
);

alter table categorias add column level_depth int null; 

create table categorias_productos(
	id_categoria_producto int not null primary key auto_increment
);

alter table categorias_productos add column pro_codigo int null; 
alter table categorias_productos add column id_categoria int null; 

create table tipos_pagos(
	id_tipo_pago int not null primary key auto_increment,
    nombre varchar(255) not null,
    porcentaje double not null,
    defecto boolean
);

create table productos_tipos_pagos(
	id_producto_tipo_pago int not null primary key auto_increment
);

-- alter table productos_tipos_pagos drop column pro_codigo; 
-- alter table productos_tipos_pagos drop column id_tipo_pago; 

create table lista_precios(
	id_lista_precio int not null primary key auto_increment,
    nombre varchar(255),
    fecha_desde date not null,
    fecha_hasta date not null,
    importe double not null,
    porcentaje double not null,
    defecto boolean,
    descuento double not null
);

create table tipos_pagos_lista_precios(
	id_tipo_pago_lista_precio int not null primary key auto_increment
);

create table lista_precios_clientes(
	id_lista_precio_cliente int not null primary key auto_increment
);

alter table lista_precios_clientes add column fkIdClienteLista int null;

create table lista_productos(
	id_lista_producto int not null primary key auto_increment
);

create table facturas(
	id_factura int not null primary key auto_increment,
    descripcion varchar(255) not null,
    observacion varchar(255) not null,
    createAt date not null
);

alter table facturas drop column createAt; 
alter table facturas add column create_at date null; 

create table facturas_items(
	id int not null primary key auto_increment,
    cantidad int not null
);

alter table facturas_items add column precio long null; 

-- alter table lista_productos drop column id_lista; 
-- alter table lista_productos drop column pro_codigo; 
alter table lista_productos add column importe long null; 
alter table lista_productos add column porcentaje long null; 
alter table lista_productos add column cantidadminima int null; 

-- INSERTS
insert into tipos_documentos(tipo_documento) values
("D.N.I"),
("L.C."),
("L.E."),
("C.I."),
("CUIT"),
("CUIL");

insert into tipos_clientes(tipo_cliente, habilitado) values
('MINORISTAS', 1),
('MAYORISTAS', 1);

select * from clientes;
select * from proveedores;
select * from categorias;
select * from lista_precios;
select * from lista_precios_clientes where fkIdCLienteLista = 12579;
select * from tipos_pagos;
select * from tipos_pagos_lista_precios;
-- select * from listas_precios;
select * from productos;
select * from lista_productos;

/*
UPDATE productos 
SET iva = REPLACE(iva,',','.')
WHERE pro_codigo > 0;
*/

/*
UPDATE productos 
SET pre_lista = REPLACE(pre_lista,',','.')
WHERE pro_codigo > 0;
*/

/*
UPDATE productos
SET pre_lista = 1.5
WHERE pro_codigo = 323;
*/

-- select * from lista_productos where fkIdListaPrecioProducto = 1;



-- select * from categorias;
-- select * from categorias_productos;
-- select * from productos_tipos_pagos;

-- delete from tipos_pagos_lista_precios where id_tipo_pago_lista_precio > 15;

-- delete from productos_tipos_pagos where id_producto_tipo_pago > 2403;

-- delete from lista_productos where id_lista_producto > 0;

-- delete from productos where pro_codigo > 0;

-- delete from categorias_productos where id_categoria_producto > 0;
-- select * from fabricantes;

-- delete from facturas_items where id > 0;
-- delete from facturas where id_factura > 0;
-- select * from facturas;
-- select * from facturas_items;
