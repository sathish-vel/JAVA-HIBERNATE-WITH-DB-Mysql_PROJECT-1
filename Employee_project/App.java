package com.Hibernate.Emp.Employee;

import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App {
	public static void main(String[] args) {
		ArrayList<Employee> emp = new ArrayList<Employee>();
		emp.add(new Employee(1, "satz", 85000, 1234567));// adding the value using constructor and "Anonymous Object"with using ArrayList()
		emp.add(new Employee(2, "nandha", 95000, 456789));
		emp.add(new Employee(3, "roman", 85000, 568676));
		emp.add(new Employee(4, "captain", 85000, 8751445));

		ArrayList<Manager> mang = new ArrayList<Manager>();
		Manager m1 = new Manager(1, "satz");// adding the value using constructor and "Creating Object" with ArrayList()
		Manager m2 = new Manager(2, "roman");
		Manager m3 = new Manager(3, "captain");
		Manager m4 = new Manager(4, "vel");

		mang.add(m1);
		mang.add(m2);
		mang.add(m3);
		mang.add(m4);

		Configuration con = new Configuration().configure().addAnnotatedClass(Employee.class)
				.addAnnotatedClass(Manager.class);

		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();

		SessionFactory sf = con.buildSessionFactory(reg);

		Session session = sf.openSession();

		session.beginTransaction();

		// Function Of Manger Class::::::

		for (Manager manager : mang) {
			session.save(manager);
		}
		// update name using set method
		m1.setName("sathish vel");
		m2.setName("nandha kumar");

		session.saveOrUpdate(m1);
		session.saveOrUpdate(m2);

		// get manager object get method();
		Manager man = (Manager) session.get(Manager.class, 3);
		System.out.println(man);
		System.out.println("Manager ID : " + man.getId());
		System.out.println("Manager Name : " + man.getName());
		System.out.println("Manager Name : " + m4.getName());

		// Delete the manager object using delete() methoad
		Manager man1 = (Manager) session.get(Manager.class, 4);
		session.delete(man1);

		// Function Of Employee Class::::::

		// saving data to MySQl
		for (Employee e : emp)
			session.save(e);

		// printing Employee Details
		for (Employee e : emp)
			System.out.println(e);

		// Update Employee table by using Query
		Query q = session.createQuery("update Employee set name=:n where id=:i");
		q.setParameter("n", "sathish vel");
		q.setParameter("i", 1);
		q.executeUpdate();
		int n = 2;
		// Delete Employee table by using Query
		Query qry = session.createQuery("delete from Employee where id=1");
		qry.executeUpdate();

		session.getTransaction().commit();

	}
}
