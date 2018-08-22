package com.demo.spring;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class MyJpaRunner implements CommandLineRunner {

	@PersistenceContext
	EntityManager em;

	@Override
	public void run(String... args) throws Exception {
		Emp e = findOne(104);
		System.out.println(e.getName());
		try {
//			e = findOne(109);
				Emp e2 = new Emp(1201, "VV", "Chennai", 1220);
				System.out.println("========>"+saveEmp(e2));
			
		} catch (Exception exp) {			
			exp.printStackTrace();

		}

	}

	public Emp findOne(int id) {
		Emp e = em.find(Emp.class, id);
		if (e == null) {
			throw new RuntimeException("No such employee");
		}
		return e;
	}

	public List<Emp> getAll() {
		Query query = em.createQuery("select e from Emp e");
		return query.getResultList();

	}

	public String saveEmp(Emp e) {
		String res = "";
		try {
			em.persist(e);
			res = "Saved";
		} catch (Exception exp) {
			res = "Failed";
			throw new RuntimeException("Error in saving the data..");
		}
		return res;
	}

}
