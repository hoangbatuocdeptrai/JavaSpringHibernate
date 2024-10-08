package com.bkap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Users")
public class Users {
	@Id
	@Column(name = "Id")
	private Integer id;
	
	@Column(name = "UserName")
	@NotEmpty(message = "Tên đăng nhập không được để trống")
	private String userName;
	
	@Column(name = "Password")
	@NotEmpty(message = "Mật khẩu không được để trống")
	private String password;

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(Integer id, @NotEmpty(message = "Tên đăng nhập không được để trống") String userName,
			@NotEmpty(message = "Mật khẩu không được để trống") String password) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
