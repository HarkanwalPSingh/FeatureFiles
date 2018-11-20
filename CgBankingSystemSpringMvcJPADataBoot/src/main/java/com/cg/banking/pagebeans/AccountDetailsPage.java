package com.cg.banking.pagebeans;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AccountDetailsPage {
	@FindBy(how = How.CLASS_NAME, name = "accountNumber")
	WebElement accountNumber;
	@FindBy(how = How.CLASS_NAME, name = "submit")
	WebElement button;
	@FindBy(how=How.ID, id="exception")
	WebElement exception;
	
	public AccountDetailsPage(){}
	
	public void setAccountNumber(String accountNumber) {
		this.accountNumber.clear();
		this.accountNumber.sendKeys(accountNumber);
	}
	
	public void clickSubmit() {
		this.button.click();
	}
	
	public String getException() {
		return this.exception.getText();
	}
}
