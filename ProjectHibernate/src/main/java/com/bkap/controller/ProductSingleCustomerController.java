package com.bkap.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bkap.entity.Category;

@Controller
@RequestMapping("/product_single")
public class ProductSingleCustomerController {
	@RequestMapping(value = {""})
    public String listCate() {
    
        return "/Customer/product_single";
    }
}
