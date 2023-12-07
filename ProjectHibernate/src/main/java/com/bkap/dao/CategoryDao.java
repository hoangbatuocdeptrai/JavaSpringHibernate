package com.bkap.dao;

import java.util.List;

import com.bkap.entity.Category;

public interface CategoryDao {
	public List<Category> getAll();
	public List<Category> searchByName(String name);
	public Category getById(Integer id);
	public boolean insert(Category c);
	public boolean update(Category c);
	public boolean delete(Integer id);
	
	
}
