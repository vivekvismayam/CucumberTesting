Feature:Automation testing demo site:http://automationpractice.com/index.php

  Scenario: Login test
    Given Open chrome and practice site is open. 
    When I fill details and click login
    Then User logged in successfully
    And Logout
    And Close browser


