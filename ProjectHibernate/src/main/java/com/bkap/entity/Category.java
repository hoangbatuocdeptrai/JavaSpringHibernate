package com.bkap.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.bkap.dao.CategoryDao;
import com.bkap.impl.CategoryDaoImpl;

@Entity
@Table(name = "Category")
public class Category {
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Integer id;
	
	@Column(name = "Name")
	@NotEmpty(message ="Tên không đc để trống")
	private String name;
	
	@Column(name = "Status")
	@NotNull(message ="Trạng thái không được để trống")
	private boolean status;
	
	@OneToMany(mappedBy = "id")//map den cot id cua bang entity.product
	private List<Product> listProduct;

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(Integer id, @NotNull(message = "Tên không đc để trống") String name,
			@NotNull(message = "Trạng thái không được để trống") boolean status,
			List<Product> listProduct) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.listProduct = listProduct;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<Product> getListProduct() {
		return listProduct;
	}

	public void setListProduct(List<Product> listProduct) {
		this.listProduct = listProduct;
	}

	
	
}
