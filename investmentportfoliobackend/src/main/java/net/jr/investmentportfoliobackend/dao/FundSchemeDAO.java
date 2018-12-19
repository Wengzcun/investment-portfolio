package net.jr.investmentportfoliobackend.dao;

import java.util.List;

import net.jr.investmentportfoliobackend.dto.FundScheme;

public interface FundSchemeDAO {
	
	FundScheme get(int id);
	List<FundScheme> fundSchemeList();
	boolean add(FundScheme fundScheme) ;
	boolean update(FundScheme fundScheme) ;
	boolean delete(FundScheme fundScheme) ;
	
}
