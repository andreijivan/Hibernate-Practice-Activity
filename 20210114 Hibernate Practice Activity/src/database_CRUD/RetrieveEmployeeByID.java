package database_CRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import employee.Employee;

public class RetrieveEmployeeByID {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			Employee employeeFromDB= session.get(Employee.class, 8);
			
			System.out.println(employeeFromDB);
			session.getTransaction().commit();
			
		} finally {
			session.close();
		}

	}

}
