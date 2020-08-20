@activity1_1
Feature: Job Board Activity1

Scenario Outline: Create new User
Given user is on to jobboard site
When user logs in with "<username>" and "<password>"
Then user is on jobboard home page 
Then Click on Add new user and Verify user is created
Then close the browser for activity1

Examples:
|username|password|
|root		 |pa$$w0rd|




