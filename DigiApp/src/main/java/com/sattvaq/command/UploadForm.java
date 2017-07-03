package com.sattvaq.command;

import org.springframework.web.multipart.MultipartFile;

public class UploadForm {
    private int id;
	private MultipartFile file1;
	private MultipartFile file2;
	private String search;
	private String title;
	private String useremail;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public MultipartFile getFile1() {
		return file1;
	}
	public void setFile1(MultipartFile file1) {
		this.file1 = file1;
	}
	public MultipartFile getFile2() {
		return file2;
	}
	public void setFile2(MultipartFile file2) {
		this.file2 = file2;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	
}
