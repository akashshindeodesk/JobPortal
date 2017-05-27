package com.andre.jobportal.services;

import java.util.List;

import com.andre.jobportal.domain.InvoiceName;


/**
 * @author akash
 *
 */
public interface InvoiceService {

	/**
	 * @return
	 */
	List<InvoiceName> listAllInvoices();
	/**
	 * @param invoiceName
	 * @return
	 */
	InvoiceName saveInvoice(InvoiceName invoiceName);
	/**
	 * @param invoiceId
	 * @return
	 */
	InvoiceName getInvoiceById(Double invoiceId);
}
