package net.jr.investmentportfoliobackend.dao;

import java.util.List;

import net.jr.investmentportfoliobackend.dto.LifeInsurance;

public interface LifeInsuranceDAO {
	LifeInsurance get(int id);
	List<LifeInsurance> lifeInsuranceList();
	List<LifeInsurance> lifeInsuranceCustomerWiseList(String customername);
	boolean add(LifeInsurance lifeInsurance) ;
	boolean update(LifeInsurance lifeInsurance);
}
