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
import net.jr.investmentportfoliobackend.dao.FundCategoryDAO;
import net.jr.investmentportfoliobackend.dao.FundSchemeDAO;
import net.jr.investmentportfoliobackend.dto.CustomerDetails;
import net.jr.investmentportfoliobackend.dto.FundCategory;
import net.jr.investmentportfoliobackend.dto.FundScheme;

@Controller
public class PageController 
{
	@Autowired
	private CustomerDetailsDAO customerDetailsDAO;
	@Autowired 
	private FundCategoryDAO fundCategoryDAO;
	@Autowired
	private FundSchemeDAO fundSchemeDAO;
	
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
	
	@RequestMapping(value= {"/addcustomer"})
	public ModelAndView add()
	{
		CustomerDetails customerDetails = new CustomerDetails();
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Dashboard");
		
		mv.addObject("userClickAdd", true);
		mv.addObject("addDetails" ,customerDetails);
		return mv;

	}
	
	@RequestMapping(value= {"/submitCusomter"},method=RequestMethod.POST)
	public String addCusomter(@ModelAttribute("addDetails") CustomerDetails customerDetails)
	{
		customerDetailsDAO.add(customerDetails);
		return "redirect:/index";

	}
 
	//Fund Category
	@RequestMapping(value= {"/fundcategory"})
	public ModelAndView fundCategoryView()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Fund Category");
		
		//Passing the list of customers
		mv.addObject("fundcategory", fundCategoryDAO.fundCategoryList());
		
		mv.addObject("userClickFundCategory", true);
		return mv;
	}
	
	@RequestMapping(value= {"/addfundcategory"})
	public ModelAndView addFundCategory()
	{
		FundCategory fundCategory = new FundCategory();

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Add Fund Category");
		mv.addObject("addFundsCategory" ,fundCategory);		
		mv.addObject("userClickAddFundCatgory", true);
		return mv;

	}
	
	@RequestMapping(value= {"/submitFundCategory"},method=RequestMethod.POST)
	public String addFundCategory(@ModelAttribute("addFundsCategory") FundCategory fundCategory)
	{
		fundCategoryDAO.add(fundCategory);
		return "redirect:/fundcategory";

	}
	
	//Fund Scheme
	@RequestMapping(value= {"/fundscheme"})
	public ModelAndView fundSchemeView()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Fund Scheme");
		
		//Passing the list of customers
		mv.addObject("fundscheme", fundSchemeDAO.fundSchemeList());
		
		mv.addObject("userClickFundScheme", true);
		return mv;
	}
	
	@RequestMapping(value= {"/addfundscheme"})
	public ModelAndView addFundScheme()
	{
		FundScheme fundScheme = new FundScheme();

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Add Fund Category");
		mv.addObject("addFundsScheme" ,fundScheme);		
		mv.addObject("userClickAddFundScheme", true);
		return mv;

	}
	
	@RequestMapping(value= {"/submitFundScheme"},method=RequestMethod.POST)
	public String addFundScheme(@ModelAttribute("addFundsScheme") FundScheme fundScheme)
	{
		fundSchemeDAO.add(fundScheme);
		return "redirect:/fundscheme";

	}
	
	 @ModelAttribute("fundcategorylist")
     public Map<Integer, String> getCountryList() {
	      Map<Integer, String> fundCateogryList = new HashMap<Integer, String>();
	      List<FundCategory> fundCatList = fundCategoryDAO.fundCategoryList();
	      Iterator<FundCategory> iterator = fundCatList.listIterator();
	      while(iterator.hasNext()) {
	    	  FundCategory category = iterator.next();
	    	  fundCateogryList.put(category.getId(), category.getFundname());
	      }
	      return fundCateogryList;
     }
	
}
