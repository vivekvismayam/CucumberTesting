Feature: Twitter Login test 

Scenario: Test login with valid credentials
Given Open the Chrome and start the application
When I enter valid username and password
Then User should be able to login
And logout of the application