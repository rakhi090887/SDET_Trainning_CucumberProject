@activity1_3
Feature: Posting a job using parameterization

Scenario: Posting Job parameterization

Given User is on Alchemy WebSite
When Navigate to Post JobPage and fill "Software1503","Delhi","Full Time" and "test" the info.
Then Verify job is listed in listing on jobPage
Then close the browser for activity3
