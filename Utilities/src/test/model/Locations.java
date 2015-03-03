package test.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Locations {
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int locationid;
	
	private String locationDesc;
	
	@ManyToMany (mappedBy="listOfLocations")
	private Collection<Employee> listOfEmployees = new ArrayList<Employee>();

	public int getLocationid() {
		return locationid;
	}

	public void setLocationid(int locationid) {
		this.locationid = locationid;
	}

	public String getLocationDesc() {
		return locationDesc;
	}

	public void setLocationDesc(String locationDesc) {
		this.locationDesc = locationDesc;
	}

	public Collection<Employee> getListOfEmployees() {
		return listOfEmployees;
	}

	public void setListOfEmployees(Collection<Employee> listOfEmployees) {
		this.listOfEmployees = listOfEmployees;
	}
	
	
	

}
