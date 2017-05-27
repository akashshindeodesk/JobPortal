package com.andre.jobportal.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.andre.jobportal.domain.Benefieciary;
import com.andre.jobportal.domain.Client;
import com.andre.jobportal.domain.InvoiceName;
import com.andre.jobportal.domain.Referral;
import com.andre.jobportal.domain.Traders;
import com.andre.jobportal.dto.TradersDTO;
import com.andre.jobportal.services.BenefiencyService;
import com.andre.jobportal.services.ClientService;
import com.andre.jobportal.services.InvoiceService;
import com.andre.jobportal.services.ReferralService;
import com.andre.jobportal.services.TradersService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author akash
 *
 */
@Controller
public class TradersController {

	/**
	 * 
	 */
	private TradersService tradersService;
	/**
	 * 
	 */
	private ClientService clientService;
	/**
	 * 
	 */
	private BenefiencyService benefiencyService;

	/**
	 * 
	 */
	private ReferralService referralService;

	/**
	 * 
	 */
	private InvoiceService invoiceService;

	/**
	 * @param rService
	 */
	@Autowired
	public void setCountryService(ReferralService rService) {
		this.referralService = rService;
	}

	/**
	 * @param iService
	 */
	@Autowired
	public void setInvoiceService(InvoiceService iService) {
		this.invoiceService = iService;
	}

	/**
	 * @param bService
	 */
	@Autowired
	public void setBenefiencyService(BenefiencyService bService) {
		this.benefiencyService = bService;
	}

	/**
	 * @param traderService
	 */
	@Autowired
	public void setClientService(ClientService traderService) {
		this.clientService = traderService;
	}

	/**
	 * @param traderService
	 */
	@Autowired
	public void setTradersService(TradersService traderService) {
		this.tradersService = traderService;
	}

