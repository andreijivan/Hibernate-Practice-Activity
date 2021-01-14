package database_CRUD;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import employee.Employee;

public class QuerryEmployees {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {
	
			session.beginTransaction();
	
			
			List<Employee> theEmployees = session.createQuery("from Employee e where e.company='LB'").getResultList();
			System.out.println("\n\n Employees who work at LB");
			displayEmployees(theEmployees);
			
			theEmployees = session.createQuery("from Employee e where e.company LIKE '%Worldwide'").getResultList();
			System.out.println("\n\n Employees who work at ACI");
			displayEmployees(theEmployees);
			
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
		}

	}
	private static void displayEmployees(List<Employee> employees) {
		for(Employee employee: employees) {
			System.out.println(employee);
		}
	}

}
