package net.jr.investmentportfoliobackend.dao;

import java.util.List;

import net.jr.investmentportfoliobackend.dto.FundCategory;

public interface FundCategoryDAO {

	FundCategory get(int id);
	List<FundCategory> fundCategoryList();
	boolean add(FundCategory fundCategory) ;
	boolean update(FundCategory fundCategory) ;
	boolean delete(FundCategory fundCategory) ;
	
}
