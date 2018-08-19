package net.jr.investmentportfoliobackend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customerdetails")
public class CustomerDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="customerid")
	private int customerID;
	
	@Column(name="customername")
	private String customerName;
	
	@Column(name="customeremail")
	private String customerEmail;
	
	@Column(name="customerphone")
	private String customerPhone;
	
	@Column(name="customerpan")
	private String customerPAN;
	
	@Column(name="customerpwd")
	private String customerPWD;
	
	@Column(name="is_active")
	private boolean isActive=false;
	
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
	
	@Override
	public String toString() {
		return "CustomerDetails [customerID=" + customerID + ", customerName=" + customerName + ", customerEmail="
				+ customerEmail + ", customerPhone=" + customerPhone + ", customerPAN=" + customerPAN + ", customerPWD="
				+ customerPWD + ", isActive=" + isActive + "]";
	}
	
}
