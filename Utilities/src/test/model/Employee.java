package test.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;
import javax.persistence.JoinColumn;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
public class Employee {
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO, generator="my_entity_seq_gen")
   @SequenceGenerator(name="my_entity_seq_gen", sequenceName="serial")
   private int id;
   private String firstName; 
   private String lastName;   
   private int salary;  

	@OneToOne
	@JoinColumn(name = "VEHICLEID")
	private Vehicle vehicle;

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	@AttributeOverrides ({
	   @AttributeOverride (name="city", column=@Column (name="OFF_CITY")),
	   @AttributeOverride (name="state", column=@Column (name="OFF_STATE")),
	   @AttributeOverride (name="zipcode", column=@Column (name="OFF_ZIPCODE")),
	   @AttributeOverride (name="street", column=@Column (name="OFF_STREET"))
   })
   private Address homeaddress;
   
   //@Embedded
   @ElementCollection
   @JoinTable (name="ADDRESS",
   			   joinColumns=@JoinColumn(name="EMPLOYEEID")	
		   )
   @GenericGenerator (name="my_hilo", strategy = "hilo" )
   @CollectionId(columns = {@Column(name="ADDRESSID")}, generator = "my_hilo", type = @Type(type="long"))
   private Collection<Address> listOfOfficeaddress = new ArrayList<Address>();

   public Employee() {}
   
   public Employee(String fname, String lname, int salary) {
      this.firstName = fname;
      this.lastName = lname;
      this.salary = salary;
   }
   public int getId() {
      return id;
   }
   public void setId( int id ) {
      this.id = id;
   }
   public String getFirstName() {
      return firstName;
   }
   public void setFirstName( String first_name ) {
      this.firstName = first_name;
   }
   public String getLastName() {
      return lastName;
   }
   public void setLastName( String last_name ) {
      this.lastName = last_name;
   }
   public Address getHomeaddress() {
	return homeaddress;
}

public void setHomeaddress(Address homeaddress) {
	this.homeaddress = homeaddress;
}


public Collection<Address> getListOfOfficeaddress() {
	return listOfOfficeaddress;
}

public void setListOfOfficeaddress(Collection<Address> listOfOfficeaddress) {
	this.listOfOfficeaddress = listOfOfficeaddress;
}

public int getSalary() {
      return salary;
   }
   public void setSalary( int salary ) {
      this.salary = salary;
   }
}