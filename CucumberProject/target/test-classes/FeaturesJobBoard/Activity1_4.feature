@activity1_4
Feature: Posting a job using parameterization

Scenario Outline: Posting Job parameterization

Given User is on Alchemy WebSites
When Navigate to Post JobPage
Then Fill the form using "<Job_Title>","<Job_Location>","<Job_Type>" and "<Job_Desc>".
Then Verify job is listed in listing on jobPage.
Then close the browser for activity4

Examples:
| Job_Title 		| Job_Location | Job_Type  | Job_Desc   |
| Software1503  | Delhi				 | Full Time | Test       |
| Testing1503		| Chennai      | Full Time | Testing1503|
