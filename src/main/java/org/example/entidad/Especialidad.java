package org.example.entidad;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="especialidad")
public class Especialidad {
	
	@Id
	private String nombre_especialidad;
	private String duracion_carrera;
	
	public Especialidad() {
		super();
	}

	public Especialidad(String nombre_especialidad, String duracion_carrera) {
		super();
		this.nombre_especialidad = nombre_especialidad;
		this.duracion_carrera = duracion_carrera;
	}

	public String getNombre_especialidad() {
		return nombre_especialidad;
	}

	public void setNombre_especialidad(String nombre_especialidad) {
		this.nombre_especialidad = nombre_especialidad;
	}

	public String getDuracion_carrera() {
		return duracion_carrera;
	}

	public void setDuracion_carrera(String duracion_carrera) {
		this.duracion_carrera = duracion_carrera;
	}
	
	
	
}
