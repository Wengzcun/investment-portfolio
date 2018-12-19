package net.jr.investmentportfoliobackend.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.jr.investmentportfoliobackend.dao.FundSchemeDAO;
import net.jr.investmentportfoliobackend.dto.CustomerDetails;
import net.jr.investmentportfoliobackend.dto.FundScheme;

@Repository("fundSchemeDAO")
@Transactional
public class FundSchemeDAOImpl implements FundSchemeDAO{

	@Autowired 
	private SessionFactory sessionFactory;
	
	@Override
	public FundScheme get(int id) {
		try {
			return sessionFactory.getCurrentSession().get(FundScheme.class, Integer.valueOf(id));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<FundScheme> fundSchemeList() {
		try {
			List<FundScheme> fundSchemeList = new ArrayList<>();
			
			String selectActiveQuery = "from FundScheme where is_active = :active";
			Query query = sessionFactory.getCurrentSession().createQuery(selectActiveQuery);
			query.setParameter("active", true);
			fundSchemeList = query.getResultList();
			return fundSchemeList;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean add(FundScheme fundScheme) {
		try {
			fundScheme.setIs_active(true);
			sessionFactory.getCurrentSession().persist(fundScheme);;
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(FundScheme fundScheme) {
		try {
			sessionFactory.getCurrentSession().update(fundScheme);
			return true;			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(FundScheme fundScheme) {
		try {
			fundScheme.setIs_active(false);
			sessionFactory.getCurrentSession().update(fundScheme);
			return true;			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			e.printStackTrace();
			return false;
		}
	}

}
