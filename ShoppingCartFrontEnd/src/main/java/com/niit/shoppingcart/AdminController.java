package com.niit.shoppingcart;


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;


public class AdminController {
	
	Logger log = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private Category category;

	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private Product product;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private Supplier supplier;
	
	@Autowired
	private SupplierDAO supplierDAO;

	

	@RequestMapping("/categories")
	public ModelAndView manageCategories(@ModelAttribute("category")Category category) {
		log.debug("Start: method manageCategories");
		ModelAndView mv = new ModelAndView("Home");
		mv.addObject("category", category);
		mv.addObject("isAdminClickedCategories", "true");
		mv.addObject("categoryList", categoryDAO.list());
		log.debug("End: method manageCategories");
		return mv;
	}
	

	
	@RequestMapping("/products")
	public ModelAndView manageProducts(@ModelAttribute("product") Product product) {
		log.debug("Start: method manageProducts");
		ModelAndView mv = new ModelAndView("/Home");
		mv.addObject("product", product);
		mv.addObject("isAdminClickedProducts", "true");
		mv.addObject("productList", productDAO.list());
		mv.addObject("supplierList", supplierDAO.list());
		mv.addObject("categoryList", categoryDAO.list());
		log.debug("End: method manageProducts");
		return mv;
	}

	@RequestMapping("/supplier")
	public ModelAndView manageSuppliers() {
		log.debug("Start: method manageSuppliers");
		ModelAndView mv = new ModelAndView("/Home");
		mv.addObject("supplier", supplier);
		mv.addObject("isAdminClickedSuppliers", "true");
		mv.addObject("supplierList", supplierDAO.list());
		log.debug("End: method manageSuppliers");
		return mv;
	}

	
}
