package com.bkap.dao;

import java.util.List;

import com.bkap.entity.Category;

public interface CategoryDao {
	public List<Category> getAll(int page, int size);
	public List<Category> getAll();
	public long count();
	public List<String> getAllName();
	public List<Category> searchByName(String name, int page, int size);
	public Category getById(Integer id);
	public boolean insert(Category c);
	public boolean update(Category c);
	public boolean delete(Integer id);
	public boolean isCategoryExists(String categoryName);
	
}
