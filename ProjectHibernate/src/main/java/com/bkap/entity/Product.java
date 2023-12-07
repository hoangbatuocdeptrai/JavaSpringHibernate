package com.bkap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;
import org.springframework.web.multipart.MultipartFile;

import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;

@Entity
@Table(name = "Product")
public class Product {
	
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int id;

	@Column(name = "Name")
	@NotEmpty(message = "Tên không được để trống")
	private String name;

	@Column(name = "Price")
	@NotNull(message = "Giá không được để trống")
	private float price;

	@Column(name = "Image")
	private String image;

	@Column(name = "Status")
	@NotNull(message = "Trạng thái không được để trống")
	private boolean status;

	@Column(name = "Description")
	@NotEmpty(message = "Mô tả không được để trống")
	private String description;

	@ManyToOne
	@JoinColumn(name = "CategoryId")
	@NotNull(message = "Mã danh mục không được để trống")
	private Category categoryId;

	@Transient
	private MultipartFile fileUpload;
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Product(int id, @NotEmpty(message = "Tên không được để trống") String name,
			@NotNull(message = "Giá không được để trống") float price,
			@NotEmpty(message = "Ảnh không được để trống") String image,
			@NotNull(message = "Trạng thái không được để trống") boolean status,
			@NotEmpty(message = "Mô tả không được để trống") String description,
			@NotNull(message = "Mã danh mục không được để trống") Category categoryId) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.image = image;
		this.status = status;
		this.description = description;
		this.categoryId = categoryId;
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