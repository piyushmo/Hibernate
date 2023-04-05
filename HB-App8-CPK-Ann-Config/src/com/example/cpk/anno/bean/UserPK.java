package com.example.cpk.anno.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserPK  implements Serializable{
	
	@Column(name = "user_id")
	private Integer user_id;
	
	@Column(name = "user_name")
	private String user_name;

	public UserPK() {
		super();
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	@Override
	public String toString() {
		return "UserPK [user_id=" + user_id + ", user_name=" + user_name + "]";
	}

}
