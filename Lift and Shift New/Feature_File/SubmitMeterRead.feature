Feature: Submit Meter Read for Anonymous Read

Background:
Given I launch the application

@current
Scenario: Landing a submit meter read page for anonymous

Given I am login with the credentials
When I should navigate to account summary page
Then I should verify the submit meter read landing page

@Errorscenario

Scenario: To validate the client side validation
When user enter the username and password
Then user verify the error scenario