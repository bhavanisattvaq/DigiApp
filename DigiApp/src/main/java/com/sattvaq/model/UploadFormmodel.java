package com.sattvaq.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name = "digidata")
public class UploadFormmodel implements Serializable {

	@Id
	   @Column(name="digitalID")
	@GenericGenerator(name="gen1",strategy="increment")
	@GeneratedValue(generator="gen1")
	private int id;
	@Column(name="digi_file_title")
	private String title;
	 @Column(name="digi_file_URL_front")
	private String fpage;
	 @Column(name="digi_file_URL_back")
	private String bpage;
	 @Column(name="searchTags")
	private String search;
	 @Column(name="date_of_Upload")
	 private Date uploaddate=new Date();
	 @Column(name="userEmail")
	 private String userEmail;
	 public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFpage() {
		return fpage;
	}
	public void setFpage(String fpage) {
		this.fpage = fpage;
	}
	public String getBpage() {
		return bpage;
	}
	public void setBpage(String bpage) {
		this.bpage = bpage;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public Date getUploaddate() {
		return uploaddate;
	}
	public void setUploaddate(Date uploaddate) {
		this.uploaddate = uploaddate;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	
	
	
}
