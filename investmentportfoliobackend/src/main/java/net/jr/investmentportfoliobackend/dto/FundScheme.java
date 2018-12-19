package net.jr.investmentportfoliobackend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fundscheme")
public class FundScheme {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int fundSchemeID;
	
	@Column(name="fundschemename")
	private String fundSchemeName;
	
	@Column(name="fundcategoryid")
	private Integer fundCategoryId;
	
	@Column(name="is_active")
	private Boolean is_active;
	
	public int getFundSchemeID() {
		return fundSchemeID;
	}

	public void setFundSchemeID(int fundSchemeID) {
		this.fundSchemeID = fundSchemeID;
	}

	public String getFundSchemeName() {
		return fundSchemeName;
	}

	public void setFundSchemeName(String fundSchemeName) {
		this.fundSchemeName = fundSchemeName;
	}

	public Integer getFundCategoryId() {
		return fundCategoryId;
	}

	public void setFundCategoryId(Integer fundCategoryId) {
		this.fundCategoryId = fundCategoryId;
	}

	public Boolean getIs_active() {
		return is_active;
	}

	public void setIs_active(Boolean is_active) {
		this.is_active = is_active;
	}
	
	
}
