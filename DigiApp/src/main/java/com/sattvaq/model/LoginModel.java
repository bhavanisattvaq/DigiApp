package com.sattvaq.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "userdata")
public class LoginModel implements Serializable{
	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 @Id
	   @Column(name="userEmail")
	   private String userEmail;
	 @Column(name="name")	
	   private String name;
	  
      
       @Column(name="userPassword")	
	   private String userPassword;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	   
	}
