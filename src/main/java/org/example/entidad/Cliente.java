package org.example.entidad;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="clientes")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String CUIT;
	
	private String nombre;
	private String apellido;
	private String razonSocial;
	
	public Cliente() {
		super();
	}

	public Cliente(String CUIT, String nombre, String apellido, String razonSocial) {
		super();
		CUIT = CUIT;
		this.nombre = nombre;
		this.apellido = apellido;
		this.razonSocial = razonSocial;
	}

	public String getCUIT() {
		return CUIT;
	}

	public void setCUIT(String CUIT) {
		this.CUIT = CUIT;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	@Override
	public String toString() {
		return "Cliente [CUIT=" + CUIT + ", nombre=" + nombre + ", apellido=" + apellido + ", razonSocial="
				+ razonSocial + "]";
	}
	

}
