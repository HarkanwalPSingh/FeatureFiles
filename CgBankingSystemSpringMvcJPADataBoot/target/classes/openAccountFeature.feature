Feature: New Account to be created using Banking Services open Account feature
Using this feature one can open new account using services provided by Banking Services
Scenario: User wants to open new account
Given User is on openAccountPage page
When User entered the all the required details
Then New account will be created

Scenario: User wants to open new account using invalid deposit amount
Given User is on openAccountPage page
When User amount the initial deposit less than 0
Then New account will not be created