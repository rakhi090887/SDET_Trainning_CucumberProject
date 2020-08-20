@CRMFeature @CRMActivity3_2

Feature: Create leads using parameterization

Scenario: Create leads using parameterization
Given User is loggedin on AlchemyCRM WEbsite using "admin" and "pa$$w0rd"
When Navigate to leads page and createLeads
Then fill the form using Firstname "Software" and lastName "TestABC" 
Then Navigate to view leads to verify leads "SoftwareTestABC"
Then close the browser for CRMActivity3_2
