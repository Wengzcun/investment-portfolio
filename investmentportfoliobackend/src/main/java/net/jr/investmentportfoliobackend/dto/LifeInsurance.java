package net.jr.investmentportfoliobackend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lifeinsurance")
public class LifeInsurance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int lifeInsuranceID;
	@Column(name="policydate")
	private String policydate;
	@Column(name="amount")
	private Integer amount;
	@Column(name="policyperiod")
	private Integer policyperiod;
	@Column(name="schemename")
	private String schemename;
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

	public int getLifeInsuranceID() {
		return lifeInsuranceID;
	}
	public void setLifeInsuranceID(int lifeInsuranceID) {
		this.lifeInsuranceID = lifeInsuranceID;
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
	public String getSchemename() {
		return schemename;
	}
	public void setSchemename(String schemename) {
		this.schemename = schemename;
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
	
}
