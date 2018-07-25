package net.jr.investmentportfoliobackend.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.jr.investmentportfoliobackend.dao.CustomerDetailsDAO;
import net.jr.investmentportfoliobackend.dto.CustomerDetails;

@Repository("customerDetailsDao")
public class CustomerDetailsDAOImpl implements CustomerDetailsDAO {

	private static List<CustomerDetails> customers = new ArrayList<>();
	
	static {
		
		CustomerDetails customerDetails = new CustomerDetails();
		
		customerDetails.setCustomerID(1);
		customerDetails.setCustomerName("GAITONDE");
		customerDetails.setCustomerEmail("h@gmail.com");
		customerDetails.setCustomerPAN("DTEP981914");
		customerDetails.setCustomerPhone("7379042763");
		customerDetails.setActive(true);
		
		customers.add(customerDetails);
		
		customerDetails = new CustomerDetails();

		customerDetails.setCustomerID(1);
		customerDetails.setCustomerName("Shrini");
		customerDetails.setCustomerEmail("shrini@gmail.com");
		customerDetails.setCustomerPAN("DTEP981914");
		customerDetails.setCustomerPhone("9821670589");
		customerDetails.setActive(true);
		
		customers.add(customerDetails);

		customerDetails.setCustomerID(1);
		customerDetails.setCustomerName("Anuradha");
		customerDetails.setCustomerEmail("anu@gmail.com");
		customerDetails.setCustomerPAN("ABCD981914");
		customerDetails.setCustomerPhone("9821670590");
		customerDetails.setActive(true);
	}
	
	@Override
	public List<CustomerDetails> customerList() {
		// TODO Auto-generated method stub
		return customers;
	}

}
