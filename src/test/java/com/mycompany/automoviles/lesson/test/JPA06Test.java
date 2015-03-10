package com.mycompany.automoviles.lesson.test;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import com.mycompany.demo.onetomany2.AulaBi;
import com.mycompany.demo.onetomany2.EstudianteBi;
import com.mycompany.demo.util.JPAUtil;

public class JPA06Test {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();

		// Uso de one-to-many
		// Por cada relacion hay una tabla que se crea con JPA
		// para evitar eso debemos usar attributo 
		// @JoinColumn(name="foreign key dominated")
		// Ejemplo Bidireccional
		AulaBi aulabi1 = new AulaBi("Aula 101");
		EstudianteBi est1 = new EstudianteBi("Julio Rom�n");
		EstudianteBi est2 = new EstudianteBi("Facundo Rom�n");
		EstudianteBi est3 = new EstudianteBi("Claudia Rom�n");
		EstudianteBi est4 = new EstudianteBi("Julieta Rom�n");
		List<EstudianteBi> ests1 = Arrays.asList(est1,est2,est3,est4);
		
		aulabi1.setEstudiantes(ests1);
		est1.setAulaBi(aulabi1);
		est2.setAulaBi(aulabi1);
		est3.setAulaBi(aulabi1);
		est4.setAulaBi(aulabi1);
		
		try {
			em.getTransaction().begin();
			em.persist(est1);
			em.persist(est2);
			em.persist(est3);
			em.persist(est4);
			em.persist(aulabi1);
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
