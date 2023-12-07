package com.bkap.dao;

import java.util.List;

import com.bkap.entity.Product;

public interface ProductDao {
	public List<Product> getAll();
	public List<Product> searchByName(String name);
	public Product getById(Integer id);
	public boolean insert(Product c);
	public boolean update(Product c);
	public boolean delete(Integer id);
}
