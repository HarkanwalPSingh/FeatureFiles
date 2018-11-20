Feature: Withdraw money on balance Amount
Using this feature one can get withdraw money using services provided by Banking Services

Scenario: User want to withdraw money
Given User is on Banking Services withdraw page
When User entered the correct AccountNo and pinNo
And User entered the amount to be withdrawn
Then Money will be withdrawn from account

Scenario: User want to withdraw money more than balance
Given User is on Banking Services withdraw page
When User entered the correct AccountNo and pinNo
And User entered the amount to be withdrawn more than balance
Then Money will not be withdrawn from account
And Page will be rediredected to withdraw page

Scenario: User want to withdraw money with incorrect pin
Given User is on Banking Services withdraw page
When User entered the correct AccountNo 
But User entered incorrect pin number
Then Money will not be withdrawn from account
And Page will be redirected to withdraw Page 