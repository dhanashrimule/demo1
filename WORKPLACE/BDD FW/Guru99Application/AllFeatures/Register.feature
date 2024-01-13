Feature: Test Guru99 Application Functionality

  Scenario Outline: validate register Functionality
    Given User is on register page
    When user enter "<firstname>","<lastname>","<phone>" and "<email>"
    And user enter "<address>","<city>","<state>", "<postalcode>" and "<country>"
    And user enter "<username>", "<password>","<confirmpassword>" and click on submit button
    Then user is on register success page

    Examples: 
      | firstname | lastname | phone     | email          | address | city  | state      | postalcode | country | username | password    | confirmpassword |
      | Dhanashri | Mule     | 948756857 | dhan@gmail.com | udgir   | latur | Maharastra |     412748 | dhan@24 | Dhanshri | Dhanshri@24 | Dhanshri@24     |
      | Ram       | patil    | 964564745 | ram@gmail.com  | udgir   | latur | Maharastra |     413526 | ram@24  | ram      | ram@24      | ram@24          |
