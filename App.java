package com.myDemoProject.HibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App {
	public static void main(String[] args) {
		StudentDemo obj = new StudentDemo();
		obj.setId(2);
		obj.setName("romsn");
		obj.setAge(20);
		obj.setRollno(54321);
		Configuration con = new Configuration().configure().addAnnotatedClass(StudentDemo.class);

		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();

		SessionFactory sf = con.buildSessionFactory(reg);

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.save(obj);

		tx.commit();

	}
}
