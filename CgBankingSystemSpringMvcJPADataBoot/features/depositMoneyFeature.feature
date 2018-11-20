Feature: Deposit money on Deposit Amount Homepage
Using this feature one can get deposit money using services provided by Banking Services
Scenario: User wants to deposit money
Given User is on Banking Services Deposit page
When User entered the correct AccountNo 
And User entered the amount to be deposited
Then Money will be deposited into account

Scenario: User wants to deposit money using invalid account number
Given User is on Banking Services Deposit page
When User entered the incorrect AccountNo 
And User entered the amount to be deposited
Then Money will not be deposited into account with invalid account number error

Scenario: User wants to deposit money using invalid deposit amount 
Given User is on Banking Services Deposit page
When User entered the correct AccountNo 
And User entered the amount less than zero
Then Money will not be deposited into account with invalid amount error