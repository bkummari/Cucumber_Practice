Feature: Login Page feature

Scenario: Verify page Tile
Given User is in login oage
When Users gets the login page title
Then Page title should be "OrangeHRM"


Scenario: Verify Forgot password link
Given User is in login Page
Then Forgot password link should display

Scenario: Verify login with valid iputs
Given User is in login page
When User enters username as "Admin"
And User enters password as "admin123"
And User clicks on Login button
Then User Navigate to Dash board page 
And  Dashboard Header text will be dispaly
