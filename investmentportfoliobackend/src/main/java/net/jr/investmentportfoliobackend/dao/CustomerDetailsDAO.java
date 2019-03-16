package net.jr.investmentportfoliobackend.dao;

import java.util.List;

import net.jr.investmentportfoliobackend.dto.CustomerDetails;
import net.jr.investmentportfoliobackend.dto.CustomterAllDetails;

public interface CustomerDetailsDAO {

	CustomerDetails get(int id);
	List<CustomerDetails> get();
	List<CustomterAllDetails> getAllCustomerDetails();
	boolean add(CustomerDetails customerDetails) ;
	boolean delete(CustomerDetails customerDetails) ;
	boolean update(CustomerDetails customerDetails);
	

}
