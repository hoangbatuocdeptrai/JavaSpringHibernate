package com.bkap.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bkap.entity.Users;
import com.bkap.impl.CategoryDaoImpl;
import com.bkap.impl.UserDaoImpl;

@Controller
@RequestMapping("/admin/login")
public class LoginAdminController {
	@Autowired
	private UserDaoImpl userDao;

	@RequestMapping(value = { "/", "/index" })
	public String login() {

		return "/Admin/login/loginAdmin";
	}

	@PostMapping("/login")
	public String login(@RequestParam("username") String username, @RequestParam("password") String password,
			Model model) {

		Users user = userDao.findByUsername(username);
		if (user != null && user.getPassword().equals(password)) {
			// Xác thực thành công, chuyển hướng đến trang chính
			model.addAttribute("username", username);
			
			return "/Admin/indesx";
		} else {
			// Xác thực không thành công

			model.addAttribute("err", "Sai thông tin");
			return "/Admin/login/loginAdmin";
		}

	}
	
	@GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate(); // Xóa session
        }
        return "/Admin/login/loginAdmin"; // Chuyển hướng đến trang đăng nhập
    }

}
