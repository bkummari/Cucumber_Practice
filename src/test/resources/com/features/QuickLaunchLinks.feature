Feature:  Verify Quick Launch links in Dash board


Scenario: Dash board Title
Given User has already logged in
|username|password|
|Admin|admin123|
When User gets page title
Then The Page Title should Be "OrangeHRM"

Scenario: Verify Quick Launch links count
Given User is in Dash board page
Then User gets  Quick Launch links
|Assign Leave|
|Leave List|
|Timesheets|
|Apply Leave|
|My Leave|
|My Timesheet|
And The links count should be 6

