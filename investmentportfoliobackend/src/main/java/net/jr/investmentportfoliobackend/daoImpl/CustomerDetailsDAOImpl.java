package net.jr.investmentportfoliobackend.daoImpl;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.jr.investmentportfoliobackend.dao.CustomerDetailsDAO;
import net.jr.investmentportfoliobackend.dao.LifeInsuranceDAO;
import net.jr.investmentportfoliobackend.dto.CustomerDetails;
import net.jr.investmentportfoliobackend.dto.FundCategory;
import net.jr.investmentportfoliobackend.dto.FundScheme;
import net.jr.investmentportfoliobackend.dto.LifeInsurance;

@Repository("customerDetailsDAO")
@Transactional
public class CustomerDetailsDAOImpl implements CustomerDetailsDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * Getting Customer Details of single Customer by id(Primary key)
	 */
	@Override
	public CustomerDetails get(int id) {
		try {
			// TODO Auto-generated method stub
			return sessionFactory.getCurrentSession().get(CustomerDetails.class, Integer.valueOf(id));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Getting Customer Details Complete Record
	 */
	@Override
	public List<CustomerDetails> customerList() {
		// TODO Auto-generated method stub
		try {
			List<CustomerDetails> customerDetailsList = new ArrayList<>();
			
			String selectActiveQuery = "from CustomerDetails where is_active = :active";
			Query query = sessionFactory.getCurrentSession().createQuery(selectActiveQuery);
			query.setParameter("active", true);
			customerDetailsList = query.getResultList();
			return customerDetailsList;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public boolean add(CustomerDetails customerDetails) {
		// TODO Auto-generated method stub
		try {
			customerDetails.setActive(true);
			sessionFactory.getCurrentSession().persist(customerDetails);;
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
	public boolean update(CustomerDetails customerDetails) {
		try {
			sessionFactory.getCurrentSession().update(customerDetails);
			
			/*List<LifeInsurance> lifeInsuracneList = new ArrayList<>();
			
			String selectActiveQuery = "from LifeInsurance where customername = :customername";
			Query query = sessionFactory.getCurrentSession().createQuery(selectActiveQuery);
			query.setParameter("customername", customerDetails.getCustomerName());
			lifeInsuracneList = query.getResultList();
			Iterator<LifeInsurance> it = lifeInsuracneList.iterator();
			while (it.hasNext()) {
				LifeInsurance lifeInsurance = (LifeInsurance) it.next();
				lifeInsurance.setCustomername(customerDetails.getCustomerName());
				LifeInsuranceDAOImpl insuranceDAOImpl  = new LifeInsuranceDAOImpl();
				insuranceDAOImpl.update(lifeInsurance);
			}
			*/
			return true;			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Delete Single Record
	 */

	@Override
	public boolean delete(CustomerDetails customerDetails) {
		try {
			customerDetails.setActive(false);
			sessionFactory.getCurrentSession().update(customerDetails);
			return true;			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			e.printStackTrace();
			return false;
		}

	}
	
	public List<CustomerDetails> customerListFromExcel() {
		List<CustomerDetails> customers = new ArrayList<>();
		try {
			//Create file system using specific name
			File file = new File("/Users/jayaditya/Documents/customerDetails.xlsx");
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);//I created Object of workbook
			XSSFSheet spreadsheet = workbook.getSheetAt(0);//Will read first sheet

			
			Iterator < Row >  rowIterator = spreadsheet.iterator();
		      
		     while (rowIterator.hasNext()) {
		 		 CustomerDetails customerDetails = new CustomerDetails();
		         Row row = (XSSFRow) rowIterator.next();
		         
		         for(int cn = 1 ; cn<row.getLastCellNum();cn++) {
			            Cell cell = row.getCell(cn);
			            
			            if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK) {
			                // Can't be this cell - it's empty
			                continue;
			            }
			            switch(cn) {
			            case 1:
			        		customerDetails.setCustomerName(cell.getStringCellValue());
			            	break;
			            case 2:
			        		customerDetails.setCustomerEmail(cell.getStringCellValue());
			            	break;
			            case 3:
			        		customerDetails.setCustomerPAN(cell.getStringCellValue());
			            	break;
			            case 4:
			        		customerDetails.setCustomerPhone(Double.toString(cell.getNumericCellValue()));
			            	break;

			            }
		         }
		         customers.add(customerDetails);
		      }
		      fis.close();
		      
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return customers;
	}
	
}
