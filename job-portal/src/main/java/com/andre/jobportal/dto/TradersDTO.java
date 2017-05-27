package com.andre.jobportal.dto;

import java.sql.Date;

public class TradersDTO {
	
	private Integer id;

	private String traderName;
	private String date;
	private Double clientId;
	private String currencyPair;
	private Double quoteRate;
	private Double sourceAmount;
	private Double sourceDestinationId;
	private Double destAmount;
	private Double beneficiariesId;
	private String messages;
	private String tradersStatus;
	private String paymentStatus;
	private Double referralId;
	private String uploadInvoiceId;
	private String refName;
	private String refEmail;
	private String type;
	private String status = "Untraded";
	private String payment = "UnPaid";
	private Date dateCreated;

	private String clientName;
	private String beneficiaryName;
	private java.util.Date dateConverted;
	private java.util.Date dateLongCreatedDate;
	
	private String currencySymbol;
	private String destAmtSymbol;
	private String isReferal;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTraderName() {
		return traderName;
	}
	public void setTraderName(String traderName) {
		this.traderName = traderName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Double getClientId() {
		return clientId;
	}
	public void setClientId(Double clientId) {
		this.clientId = clientId;
	}
	public String getCurrencyPair() {
		return currencyPair;
	}
	public void setCurrencyPair(String currencyPair) {
		this.currencyPair = currencyPair;
	}
	public Double getQuoteRate() {
		return quoteRate;
	}
	public void setQuoteRate(Double quoteRate) {
		this.quoteRate = quoteRate;
	}
	public Double getSourceAmount() {
		return sourceAmount;
	}
	public void setSourceAmount(Double sourceAmount) {
		this.sourceAmount = sourceAmount;
	}
	public Double getSourceDestinationId() {
		return sourceDestinationId;
	}
	public void setSourceDestinationId(Double sourceDestinationId) {
		this.sourceDestinationId = sourceDestinationId;
	}
	public Double getDestAmount() {
		return destAmount;
	}
	public void setDestAmount(Double destAmount) {
		this.destAmount = destAmount;
	}
	public Double getBeneficiariesId() {
		return beneficiariesId;
	}
	public void setBeneficiariesId(Double beneficiariesId) {
		this.beneficiariesId = beneficiariesId;
	}
	public String getMessages() {
		return messages;
	}
	public void setMessages(String messages) {
		this.messages = messages;
	}
	public String getTradersStatus() {
		return tradersStatus;
	}
	public void setTradersStatus(String tradersStatus) {
		this.tradersStatus = tradersStatus;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public Double getReferralId() {
		return referralId;
	}
	public void setReferralId(Double referralId) {
		this.referralId = referralId;
	}
	public String getUploadInvoiceId() {
		return uploadInvoiceId;
	}
	public void setUploadInvoiceId(String uploadInvoiceId) {
		this.uploadInvoiceId = uploadInvoiceId;
	}
	public String getRefName() {
		return refName;
	}
	public void setRefName(String refName) {
		this.refName = refName;
	}
	public String getRefEmail() {
		return refEmail;
	}
	public void setRefEmail(String refEmail) {
		this.refEmail = refEmail;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getBeneficiaryName() {
		return beneficiaryName;
	}
	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}
	public java.util.Date getDateConverted() {
		return dateConverted;
	}
	public void setDateConverted(java.util.Date dateConverted) {
		this.dateConverted = dateConverted;
	}
	public java.util.Date getDateLongCreatedDate() {
		return dateLongCreatedDate;
	}
	public void setDateLongCreatedDate(java.util.Date dateLongCreatedDate) {
		this.dateLongCreatedDate = dateLongCreatedDate;
	}
	public String getCurrencySymbol() {
		return currencySymbol;
	}
	public void setCurrencySymbol(String currencySymbol) {
		this.currencySymbol = currencySymbol;
	}
	public String getDestAmtSymbol() {
		return destAmtSymbol;
	}
	public void setDestAmtSymbol(String destAmtSymbol) {
		this.destAmtSymbol = destAmtSymbol;
	}
	public String getIsReferal() {
		return isReferal;
	}
	public void setIsReferal(String isReferal) {
		this.isReferal = isReferal;
	}


}


