package test.model;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache (usage=CacheConcurrencyStrategy.READ_ONLY)
@NamedQuery(name="TestUser.ByUserId", query="from TestUser where userid=?")
@NamedNativeQuery(name="TestUser.ByUserName", query="select * from TEST_USER where username='Sunil4'", resultClass=TestUser.class)
@Table(name="TEST_USER")
//@org.hibernate.annotations.Entity (selectBeforeUpdate=true)  
public class TestUser {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userid;
	private String username;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
