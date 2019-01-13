package net.jr.investmentportfoliobackend.dao;

import java.util.List;

import net.jr.investmentportfoliobackend.dto.FixedDeposite;

public interface FixedDepositDAO {

	FixedDeposite get(int id);
	List<FixedDeposite> fixedDepositeList();
	boolean add(FixedDeposite fixedDeposite) ;
	
}
