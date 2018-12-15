package net.jr.investmentportfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.jr.investmentportfoliobackend.dao.CustomerDetailsDAO;

@Controller
public class PageController 
{
	@Autowired
	private CustomerDetailsDAO customerDetailsDAO;
	
	@RequestMapping(value= {"/","/home","/index"})
	public ModelAndView dashboard()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Dashboard");
		
		//Passing the list of customers
		mv.addObject("customers", customerDetailsDAO.customerList());
		
		mv.addObject("userClickDashboard", true);
		return mv;
	}
	@RequestMapping(value= {"/login"})
	public ModelAndView login()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Login");
		mv.addObject("userClickLogin", true);
		return mv;
	}
	
	/*@RequestMapping(value= {"/test"})
	public ModelAndView test(@RequestParam(value="source",required=false) String req1 , @RequestParam(value="ei",required=true) String req2 )
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("hi" ,req2);
		return mv;
	}*/
}
