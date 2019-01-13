package net.jr.investmentportfoliobackend.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.jr.investmentportfoliobackend.dao.FixedDepositDAO;
import net.jr.investmentportfoliobackend.dto.FixedDeposite;

@Repository("fixedDepositDAO")
@Transactional
public class FixedDepositDAOImpl implements FixedDepositDAO {

	
	@Autowired 
	private SessionFactory sessionFactory;
	
	@Override
	public FixedDeposite get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FixedDeposite> fixedDepositeList() {
		try {
			List<FixedDeposite> fixedDepositList = new ArrayList<>();
			
			String selectActiveQuery = "from FixedDeposite where is_active = :active";
			Query query = sessionFactory.getCurrentSession().createQuery(selectActiveQuery);
			query.setParameter("active", true);
			fixedDepositList = query.getResultList();
			return fixedDepositList;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean add(FixedDeposite fixedDeposite) {
		try {
			fixedDeposite.setIs_active(true);
			sessionFactory.getCurrentSession().persist(fixedDeposite);;
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			e.printStackTrace();
			return false;
		}
	}

}
