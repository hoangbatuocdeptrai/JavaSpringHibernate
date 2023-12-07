package com.bkap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class Admin {

	@RequestMapping("")
	public String index() {
		return "/Admin/Banner/index";
	}
	
}
