
@CRMFeature @CRMActivity3_3

Feature: Schedule a meeting and invite members

Scenario Outline: Schedule a meeting and invite members
Given User is logged in on alchemy CRM page
When Navigate to schedule meeting and search for page
Then add member "<firstName>" and "<lastName>"
Then verify the meeting created "Testting"
Then close the browser for CRMAc3_3

Examples:
| firstName | lastName |
| test 			| test1		 |
#| abc				|	xyz      | 
