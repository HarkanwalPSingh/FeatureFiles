package com.cg.banking.stepdefinition;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.cg.banking.pagebeans.DepositPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DepositMoneyStepDefinition {
	private WebDriver driver;
	private DepositPage depositPage;
	@Given("^User is on Banking Services Deposit page$")
	public void user_is_on_Banking_Services_Deposit_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:4444/deposit");
		depositPage=PageFactory.initElements(driver,DepositPage.class);
	}

	@When("^User entered the correct AccountNo$")
	public void user_entered_the_correct_AccountNo() throws Throwable {
		depositPage.setAccountNumber("123123123");
	}

	@When("^User entered the amount to be deposited$")
	public void user_entered_the_amount_to_be_deposited() throws Throwable {
		depositPage.setAmount("5000");
		depositPage.clickSubmit();
	}

	@Then("^Money will be deposited into account$")
	public void money_will_be_deposited_into_account() throws Throwable {
		String expectedTitle = "Deposit Success";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
		driver.close();
	}

	@When("^User entered the incorrect AccountNo$")
	public void user_entered_the_incorrect_AccountNo() throws Throwable {
		depositPage.setAccountNumber("5646123123");
	}
	
	@Then("^Money will not be deposited into account with invalid account number error$")
	public void money_will_not_be_deposited_into_account_with_invalid_account_number_error() throws Throwable {
		String expectedError = "Account not found for account no. 5646123123";
		String actualError = depositPage.getException();
		Assert.assertEquals(expectedError, actualError);
		driver.close();
	}


	@When("^User entered the amount less than zero$")
	public void user_entered_the_amount_less_than_zero() throws Throwable {
		depositPage.setAmount("-200");
		depositPage.clickSubmit();
	}
	
	@Then("^Money will not be deposited into account with invalid amount error$")
	public void money_will_not_be_deposited_into_account_with_invalid_amount_error() throws Throwable {
		String expectedError = "Invalid amount";
		String actualError = depositPage.getException();
		Assert.assertEquals(expectedError, actualError);
		driver.close();
	}

}
