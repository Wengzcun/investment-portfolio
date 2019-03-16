package net.jr.investmentportfoliobackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.jr.investmentportfoliobackend.dao.CustomerDetailsDAO;
import net.jr.investmentportfoliobackend.dto.CustomerDetails;

public class CustomerDetailsTestCase {

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
	public void testCustomerDetails() {
		customerDetails = new CustomerDetails();
		customerDetails.setActive(true);
		customerDetails.setCustomerEmail("jayadityar78@gmail.com");
		customerDetails.setCustomerName("Anuradha");
		customerDetails.setCustomerPAN("10098DG56");
		customerDetails.setCustomerPhone("9876543209");
		customerDetails.setCustomerPWD("A@D4$");
		
		assertEquals("Successfully added",true, customerDetailsDAO.add(customerDetails));
	}
	
	@Test
	public void testGetSingleCustomerDetails() {
		customerDetails = customerDetailsDAO.get(4);
		assertEquals("Successfully fetched record","Aditya", customerDetails.getCustomerName());
	}
	
		@Test
	public void testUpdateSingleCustomerDetails() {
		customerDetails = customerDetailsDAO.get(3);
		customerDetails.setCustomerName("Jay Ravindra");
		assertEquals("Successfully added",true, customerDetailsDAO.update(customerDetails));
	}
	
		@Test
	public void testDeleteSingleCustomerDetails() {
		customerDetails = customerDetailsDAO.get(4);
		assertEquals("Successfully Deleted",true, customerDetailsDAO.delete(customerDetails));
	}
	*/
	@Test
	public void testSelectCustomerDetailsList() {
		assertEquals("Fetch List of Cateogry added",1, customerDetailsDAO.get().size() );
	}

}
