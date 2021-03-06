package test.dao;
import java.util.List; 
import java.util.Date;
import java.util.Iterator; 

import org.hibernate.HibernateException; 
import org.hibernate.Query;
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
		   
		      tx = session.beginTransaction();
		      try{
		    	 TestUser tu = null;
		    	 
		    	 for(int i=1;i<=10;i++){
		    		 tu = new TestUser();
			    	 tu.setUsername("Sunil" + i);
			    	 session.save(tu);
			     }
		    	  
		         
		    	 //Query sel = session.createQuery("from TestUser where userid>0");
		    	 Query sel = session.getNamedQuery("TestUser.ByUserName");
		    	 sel.setString(0, "Sunil4");
		    	 //sel.setFirstResult(5);
		    	 //sel.setMaxResults(5);
		    	 List<TestUser> results = (List<TestUser>)sel.list();
		    	 //for (int i=0;i<results.size();i++) {
		    	for(TestUser u : results) {
		    		 //System.out.println("User Retrieved " + ((TestUser)results.get(i)).getUsername());
		    		System.out.println("User Retrieved " + u.getUsername());
		    	 }
		    	 
		    	 
		    	 tx.commit();
		         session.close();
		        
		         
		         
		      }catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      }
		     
	    
	
	      }
     
}