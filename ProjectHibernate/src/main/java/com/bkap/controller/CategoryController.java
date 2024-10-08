package com.bkap.controller;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.swing.text.html.FormSubmitEvent.MethodType;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bkap.dao.CategoryDao;
import com.bkap.entity.Category;
import com.bkap.impl.CategoryDaoImpl;

@Controller
@RequestMapping("/admin/category")
public class CategoryController {
	@Autowired
	private CategoryDaoImpl cateDao;
	
	@RequestMapping(value = {"/", "/listCategory"})
    public String listCate(Model model, @RequestParam(defaultValue = "1") int page,
                           @RequestParam(defaultValue = "2") int size) {
        List<Category> lst = cateDao.getAll(page, size);
        long totalCategories = cateDao.count();
        int totalPages = (int) Math.ceil((double) totalCategories / size);
        model.addAttribute("ca", lst);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        return "/Admin/category/list";
    }
	
	@RequestMapping(value = "/search")
	public String listSearch(Model model, @RequestParam("name")String name, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "2") int size) {
		List<Category> lst = cateDao.searchByName(name, page, size);
		List<Category> lstt = cateDao.getAll(page, size);
		if(name == null) {
			
	        long totalCategories = cateDao.count();
	        int totalPages = (int) Math.ceil((double) totalCategories / size);
	        model.addAttribute("ca", lstt);
	        model.addAttribute("currentPage", page);
	        model.addAttribute("totalPages", totalPages);
	        return "/Admin/category/list";
		}else {
			
			long totalCategories = cateDao.countByName(name);
			int totalPages = (int) Math.ceil((double) totalCategories / size);
			model.addAttribute("ca", lst);
			model.addAttribute("currentPage", page);
			model.addAttribute("totalPages", totalPages);
			return "/Admin/category/list";
			
		}
		
	}
	
//	@RequestMapping(value = "/search")
//	public String listSearch(Model model, @RequestParam("name")String name) {
//		List<Category> lst = cateDao.searchByName(name);
//		if(lst == null) {
////			List<Category> list = cateDao.getAll();
//			model.addAttribute("ca", lst);
//			return "redirect:listCategory";
//		}else {
//			model.addAttribute("ca", lst);
//			return "/Admin/category/list";
//		}
//	}
	
	@RequestMapping(value = "/details")
	public String detailCategory(@RequestParam("id") Integer id, Model model) {
		Category ca = cateDao.getById(id);
		model.addAttribute("b",ca);
		
		return "/Admin/category/details";
	}
	
	
	@RequestMapping(value = "/initInsert")
	public String initInsert(Model model) {
		Category c = new Category();
		model.addAttribute("c", c);
		
		return "/Admin/category/insert";
	}
	
	
	@RequestMapping(value = "/insertCategory", method = RequestMethod.POST)
	public String insertCategory(@ModelAttribute("c") @Valid Category c, BindingResult result,  Model model) {
		try {
	

			List<String> list = cateDao.getAllName();
			
			for (String category : list) {
				if(c.getName().equals(category)) {
//					test = 1;
					model.addAttribute("err", "Không nhập trùng ");
					return "/Admin/category/insert";
				}
			}
			
	        
			if(result.hasErrors()) {
				model.addAttribute("err", "Thêm không thành công");
				model.addAttribute("c", c);
				return "/Admin/category/insert";
			}
//			else if(test == 1){
//				model.addAttribute("err", "Không nhập trùng ");
//				return "/Admin/category/insert";
//			}
			else{
				boolean bl = cateDao.insert(c);
				model.addAttribute("c", c);
				return "redirect:listCategory";
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return null;
		
	}
	
	@RequestMapping(value = "/initUpdate")
	public String initUpdate(@RequestParam("id")int id, Model model) {
		Category category = cateDao.getById(id);
		model.addAttribute("c", category);
		return "/Admin/category/update";
		
		
	}
	int category = 0;
	public void duplicate(Category c) {
		this.category = 1;
		c.getName().equals(c.getName());
	}
	@RequestMapping(value = "/updateCategory")
	public String updateCategory(@Valid @ModelAttribute("c")Category c, BindingResult result,Model model) {
		boolean bl = cateDao.update(c);
		if(result.hasErrors()) {
			model.addAttribute("err", "Sửa không thành công");
			model.addAttribute("c", c);
			return "/Admin/category/update";
		}
//		else if(this.category > 0) {
//			model.addAttribute("err", "Không nhập trùng ");
//			model.addAttribute("c", c);
//			return "/Admin/category/update";
//		}
		else {
			model.addAttribute("err", "sửa thành công cong ");
			return "redirect:listCategory";
		}
	}
	
	@RequestMapping("/deleteCa")
	public String deleteCategory(@RequestParam("id")Integer id, Model model, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "2") int size) {
		boolean bl = cateDao.delete(id);
		
		if(bl) {
			model.addAttribute("err", "Xóa thành công");
			List<Category> lst = cateDao.getAll(page, size);
			model.addAttribute("ca", lst); 
			return "/Admin/category/list";
		}else {
			model.addAttribute("err", "Xóa không thành công");
			List<Category> lst = cateDao.getAll(page, size);
			model.addAttribute("ca", lst); 
			return "/Admin/category/list";
		}
	}

	
}
