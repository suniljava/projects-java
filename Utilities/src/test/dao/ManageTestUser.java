package test.dao;
import java.util.List; 
import java.util.Date;
import java.util.Iterator; 

import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import test.model.Address;
import test.model.Employee;
import test.model.FourWheeler;
import test.model.TestUser;
import test.model.TwoWheeler;
import test.model.Vehicle;

public class ManageTestUser {
   private static SessionFactory factory; 
	   public static void main(String[] args) {
		      try{
		         factory = new Configuration().configure().buildSessionFactory();
		      }catch (Throwable ex) { 
		         System.err.println("Failed to create sessionFactory object." + ex);
		         throw new ExceptionInInitializerError(ex); 
		      }
		      ManageTestUser ME = new ManageTestUser();
		      Session session = factory.openSession();
		      Transaction tx = null;
		   
		      
		      try{
		    	 
		    	 TestUser tu = new TestUser();
		    	 tu.setUsername("Sunil");
		         tx = session.beginTransaction();
		         session.save(tu);
		         tu.setUsername("Sunil - Still Persistent");
		        
		         
		         tx.commit();
		         session.close(); 
		         
		         tu.setUsername("Sunil - Detached");
		         
		         session = factory.openSession();
		         session.beginTransaction();
		         session.update(tu);
		         session.getTransaction().commit();
		         session.close();
		         
		         
		      }catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      }
		     
	    
	
	      }
     
}