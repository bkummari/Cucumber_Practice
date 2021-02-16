Feature: Update my info

Scenario Outline: Verify leave apply
Given User is in login page
When User enters username as "Admin"
And User enters password as "admin123"
And User clicks on Login button
Given User navigates to Personal details page
When User fills data from given sheet "<SheetName>" and row number <RowNumber>
Then User cllicks save button
And verify for Edit button


Examples:
|SheetName|RowNumber|
|per_det|0|
|per_det|1|