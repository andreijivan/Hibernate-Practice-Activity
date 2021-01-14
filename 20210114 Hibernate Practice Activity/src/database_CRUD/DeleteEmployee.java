package database_CRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import employee.Employee;

public class DeleteEmployee {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			
			int employeeId = 7; 
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			
			System.out.println("Deleting employee id = " + employeeId);
			session.createQuery("delete from Employee where id = " + employeeId).executeUpdate();
			
			session.getTransaction().commit();
			
			
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
		}

	}

}
