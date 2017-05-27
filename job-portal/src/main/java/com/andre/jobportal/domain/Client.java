package com.andre.jobportal.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer clientId;

	private String name;
	private String wyreAccountID;
	private String country;
	private Integer clientSource;

	private Date createdDate;

	/**
	 * @return
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return
	 */
	public Integer getClientId() {
		return clientId;
	}

	/**
	 * @param clientId
	 */
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return
	 */
	public String getWyreAccountID() {
		return wyreAccountID;
	}

	/**
	 * @param wyreAccountID
	 */
	public void setWyreAccountID(String wyreAccountID) {
		this.wyreAccountID = wyreAccountID;
	}

	/**
	 * @return
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return
	 */
	public Integer getClientSource() {
		return clientSource;
	}

	/**
	 * @param clientSource
	 */
	public void setClientSource(Integer clientSource) {
		this.clientSource = clientSource;
	}

	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", name=" + name + ", wyreAccountID=" + wyreAccountID + ", country="
				+ country + ", clientSource=" + clientSource + "]";
	}

}
