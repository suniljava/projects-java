package test.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "my_entity_seq_gen")
	@SequenceGenerator(name = "my_entity_seq_gen", sequenceName = "serial")
	private int id;
	
	private String firstName;
	@AttributeOverrides({
			@AttributeOverride(name = "city", column = @Column(name = "OFF_CITY")),
			@AttributeOverride(name = "state", column = @Column(name = "OFF_STATE")),
			@AttributeOverride(name = "zipcode", column = @Column(name = "OFF_ZIPCODE")),
			@AttributeOverride(name = "street", column = @Column(name = "OFF_STREET")) })
	private Address homeaddress;
	
	private String lastName;

	@OneToMany(mappedBy = "employeeid")
	private Collection<Job> listOfJobs = new ArrayList<Job>();

	@ManyToMany
	private Collection<Locations> listOfLocations = new ArrayList<Locations>();
	
	public Collection<Job> getListOfJobs() {
		return listOfJobs;
	}

	public void setListOfJobs(Collection<Job> listOfJobs) {
		this.listOfJobs = listOfJobs;
	}

	public Collection<Locations> getListOfLocations() {
		return listOfLocations;
	}

	public void setListOfLocations(Collection<Locations> listOfLocations) {
		this.listOfLocations = listOfLocations;
	}

	// @Embedded
	@ElementCollection
	@JoinTable(name = "ADDRESS", joinColumns = @JoinColumn(name = "EMPLOYEEID"))
	@GenericGenerator(name = "my_hilo", strategy = "hilo")
	@CollectionId(columns = { @Column(name = "ADDRESSID") }, generator = "my_hilo", type = @Type(type = "long"))
	private Collection<Address> listOfOfficeaddress = new ArrayList<Address>();

	@OneToMany (cascade=CascadeType.ALL)
	@JoinTable(name = "EMPLOYEE_VEHICLE_MAP", joinColumns = @JoinColumn(name = "EMPLOYEEID"), inverseJoinColumns = @JoinColumn(name = "VEHICLEID"))
	private Collection<Vehicle> listOfvehicle = new ArrayList<Vehicle>();

	@OneToOne
	@JoinColumn(name = "DEGREE_ID")
	private Qualification qualification;

	private int salary;

	public Employee() {
	}

	public Employee(String fname, String lname, int salary) {
		this.firstName = fname;
		this.lastName = lname;
		this.salary = salary;
	}

	public String getFirstName() {
		return firstName;
	}

	public Address getHomeaddress() {
		return homeaddress;
	}

	public int getId() {
		return id;
	}

	public String getLastName() {
		return lastName;
	}

	public Collection<Address> getListOfOfficeaddress() {
		return listOfOfficeaddress;
	}

	public Collection<Vehicle> getListOfvehicle() {
		return listOfvehicle;
	}

	public Qualification getQualification() {
		return qualification;
	}

	public int getSalary() {
		return salary;
	}

	public void setFirstName(String first_name) {
		this.firstName = first_name;
	}

	public void setHomeaddress(Address homeaddress) {
		this.homeaddress = homeaddress;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setLastName(String last_name) {
		this.lastName = last_name;
	}

	public void setListOfOfficeaddress(Collection<Address> listOfOfficeaddress) {
		this.listOfOfficeaddress = listOfOfficeaddress;
	}

	public void setListOfvehicle(Collection<Vehicle> listOfvehicle) {
		this.listOfvehicle = listOfvehicle;
	}

	public void setQualification(Qualification qualification) {
		this.qualification = qualification;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
}