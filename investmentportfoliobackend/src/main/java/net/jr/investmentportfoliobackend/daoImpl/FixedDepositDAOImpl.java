package net.jr.investmentportfoliobackend.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.jr.investmentportfoliobackend.dao.FixedDepositDAO;
import net.jr.investmentportfoliobackend.dto.FixedDeposite;
import net.jr.investmentportfoliobackend.dto.LifeInsurance;

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
	public List<FixedDeposite> fixedDepositeCustomerWiseList(String customername) {
		try {
			
			List<FixedDeposite> fixedDepositList = new ArrayList<>();
			
			Class.forName("org.h2.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:h2:tcp://localhost/~/investmentportfolio","sa","");  
			//here sonoo is database name, root is username and password  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("SELECT * FROM FIXEDEPOSITE where is_active = true and customername = '"+customername+"'");  
			while(rs.next()) {
				FixedDeposite allDetails = new FixedDeposite();
				allDetails.setFixeddepositeID(rs.getInt(1));
				allDetails.setPolicydate(rs.getString(2));
				allDetails.setAmount(rs.getInt(3));
				allDetails.setPolicyperiod(rs.getInt(4));
				allDetails.setBankname(rs.getString(5));
				allDetails.setPolicynumber(rs.getString(6));
				allDetails.setSumassured(rs.getInt(7));
				allDetails.setPolicylastdate(rs.getString(8));
				allDetails.setCustomername(rs.getString(9));
				
				fixedDepositList.add(allDetails);
			}
			con.close();  
			
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
