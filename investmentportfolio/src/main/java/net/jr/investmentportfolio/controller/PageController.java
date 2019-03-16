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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.jr.investmentportfoliobackend.dao.CustomerDetailsDAO;
import net.jr.investmentportfoliobackend.dao.FundCategoryDAO;
import net.jr.investmentportfoliobackend.dao.FundSchemeDAO;
import net.jr.investmentportfoliobackend.dao.LifeInsuranceDAO;
import net.jr.investmentportfoliobackend.dao.LoginDetailsDAO;
import net.jr.investmentportfoliobackend.dto.CustomerDetails;
import net.jr.investmentportfoliobackend.dto.FundCategory;
import net.jr.investmentportfoliobackend.dto.FundScheme;
import net.jr.investmentportfoliobackend.dto.LifeInsurance;
import net.jr.investmentportfoliobackend.dto.LoginDetails;

@Controller
public class PageController 
{
	@Autowired
	private CustomerDetailsDAO customerDetailsDAO;
	@Autowired 
	private FundCategoryDAO fundCategoryDAO;
	@Autowired
	private FundSchemeDAO fundSchemeDAO;
	@Autowired
	private LifeInsuranceDAO LifeInsuranceDAO;
	@Autowired
	private LoginDetailsDAO LoginDetailsDAO;
	
	@RequestMapping(value= {"/","/home","/index"})
	public ModelAndView login()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Login");
		
		//Passing the list of customers
		LoginDetails loginDetails = new LoginDetails();
		mv.addObject("loginDetails" ,loginDetails);
		//mv.addObject("customers", customerDetailsDAO.customerList());
		
		mv.addObject("userClickLogin", true);
		return mv;
	}
	
	@RequestMapping(value= {"/submitLogin"},method=RequestMethod.POST)
	public String LoginDetails(@ModelAttribute("loginDetails") LoginDetails loginDetails)
	{
		List<LoginDetails> loginDetails2 = LoginDetailsDAO.get(loginDetails.getUserName(),loginDetails.getUserPassword());
	
		if(loginDetails2.isEmpty())
			return "redirect:/index";
		else {
			return "redirect:/getCustomerDetails";
		}

	}
	
	@RequestMapping(value= {"/getCustomerDetails"})
	public ModelAndView dashboard()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Dashboard");
		
		//Passing the list of customers
		mv.addObject("customers", customerDetailsDAO.getAllCustomerDetails());
		
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
	
	@RequestMapping(value= {"/submitCusomter"},method = RequestMethod.POST)
	public String addCusomter(@ModelAttribute("addDetails") CustomerDetails customerDetails)
	{
		customerDetailsDAO.add(customerDetails);
		return "redirect:/getCustomerDetails";
	}
 
	//Get Require By Id for edit
	@RequestMapping(value= "/editcustomer")
	public ModelAndView editCustomer(@RequestParam(value="id" , required = true) int id)
	{
		CustomerDetails customerDetails = new CustomerDetails();
		customerDetails = customerDetailsDAO.get(id);
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickEditCustomer", true);
		mv.addObject("title", "Edit Customer");

		mv.addObject("editCustomerDetails" ,customerDetails);
		return mv;
	}
	
	//Update Record  
	@RequestMapping(value= "/updateCusomter",method = RequestMethod.POST)
	public String updateCustomer(@ModelAttribute("editCustomerDetails") CustomerDetails customerDetails)
	{
		customerDetailsDAO.update(customerDetails);
		return "redirect:/getCustomerDetails";
	}
	
	//Delete 
	@RequestMapping(value= "/deleteCustomer")
	public String deleteCustomer(@RequestParam(value="id" , required = true) int id)
	{
		CustomerDetails customerDetails = new CustomerDetails();
		customerDetails.setCustomerID(id);
		customerDetailsDAO.delete(customerDetails);
		return "redirect:/getCustomerDetails";
	}
	
	//Test Ajax
	@RequestMapping(value= "/getCustomerLifeInsurance")
	public List<CustomerDetails> getCustomerAllLifeInsurance(){
		
		List<CustomerDetails> customerDetailsList = customerDetailsDAO.get();
		return customerDetailsList;
		
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

	
	
	//Fund Scheme
	@RequestMapping(value= {"/lifeinsurance"})
	public ModelAndView viewLifeInsuracne()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Life Insuracne");
		
		//Passing the list of customers
		mv.addObject("lifeinsurance", LifeInsuranceDAO.lifeInsuranceList());
		
		mv.addObject("userClickLifeInsurance", true);
		return mv;
	}
	
	@RequestMapping(value= {"/addlifeinsuracne"})
	public ModelAndView addLifeInsurance()
	{
		LifeInsurance lifeInsurance = new LifeInsurance();

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Add Life Insuracne");
		mv.addObject("addLifeInsurance" ,lifeInsurance);		
		mv.addObject("userClickAddLifeInsuracne", true);
		return mv;

	}
	
	@RequestMapping(value= {"/submitLifeInsurance"},method=RequestMethod.POST)
	public String addLifeInsuracne(@ModelAttribute("addLifeInsuracne") LifeInsurance lifeInsurance)
	{
		LifeInsuranceDAO.add(lifeInsurance);
		return "redirect:/lifeinsurance";

	}

	 @ModelAttribute("fundcategorylist")
     public Map<Integer, String> getFundCategoryList() {
	      Map<Integer, String> fundCateogryList = new HashMap<Integer, String>();
	      List<FundCategory> fundCatList = fundCategoryDAO.fundCategoryList();
	      Iterator<FundCategory> iterator = fundCatList.listIterator();
	      while(iterator.hasNext()) {
	    	  FundCategory category = iterator.next();
	    	  fundCateogryList.put(category.getId(), category.getFundname());
	      }
	      return fundCateogryList;
     }
	 
	 @ModelAttribute("fundschemelist")
     public Map<String, String> getFundSchemeList() {
	      Map<String, String> fundSchemeMap = new HashMap<String, String>();
	      List<FundScheme> fundSchemeList = fundSchemeDAO.fundSchemeList();
	      Iterator<FundScheme> iterator = fundSchemeList.listIterator();
	      while(iterator.hasNext()) {
	    	  FundScheme category = iterator.next();
	    	  fundSchemeMap.put(category.getFundSchemeName(), category.getFundSchemeName());
	      }
	      return fundSchemeMap;
     }
	 
	 @ModelAttribute("customerlist")
     public Map<String, String> getCusomterList() {
	      Map<String, String> cusomterMap = new HashMap<String, String>();
	      List<CustomerDetails> cusomterList = customerDetailsDAO.get();
	      Iterator<CustomerDetails> iterator = cusomterList.listIterator();
	      while(iterator.hasNext()) {
	    	  CustomerDetails cusomter = iterator.next();
	    	  cusomterMap.put(cusomter.getCustomerName(), cusomter.getCustomerName());
	      }
	      return cusomterMap;
     }
}
