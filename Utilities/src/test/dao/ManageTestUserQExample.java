package test.dao;
import java.util.List; 
import java.util.Date;
import java.util.Iterator; 

import org.hibernate.Criteria;
import org.hibernate.HibernateException; 
import org.hibernate.Query;
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import test.model.Address;
import test.model.Employee;
import test.model.FourWheeler;
import test.model.TestUser;
import test.model.TwoWheeler;
import test.model.Vehicle;

public class ManageTestUserQExample {
   private static SessionFactory factory; 
	   public static void main(String[] args) {
		      try{
		         factory = new Configuration().configure().buildSessionFactory();
		      }catch (Throwable ex) { 
		         System.err.println("Failed to create sessionFactory object." + ex);
		         throw new ExceptionInInitializerError(ex); 
		      }
		      ManageTestUserQExample ME = new ManageTestUserQExample();
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
		    	 
		    	 TestUser t_example = new TestUser();
		    	 t_example.setUsername("Sunil%");
		    	 Example example = Example.create(t_example).enableLike();
		    	 
		    	 
		    	 Criteria ct = session.createCriteria(TestUser.class)
		    			 .add(example);
		    	 
		    	 List<TestUser> results = (List<TestUser>)ct.list();
		    	 
		    	for(TestUser u : results) {
		    		System.out.println("User Retrieved " + u.getUserid());
		    	 }
		    	 
		    	 
		    	 tx.commit();
		         session.close();
		         
		         
		      }catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      }
		     
	    
	
	      }
     
}