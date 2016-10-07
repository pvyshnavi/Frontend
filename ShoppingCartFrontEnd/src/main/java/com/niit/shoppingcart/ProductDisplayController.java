package com.niit.shoppingcart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;

public class ProductDisplayController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping("/saree")
	public ModelAndView saree()
	{
		ModelAndView mv = new ModelAndView("/Home");
		mv.addObject("isUserClickedSaree","true");
		mv.addObject("categoryList", categoryDAO.list());
		return mv;
	}
	
	@RequestMapping("/lehenga")
	public ModelAndView lehenga()
	{
		ModelAndView mv = new ModelAndView("/Home");
		mv.addObject("isUserClickedLehenga","true");
		mv.addObject("categoryList", categoryDAO.list());
		return mv;
	}
	
	@RequestMapping("/gown")
	public ModelAndView gown()
	{
		ModelAndView mv = new ModelAndView("/Home");
		mv.addObject("isUserClickedGown","true");
		mv.addObject("categoryList", categoryDAO.list());
		return mv;
	}
	
	@RequestMapping("/salwars")
	public ModelAndView salwars()
	{
		ModelAndView mv = new ModelAndView("/Home");
		mv.addObject("isUserClickedSalwars","true");
		mv.addObject("categoryList", categoryDAO.list());
		return mv;
	}
	
	@RequestMapping("/tops")
	public ModelAndView tops()
	{
		ModelAndView mv = new ModelAndView("/Home");
		mv.addObject("isUserClickedTops","true");
		mv.addObject("categoryList", categoryDAO.list());
		return mv;
	}
	
}
