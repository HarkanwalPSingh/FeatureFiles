package com.cg.banking.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.cg.banking.pagebeans.AccountDetailsPage;
import com.cg.banking.pagebeans.DepositPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AccountDetailsStepDefinition {
	private WebDriver driver;
	private AccountDetailsPage accountDetailsPage;
@Given("^User is on get Account Details Page$")
public void user_is_on_get_Account_Details_Page() throws Throwable {
	System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("http://localhost:4444/account");
	accountDetailsPage=PageFactory.initElements(driver,AccountDetailsPage.class);
}

@When("^User entered the correct details and click on submit button$")
public void user_entered_the_correct_details_and_click_on_submit_button() throws Throwable {
accountDetailsPage.setAccountNumber("123123123");
accountDetailsPage.clickSubmit();
}

@Then("^Details are retrieved from the database$")
public void details_are_retrieved_from_the_database() throws Throwable {
	String expectedTitle = "Account Details Page";
	String actualTitle = driver.getTitle();
	Assert.assertEquals(expectedTitle, actualTitle);
	driver.close();
}

@When("^User entered incorrect details and click on submit button$")
public void user_entered_incorrect_details_and_click_on_submit_button() throws Throwable {
	accountDetailsPage.setAccountNumber("789456123");
	accountDetailsPage.clickSubmit();
}

@Then("^page is returned to getAccountDetails page$")
public void page_is_returned_to_getAccountDetails_page() throws Throwable {
	String expectedError = "Account not found for account no. 789456123";
			String actualError = accountDetailsPage.getException();
			Assert.assertEquals(expectedError, actualError);
			driver.close();
}
}
