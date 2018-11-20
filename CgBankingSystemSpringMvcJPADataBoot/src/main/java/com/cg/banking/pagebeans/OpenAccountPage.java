package com.cg.banking.pagebeans;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class OpenAccountPage {
	@FindBy(how=How.CLASS_NAME,name="accountType")
	WebElement accountType;
	@FindBy(how=How.CLASS_NAME,name="accountBalance")
	WebElement accountBalance;
	@FindBy(how=How.CLASS_NAME,name="submit")
	WebElement button;
	@FindBy(how=How.ID,id="accountType.errors")
	WebElement accountTypeErrors;
	@FindBy(how=How.ID,id="accountBalance.errors")
	WebElement accountBalanceErrors;
	
	public OpenAccountPage() {}

	public String getAccountType() {
		return accountType.getAttribute("value");
	}

	public void setAccountType(String accountType) {
		this.accountBalance.clear();
		this.accountType.sendKeys(accountType);
	}

	public String getAccountBalance() {
		return accountBalance.getAttribute("value");
	}

	public void setAccountBalance(String accountBalance) {
		this.accountBalance.clear();
		this.accountBalance.sendKeys(accountBalance);
	}

	public WebElement getButton() {
		return button;
	}

	public void setButton(WebElement button) {
		this.button = button;
	}

	public String getAccountTypeErrors() {
		return accountTypeErrors.getText();
	}


	public String getAccountBalanceErrors() {
		return accountBalanceErrors.getText();
	}
	
	public void clickSubmit() {
		this.button.click();
	}
	
}
