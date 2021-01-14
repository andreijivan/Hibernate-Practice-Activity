package database_CRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import employee.Employee;

public class CreateNewEmployee {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Creating new employee...");
			Employee tempEmployee = new Employee("Jivan", "Amalia", "ACI Worldwide");
			session.beginTransaction();
			session.save(tempEmployee);
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}finally {
			factory.close();
		}
		

	}

}
