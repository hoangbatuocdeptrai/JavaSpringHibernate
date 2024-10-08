package com.bkap.impl;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bkap.dao.UserDao;
import com.bkap.entity.Category;
import com.bkap.entity.Product;
import com.bkap.entity.Users;

@Repository
public class UserDaoImpl implements UserDao{
	@Autowired
    private SessionFactory sessionFactory;
	
//	@Override
//	public Users findByUsername(String username) {
//		try {
//			Session session = sessionFactory.getCurrentSession();
//	        Query<Users> query = session.createQuery("from Users where UserName = :username", Users.class);
//	        query.setParameter("username", username);
//	        return query.uniqueResult();
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println(e.getMessage());
//		}
//		return null;
//	}
	
	@Override
	public Users findByUsername(String username) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			Users users = (Users) session.createQuery("from Users where UserName = :username").setParameter("username", username)
					.uniqueResult();
			session.getTransaction().commit();
			session.close();
			return users;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.getTransaction().rollback();
			session.close();
		} finally {
			session.close();
		}
		return null;
	}

}
