package net.jr.investmentportfoliobackend.daoImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.jr.investmentportfoliobackend.dao.LifeInsuranceDAO;
import net.jr.investmentportfoliobackend.dto.CustomerDetails;
import net.jr.investmentportfoliobackend.dto.LifeInsurance;

@Repository("LifeInsuranceDAO")
@Transactional
public class LifeInsuranceDAOImpl implements LifeInsuranceDAO{

	@Autowired 
	private SessionFactory sessionFactory;
	
	@Override
	public LifeInsurance get(int id) {
		try {
			return sessionFactory.getCurrentSession().get(LifeInsurance.class, Integer.valueOf(id));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<LifeInsurance> lifeInsuranceList() {
		try {
			List<LifeInsurance> lifeInsuracneList = new ArrayList<>();
			
			String selectActiveQuery = "from LifeInsurance where is_active = :active";
			Query query = sessionFactory.getCurrentSession().createQuery(selectActiveQuery);
			query.setParameter("active", true);
			lifeInsuracneList = query.getResultList();
			return lifeInsuracneList;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean add(LifeInsurance lifeInsuracne) {
		try {
			lifeInsuracne.setIs_active(true);
			sessionFactory.getCurrentSession().persist(lifeInsuracne);;
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Update Single Record
	 */
	@Override
	public boolean update(LifeInsurance lifeInsurance) {
		try {
			sessionFactory.getCurrentSession().update(lifeInsurance);
			return true;			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			e.printStackTrace();
			return false;
		}
	}

}
