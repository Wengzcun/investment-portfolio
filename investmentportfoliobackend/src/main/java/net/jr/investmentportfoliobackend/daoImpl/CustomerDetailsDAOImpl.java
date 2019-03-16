package net.jr.investmentportfoliobackend.daoImpl;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
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
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.jr.investmentportfoliobackend.dao.CustomerDetailsDAO;
import net.jr.investmentportfoliobackend.dto.CustomerDetails;
import net.jr.investmentportfoliobackend.dto.CustomterAllDetails;

@Repository("customerDetailsDAO")
@Transactional
public class CustomerDetailsDAOImpl implements CustomerDetailsDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	JdbcTemplate template;    
    
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}    

	
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
	public List<CustomerDetails> get() {
		// TODO Auto-generated method stub
		try {
			List<CustomerDetails> customerDetailsList = new ArrayList<>();
			
			String selectActiveQuery = "from CustomerDetails where is_active = :active";
			Query query = sessionFactory.getCurrentSession().createQuery(selectActiveQuery);
			query.setParameter("active", true);
			customerDetailsList = query.getResultList();
			
			Collections.sort(customerDetailsList, CustomerDetails.customerNameComparator);
			
			return customerDetailsList;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			e.printStackTrace();
			return null;
		}

	}
	
	@Override
	public List<CustomterAllDetails> getAllCustomerDetails() {
		// TODO Auto-generated method stub
		try {
			List<CustomterAllDetails> customerDetailsList = new ArrayList<>();
			
			/*customerDetailsList = template.query("SELECT * FROM CUSTOMERDETAILS",new RowMapper<CustomterAllDetails>(){    
			        public CustomterAllDetails mapRow(ResultSet rs, int row) throws SQLException {    
			        	CustomterAllDetails e=new CustomterAllDetails();   
			            e.setCustomerID(rs.getInt(1));    
			            e.setCustomerName(rs.getString(2));    
			            e.setCustomerEmail(rs.getString(3));    
			            e.setCustomerPAN(rs.getString(4));
			            e.setCustomerPAN(rs.getString(5));    
			            return e;    
			        }    
			    });    
			
			
			private final static String DATABASE_URL="jdbc:h2:tcp://localhost/~/investmentportfolio";
			private final static String DATABASE_DRIVER="org.h2.Driver";
			private final static String DATABASE_DIALECT="org.hibernate.dialect.H2Dialect";
			private final static String DATABASE_USERNAME="sa";
			private final static String DATABASE_PASSWORD="";
			*/
			
			Class.forName("org.h2.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:h2:tcp://localhost/~/investmentportfolio","sa","");  
			//here sonoo is database name, root is username and password  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("SELECT * FROM CUSTOMERDETAILS where is_active = true");  
			while(rs.next()) {
				CustomterAllDetails allDetails = new CustomterAllDetails();
				allDetails.setCustomerID(rs.getInt(1));
				String  customerName = rs.getString(2);
				allDetails.setCustomerName(customerName);
				allDetails.setCustomerEmail(rs.getString(3));
				allDetails.setCustomerPhone(rs.getString(4));
				allDetails.setCustomerPAN(rs.getString(5));
				allDetails.setIsLifeInsurance(0);
				if(!customerName.equals(null)) {
					Statement stmt1=con.createStatement();  
					ResultSet rs1=stmt1.executeQuery("select count(*) from LIFEINSURANCE where customername = '"+customerName+"'");  
					rs1.next();
					allDetails.setIsLifeInsurance(rs1.getInt(1));
				}
				
				allDetails.setIsFixedDeposite(0);
				if(!customerName.equals(null)) {
					Statement stmt2=con.createStatement();  
					ResultSet rs2=stmt2.executeQuery("select count(*) from fixedeposite where customername = '"+customerName+"'");  
					rs2.next();
					allDetails.setIsFixedDeposite(rs2.getInt(1));
				}
				
				customerDetailsList.add(allDetails);
			}
			//System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
			con.close();  
			/*String selectActiveQuery = "from CustomerDetails where is_active = :active";
			Query query = sessionFactory.getCurrentSession().createQuery(selectActiveQuery);
			query.setParameter("active", true);
			
			customerDetailsList = query.getResultList();
			*/
			Collections.sort(customerDetailsList, CustomterAllDetails.customerNameComparator);
			
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
			
			//CustomerDetails customerDetails2 = get(customerDetails.getCustomerID());
			//String customerName = customerDetails2.getCustomerName();
			
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
