package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Progama {

	public static void main(String[] args) {
		EntityManager em = entityManager();
		Pessoa p = extrair(em);
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		System.out.println("deletado");
	}

	private static void procurar() {
		EntityManager em = entityManager();
		Pessoa p = extrair(em);
		System.out.println(p);
		em.close();
	}

	private static Pessoa extrair(EntityManager em) {
		Pessoa p = em.find(Pessoa.class, 2);
		return p;
	}

	private static void salvarPessoa() {
		Pessoa p1 = new Pessoa(null, "Carlos", "carlos@gmail");
		Pessoa p2 = new Pessoa(null, "Marcos", "marcos@gmail");
		Pessoa p3 = new Pessoa(null, "Antonio", "antonio@gmail");
		EntityManager em = entityManager();
		em.getTransaction().begin();
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.getTransaction().commit();
		System.out.println("salvo");
	}

	private static EntityManager entityManager() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		return em;
	}

}
