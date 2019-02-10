package net.jr.investmentportfoliobackend.dao;

import java.util.List;

import net.jr.investmentportfoliobackend.dto.LoginDetails;

public interface LoginDetailsDAO {
	List<LoginDetails> get(String username , String Password);
}
