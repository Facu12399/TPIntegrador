package org.example.TPIntegrator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;

import org.example.entidad.Cliente;
import org.example.entidad.Especialidad;
import org.example.entidad.Incidente;
import org.example.entidad.Tecnico;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App 
{
    public static void main( String[] args )
    {
    	SessionFactory sessionFactory;
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        
    	Cliente cliente1= new Cliente();
    	cliente1.setCUIT("20-41818893-7");
    	cliente1.setNombre("Facundo");
    	cliente1.setApellido("Maza");
    	cliente1.setRazonSocial("IPPST");
    	
    	Cliente cliente2= new Cliente();
    	cliente2.setCUIT("20-40878899-5");
    	cliente2.setNombre("Silvia");
    	cliente2.setApellido("Brandan");
    	cliente2.setRazonSocial("OSDE");
    	
    	Cliente cliente3= new Cliente();
    	cliente3.setCUIT("20-35828948-2");
    	cliente3.setNombre("Arturo");
    	cliente3.setApellido("Terán");
    	cliente3.setRazonSocial("OSESAC");
    	
    	Especialidad especialidad1 = new Especialidad();
    	especialidad1.setNombre_especialidad("Computación");
    	especialidad1.setDuracion_carrera("3 años");
    	
    	Especialidad especialidad2 = new Especialidad();
    	especialidad2.setNombre_especialidad("Ing. Sistemas");
    	especialidad2.setDuracion_carrera("6 años");
    	
    	Especialidad especialidad3 = new Especialidad();
    	especialidad3.setNombre_especialidad("Tecnico en Virus");
    	especialidad3.setDuracion_carrera("3 años");
    	
    	Tecnico tecnico1 = new Tecnico();
    	tecnico1.setNombre("Carlos");
    	tecnico1.setApellido("Raymundo");
    	tecnico1.setEspecialidad(especialidad1);
    	
    	Tecnico tecnico2 = new Tecnico();
    	tecnico2.setNombre("Cesar");
    	tecnico2.setApellido("Olmos");
    	tecnico2.setEspecialidad(especialidad2);
    	
    	Tecnico tecnico3 = new Tecnico();
    	tecnico3.setNombre("Andres");
    	tecnico3.setApellido("Zelarayan");
    	tecnico3.setEspecialidad(especialidad3);
    	
    	java.util.Date fechaActual = new java.util.Date();
    	
    	Incidente incidente1 = new Incidente();
    	incidente1.setDescripcion("Falla en Software");
    	incidente1.setEspecialidadRequerida("Computacion");
    	incidente1.setFechaReporte(fechaActual);
    	incidente1.setTecnico(tecnico1);
    	
    	
    	Incidente incidente2 = new Incidente();
    	incidente2.setDescripcion("Problemas de licencias");
    	incidente2.setEspecialidadRequerida("Computacion");
    	incidente2.setFechaReporte(fechaActual);
    	incidente2.setTecnico(tecnico1);
    	
    	Incidente incidente3 = new Incidente();
    	incidente3.setDescripcion("Incompatibilidad de Windows");
    	incidente3.setEspecialidadRequerida("Ing. Sistemas");
    	incidente3.setFechaReporte(fechaActual);
    	incidente3.setTecnico(tecnico2);
    	
    	Incidente incidente4 = new Incidente();
    	incidente4.setDescripcion("Virus peligroso y maligno");
    	incidente4.setEspecialidadRequerida("Tecnico en Virus");
    	incidente4.setFechaReporte(fechaActual);
    	incidente4.setTecnico(tecnico3);
 
    	
    	HashSet<Cliente> listaClientes = new HashSet<Cliente>();
    	listaClientes.add(cliente1);
    	
    	HashSet<Cliente> listaClientes2 = new HashSet<Cliente>();
    	listaClientes2.add(cliente2);
    	
    	HashSet<Cliente> listaClientes3 = new HashSet<Cliente>();
    	listaClientes3.add(cliente3);
    	
    	incidente1.setListaClientes(listaClientes);
    	incidente2.setListaClientes(listaClientes);
    	incidente3.setListaClientes(listaClientes2);
    	incidente4.setListaClientes(listaClientes3);
    	
    	session.save(cliente1);
    	session.save(cliente2);
    	session.save(cliente3);
    	session.save(tecnico1);
    	session.save(tecnico2);
    	session.save(tecnico3);
    	session.save(incidente1);
    	session.save(incidente2);
    	session.save(incidente3);
    	session.save(incidente4);
    	
        session.getTransaction().commit();
        session.close();
        
        sessionFactory.close();

    	
    }
}
