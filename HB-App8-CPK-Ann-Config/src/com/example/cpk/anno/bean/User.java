package com.example.cpk.anno.bean;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "USER_DETAILS")
public class User implements Serializable {
	
	@EmbeddedId
	
	@AttributeOverrides({
		@AttributeOverride(name="user_id",  column =  @Column(name ="user_id")),
		@AttributeOverride(name="user_name", column = @Column(name ="user_name"))
	})
	private UserPK userPK;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "profession")
	private String profession;
	
	@Column(name = "city")
	private String city;
	
	public User() {
		super();
	}

	public UserPK getUserPK() {
		return userPK;
	}

	public void setUserPK(UserPK userPK) {
		this.userPK = userPK;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	
	@Override
	public String toString() {
		return "User [userPK=" + userPK + ", password=" + password + ", profession=" + profession + ", city=" + city
				+ "]";
	}

	
}
