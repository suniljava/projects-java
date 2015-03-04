
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

public class ManageTestUserQueryCache {
   private static SessionFactory factory; 
	   public static void main(String[] args) {
		      try{
		         factory = new Configuration().configure().buildSessionFactory();
		      }catch (Throwable ex) { 
		         System.err.println("Failed to create sessionFactory object." + ex);
		         throw new ExceptionInInitializerError(ex); 
		      }
		      ManageTestUserQueryCache ME = new ManageTestUserQueryCache();
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
		    	 
		    	 tx.commit();
		         session.close();
		         
		         
		         session = factory.openSession();
			     tx = session.beginTransaction();
			   
		    	 Query sel = session.createQuery("from TestUser where userid>0");
		    	 sel.setCacheable(true);
		    	 List<TestUser> results = (List<TestUser>)sel.list();
		    	
		    	for(TestUser u : results) {
		    		
		    		//System.out.println("User Retrieved " + u.getUsername());
		    	 }
		    	 
		    	 
		    	 tx.commit();
		         session.close();
		         
		         session = factory.openSession();
			      tx = session.beginTransaction();
			   
			     Query sel2 = session.createQuery("from TestUser where userid>0");
		    	 sel2.setCacheable(true);
		    	 results = (List<TestUser>)sel2.list();
		    	 
		    	for(TestUser u : results) {
		    		 
		    		//System.out.println("User Retrieved " + u.getUsername());
		    	 }
		    	 
		    	 
		    	 tx.commit();
		         session.close();
		        
		         
		         
		      }catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      }
		     
	    
	
	      }
     
}