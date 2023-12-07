package com.bkap.form;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import com.bkap.entity.Category;

public class ProductForm {

	
	private int id;

	private String name;

	private float price;

	private String image;

	private boolean status;

	private String description;

	private Category categoryId;
	
	private MultipartFile fileUpload;

	
	
	public ProductForm() {
		super();
		// TODO Auto-generated constructor stub
	}



	public ProductForm(int id, String name, float price, String image, boolean status, String description,
			Category categoryId, MultipartFile fileUpload) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.image = image;
		this.status = status;
		this.description = description;
		this.categoryId = categoryId;
		this.fileUpload = fileUpload;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public float getPrice() {
		return price;
	}



	public void setPrice(float price) {
		this.price = price;
	}



	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}



	public boolean isStatus() {
		return status;
	}



	public void setStatus(boolean status) {
		this.status = status;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public Category getCategoryId() {
		return categoryId;
	}



	public void setCategoryId(Category categoryId) {
		this.categoryId = categoryId;
	}



	public MultipartFile getFileUpload() {
		return fileUpload;
	}



	public void setFileUpload(MultipartFile fileUpload) {
		this.fileUpload = fileUpload;
	}
	
	
	
}