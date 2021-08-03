package com.ryr.models.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	private int cli_codigo;

	private String cod_postal;

	private String obs;

	private String email;

	private String razon_social;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha_alta;

	private boolean habilitado;

	private int iva_codigo;

	private String piso;

	private String dpto;

	private String telefono_1;

	private String telefono_2;

	private String direccion;

	private String nro_documento;

	@JoinColumn(name = "fkidlocalidadcliente", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	private Localidad fkidlocalidadcliente;

	@JoinColumn(name = "fkidtipocliente", referencedColumnName = "id_tipo_cliente")
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	private Tipo_Cliente fkidtipocliente;

	@JoinColumn(name = "fkidtipodocumento", referencedColumnName = "id_tipo_documento")
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	private Tipo_Documento fkidtipodocumento;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JoinColumn(name = "fkidclientelista")
	@JsonManagedReference
	@JsonIgnore
	private List<Lista_Precio_Cliente> fkidclientelista;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JoinColumn(name = "fkclicodigo")
	@JsonManagedReference
	@JsonIgnore
	private List<Factura> fkclicodigo;

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

	public Date getFecha_alta() {
		return fecha_alta;
	}

	public void setFecha_alta(Date fecha_alta) {
		this.fecha_alta = fecha_alta;
	}

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}

	public Tipo_Cliente getFkidtipocliente() {
		return fkidtipocliente;
	}

	public void setFkidtipocliente(Tipo_Cliente fkidtipocliente) {
		this.fkidtipocliente = fkidtipocliente;
	}

	public Localidad getFkidlocalidadcliente() {
		return fkidlocalidadcliente;
	}

	public void setFkidlocalidadcliente(Localidad fkidlocalidadcliente) {
		this.fkidlocalidadcliente = fkidlocalidadcliente;
	}

	public int getIva_codigo() {
		return iva_codigo;
	}

	public void setIva_codigo(int iva_codigo) {
		this.iva_codigo = iva_codigo;
	}

	public String getPiso() {
		return piso;
	}

	public void setPiso(String piso) {
		this.piso = piso;
	}

	public String getDpto() {
		return dpto;
	}

	public void setDpto(String dpto) {
		this.dpto = dpto;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNro_documento() {
		return nro_documento;
	}

	public void setNro_documento(String nro_documento) {
		this.nro_documento = nro_documento;
	}

	public Tipo_Documento getFkidtipodocumento() {
		return fkidtipodocumento;
	}

	public void setFkidtipodocumento(Tipo_Documento fkidtipodocumento) {
		this.fkidtipodocumento = fkidtipodocumento;
	}

	public int getCli_codigo() {
		return cli_codigo;
	}

	public void setCli_codigo(int cli_codigo) {
		this.cli_codigo = cli_codigo;
	}

	public String getCod_postal() {
		return cod_postal;
	}

	public void setCod_postal(String cod_postal) {
		this.cod_postal = cod_postal;
	}

	@JsonIgnore
	public List<Lista_Precio_Cliente> getFkidclientelista() {
		return fkidclientelista;
	}

	public void setFkidclientelista(List<Lista_Precio_Cliente> fkidclientelista) {
		this.fkidclientelista = fkidclientelista;
	}

	public List<Factura> getFkclicodigo() {
		return fkclicodigo;
	}

	public void setFkclicodigo(List<Factura> fkclicodigo) {
		this.fkclicodigo = fkclicodigo;
	}

}
