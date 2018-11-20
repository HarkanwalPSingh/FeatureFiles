package com.cg.banking.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;
import com.cg.banking.exceptions.AccountBlockedException;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.BankingServicesDownException;
import com.cg.banking.exceptions.InsufficientAmountException;
import com.cg.banking.exceptions.InvalidPinNumberException;
import com.cg.banking.services.BankingServices;



@Controller
public class TransactionController {
	@Autowired
	private BankingServices bankingServices;
	
	@RequestMapping("/transactions")
	public ModelAndView viewTransactionsAction(@RequestParam("accountNumber") Long accountNumber,@RequestParam("pinNumber") int pinNumber){
		try {
			List<Transaction> transactions;
			Account account = bankingServices.getAccountDetails(accountNumber);
			if(account.getPinNumber()==pinNumber)
			transactions = bankingServices.getAccountAllTransaction(accountNumber);
			else throw new InvalidPinNumberException("Invalid Pin Number");
			return new ModelAndView("transactionDetailsPage", "transactions", transactions);
		} catch (NumberFormatException | BankingServicesDownException | AccountNotFoundException | InvalidPinNumberException e) {
			return new ModelAndView("transactionPage", "exception", e.getMessage());
		}
		
	}
	
}
