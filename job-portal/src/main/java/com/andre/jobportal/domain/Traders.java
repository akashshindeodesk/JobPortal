package com.andre.jobportal.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Traders {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id = 0;

	/**
	 * 
	 */
	private String traderName ="";
	/**
	 * 
	 */
	private String date ="";
	/**
	 * 
	 */
	private Double clientId = 0.0;
	/**
	 * 
	 */
	private String currencyPair ="";
	/**
	 * 
	 */
	private Double quoteRate = 0.0;
	/**
	 * 
	 */
	private Double sourceAmount= 0.0; ;
	/**
	 * 
	 */
	private Double sourceDestinationId = 0.0;;
	/**
	 * 
	 */
	private Double destAmount = 0.0;;
	/**
	 * 
	 */
	private Double beneficiariesId = 0.0;;
	/**
	 * 
	 */
	private String messages = "";
	/**
	 * 
	 */
	private String tradersStatus;
	/**
	 * 
	 */
	private String paymentStatus;
	/**
	 * 
	 */
	private Double referralId = 0.0; ;
	/**
	 * 
	 */
	private String uploadInvoiceId;
	/**
	 * 
	 */
	private String refName = "";
	/**
	 * 
	 */
	private String refEmail = "";
	/**
	 * 
	 */
	private String type = "";
	/**
	 * 
	 */
	private String status = "Untraded";
	/**
	 * 
	 */
	private String payment = "UnPaid";
	/**
	 * 
	 */
	private Date dateCreated ;
	
	/**
	 * 
	 */
	private String currencySymbol = "dollar";
	/**
	 * 
	 */
	private String destAmtSymbol = "dollar";
	/**
	 * 
	 */
	private String isReferal = "yes";

	/**
	 * @return
	 */
	public String getIsReferal() {
		return isReferal;
	}

	/**
	 * @param isReferal
	 */
	public void setIsReferal(String isReferal) {
		this.isReferal = isReferal;
	}

	
	/**
	 * @return
	 */
	public String getDestAmtSymbol() {
		return destAmtSymbol;
	}

	/**
	 * @param destAmtSymbol
	 */
	public void setDestAmtSymbol(String destAmtSymbol) {
		this.destAmtSymbol = destAmtSymbol;
	}
	
	/**
	 * @return
	 */
	public Date getDateCreated() {
		return dateCreated;
	}

	/**
	 * @param dateCreated
	 */
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}


	/**
	 * @return
	 */
	public String getCurrencySymbol() {
		return currencySymbol;
	}

	/**
	 * @param currencySymbol
	 */
	public void setCurrencySymbol(String currencySymbol) {
		this.currencySymbol = currencySymbol;
	}

	/**
	 * @return
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return
	 */
	public String getPayment() {
		return payment;
	}

	/**
	 * @param payment
	 */
	public void setPayment(String payment) {
		this.payment = payment;
	}

	/**
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return
	 */
	public String getRefName() {
		return refName;
	}

	/**
	 * @param refName
	 */
	public void setRefName(String refName) {
		this.refName = refName;
	}

	/**
	 * @return
	 */
	public String getRefEmail() {
		return refEmail;
	}

	/**
	 * @param refEmail
	 */
	public void setRefEmail(String refEmail) {
		this.refEmail = refEmail;
	}

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
	public String getTraderName() {
		return traderName;
	}

	/**
	 * @param traderName
	 */
	public void setTraderName(String traderName) {
		this.traderName = traderName;
	}

	/**
	 * @return
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return
	 */
	public Double getClientId() {
		return clientId;
	}

	/**
	 * @param clientId
	 */
	public void setClientId(Double clientId) {
		this.clientId = clientId;
	}

	/**
	 * @return
	 */
	public String getCurrencyPair() {
		return currencyPair;
	}

	/**
	 * @param currencyPair
	 */
	public void setCurrencyPair(String currencyPair) {
		this.currencyPair = currencyPair;
	}

	/**
	 * @return
	 */
	public Double getQuoteRate() {
		return quoteRate;
	}

	/**
	 * @param quoteRate
	 */
	public void setQuoteRate(Double quoteRate) {
		this.quoteRate = quoteRate;
	}

	/**
	 * @return
	 */
	public Double getSourceAmount() {
		return sourceAmount;
	}

	/**
	 * @param sourceAmount
	 */
	public void setSourceAmount(Double sourceAmount) {
		this.sourceAmount = sourceAmount;
	}

	/**
	 * @return
	 */
	public Double getSourceDestinationId() {
		return sourceDestinationId;
	}

	/**
	 * @param sourceDestinationId
	 */
	public void setSourceDestinationId(Double sourceDestinationId) {
		this.sourceDestinationId = sourceDestinationId;
	}

	/**
	 * @return
	 */
	public Double getDestAmount() {
		return destAmount;
	}

	/**
	 * @param destAmount
	 */
	public void setDestAmount(Double destAmount) {
		this.destAmount = destAmount;
	}

	/**
	 * @return
	 */
	public Double getBeneficiariesId() {
		return beneficiariesId;
	}

	/**
	 * @param beneficiariesId
	 */
	public void setBeneficiariesId(Double beneficiariesId) {
		this.beneficiariesId = beneficiariesId;
	}

	/**
	 * @return
	 */
	public String getMessages() {
		return messages;
	}

	/**
	 * @param messages
	 */
	public void setMessages(String messages) {
		this.messages = messages;
	}

	/**
	 * @return
	 */
	public String getTradersStatus() {
		return tradersStatus;
	}

	/**
	 * @param tradersStatus
	 */
	public void setTradersStatus(String tradersStatus) {
		this.tradersStatus = tradersStatus;
	}

	/**
	 * @return
	 */
	public String getPaymentStatus() {
		return paymentStatus;
	}

	/**
	 * @param paymentStatus
	 */
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	/**
	 * @return
	 */
	public Double getReferralId() {
		return referralId;
	}

	/**
	 * @param referralId
	 */
	public void setReferralId(Double referralId) {
		this.referralId = referralId;
	}

	/**
	 * @return
	 */
	public String getUploadInvoiceId() {
		return uploadInvoiceId;
	}

	/**
	 * @param uploadInvoiceId
	 */
	public void setUploadInvoiceId(String uploadInvoiceId) {
		this.uploadInvoiceId = uploadInvoiceId;
	}

	@Override
	public String toString() {
		return "Traders [id=" + id + ", traderName=" + traderName + ", date=" + date + ", clientId=" + clientId
				+ ", currencyPair=" + currencyPair + ", quoteRate=" + quoteRate + ", sourceAmount=" + sourceAmount
				+ ", sourceDestinationId=" + sourceDestinationId + ", destAmount=" + destAmount + ", beneficiariesId="
				+ beneficiariesId + ", messages=" + messages + ", tradersStatus=" + tradersStatus + ", paymentStatus="
				+ paymentStatus + ", referralId=" + referralId + ", uploadInvoiceId=" + uploadInvoiceId + "]";
	}

}
