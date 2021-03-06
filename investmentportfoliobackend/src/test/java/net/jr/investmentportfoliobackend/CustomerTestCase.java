package net.jr.investmentportfoliobackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.jr.investmentportfoliobackend.dao.CustomerDetailsDAO;
import net.jr.investmentportfoliobackend.daoImpl.CustomerDetailsDAOImpl;
import net.jr.investmentportfoliobackend.dto.CustomerDetails;

public class CustomerTestCase {
	private static AnnotationConfigApplicationContext context;
	private static CustomerDetailsDAO customerDetailsDAO;
	private CustomerDetails customerDetails;
	
	@BeforeClass
	public static void init() {
		context=  new AnnotationConfigApplicationContext();
		context.scan("net.jr.investmentportfoliobackend");	
		context.refresh();
		
		customerDetailsDAO=(CustomerDetailsDAO) context.getBean("customerDetailsDAO");
	}
	
	/*@Test
	public void testaddCustomerDetails() {
		customerDetails = new CustomerDetails();
		customerDetails.setActive(true);
		customerDetails.setCustomerEmail("jayadityar78@gmail.com");
		customerDetails.setCustomerName("JAY");
		customerDetails.setCustomerPAN("10098DG56");
		customerDetails.setCustomerPhone("9876543209");
		customerDetails.setCustomerPWD("A@D4$");
		
		customerDetailsDAO = new CustomerDetailsDAOImpl();
		
		assertEquals("Successfully added",true, customerDetailsDAO.add(customerDetails));
	}*/
	
	@Test
	public void testGetSingleCustomerDetails() {
		customerDetails = new CustomerDetails();
		customerDetails.setActive(true);
		customerDetails.setCustomerEmail("jayadityar78@gmail.com");
		customerDetails.setCustomerName("JAY");
		customerDetails.setCustomerPAN("10098DG56");
		customerDetails.setCustomerPhone("9876543209");
		customerDetails.setCustomerPWD("A@D4$");
		
		customerDetailsDAO = new CustomerDetailsDAOImpl();
		
		assertEquals("Successfully added",true, customerDetailsDAO.add(customerDetails));
	}
}
