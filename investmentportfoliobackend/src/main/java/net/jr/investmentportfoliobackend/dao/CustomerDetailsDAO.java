package net.jr.investmentportfoliobackend.dao;

import java.util.List;

import net.jr.investmentportfoliobackend.dto.CustomerDetails;

public interface CustomerDetailsDAO {
	List<CustomerDetails> customerList();
	
	boolean add(CustomerDetails customerDetails) ;
	CustomerDetails get(int id);

}
