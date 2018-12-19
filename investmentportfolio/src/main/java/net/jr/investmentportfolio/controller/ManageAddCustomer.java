package net.jr.investmentportfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value= {"/customer"})
public class ManageAddCustomer {

	@RequestMapping(value= {"/addCustomer"},method=RequestMethod.GET)
	public ModelAndView showAddCusomter() {
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("title", "Add-Customer");
		mv.addObject("userClickAddCustomer", true);
		return mv;
	}
}
