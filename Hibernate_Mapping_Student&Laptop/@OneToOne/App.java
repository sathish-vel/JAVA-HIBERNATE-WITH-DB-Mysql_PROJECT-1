package com.myDemoProject.HibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App {
	public static void main(String[] args) {
		Laptop lap = new Laptop();
		lap.setId(101);
		lap.setLapName("HP");
		lap.setLapRam(8);

		Student student = new Student();
		student.setId(1);
		student.setAge(21);
		student.setName("satz");
		student.setRollno(12345);
		student.setLaptop(lap);//student having one Laptop "OneToOne Mapping"

		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class)
				.addAnnotatedClass(Laptop.class);

		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();

		SessionFactory sf = con.buildSessionFactory(reg);

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.save(student);
		session.save(lap);

		tx.commit();

	}
}
