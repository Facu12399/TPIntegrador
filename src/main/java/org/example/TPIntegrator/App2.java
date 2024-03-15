package org.example.TPIntegrator;

import java.util.ArrayList;
import java.util.List;

import org.example.dao.ConfigHibernate;
import org.example.entidad.Tecnico;
import org.example.entidad.Cliente;
import org.example.entidad.Especialidad;
import org.example.entidad.Incidente;
import org.hibernate.Session;
import org.hibernate.ejb.criteria.expression.function.LengthFunction;

public class App2 {

	public static void main(String[] args) {
		
		Punto_Uno_Incidentes_Resueltos();
		Punto_Dos_Tecnicos_Especialidad();
		Punto_Tres_Cantidad_De_Clientes();

	}
	
	public static void Punto_Uno_Incidentes_Resueltos() {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		System.out.println("1)");
		
		//Posible solución
		/*List<Object[]> listaIncTec = (List<Object[]>) session.createQuery("FROM Incidente inc INNER JOIN inc.tecnico").list();
		long cont = (long) session.createQuery("SELECT COUNT(tecnicoId) FROM Incidente GROUP BY tecnicoId").uniqueResult();
		
		for(Object[] objeto : listaIncTec) {
			Incidente incidente = (Incidente) objeto[0];
			Tecnico tecnico = (Tecnico) objeto[1];
					
			System.out.println("Nombre y Apellido: " + tecnico.getApellido() + ", " + tecnico.getApellido() + ". Incidentes resueltos: ");
			
		}*/
		//Solucion que me gusto
		List<Object[]> listaIncTec = (List<Object[]>) session.createQuery("SELECT t.nombre,t.apellido From Tecnico t GROUP BY t.nombre,t.apellido").list();
		
		//List<Tecnico> listaTecnicos = (List<Tecnico>) session.createQuery("FROM Tecnico").list();
		//long cont = (long) session.createQuery("SELECT COUNT(tecnicoId) FROM Incidente GROUP BY tecnicoId").uniqueResult();
		//for (Tecnico lista : listaTecnicos) {
			
		//	System.out.println(lista.getNombre() + ", " + lista.getApellido());
			
		//}
		/*
		String hola;
		for(Object[] list : listaIncTec) {
			String go = (String) list[0];
			String go2 = (String) list[1];
			hola = go;
			System.out.println(go + go2);
		}
		
		int x = 1;

		List<Long> incidentes_resueltos = (List<Long>) session.createQuery("SELECT COUNT(tecnicoId) FROM Incidente GROUP BY tecnicoId ").list();
		for(Long lis : incidentes_resueltos ) {
			System.out.println("El tecnico " + listaIncTec+  " resolvio " + lis);
		}
		*/
		int x = 0;
		List<Long> incidentes_resueltos = (List<Long>) session.createQuery("SELECT COUNT(tecnicoId) FROM Incidente GROUP BY tecnicoId ").list();
		for(Object[] objeto : listaIncTec) {
		System.out.println("Nombre y Apellido: " + objeto[0] + ", " + objeto[1] + ". Incidentes resueltos: " + incidentes_resueltos.get(x));
		x++;
		}

		ch.cerrarConexion();
		ch.cerrarSessionFactory();
	}
	
	public static void Punto_Dos_Tecnicos_Especialidad() {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		System.out.println("------------------------------------------------------------------");
		System.out.println("2)");
		
		List<Object[]> listaTecnicos = (List<Object[]>) session.createQuery("FROM Tecnico t INNER JOIN t.especialidad").list();
		//List<Long> count = (List<Long>) session.createQuery("SELECT COUNT(especialidad) FROM Tecnico GROUP BY especialidad").list();
		long cont = (long) session.createQuery("SELECT COUNT(especialidad) FROM Tecnico GROUP BY especialidad").uniqueResult(); 
		
		for(Object[] objeto : listaTecnicos) {
			Tecnico tecnico = (Tecnico) objeto[0];
			Especialidad especialidad = (Especialidad) objeto[1];
					
			System.out.println("La especialidad " + especialidad.getNombre_especialidad() + " tiene " + cont + " tecnico");
			
		}
		
		ch.cerrarConexion();
		ch.cerrarSessionFactory();
	}
	
	public static void Punto_Tres_Cantidad_De_Clientes() {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		
		long count = (long) session.createQuery("SELECT count(*) FROM Cliente").uniqueResult();
		System.out.println("------------------------------------------------------------------");
		System.out.println("3)");
		System.out.println("La cantidad de clientes es: " + count);
		
		ch.cerrarConexion();
		ch.cerrarSessionFactory();
	}

}
