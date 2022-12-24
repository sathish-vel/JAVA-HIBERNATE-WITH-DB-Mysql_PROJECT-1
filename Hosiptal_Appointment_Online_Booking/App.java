package com.Hibernate.Hosiptal.Mangement.system.Hospital_Booking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App {
	public static void main(String[] args) {

		List<Booking> booklist = new ArrayList<Booking>();
		System.out.println("\t***Hospital Online Appointment System***\n");
		int UserInp = 1;
		int count = 1;
		Scanner input = new Scanner(System.in);

		while (UserInp == 1) {
			System.out.println("Enter 1 to Book 0 to Exit : ");
			UserInp = input.nextInt();
			if (UserInp == 1) {
				System.out.println("Start with ID Number : " + count);
				count++;
				System.out.println("Enter Your ID: ");
				int id = input.nextInt();
				
				System.out.println("Enter Your Name : ");
				String name = input.next();
				
				System.out.println("Enter Your Date : ");
				String date = input.next();
				
				System.out.println("Enter Your Phone Number : ");
				long phno = input.nextLong();
				
				System.out.println("Enter Your Email Address : ");
				String email = input.next();
				
				
				input.nextLine();
				System.out.println("press 5 to confirm: ");
				int n = input.nextInt();
				if (n == 5) {
					booklist.add(new Booking(id, name,date,phno,email));

					Configuration con = new Configuration().configure().addAnnotatedClass(Booking.class);

					ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties())
							.buildServiceRegistry();

					SessionFactory sf = con.buildSessionFactory(reg);

					Session session = sf.openSession();

					session.beginTransaction();

					for (Booking booking : booklist)
						session.save(booking);
					System.out.println("Sucessfully Booked Your Appointment");

					session.getTransaction().commit();

				} else
					System.out.println("Your Booking Is Canceled.....");

			} else
				System.out.println("Thanks For Booking ......");
		}
		System.out.println("Records Of Appointment Patients  ");
		System.out.println(booklist);

	}
}
