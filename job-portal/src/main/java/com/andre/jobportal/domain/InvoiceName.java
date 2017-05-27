package com.andre.jobportal.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class InvoiceName {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	/**
	 * 
	 */
	private String invoiceName;
	/**
	 * 
	 */
	private String locaiton;
	/**
	 * 
	 */
	private Integer tradeId;
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
	public String getInvoiceName() {
		return invoiceName;
	}
	/**
	 * @param invoiceName
	 */
	public void setInvoiceName(String invoiceName) {
		this.invoiceName = invoiceName;
	}
	/**
	 * @return
	 */
	public String getLocaiton() {
		return locaiton;
	}
	/**
	 * @param locaiton
	 */
	public void setLocaiton(String locaiton) {
		this.locaiton = locaiton;
	}
	/**
	 * @return
	 */
	public Integer getTradeId() {
		return tradeId;
	}
	/**
	 * @param tradeId
	 */
	public void setTradeId(Integer tradeId) {
		this.tradeId = tradeId;
	}

}
