package com.bkap.impl;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.jboss.jandex.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bkap.dao.ProductDao;
import com.bkap.entity.Category;
import com.bkap.entity.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Product> getAll() {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			List list = session.createQuery("from Product").list();
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
	public List<Product> searchByName(String name) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			List list = session.createQuery("from Product where Name like ?1").setParameter(1, "%" + name + "%").list();
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
	public Product getById(Integer id) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			Product product = (Product) session.createQuery("from Product where Id = :id").setParameter("id", id)
					.uniqueResult();
			session.getTransaction().commit();
			session.close();
			return product;
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
	public boolean insert(Product p) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(p);
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
	public boolean update(Product p) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(p);
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
			int i = session.createQuery("delete from Product WHERE Id = :id").setParameter("id", id).executeUpdate();
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
	public List<Product> getAll(int page, int size) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			Query<Product> query = session.createQuery("from Product", Product.class);
			query.setFirstResult((page - 1) * size);
			query.setMaxResults(size);
			List<Product> list = query.list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return Collections.emptyList();
	}

//	@Override
	public long count() {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			long count = (long) session.createQuery("select count(*) from Product").uniqueResult();
			session.getTransaction().commit();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return 0;
	}

	@Override
	public List<Product> searchByName(String name, int page, int size) {
		try (Session session = sessionFactory.openSession()) {
			session.beginTransaction();
			Query<Product> query = session.createQuery("from Product where Name like ?1", Product.class);
			query.setParameter(1, "%" + name + "%");
			query.setFirstResult((page - 1) * size);
			query.setMaxResults(size);
			List<Product> list = query.list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return Collections.emptyList();
	}

//	 @Override
	public long countByName(String name) {
		try (Session session = sessionFactory.openSession()) {
			session.beginTransaction();
			long count = (long) session.createQuery("select count(*) from Product where name like ?1")
					.setParameter(1, "%" + name + "%").uniqueResult();
			session.getTransaction().commit();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return 0;
	}

	@Override
	public List<Product> getAllNewProduct() {
		Session session = sessionFactory.openSession();
		try {
	        session.beginTransaction();
	        List<Product> productList = session.createQuery("from Product order by id DESC", Product.class)
	                                           .setMaxResults(4)
	                                           .getResultList();
	        
	        session.getTransaction().commit();
	        return productList;
	    } catch (Exception e) {
			session.getTransaction().rollback();
	        e.printStackTrace();
	        return null;
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	    }
	
	}
	
	
}
