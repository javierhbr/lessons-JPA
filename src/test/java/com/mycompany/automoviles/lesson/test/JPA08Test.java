package com.mycompany.automoviles.lesson.test;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import com.mycompany.demo.manytomany2.Curso;
import com.mycompany.demo.manytomany2.Profesor;
import com.mycompany.demo.util.JPAUtil;

public class JPA08Test {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();

		// 	Las entidades presentan 3 comportamientos
		//	MANAGED, REMOVED, DETACHED
		
		
		Profesor profesor1 = new Profesor("David Trezeguet");
		Profesor profesor2 = new Profesor("Arturo Fortaine");
		Profesor profesor3 = new Profesor("Nicolas Resking");
		Profesor profesor4 = new Profesor("Octavio Mitknau");
		Curso curso1 = new Curso("Algoritmia");
		Curso curso2 = new Curso("Circuitos Digitales");
		Curso curso3 = new Curso("Metodos numericos");

		profesor1.setCursos(Arrays.asList(curso1,curso2,curso3));
		profesor2.setCursos(Arrays.asList(curso1));
		profesor3.setCursos(Arrays.asList(curso1));
		profesor4.setCursos(Arrays.asList(curso1,curso2));
		curso1.setProfesores(Arrays.asList(profesor1,profesor2,profesor3,profesor4));
		curso2.setProfesores(Arrays.asList(profesor1,profesor4));
		curso3.setProfesores(Arrays.asList(profesor1));
		
		
		try {
			em.getTransaction().begin();
			em.persist(curso1);
			em.persist(curso2);
			em.persist(curso3);
			em.persist(profesor1);
			em.persist(profesor2);
			em.persist(profesor3);
			em.persist(profesor4);
			em.getTransaction().commit();
			em.getTransaction().begin();
			Profesor prof = em.find(Profesor.class, 2L);
			prof.setNombre("Julian");
			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.isOpen()) {
				em.getTransaction().rollback();
			}
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
		
	
	}
}
