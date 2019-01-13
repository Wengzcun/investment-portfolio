package net.jr.investmentportfoliobackend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fixedeposite")
public class FixedDeposite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int fixeddepositeID;
	@Column(name="policydate")
	private String policydate;
	@Column(name="amount")
	private Integer amount;
	@Column(name="policyperiod")
	private Integer policyperiod;
	@Column(name="bankname")
	private String bankname;
	@Column(name="policynumber")
	private String policynumber;
	@Column(name="sumassured")
	private Integer sumassured;
	@Column(name="policylastdate")
	private String policylastdate;
	@Column(name="customername")
	private String customername;
	@Column(name="is_active")
	private Boolean is_active;
	@Column(name="interest")
	private String interset;
	
	public int getFixeddepositeID() {
		return fixeddepositeID;
	}
	public void setFixeddepositeID(int fixeddepositeID) {
		this.fixeddepositeID = fixeddepositeID;
	}
	public String getPolicydate() {
		return policydate;
	}
	public void setPolicydate(String policydate) {
		this.policydate = policydate;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Integer getPolicyperiod() {
		return policyperiod;
	}
	public void setPolicyperiod(Integer policyperiod) {
		this.policyperiod = policyperiod;
	}
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	public String getPolicynumber() {
		return policynumber;
	}
	public void setPolicynumber(String policynumber) {
		this.policynumber = policynumber;
	}
	public Integer getSumassured() {
		return sumassured;
	}
	public void setSumassured(Integer sumassured) {
		this.sumassured = sumassured;
	}
	public String getPolicylastdate() {
		return policylastdate;
	}
	public void setPolicylastdate(String policylastdate) {
		this.policylastdate = policylastdate;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public Boolean getIs_active() {
		return is_active;
	}
	public void setIs_active(Boolean is_active) {
		this.is_active = is_active;
	}
	public String getInterset() {
		return interset;
	}
	public void setInterset(String interset) {
		this.interset = interset;
	}
	
	
	
}
