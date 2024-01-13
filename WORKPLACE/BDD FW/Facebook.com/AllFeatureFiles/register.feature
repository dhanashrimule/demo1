Feature: Test the facebook Application

  Scenario: Test Register page of facebook application
    Given user open "chrome" browser
    When user is on register page
    And user enter valid "Ankit", "Pawar", "Pawar@gmail.com" and "ankit@123"
    And user select DOB as "5" ,"Jan","1998" and user select gender as "Male"
