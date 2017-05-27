package com.andre.jobportal.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andre.jobportal.domain.InvoiceName;
import com.andre.jobportal.repositories.InvoiceRepository;

/**
 * @author akash
 *
 */
@Service
public class InvoiceServiceImpl implements InvoiceService {

	private InvoiceRepository invoiceRepository;

	@Autowired
	public void setInvoiceRepository(InvoiceRepository invoiceRepository) {
		this.invoiceRepository = invoiceRepository;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.andre.jobportal.services.InvoiceService#listAllInvoices()
	 */
	@Override
	public List<InvoiceName> listAllInvoices() {

		List<InvoiceName> list = new ArrayList<>();

		for (InvoiceName iv : invoiceRepository.findAll()) {
			list.add(iv);
		}

		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.andre.jobportal.services.InvoiceService#saveInvoice(com.andre.
	 * jobportal.domain.InvoiceName)
	 */
	@Override
	public InvoiceName saveInvoice(InvoiceName invoiceName) {

		return invoiceRepository.save(invoiceName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.andre.jobportal.services.InvoiceService#getInvoiceById(java.lang.
	 * Double)
	 */
	@Override
	public InvoiceName getInvoiceById(Double invoiceId) {
		return null;
	}

}
