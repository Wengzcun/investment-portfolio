package net.jr.investmentportfoliobackend.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.jr.investmentportfoliobackend.dao.CustomerDetailsDAO;
import net.jr.investmentportfoliobackend.dto.CustomerDetails;

@Repository("customerDetailsDao")
public class CustomerDetailsDAOImpl implements CustomerDetailsDAO {

	@Autowired
	private SessionFactory sessionFactory;
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

		customerDetails = new CustomerDetails();
		customerDetails.setCustomerID(1);
		customerDetails.setCustomerName("Anuradha");
		customerDetails.setCustomerEmail("anu@gmail.com");
		customerDetails.setCustomerPAN("ABCD981914");
		customerDetails.setCustomerPhone("9821670590");
		customerDetails.setActive(true);
		customers.add(customerDetails);
	
	}
	
	@Override
	public List<CustomerDetails> customerList() {
		// TODO Auto-generated method stub
		return customers;
	}

	@Override
	@Transactional
	public boolean add(CustomerDetails customerDetails) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().persist(customerDetails);
			
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public CustomerDetails get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
