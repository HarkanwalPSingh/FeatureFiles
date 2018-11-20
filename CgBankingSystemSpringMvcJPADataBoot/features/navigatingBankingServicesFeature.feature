Feature: Navigating on Banking Services Homepage
Using this feature one can get into the different services provided by Banking Services
Scenario: User want to open new account details
Given User is on Banking Services Homepage
When User clicked on Open Account button
Then User can enter into the openAccountPage page

Scenario: User want to deposit money into account
Given User is on Banking Services Homepage
When User clicked on Deposit button
Then User can enter into the depositAmountPage page

Scenario: User want to withdraw money from account
Given User is on Banking Services Homepage
When User clicked on withdraw button
Then User can enter into withdrawAmountPage

Scenario: User want to Transfer Funds from one account to other
Given User is on Banking Services Homepage
When User clicked on Funds Transfer button
Then User can enter into fundsTransferPage

Scenario: User want to get Account details from the database
Given User is on Banking Services Homepage
When User clicked on Get Account Details button
Then User can enter into the getAccountDetails page

Scenario: User want to retrieve all transactions from account
Given User is on Banking Services Homepage
When User clicked on Get All Transaction Details button
Then User can enter into the getAccountAllTransactionDetailsPage page