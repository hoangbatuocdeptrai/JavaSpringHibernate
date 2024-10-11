package com.bkap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bkap.entity.Product;
import com.bkap.impl.CategoryDaoImpl;
import com.bkap.impl.ProductDaoImpl;

@Controller
public class HomeController {
	@Autowired
	private ProductDaoImpl proDao;
	@Autowired
	private CategoryDaoImpl cateDao;
	
	
    @GetMapping("/index")
    public String index(Model model) {
    	List<Product> lst = proDao.getAllNewProduct();
    	
    	model.addAttribute("proa", lst);
        return "/Customer/index"; 
    }
}
