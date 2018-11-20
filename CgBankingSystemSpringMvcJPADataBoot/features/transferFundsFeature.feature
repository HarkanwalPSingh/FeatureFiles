Feature: Transfer funds fundsTransfer page
Using this feature one can transfer funds using services provided by Banking Services
Scenario: User want to Transfer funds
Given User is on Banking Services fundsTransfer page
When User entered the correct AccountNofrom and pinNo
And User entered the correct AccountNoTo
And User entered the amount to be transferred
Then Money will be Transferred into accountTo

Scenario: User want to Transfer funds with incorrect accountNoto
Given User is on Banking Services fundsTransfer page
When User entered the correct AccountNofrom and pinNo
But  User entered the incorrect AccountNoTo
And User entered the amount to be transferred
Then Money will not be Transferred into accountTo
And page will be redirected to fundsTransfer page

Scenario: User want to Transfer funds more than available amount in accountNofrom
Given User is on Banking Services fundsTransfer page
When User entered the correct AccountNofrom and pinNo
And  User entered the correct AccountNoTo
But  User entered the amount to be transferred more than available amount
Then Money will not be Transferred into accountTo
And page will be redirected to fundsTransfer page

Scenario: User want to Transfer funds less than 0 in accountNofrom
Given User is on Banking Services fundsTransfer page
When User entered the correct AccountNofrom and pinNo
And User entered the correct AccountNoTo
But User entered the amount to be transferred less than 0
Then Money will not be Transferred into accountTo
And page will be redirected to fundsTransfer page

Scenario: User want to Transfer funds with incorrect accountNofrom
Given User is on Banking Services fundsTransfer page
When User entered the incorrect AccountNofrom
And User entered the correct pinNo
And User entered the correct AccountNoTo
And User entered the amount to be transferred less than 0
Then Money will not be Transferred into accountTo
And page will be redirected to fundsTransfer page

Scenario: User want to Transfer funds with incorrect accountfrom pinNo
Given User is on Banking Services fundsTransfer page
When User entered the correct AccountNofrom
And User entered the incorrect pinNo
And User entered the correct AccountNoTo
And User entered the amount to be transferred less than 0
Then Money will not be Transferred into accountTo
And page will be redirected to fundsTransfer page