	/**
	 * Upload single file using Spring Controller
	 */
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public ResponseEntity<String> uploadFileHandler(@RequestParam("name") String name,
			@RequestParam("file") MultipartFile file) {

		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();
				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath() + File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				InvoiceName iname = new InvoiceName();
				iname.setInvoiceName("Trading Invoice");
				iname.setLocaiton(serverFile.getAbsolutePath());
				int tradesId = tradersService.getAllTradesSize();
				iname.setTradeId(tradesId);
				invoiceService.saveInvoice(iname);

				return new ResponseEntity<>("You successfully uploaded file=" + name, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>("You successfully uploaded file=" + e.getMessage(),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			return new ResponseEntity<>("Empty file uploaded" + name, HttpStatus.NO_CONTENT);

		}
	}

	/**
	 * @return list of trades
	 */
	@RequestMapping(value = "/listTrades", method = RequestMethod.GET)
	public ResponseEntity<List<TradersDTO>> list() {

		List<TradersDTO> list = new ArrayList<>();

		for (Traders t : tradersService.listAllTrades()) {

			TradersDTO traders = new TradersDTO();
			traders.setBeneficiariesId(t.getBeneficiariesId());

			traders.setCurrencyPair(t.getCurrencyPair());
			traders.setDate(t.getDate());

			traders.setDateCreated(t.getDateCreated());
			traders.setDestAmount(t.getDestAmount());
			traders.setDestAmtSymbol(t.getDestAmtSymbol());
			traders.setId(t.getId());
			traders.setIsReferal(t.getIsReferal());
			traders.setMessages(t.getMessages());
			traders.setPayment(t.getPayment());
			traders.setPaymentStatus(t.getPaymentStatus());
			traders.setQuoteRate(t.getQuoteRate());

			traders.setRefEmail(t.getRefEmail());
			traders.setReferralId(t.getReferralId());

			traders.setRefName(t.getRefName());
			traders.setSourceAmount(t.getSourceAmount());
			traders.setSourceDestinationId(t.getSourceDestinationId());
			traders.setStatus(t.getStatus());
			traders.setTraderName(t.getTraderName());
			traders.setTradersStatus(t.getTradersStatus());
			traders.setType(t.getType());
			traders.setUploadInvoiceId(t.getUploadInvoiceId());

			if (t.getClientId() != null) {
				Client c = clientService.getClientById(t.getClientId());
				if (c != null)
					traders.setClientName(c.getName());
			}

			if (t.getBeneficiariesId() != null) {
				Benefieciary b = benefiencyService.getBeneficiaryById(t.getBeneficiariesId());
				if (b != null)
					traders.setBeneficiaryName(b.getName());
			}

			if (t.getDate() != null) {
				java.util.Date date1;
				try {
					date1 = new SimpleDateFormat("dd/MM/yyyy").parse(t.getDate());
					traders.setDateConverted(date1);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}

			list.add(traders);
		}

		if (list.size() > 0) {
			return new ResponseEntity<List<TradersDTO>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<TradersDTO>>(list, HttpStatus.NO_CONTENT);
		}
	}

	/**
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("product/{id}")
	public String showProduct(@PathVariable Integer id, Model model) {
		model.addAttribute("product", tradersService.getProductById(id));
		return "productshow";
	}

	/**
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("product/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		model.addAttribute("product", tradersService.getProductById(id));
		return "productform";
	}

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping("product/new")
	public String newProduct(Model model) {
		model.addAttribute("product", new Traders());
		return "productform";
	}

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping("tabsData")
	public String tabsProduct(Model model) {
		return "products";
	}

	/**
	 * @param t
	 * @return
	 */
	@RequestMapping(value = "traders", method = RequestMethod.POST)
	public ResponseEntity<Traders> saveTrade(@RequestBody TradersDTO t) {

		Traders traders = new Traders();
		traders.setBeneficiariesId(t.getBeneficiariesId());
		traders.setClientId(t.getClientId());
		traders.setCurrencyPair(t.getCurrencyPair());
		traders.setDate(t.getDate());

		traders.setDateCreated(t.getDateCreated());
		traders.setDestAmount(t.getDestAmount());
		if (t.getDestAmtSymbol() == "" || t.getDestAmtSymbol() == null) {
			traders.setDestAmtSymbol("dollar");
		} else {
			traders.setDestAmtSymbol(t.getDestAmtSymbol());
		}

		if (t.getCurrencySymbol() == "" || t.getCurrencySymbol() == null) {
			traders.setCurrencySymbol("dollar");
		} else {
			traders.setCurrencySymbol(t.getDestAmtSymbol());
		}

		traders.setId(t.getId());
		traders.setIsReferal(t.getIsReferal());
		traders.setMessages(t.getMessages());
		traders.setPayment(t.getPayment());
		traders.setPaymentStatus(t.getPaymentStatus());
		traders.setQuoteRate(t.getQuoteRate());

		traders.setRefEmail(t.getRefEmail());
		traders.setReferralId(t.getReferralId());

		traders.setRefName(t.getRefName());
		traders.setSourceAmount(t.getSourceAmount());
		traders.setSourceDestinationId(t.getSourceDestinationId());
		traders.setStatus(t.getStatus());
		traders.setTraderName(t.getTraderName());
		traders.setTradersStatus(t.getTradersStatus());
		traders.setType(t.getType());
		traders.setUploadInvoiceId(t.getUploadInvoiceId());

		traders.setDateCreated(new Date(Calendar.getInstance().getTime().getTime()));
		if (t.getIsReferal().equals("yes")) {

			Referral r = new Referral();

			if (t.getRefName() != null) {
				r.setName(t.getRefName());
			} else {
				r.setName("");
			}

			if (t.getRefEmail() != null) {
				r.setEmailId(t.getRefEmail());
			} else {
				r.setEmailId("");
			}

			Referral rf = referralService.saveReferral(r);

			if (rf != null) {
				traders.setReferralId(Double.parseDouble(rf.getId() + ""));
			}
		}
		Traders trade = tradersService.saveTrade(traders);
		if (trade != null) {
			return new ResponseEntity<>(trade, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(trade, HttpStatus.NO_CONTENT);
		}
	}

	/**
	 * @param trade
	 * @param file
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "saveTradeDataAndFile", method = RequestMethod.POST)
	@ResponseBody
	public Object saveUserDataAndFile(@RequestParam(value = "trade") String trade,
			@RequestParam(value = "file") MultipartFile file, HttpServletRequest request) {

		ObjectMapper mapper = new ObjectMapper();
		try {

			TradersDTO t = mapper.readValue(trade, TradersDTO.class);
			Traders traders = new Traders();
			if (t.getBeneficiariesId() != null) {
				traders.setBeneficiariesId(t.getBeneficiariesId());
			}

			if (t.getClientId() != null) {
				traders.setClientId(t.getClientId());

			}
			if (t.getCurrencyPair() != null) {
				traders.setCurrencyPair(t.getCurrencyPair());
			}

			if (t.getDate() != null) {

				traders.setDate(t.getDate());

			}

			if (t.getDateCreated() != null) {
				traders.setDateCreated(t.getDateCreated());
			}

			if (t.getDestAmount() != null) {
				traders.setDestAmount(t.getDestAmount());
			}

			if (t.getDestAmtSymbol() == "" || t.getDestAmtSymbol() == null) {
				traders.setDestAmtSymbol("dollar");
			} else {
				traders.setDestAmtSymbol(t.getDestAmtSymbol());
			}

			if (t.getCurrencySymbol() == "" || t.getCurrencySymbol() == null) {
				traders.setCurrencySymbol("dollar");
			} else {
				traders.setCurrencySymbol(t.getDestAmtSymbol());
			}

			if (t.getIsReferal() != null) {
				traders.setIsReferal(t.getIsReferal());
			}

			if (t.getMessages() != null) {
				traders.setMessages(t.getMessages());
			}

			if (t.getPayment() != null) {
				traders.setPayment(t.getPayment());
			}

			if (t.getPaymentStatus() != null) {
				traders.setPaymentStatus(t.getPaymentStatus());
			}

			if (t.getQuoteRate() != null) {
				traders.setQuoteRate(t.getQuoteRate());

			}

			if (t.getRefEmail() != null) {
				traders.setRefEmail(t.getRefEmail());

			}

			if (t.getRefName() != null) {
				traders.setRefName(t.getRefName());

			}

			if (t.getSourceAmount() != null) {
				traders.setSourceAmount(t.getSourceAmount());
			}

			if (t.getSourceDestinationId() != null) {
				traders.setSourceDestinationId(t.getSourceDestinationId());
			}

			traders.setStatus(t.getStatus());

			if (t.getTraderName() != null) {
				traders.setTraderName(t.getTraderName());

			}

			traders.setTradersStatus(t.getTradersStatus());
			if (t.getType() != null) {
				traders.setType(t.getType());
			}

			traders.setDateCreated(new Date(Calendar.getInstance().getTime().getTime()));
			if (t.getIsReferal().equals("yes")) {
				Referral r = new Referral();
				if (t.getRefName() != null) {
					r.setName(t.getRefName());
				} else {
					r.setName("");
				}

				if (t.getRefEmail() != null) {
					r.setEmailId(t.getRefEmail());
				} else {
					r.setEmailId("");
				}
				Referral rf = referralService.saveReferral(r);
				if (rf != null) {
					traders.setReferralId(Double.parseDouble(rf.getId() + ""));
				}
			}

			Traders tr = tradersService.saveTrade(traders);
			String rootDirectory = "\testUpload\\";
			try {
				file.transferTo(new File(rootDirectory + file.getOriginalFilename()));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			InvoiceName iname = new InvoiceName();
			iname.setInvoiceName("Trading Invoice");
			iname.setLocaiton(rootDirectory + "" + file.getOriginalFilename());
			iname.setTradeId(tr.getId());
			InvoiceName in = invoiceService.saveInvoice(iname);
			if (in != null) {

				traders.setUploadInvoiceId(in.getId() + "");

			}

			return tradersService.saveTrade(traders);

		} catch (JsonParseException e1) {
			e1.printStackTrace();
		} catch (JsonMappingException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		return null;

	}

}
