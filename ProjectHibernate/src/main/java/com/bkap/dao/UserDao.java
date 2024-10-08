package com.bkap.dao;

import com.bkap.entity.Users;

public interface UserDao {
	Users findByUsername(String username);
}
