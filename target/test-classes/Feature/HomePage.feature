Feature: Validate basic features in Input Forms

Background:
	Given User opens application in browser
	When User clicks on Input Forms
    
Scenario Outline: Verify user is able to test all the basic input form features
	
    And Selects "<Input Forms>"
    And Verifies "<Input Forms>"
    Then User should be able to execute all the test cases for the specified "<Input Forms>".
    Examples:
    |Input Forms|
    |Single Input|
   	|Two Input|
    |Single Check Box|
    |Multiple Check Box|
   	|Radio Button|
   	|Group Radio Button|
   	|Select Dropdown List|
   	|Multi Select Dropdown List|