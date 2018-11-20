package com.cg.banking.pagebeans;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DepositPage {
	@FindBy(how = How.CLASS_NAME, name = "accountNumber")
	WebElement accountNumber;
	@FindBy(how = How.CLASS_NAME, name = "amount")
	WebElement amount;
	@FindBy(how = How.CLASS_NAME, name = "submit")
	WebElement button;
	@FindBy(how=How.ID, id="exception")
	WebElement exception;
	
	public DepositPage() {}
	
	public void setAccountNumber(String accountNumber) {
		this.accountNumber.clear();
		this.accountNumber.sendKeys(accountNumber);
	}
	
	public void setAmount(String amount) {
		this.amount.clear();
		this.amount.sendKeys(amount);
	}
	
	public void clickSubmit() {
		this.button.click();
	}
	
	public String getException() {
		return this.exception.getText();
	}
}
