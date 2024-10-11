package com.bkap.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bkap.entity.Category;
import com.bkap.entity.Product;
import com.bkap.impl.CategoryDaoImpl;
import com.bkap.impl.ProductDaoImpl;

@Controller
@RequestMapping("/shop")
public class ShopCustomerController {
	@Autowired
	private ProductDaoImpl proDao;
	@Autowired
	private CategoryDaoImpl cateDao;
	@Autowired
	ServletContext context;

	@RequestMapping(value = { "" })
	public String listCate(Model model, @RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "12") int size) {
		List<Product> lstt = proDao.getAll(page, size);

		long totalProducts = proDao.count();
		int totalPages = (int) Math.ceil((double) totalProducts / size);
		model.addAttribute("pro", lstt);
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", totalPages);

		List<Category> lsts = cateDao.getAll();
		model.addAttribute("c", lsts);

		return "/Customer/shop";
	}

}
