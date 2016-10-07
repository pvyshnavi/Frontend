package com.niit.shoppingcart;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Product;



public class ProductController {
	
	Logger log = LoggerFactory.getLogger(ProductController.class);

	@Autowired(required = true)
	private ProductDAO productDAO;

	@Autowired(required = true)
	private CategoryDAO categoryDAO;

	@Autowired(required = true)
	private SupplierDAO supplierDAO;
		
	@Autowired
	private Product product ;
	
	// For add and update product both
	
	//@RequestMapping("product/remove/{id}")
	//public String removeProduct(@PathVariable("id") String id, ModelMap model) throws Exception {
		//log.debug("Start: method removeProduct");


		//try {
			
			//Product product= productDAO.getByName(id);
			//productDAO.delete(product);
			//model.addAttribute("message", "Successfully Added");
		//} catch (Exception e) {
			//model.addAttribute("message", e.getMessage());
			//e.printStackTrace();
		//}
		
		// redirectAttrs.addFlashAttribute(arg0, arg1)
		//log.debug("End: method removeProduct");
		//return "redirect:/product";
	//}

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

	@RequestMapping(value = "product/get/{id}")
	public String getSelectedProduct(@PathVariable("id") String id, Model model,
			RedirectAttributes redirectAttributes) {
		//redirectAttributes.addFlashAttribute("userClickedProductName", true);
		redirectAttributes.addFlashAttribute("selectedProduct", productDAO.get(id));
		return "redirect:/backToHome";

	}

	@RequestMapping(value = "/backToHome", method = RequestMethod.GET)
	public String backToHome(@ModelAttribute("selectedProduct") 
	        final Object selectedProduct, final Model model) {
        //model.addAttribute("userClickedProductName",true);
		model.addAttribute("selectedProduct", selectedProduct);
		//model.addAttribute("categoryList", this.categoryDAO.list());

		return "/Home";
	}
	
}
