package com.bkap.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bkap.dao.ProductDao;
import com.bkap.entity.Category;
import com.bkap.entity.Product;
import com.bkap.form.ProductForm;
import com.bkap.impl.CategoryDaoImpl;
import com.bkap.impl.ProductDaoImpl;

@Controller
@RequestMapping("/admin/product")
public class ProductController {
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
	
	
	@RequestMapping(value = { "/", "/listProduct" })
	public String getAll(Model model) {
		List<Product> lst = proDao.getAll();
		model.addAttribute("pro", lst);
		return "/Admin/product/list";

	}

	@RequestMapping(value = "/search")
	public String listSearch(Model model, @RequestParam("name") String name) {
//		CategoryDaoImpl cateDao = new CategoryDaoImpl();
		List<Product> lst = proDao.searchByName(name);
		if (lst == null) {
			List<Product> list = proDao.getAll();
			model.addAttribute("pro", lst);
			return "redirect:listProduct";
		} else {

			model.addAttribute("ca", lst);
			return "/Admin/product/list";
		}
	}

	@RequestMapping(value = "/details")
	public String detailCategory(@RequestParam("id") Integer id, Model model) {
		Product b = proDao.getById(id);
		model.addAttribute("b", b);

		return "/Admin/product/details";
	}

	@RequestMapping(value = "/initInsert")
	public String initInsert(Model model) {
		ProductForm p = new ProductForm();
		model.addAttribute("p", p);

		List<Category> lst = cateDao.getAll();
		model.addAttribute("c", lst);
		return "/Admin/product/insert";
	}

	@RequestMapping(value = "/insertProduct", method = RequestMethod.POST)
	public String insertProduct(@Valid @ModelAttribute("p") Product p, BindingResult result,
			HttpServletRequest request, Model model) {
		
		if (result.hasErrors()) {
			model.addAttribute("err", "Thêm không thành công");
			model.addAttribute("p", p);
			return "/Admin/product/insert";
		} else {
			String path = request.getServletContext().getRealPath("resources/Test");
			MultipartFile fileUpload = p.getFileUpload();
			File f = new File(path);
			System.out.println(fileUpload.getOriginalFilename());
			File dest = new File(f.getAbsolutePath() + "/" + fileUpload.getOriginalFilename());
			if (!dest.exists()) {
				try {
					byte[] datImage = fileUpload.getBytes();
					Files.write(dest.toPath(), datImage, StandardOpenOption.CREATE);

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			p.setImage(fileUpload.getOriginalFilename());
			boolean bl = proDao.insert(p);
			model.addAttribute("p", p);
			return "redirect:listProduct";
		}
	}

}
