Feature: Home Page Part 1
  Description: Test Automation for Rescheduling and Cancellation on Student Portal

  Background: User is Logged In

    Given  User is at Student portal Login Page
    When   User clicks on 'Login with Password' CTA
    Then   User is at 'Login with Password' screen
    When   User enters valid email and password

      |Email|Password|
      |apurva.kushwaha@mailinator.com|qwerty  |
      |prathyusha.m@brightchamps.com |prat2021|

    And    User clicks on Sign-in CTA
    Then   User is at the Home Page


  @Regression @Reschedule
  Scenario: 1 #Verifying back button of Re-scheduling Next Class screen

    When   User Clicks on three dots button
    Then   Dropdown should appear
    When   User Selects Reschedule button
    Then   User is at Reschedule screen and Next class should be pre-selected
    When   User clicks on back button
    Then   User should be redirected to Home Page


  @Regression @Reschedule
  Scenario: 2 #Verifying Re-scheduling Next Class

    When   User Clicks on three dots button
    Then   Dropdown should appear
    When   User Selects Reschedule button
    Then   User is at Reschedule screen and Next class should be pre-selected
    When   User selected next class date and time
    And    User clicks on Book your Slot CTA
    Then   User should be able to successfully Reschedule the class
    And    User should be redirected to Home Page


  @Regression @Reschedule
  Scenario: 3 #Verifying Re-scheduling All Class

    When   User Clicks on three dots button
    Then   Dropdown should appear
    When   User Selects Reschedule button
    Then   User is at Reschedule screen
    And    User selects All Class tab
    Then   By default three class per week should be shown
    When   User selects classes one by one
    Then   User should see the option to select date amd time based on number of classes selected
    When   User selected all four classes date and time
    And    User clicks on Book your Slot CTA
    Then   User should be able to successfully Reschedule all the classes
    And    User should be redirected to Home Page


  @Regression @Cancel
  Scenario: 4 #Verifying No button on Cancel Class card

    When   User Clicks on three dots button
    Then   Dropdown should appear
    When   User Selects Cancel button
    Then   User is at Cancel screen
    When   User clicks on NO button
    Then   User should be redirected to Home Page


  @Regression @Cancel
  Scenario: 5 #Verifying YES button on Cancel Class card without selecting any reason

    When   User Clicks on three dots button
    Then   Dropdown should appear
    When   User Selects Cancel button
    Then   User is at Cancel screen
    When   User clicks on YES button
    Then   User should be able to successfully Cancel the class
    And    User should be redirected to Home Page

  @Regression @Cancel
  Scenario: 6 #Verifying YES button on Cancel Class card after selecting any reason

    When   User Clicks on three dots button
    Then   Dropdown should appear
    When   User Selects Cancel button
    Then   User is at Cancel screen
    When   User select Cancellation reason
    And    User clicks on YES button
    Then   User should be able to successfully Cancel the class
    And    User should be redirected to Home Page


  @Regression @Referral
  Scenario: 7 #Verifying referral card on Home Page

    When    User clicks on Book Free Trial CTA of referral card
    Then    User should be redirected to mWeb
    When    User taps device back button
    Then    User should be navigated to the same page

