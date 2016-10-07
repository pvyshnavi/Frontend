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

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.dao.UserDetailsDAO;
import com.niit.shoppingcart.model.Cart;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppingcart.model.UserDetails;
import com.niit.shoppingcart.util.FileUtil;

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
	
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	Cart cart;
	
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
		
		productDAO.saveOrUpdate(product);
		
		MultipartFile file = product.getImage();
		
		FileUtil.upload(path, file, "id"+product.getId()+".jpg");
	
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
	
	@RequestMapping(value = "here/register", method = RequestMethod.GET)
	public ModelAndView registerUser(HttpSession session) {
		log.debug("Start: method registerUser");
		log.info("User object going to be registered has user id: " + userDetails.getId());
		userDetails.setRole("ROLE_USER");
		UserDetails userDetails = (UserDetails) session.getAttribute("userDetails");
		userDetailsDAO.saveOrUpdate(userDetails);
		ModelAndView mv = new ModelAndView("redirect:/");
		mv.addObject("successMessage", "You are successfully register");

		log.debug("End: method registerUser");
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
	
	@RequestMapping(value = "/myCart")
	public String myCart(Model model, HttpSession session) {
		log.debug("Start: method myCart");
		UserDetails userDetails =(UserDetails) session.getAttribute("user");
		System.out.println("ccccccccccccccccc"+userDetails);
		log.info("\n*************\nuserID is {}\n*************\n", userDetails.getId());
		model.addAttribute("userClickedCartHere", true);
		model.addAttribute("category", new Category());
		model.addAttribute("categoryList", categoryDAO.list());
		//cart = cartDAO.getByUserId(userDetails.getId());
		//model.addAttribute("cart", cart);
		
		model.addAttribute("cartList", cartDAO.userCartList(userDetails.getId()));
		System.out.println("sizeeeeeeeeeeeeeeeeeeeeeeeeeee"+cartDAO.userCartList(userDetails.getId()).size());
		for(Cart c :cartDAO.userCartList(userDetails.getId()))
		{
			System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhh"+c.getPrice());
			
		}
		System.out.println(cartDAO.getTotal(userDetails.getId()));
		model.addAttribute("totalAmount", cartDAO.getTotal(userDetails.getId())); 
		model.addAttribute("displayCart", "true");
		log.debug("End: method myCart");
		return "/Home";
	} 
	
	@RequestMapping("myCart/remove/{id}")
	public String removeCart(@PathVariable("id") String id, ModelMap model) throws Exception {
		log.debug("Start: method removeCart");
		System.out.println("ccccccc"+id);
		cart=cartDAO.get(id);
		
		//try {
			System.out.println("bbbb");
			cartDAO.delete(cart);
			System.out.println("aaaaaa");
			model.addAttribute("message", "Successfully removed");
		//} catch (Exception e) {
			//model.addAttribute("message", e.getMessage());
			//e.printStackTrace();
		//}
		 //redirectAttrs.addFlashAttribute(arg0, arg1)
		log.debug("End: method removeCart");
		return "redirect:/myCart";
	}

	
}
