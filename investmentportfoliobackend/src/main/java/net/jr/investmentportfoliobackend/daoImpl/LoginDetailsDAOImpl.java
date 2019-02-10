package net.jr.investmentportfoliobackend.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.jr.investmentportfoliobackend.dao.LoginDetailsDAO;
import net.jr.investmentportfoliobackend.dto.LoginDetails;

@Repository("LoginDetailsDAO")
@Transactional
public class LoginDetailsDAOImpl implements LoginDetailsDAO{

	@Autowired 
	private SessionFactory sessionFactory;
	
	@Override
	public List<LoginDetails> get(String username, String Password) {
		// TODO Auto-generated method stub
		
		List<LoginDetails> loginDetailsList = new ArrayList<>();
		
		String selectActiveQuery = "from LoginDetails where username = :uname and userpwd = :upwd";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveQuery);
		query.setParameter("uname", username);
		query.setParameter("upwd", Password);
		loginDetailsList = query.getResultList();
		
		return loginDetailsList;
	}

}
