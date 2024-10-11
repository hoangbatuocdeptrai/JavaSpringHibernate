package com.bkap.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bkap.entity.Category;
import com.bkap.entity.Product;
import com.bkap.impl.CategoryDaoImpl;
import com.bkap.impl.ProductDaoImpl;

@Controller
@RequestMapping("/product_single")
public class ProductSingleCustomerController {
	
	@Autowired
	private ProductDaoImpl proDao;
	@Autowired
	private CategoryDaoImpl cateDao;
	@Autowired
	ServletContext context;

	@InitBinder
	public void initBinder(WebDataBinder data) {
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		data.registerCustomEditor(Date.class, new CustomDateEditor(s, true));
	}
	
	@RequestMapping(value = "/details")
    public String listCate(@RequestParam("id") Integer id, Model model) {
		Product p = proDao.getById(id);
		model.addAttribute("b", p);

        return "/Customer/product_single";
    }
	
	
	
}
