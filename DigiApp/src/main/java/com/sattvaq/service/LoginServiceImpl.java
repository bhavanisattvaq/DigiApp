package com.sattvaq.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sattvaq.dao.LoginDAO;
import com.sattvaq.model.UploadFormmodel;


@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Autowired(required=true)
	 private LoginDAO loginDAO;

	   public void setLoginDAO(LoginDAO loginDAO) {
              this.loginDAO = loginDAO;
       }
      
       public boolean checkLogin(String userEmail, String userPassword){
              System.out.println("In Service class...Check Login");
              return loginDAO.checkLogin(userEmail, userPassword);
       }
       @Override
   	public void insert(UploadFormmodel model) {
    	   System.out.println("In Service class...add");
   		UploadFormmodel form=new UploadFormmodel();
   		System.out.println(model.getFpage());
   		System.out.println(model.getBpage());
   		System.out.println(model.getId());
   		System.out.println(model.getSearch());
   		System.out.println(model.getTitle());
   		System.out.println(model.getUploaddate());
   		System.out.println(model.getSearch());
   		
   		
   		form.setFpage(model.getFpage());
   		form.setBpage(model.getBpage());
   		form.setId(model.getId());
   		form.setSearch(model.getSearch());
   		form.setTitle(model.getTitle());
   		form.setUploaddate(model.getUploaddate());
   		form.setUserEmail(model.getUserEmail());
   		System.out.println("service befor insert");
   		loginDAO.insert(form);
   		System.out.println("service after insert");
   	}

	@Override
	public UploadFormmodel getFile(int id) {
		return loginDAO.getFile(id);
	}

	@Override
	public UploadFormmodel updateFile(UploadFormmodel model) {
		System.out.println("In Service class...update");
   		UploadFormmodel form=new UploadFormmodel();
		// TODO Auto-generated method stub
   		form.setFpage(model.getFpage());
   		form.setBpage(model.getBpage());
   		form.setId(model.getId());
   		form.setSearch(model.getSearch());
   		form.setTitle(model.getTitle());
   		form.setUploaddate(model.getUploaddate());
   		form.setUserEmail(model.getUserEmail());
		return loginDAO.updateFile(model);
	}

	@Override
	public List<UploadFormmodel> getAllFiles() {
		
		return loginDAO.getAllFiles();
	}
}