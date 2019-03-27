package net.jr.investmentportfoliobackend.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.jr.investmentportfoliobackend.dao.LifeInsuranceDAO;
import net.jr.investmentportfoliobackend.dto.CustomerDetails;
import net.jr.investmentportfoliobackend.dto.CustomterAllDetails;
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
	public List<LifeInsurance> lifeInsuranceCustomerWiseList(String customername) {
		try {
			List<LifeInsurance> lifeInsuracneList = new ArrayList<>();
			
			Class.forName("org.h2.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:h2:tcp://localhost/~/investmentportfolio","sa","");  
			//here sonoo is database name, root is username and password  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("SELECT * FROM LIFEINSURANCE where is_active = true and customername = '"+customername+"'");  
			while(rs.next()) {
				LifeInsurance allDetails = new LifeInsurance();
				allDetails.setLifeInsuranceID(rs.getInt(1));
				allDetails.setPolicydate(rs.getString(2));
				allDetails.setAmount(rs.getInt(3));
				allDetails.setPolicyperiod(rs.getInt(4));
				allDetails.setSchemename(rs.getString(5));
				allDetails.setPolicynumber(rs.getString(6));
				allDetails.setSumassured(rs.getInt(7));
				allDetails.setPolicylastdate(rs.getString(8));
				allDetails.setCustomername(rs.getString(9));
				
				lifeInsuracneList.add(allDetails);
			}
			con.close();  
			
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
