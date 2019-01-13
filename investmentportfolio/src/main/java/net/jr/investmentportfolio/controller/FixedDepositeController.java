package net.jr.investmentportfolio.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.jr.investmentportfoliobackend.dao.CustomerDetailsDAO;
import net.jr.investmentportfoliobackend.dao.FixedDepositDAO;
import net.jr.investmentportfoliobackend.dto.CustomerDetails;
import net.jr.investmentportfoliobackend.dto.FixedDeposite;

@Controller
public class FixedDepositeController {
	@Autowired
	private FixedDepositDAO fixedDepositDAO;
	
	@Autowired
	private CustomerDetailsDAO customerDetailsDAO;
	
	@RequestMapping(value= {"/fixeddeposite"})
	public ModelAndView viewFixedDepositDetails()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Fixed Deposit");
		
		//Passing the list of customers
		mv.addObject("fixeddeposite", fixedDepositDAO.fixedDepositeList());
		
		mv.addObject("userClickFixedDeposite", true);
		return mv;
	}
	
	@RequestMapping(value= {"/addfixeddeposite"})
	public ModelAndView add()
	{
		FixedDeposite fixedDeposite = new FixedDeposite();
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Add Fixed Deposit");
		
		mv.addObject("userClickAddFixedDeposite", true);
		mv.addObject("addFixedDeposit" ,fixedDeposite);
		return mv;

	}
	
	@RequestMapping(value= {"/submitfixeddeposit"},method=RequestMethod.POST)
	public String addCusomter(@ModelAttribute("addFixedDeposit") FixedDeposite fixedDeposite)
	{
		fixedDepositDAO.add(fixedDeposite);
		return "redirect:/fixeddeposite";

	}
	

	@ModelAttribute("customerlist")
    public Map<String, String> getCusomterList() {
	      Map<String, String> cusomterMap = new HashMap<String, String>();
	      List<CustomerDetails> cusomterList = customerDetailsDAO.customerList();
	      Iterator<CustomerDetails> iterator = cusomterList.listIterator();
	      while(iterator.hasNext()) {
	    	  CustomerDetails cusomter = iterator.next();
	    	  cusomterMap.put(cusomter.getCustomerName(), cusomter.getCustomerName());
	      }
	      return cusomterMap;
    }
	
	
}
