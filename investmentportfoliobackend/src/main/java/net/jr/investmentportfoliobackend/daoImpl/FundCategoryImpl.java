package net.jr.investmentportfoliobackend.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.jr.investmentportfoliobackend.dao.FundCategoryDAO;
import net.jr.investmentportfoliobackend.dto.FundCategory;

@Repository("fundCategoryDAO")
@Transactional
public class FundCategoryImpl implements FundCategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public FundCategory get(int id) {

		try {
			// TODO Auto-generated method stub
			return sessionFactory.getCurrentSession().get(FundCategory.class, Integer.valueOf(id));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<FundCategory> fundCategoryList() {
			try {
				List<FundCategory> fundCategoriesList = new ArrayList<>();
				String selectActiveQuery = "from FundCategory  where is_active = :active";
				Query query = sessionFactory.getCurrentSession().createQuery(selectActiveQuery);
				query.setParameter("active", true);
				fundCategoriesList = query.getResultList();
				return fundCategoriesList;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
				e.printStackTrace();
				return null;
			}

	}

	@Override
	public boolean add(FundCategory fundCategory) {
		try {
			fundCategory.setIs_active(true);
			sessionFactory.getCurrentSession().persist(fundCategory);;
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(FundCategory fundCategory) {
		try {
			sessionFactory.getCurrentSession().update(fundCategory);
			return true;			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(FundCategory fundCategory) {
		try {
			fundCategory.setIs_active(false);
			sessionFactory.getCurrentSession().update(fundCategory);
			return true;			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			e.printStackTrace();
			return false;
		}
	}

}
