package com.bkap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Customer")
public class Customer {
	@javax.persistence.Id
	@Column(name = "Id")	
	private Integer id;
	
	@Column(name = "Name")
	@NotEmpty(message = "TÃªn khÃ´ng Ä‘Æ°á»£c Ä‘á»ƒ trá»‘ng")
	private String name;
	
	@Column(name = "Phone")
	@NotEmpty(message = "Sá»‘ Ä�T khÃ´ng Ä‘Æ°á»£c Ä‘á»ƒ trá»‘ng")
	private String phone;
	
	@Column(name = "Address")
	@NotEmpty(message = "Ä�á»‹a chá»‰ khÃ´ng Ä‘Æ°á»£c Ä‘á»ƒ trá»‘ng")
	private String address;
	
	@Column(name = "UserName")
	@NotEmpty(message = "TÃªn Ä�Äƒng nháº­p khÃ´ng Ä‘Æ°á»£c Ä‘á»ƒ trá»‘ng")
	private String userName;
	
	@Column(name = "Password")
	@NotEmpty(message = "Pass khÃ´ng Ä‘Æ°á»£c Ä‘á»ƒ trá»‘ng")
	private String password;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(Integer id, @NotEmpty(message = "TÃªn khÃ´ng Ä‘Æ°á»£c Ä‘á»ƒ trá»‘ng") String name,
			@NotEmpty(message = "Sá»‘ Ä�T khÃ´ng Ä‘Æ°á»£c Ä‘á»ƒ trá»‘ng") String phone,
			@NotEmpty(message = "Ä�á»‹a chá»‰ khÃ´ng Ä‘Æ°á»£c Ä‘á»ƒ trá»‘ng") String address,
			@NotEmpty(message = "TÃªn Ä�Äƒng nháº­p khÃ´ng Ä‘Æ°á»£c Ä‘á»ƒ trá»‘ng") String userName,
			@NotEmpty(message = "Pass khÃ´ng Ä‘Æ°á»£c Ä‘á»ƒ trá»‘ng") String password) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.userName = userName;
		this.password = password;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
}
