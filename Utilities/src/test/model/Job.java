package test.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Job {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int jobid;
	
	private String jobdescription;
	
	private int jobs_yos;
	
	@ManyToOne
	@JoinColumn(name="EMPLOYEEID")
	private Employee employeeid;
	
	public Employee getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(Employee employeeid) {
		this.employeeid = employeeid;
	}
	public int getJobid() {
		return jobid;
	}
	public void setJobid(int jobid) {
		this.jobid = jobid;
	}
	public String getJobdescription() {
		return jobdescription;
	}
	public void setJobdescription(String jobdescription) {
		this.jobdescription = jobdescription;
	}
	public int getJobs_yos() {
		return jobs_yos;
	}
	public void setJobs_yos(int jobs_yos) {
		this.jobs_yos = jobs_yos;
	}
	
	
}
