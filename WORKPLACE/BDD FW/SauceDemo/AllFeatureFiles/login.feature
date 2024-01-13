Feature: Test SauceDemo Application

  Scenario: Test login Functionality
    Given user is on login page
    When user eneter valid username and password and click on login button
    Then user is on Home page and user validate home page by using url link
    Then user add product to cart and click on card user click on checkout button
    And user fill the information firstname,lastname and zip code and click on continue button
    And user click on finish button
    And user validate order placed
