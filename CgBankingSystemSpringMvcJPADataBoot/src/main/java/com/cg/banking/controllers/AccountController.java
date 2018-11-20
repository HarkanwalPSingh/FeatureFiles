package com.cg.banking.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.banking.beans.Account;
import com.cg.banking.exceptions.AccountBlockedException;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.BankingServicesDownException;
import com.cg.banking.exceptions.InsufficientAmountException;
import com.cg.banking.exceptions.InvalidAccountTypeException;
import com.cg.banking.exceptions.InvalidAmountException;
import com.cg.banking.exceptions.InvalidPinNumberException;
import com.cg.banking.services.BankingServices;

@Controller
public class AccountController {
	@Autowired
	private BankingServices bankingServices;
	private Account account;

	@RequestMapping("/registerAccount")
	public ModelAndView registerAccountAction(@Valid @ModelAttribute Account account, BindingResult result) {
		if (result.hasErrors())
			return new ModelAndView("openAccountPage");
		try {
			account = bankingServices.openAccount(account);
			return new ModelAndView("openAccountSuccessPage", "account", account);
		} catch (InvalidAmountException | InvalidAccountTypeException | BankingServicesDownException e) {
			return new ModelAndView("openAccountPage", "exception", e.getMessage());
		}

	}

	@RequestMapping("/depositFunds")
	public ModelAndView depositFundsAction(@RequestParam("accountNumber") String accountNumber,
			@RequestParam("amount") String amount) {
		Account account;
		try {
			account = bankingServices.depositAmount(Long.parseLong(accountNumber), Float.parseFloat(amount));
			return new ModelAndView("depositSuccessPage", "account", account);
		} catch (NumberFormatException | AccountNotFoundException | BankingServicesDownException
				| AccountBlockedException | InvalidAmountException e) {
			return new ModelAndView("depositPage", "exception", e.getMessage());
		}
	}

	@RequestMapping("/withdrawFunds")
	public ModelAndView withdrawFundsAction(@RequestParam("accountNumber") String accountNumber,
			@RequestParam("amount") String amount, @RequestParam("pinNumber") String pinNumber){
		Account account;
		try {
			account = bankingServices.withdrawAmount(Long.parseLong(accountNumber), Float.parseFloat(amount),
					Integer.parseInt(pinNumber));
			return new ModelAndView("withdrawSuccessPage", "account", account);
		} catch (NumberFormatException | InsufficientAmountException | AccountNotFoundException
				| InvalidPinNumberException | BankingServicesDownException | AccountBlockedException e) {
			return new ModelAndView("withdrawPage", "exception", e.getMessage());
		}
		
	}

	@RequestMapping("/transferFunds")
	public ModelAndView fundTransferAction(@RequestParam("accountNumberFrom") String accountNumberFrom,
			@RequestParam("accountNumberTo") String accountNumberTo, @RequestParam("pinNumber") String pinNumber,
			@RequestParam("amount") String amount){
		try {
			bankingServices.fundTransfer(Long.parseLong(accountNumberTo), Long.parseLong(accountNumberFrom),
					Float.parseFloat(amount), Integer.parseInt(pinNumber));
			account = bankingServices.getAccountDetails(Long.parseLong(accountNumberFrom));
			return new ModelAndView("transferSuccessPage", "account", account);
		} catch (NumberFormatException | InsufficientAmountException | AccountNotFoundException
				| InvalidPinNumberException | BankingServicesDownException | AccountBlockedException e) {
			return new ModelAndView("transferPage", "exception", e.getMessage());
		}
		
	}

	@RequestMapping("/accountDetails")
	public ModelAndView accountDetailsAction(@RequestParam("accountNumber") String accountNumber){
		Account account;
		try {
			account = bankingServices.getAccountDetails(Long.parseLong(accountNumber));
			return new ModelAndView("accountDetailsDisplayPage", "account", account);
		} catch (NumberFormatException | AccountNotFoundException | BankingServicesDownException e) {
			return new ModelAndView("accountDetailsPage", "exception", e.getMessage());
		}
		
	}
}
