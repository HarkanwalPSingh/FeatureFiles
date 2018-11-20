package com.cg.banking.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cg.banking.pagebeans.OpenAccountPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OpenAccountStepDefinition {
	private WebDriver driver;
	private OpenAccountPage openAccountPage;
	@Given("^User is on openAccountPage page$")
	public void user_is_on_openAccountPage_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:4444/registerAccount");
		openAccountPage=PageFactory.initElements(driver, OpenAccountPage.class);
	}

	@When("^User entered the all the required details$")
	public void user_entered_the_all_the_required_details() throws Throwable {
		openAccountPage.setAccountType("Savings");
		openAccountPage.setAccountBalance("500");
		openAccountPage.clickSubmit();
	}

	@Then("^New account will be created$")
	public void new_account_will_be_created() throws Throwable {
		String expectedTitle = "Account Opened";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
		driver.close();
	}

	@When("^User amount the initial deposit less than (\\d+)$")
	public void user_amount_the_initial_deposit_less_than(int arg1) throws Throwable {
		arg1 = 0;
		//WebDriverWait wait = new WebDriverWait(WebDriverRefrence,TimeOut);
//		WebDriverWait wait = new WebDriverWait (driver, 20);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("accountType")));
		openAccountPage.setAccountType("Savings");
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("accountBalance")));
		openAccountPage.setAccountBalance("-200");
		openAccountPage.clickSubmit();
	}

	@Then("^New account will not be created$")
	public void new_account_will_not_be_created() throws Throwable {
		String expectedError = "Enter valid initial balance";
		String actualError = openAccountPage.getAccountBalanceErrors();
		Assert.assertEquals(expectedError, actualError);
		driver.close();
	}


}
