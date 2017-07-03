package com.sattvaq.dao;

import java.util.List;

import com.sattvaq.model.UploadFormmodel;

public interface LoginDAO{    
       public boolean checkLogin(String userEmail, String userPassword);
       public void insert(UploadFormmodel model);
       public UploadFormmodel getFile(int id);
       public UploadFormmodel updateFile(UploadFormmodel model);
       public List<UploadFormmodel> getAllFiles();
}