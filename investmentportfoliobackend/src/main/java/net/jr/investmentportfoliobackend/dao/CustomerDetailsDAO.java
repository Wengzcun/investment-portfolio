package net.jr.investmentportfoliobackend.dao;

import java.util.List;

import net.jr.investmentportfoliobackend.dto.CustomerDetails;

public interface CustomerDetailsDAO {

	CustomerDetails get(int id);
	List<CustomerDetails> customerList();
	boolean add(CustomerDetails customerDetails) ;
	boolean delete(CustomerDetails customerDetails) ;
	boolean update(CustomerDetails customerDetails);


}
