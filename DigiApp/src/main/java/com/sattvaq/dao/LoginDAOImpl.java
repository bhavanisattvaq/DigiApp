package com.sattvaq.dao;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.sattvaq.model.UploadFormmodel;

@Repository("loginDAO")
public class LoginDAOImpl implements LoginDAO{
     
			 
       @Resource(name="sessionFactory")
       protected SessionFactory sessionFactory;

       public void setSessionFactory(SessionFactory sessionFactory) {
              this.sessionFactory = sessionFactory;
       }
      
       protected Session getSession(){
              return sessionFactory.openSession();
       }

       public boolean checkLogin(String userEmail, String userPassword){
			System.out.println("In Check login");
			Session session = sessionFactory.openSession();
			boolean userFound = false;
			//Query using Hibernate Query Language
			String SQL_QUERY =" from LoginModel as o where o.userEmail=? and o.userPassword=?";
			Query query = session.createQuery(SQL_QUERY);
			query.setParameter(0,userEmail);
			query.setParameter(1,userPassword);
			List<UploadFormmodel> list = query.list();

			if ((list != null) && (list.size() > 0)) {
				userFound= true;
			}
			return userFound;              
       }

	@Override
	public void insert(UploadFormmodel model) {
		System.out.println("In db insert");
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		UploadFormmodel form=new UploadFormmodel();
		form.setBpage(model.getBpage());
		System.out.println(model.getBpage());
		form.setFpage(model.getFpage());
		System.out.println(model.getFpage());
		form.setId(model.getId());
		System.out.println(model.getId());
		form.setSearch(model.getSearch());
		System.out.println(model.getSearch());
		form.setTitle(model.getTitle());
		System.out.println(model.getTitle());
		form.setUploaddate(model.getUploaddate());
		System.out.println(model.getUploaddate());
		form.setUserEmail(model.getUserEmail());
		System.out.println(model.getUserEmail());
		Transaction tx = null;
		tx = session.getTransaction();
        tx.begin();
        System.out.println("after tx");
        session.save(form);
        tx.commit();
        System.out.println("after save");
	}

	@Override
	public UploadFormmodel getFile(int id) {
		System.out.println("In db getfile");
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		UploadFormmodel model	=(UploadFormmodel)session.load(UploadFormmodel.class, new Integer(id));
		return model;
	}

	@Override
	public UploadFormmodel updateFile(UploadFormmodel model) {
		// TODO Auto-generated method stub
		System.out.println("In db update");
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		UploadFormmodel mo=new UploadFormmodel();
		mo.setBpage(model.getBpage());
		mo.setFpage(model.getFpage());
		mo.setId(model.getId());
		mo.setTitle(model.getTitle());
		mo.setUploaddate(model.getUploaddate());
		mo.setUserEmail(model.getUserEmail());
		mo.setSearch(model.getSearch());
		Transaction tx = null;
		tx = session.getTransaction();
        tx.begin();
        session.update(mo);
    tx.commit();
		return model;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UploadFormmodel> getAllFiles() {
		Session session = sessionFactory.openSession();
		return session.createQuery("from UploadFormmodel").list();
		
	}
}