package org.example.entidad;

import java.io.Serializable;
import java.text.DateFormat;
import java.time.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="incidentes")
public class Incidente implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int incidenteId;
	private String descripcion;
	private Date fechaReporte;
	private String especialidadRequerida;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="tecnicoId")
	private Tecnico tecnico;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="incidentes_de_clientes",joinColumns= {@JoinColumn(name="incidenteId")},inverseJoinColumns={@JoinColumn(name="CUIT_cliente")})
	//primero pone el nombre de la tabla que se va a crear, luego la columna que da la primera relacion que sale de curso
	//y para finalizar la otra columna con la que se genera la relacion que sale de alumno
	private Set<Cliente> listaClientes = new HashSet<Cliente>();
	
	public Incidente() {
		super();
	}

	public Incidente(int incidenteId, String descripcion, Date fechaReporte, String especialidadRequerida,
			Tecnico tecnico) {
		super();
		this.incidenteId = incidenteId;
		this.descripcion = descripcion;
		this.fechaReporte = fechaReporte;
		this.especialidadRequerida = especialidadRequerida;
		this.tecnico = tecnico;
	}
	
	public Incidente(int incidenteId, String descripcion, Date fechaReporte, String especialidadRequerida,
			Tecnico tecnico, Set<Cliente> listaClientes) {
		super();
		this.incidenteId = incidenteId;
		this.descripcion = descripcion;
		this.fechaReporte = fechaReporte;
		this.especialidadRequerida = especialidadRequerida;
		this.tecnico = tecnico;
		this.listaClientes = listaClientes;
	}

	public Set<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(Set<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaReporte() {
		return fechaReporte;
	}

	public void setFechaReporte(Date fechaReporte) {
		this.fechaReporte = fechaReporte;
	}

	public String getEspecialidadRequerida() {
		return especialidadRequerida;
	}

	public void setEspecialidadRequerida(String especialidadRequerida) {
		this.especialidadRequerida = especialidadRequerida;
	}
	
	
}
