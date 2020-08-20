@activity1_2
Feature: searching Jobs using xPath

Scenario: seaching for job
Given user is on alchemyJob Site
When verify user is on Alchemy Job Page
Then Navigate to Jobs page and search for job with fulltime Filteration
Then print the job title and click for apply for job
Then close the browser for Activity2