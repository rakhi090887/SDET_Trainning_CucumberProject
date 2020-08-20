@CRMFeature @CRMActivity3_4

Feature: Creating a Product.
Scenario Outline: Creating a Product.
Given User is on AlchemyCRM website page using username and password
When Create product using information "<ProductName>" and "<Price>"
Then Verify the product creation using "<ProductName>"
Then close the browser for CRMact3_4

Examples:
| ProductName  | Price |
| Test 				 | 20		|