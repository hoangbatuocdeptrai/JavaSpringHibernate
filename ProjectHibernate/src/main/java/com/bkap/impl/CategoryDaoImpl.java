package com.bkap.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.bkap.dao.CategoryDao;
import com.bkap.entity.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Category> getAll() {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			List list = session.createQuery("from Category").list();
			session.getTransaction().commit();
			session.close();
			return list;
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

	

	@Override
	public List<Category> searchByName(String name) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			List list = session.createQuery("from Category where Name like ?1").setParameter(1, "%" + name + "%")
					.list();
			session.getTransaction().commit();
			session.close();
			return list;
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

	@Override
	public Category getById(Integer id) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			Category category = (Category) session.createQuery("from Category where Id = :id").setParameter("id", id)
					.uniqueResult();
			session.getTransaction().commit();
			session.close();
			return category;
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

	@Override
	public boolean insert(Category c) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(c);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return false;

	}

	@Override
	public boolean update(Category c) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(c);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public boolean delete(Integer id) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			int i = session.createQuery("delete from Category WHERE Id = :id").setParameter("id", id).executeUpdate();
			session.getTransaction().commit();
			if (i > 0)
				return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public List<Category> getAllName() {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			List list = session.createQuery("select c.name from Category c").list();
			session.getTransaction().commit();
			session.close();
			return list;
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



	@Override
	public boolean isCategoryExists(String name) {
		try {
			Session session = sessionFactory.openSession();
			 session.beginTransaction();
			    Query query = session.createQuery("select count(*) from Category where name like :name");
			    query.setParameter("name", name);
			    Long count = (Long) query.uniqueResult();
			    return count > 0;
			   
		} catch (HibernateException e) {
		    System.out.println(e.getMessage());
		}
		return false;
		
	}

}
