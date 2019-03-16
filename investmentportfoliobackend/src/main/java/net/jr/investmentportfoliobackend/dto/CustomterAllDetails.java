package net.jr.investmentportfoliobackend.dto;

import java.util.Comparator;

public class CustomterAllDetails {

	private int customerID;
	
	private String customerName;
	
	private String customerEmail;
	
	private String customerPhone;
	
	private String customerPAN;
	
	private String customerPWD;
	
	private boolean isActive = true;

	private Integer isLifeInsurance;
	
	private Integer isFixedDeposite;
	
	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerPAN() {
		return customerPAN;
	}

	public void setCustomerPAN(String customerPAN) {
		this.customerPAN = customerPAN;
	}

	public String getCustomerPWD() {
		return customerPWD;
	}

	public void setCustomerPWD(String customerPWD) {
		this.customerPWD = customerPWD;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	} 
	
	

	public Integer getIsLifeInsurance() {
		return isLifeInsurance;
	}

	public void setIsLifeInsurance(Integer isLifeInsurance) {
		this.isLifeInsurance = isLifeInsurance;
	}

	public Integer getIsFixedDeposite() {
		return isFixedDeposite;
	}

	public void setIsFixedDeposite(Integer isFixedDeposite) {
		this.isFixedDeposite = isFixedDeposite;
	}



	public static Comparator<CustomterAllDetails> customerNameComparator = new Comparator<CustomterAllDetails>() {

		public int compare(CustomterAllDetails c1, CustomterAllDetails c2) {
		   String customerName1 = c1.getCustomerName().toUpperCase();
		   String customerName2 = c2.getCustomerName().toUpperCase();

		   //ascending order
		   return customerName1.compareTo(customerName2);

		   //descending order
		   //return customerName2.compareTo(customerName1);
	    }
	};
	
}
