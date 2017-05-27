package com.andre.jobportal.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Position {

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	/**
	 * 
	 */
	private String pairName;
	/**
	 * 
	 */
	private Double amount;
	/**
	 * @return
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return
	 */
	public String getPairName() {
		return pairName;
	}
	/**
	 * @param pairName
	 */
	public void setPairName(String pairName) {
		this.pairName = pairName;
	}
	/**
	 * @return
	 */
	public Double getAmount() {
		return amount;
	}
	/**
	 * @param amount
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}

}
