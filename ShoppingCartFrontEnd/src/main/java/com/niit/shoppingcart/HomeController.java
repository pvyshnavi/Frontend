package com.niit.shoppingcart;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.dao.UserDetailsDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppingcart.model.UserDetails;
import com.niit.shoppingcart.util.FileUtil;
import com.niit.shoppingcart.util.Util;

@Controller
public class HomeController {
	
	Logger log = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	Category category;
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	Product product;
	
	@Autowired
	SupplierDAO supplierDAO;
	
	@Autowired
	Supplier supplier;
	
	@Autowired
	UserDetailsDAO userDetailsDAO;
	
	@Autowired
	UserDetails userDetails; 
	
	private String path = "D:\\shoppingcart\\img";
	
	@RequestMapping("/product")
	public ModelAndView listProducts(@ModelAttribute("product") Product p,MultipartFile file,HttpServletRequest request) {
		 ModelAndView model=new ModelAndView("Home");
		log.debug("Start: method listProducts");
		model.addObject("isAdminClickedProducts", true);
		model.addObject("product", new Product());
		model.addObject("category", new Category());
		model.addObject("supplier", new Supplier());
		model.addObject("productList", this.productDAO.list());
		model.addObject("categoryList", categoryDAO.list());
		model.addObject("supplierList", supplierDAO.list());
		log.debug("End: method listProducts");
		return model;
	}
	
	@RequestMapping(value = "/product/add", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("product") Product product) {
		log.debug("Start: method addProduct");
System.out.println("jkkkkkkkkkkkkk"+product.getSupplier());
		/*Category category = categoryDAO.getByName(product.getCategory().getName());
		categoryDAO.save(category); // why to save??

		Supplier supplier = supplierDAO.getByName(product.getSupplier().getName());
		supplierDAO.save(supplier); // Why to save??

		product.setCategory(category);
		product.setSupplier(supplier);

		product.setCategory_id(category.getId());
		product.setSupplier_id(supplier.getId());
		String newID = Util.removeComma(product.getId());
		product.setId(newID);*/
		
		productDAO.save(product);
		
		MultipartFile file = product.getImage();
		
		//FileUtil.upload(path, file, "id"+product.getId()+".jpg");
	
		log.debug("End: method addProduct");


		return "redirect:/product";
		//return "redirect:/uploadFile";

	}
	
	@RequestMapping("product/remove/{id}")
	public String removeProduct(@PathVariable("id") String id, ModelMap model) throws Exception {
		log.debug("Start: method removeProduct");
		log.info("product is going to be deleted : " +id);

		try {
			
			//Product product= productDAO.getByName(id);
			productDAO.delete(product);
			model.addAttribute("message", "Successfully Added");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
		}
		
		// redirectAttrs.addFlashAttribute(arg0, arg1)
		log.debug("End: method removeProduct");
		return "redirect:/product";
	}

	@RequestMapping("product/edit/{id}")
	public String editProduct(@PathVariable("id") String id, Model model) {
		log.debug("Start: method editProduct");
		System.out.println("editProduct");
		
		product = productDAO.get(id);
		model.addAttribute("product",product);
		model.addAttribute("listProducts", productDAO.list());
		model.addAttribute("categoryList", categoryDAO.list());
		model.addAttribute("supplierList",supplierDAO.list());
		log.debug("End: method editProduct");

		return "redirect:/product";
	}


	
	@RequestMapping("/")
	public ModelAndView onLoad(HttpSession session) {
		ModelAndView mv = new ModelAndView("/Home");
		session.setAttribute("category", category);
		session.setAttribute("categoryList", categoryDAO.list());
		List<Category> categoryList = categoryDAO.list();
		mv.addObject("categoryList", categoryList);
		System.out.println("size" + categoryList.size());
		return mv;
	}
	
	@RequestMapping(value = "here/register", method = RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute UserDetails userDetails) {
		userDetails.setRole("ROLE_USER");
		userDetailsDAO.save(userDetails);
		ModelAndView mv  = new ModelAndView("/Home");
		mv.addObject("successMessage", "You are successfully register");
		
		return mv;
	}
	
	@RequestMapping("/loginHere")
	public ModelAndView login()
	{
		ModelAndView mv = new ModelAndView("Home");
		mv.addObject("isUserClickedLoginHere", true);
		return mv;
	}
	@RequestMapping("/registerHere")
	public ModelAndView register(@ModelAttribute("userDetails")UserDetails ud)
	{
		ModelAndView mv = new ModelAndView("Registration");
		mv.addObject("isUserClickedRegisterHere", true);
		return mv;
	}
	
}
