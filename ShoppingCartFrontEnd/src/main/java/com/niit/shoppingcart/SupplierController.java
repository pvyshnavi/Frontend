package com.niit.shoppingcart;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier;

@Controller
public class SupplierController {
	
	@Autowired
	SupplierDAO supplierDAO;
	@Autowired
	Supplier supplier;


	@RequestMapping(value = "/supplier", method = RequestMethod.GET)
	public String listSupplier(Model model) {
		//model.addAttribute("isAdminClickedSuppliers", "true");
		model.addAttribute("supplier", supplier);
		model.addAttribute("supplierList", this.supplierDAO.list());
		return "supplier";
	}

	// For add and update supplier both
	@RequestMapping(value = "/supplier/add", method = RequestMethod.POST)
	public String addSupplier(@ModelAttribute("supplier") Supplier supplier) {


		
		ModelAndView mv= new ModelAndView();
		if(supplierDAO.get(supplier.getId())==null)
		{
			supplierDAO.save(supplier);
			
		}
		else
		{
			mv.addObject("ErrorMessage", "The record exist with this id" +supplier.getId());
		}
		return "supplier";

	}

	@RequestMapping("supplier/remove/{id}")
	public String removeSupplier(@PathVariable("id") String id) throws Exception {


		supplier=supplierDAO.get(id);
		ModelAndView mv = new ModelAndView("supplier");
		if(supplier==null)
		{
			mv.addObject("errormsg","Could not delete the supplier");
			
		}
		else
		{
			supplierDAO.delete(supplier);
		}
		
		String msg= "Successfully done the operation";
		
		return "supplier";
	}

	@RequestMapping("supplier/edit/{id}")
	public String editSupplier(@PathVariable("id") String id, Model model) {
		System.out.println("editSupplier");
		supplier = supplierDAO.get(id);
		model.addAttribute("supplier", supplier);
		model.addAttribute("supplierList", supplierDAO.list());
		// model.addAttribute("supplier", supplierDAO.get(id));
		// model.addAttribute("supplierList",supplierDAO.list());
		return "redirect:/supplier";
	}

}