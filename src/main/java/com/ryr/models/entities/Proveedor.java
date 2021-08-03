package com.ryr.models.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "proveedores")
public class Proveedor {

	@Id
	private long id_proveedor;

	private String obs;

	private String email;

	private String razon_social;

	private String telefono_1;

	private String telefono_2;

	private String cuit;

	private String direccion;

	private boolean habilitado;


	public long getId_proveedor() {
		return id_proveedor;
	}

	public void setId_proveedor(long id_proveedor) {
		this.id_proveedor = id_proveedor;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRazon_social() {
		return razon_social;
	}

	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}

	public String getTelefono_1() {
		return telefono_1;
	}

	public void setTelefono_1(String telefono_1) {
		this.telefono_1 = telefono_1;
	}

	public String getTelefono_2() {
		return telefono_2;
	}

	public void setTelefono_2(String telefono_2) {
		this.telefono_2 = telefono_2;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}

}
