Feature: Get Account Details
Using this feature one can get their Account details from database
Scenario: User retrieves his Account details from the database
Given User is on get Account Details Page
When User entered the correct details and click on submit button
Then Details are retrieved from the database

Scenario: User could not retrieve his Account details from the database
Given User is on get Account Details Page
When User entered incorrect details and click on submit button
Then page is returned to getAccountDetails page