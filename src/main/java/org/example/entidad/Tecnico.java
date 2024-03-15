package org.example.entidad;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tecnicos")
public class Tecnico implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int tecnicoId;
	private String nombre;
	private String apellido;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="especialidad")
	private Especialidad especialidad;
	

	public Tecnico() {
		super();
	}

	public Tecnico(int tecnicoId, String nombre, String apellido, Especialidad especialidad) {
		super();
		this.tecnicoId = tecnicoId;
		this.nombre = nombre;
		this.apellido = apellido;
		this.especialidad = especialidad;
	}
	
	

	public int getTecnicoId() {
		return tecnicoId;
	}

	public void setTecnicoId(int tecnicoId) {
		this.tecnicoId = tecnicoId;
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

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

}
