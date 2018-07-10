package net.jr.investmentportfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController 
{
	@RequestMapping(value= {"/","/home","/index"})
	public ModelAndView dashboard()
	{
		ModelAndView mv = new ModelAndView("dashboard");
//		mv.addObject("hi" ,"hello J. Aditya");
		return mv;
	}
	
	/*@RequestMapping(value= {"/test"})
	public ModelAndView test(@RequestParam(value="source",required=false) String req1 , @RequestParam(value="ei",required=true) String req2 )
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("hi" ,req2);
		return mv;
	}*/
	
	@RequestMapping(value= {"/login"})
	public ModelAndView login()
	{
		ModelAndView mv = new ModelAndView("login");
	//	mv.addObject("hi" ,req2);
		return mv;
	}
}
