Feature: Get Account All Transactions Details
Using this feature one can get their Transaction details from database
Scenario: User retrieves his Transaction details from the database
Given User is on get Transaction Details Page
When User entered the correct Account details
Then Details are retrieved from the database

Scenario: User could not retrieve his Transaction details from the database
Given User is on get Transaction Details Page
When User entered incorrect Account details
Then page is returned to getTransactionDetails page

