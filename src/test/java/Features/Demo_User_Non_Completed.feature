Feature: Demo User Part 1
  Description: Test Automation for covering all possible cases of a Non-Completed Demo User

  Background: User is Logged In

    Given  User is at Student portal master login Page
    When   User enters valid Phone no and password

      |Phone     |Password|
      |5310000003|hr26ec2 |


    And    User clicks on SUBMIT CTA


  @Regression @Demo
  Scenario: 1 #Verifying master login for demo a/c

    Then   User is at the Home Page

  @Regression @Demo
  Scenario: 2 #Verifying Reschedule Your Class feature for demo user

    Given   User is at the Home Page
    When    User Clicks on Reschedule class for demo user
    Then    User should be on Reschedule your Class screen
    When    User selected next class date and time
    And     User selected Reschedule Reason
    And     User clicks on Book your Slot CTA
    Then    User should be able to successfully Reschedule the demo class
    And     User should be redirected to Home Page

  @Regression @Demo
  Scenario: 3 #Verifying back button of Re-scheduling Trail Class screen

    Given   User is at the Home Page
    When    User Navigate to the Reschedule screen
    Then    User should be on Reschedule your Class screen
    When    User clicks on back button of Reschedule Screen
    And     User should be redirected to Home Page

  @Regression @Demo
  Scenario: 4 #Validating error messages on Reschedule Screen

    Given   User is at the Home Page
    When    User Navigate to the Reschedule screen
    Then    User should be on Reschedule your Class screen
    And     User clicks on Book your Slot CTA
    Then    Toast Message for Selecting Class Slot Should appear
    When    User selects date
    And     User clicks on Book your Slot CTA
    Then    Toast Message for Selecting Class Slot Should appear
    When    User selects Time
    And     User clicks on Book your Slot CTA
    Then    Toast Message for Selecting Reschedule Reason Should appear


  @Regression @Demo
  Scenario: 5 #Verifying locked Certificate on Home Page

    Given   User is at the Home Page
    Then    Verify Certificate on Home Page is visible
    And     Verify Visible Certificate is locked

  @Regression @Demo
  Scenario: 6 #Verifying Glimpse of Project section on Demo Home Page

    Given   User is at the Home Page
    When    When User scrolls down to the Awesome projects cards
    Then    Verify user should be able to successfully play and close all the videos


  @Regression @Demo
  Scenario: 7 #Verifying ‘Start Creating’ CTA on Demo Home Page

    Given   User is at the Home Page
    When    User clicks on Start Creating CTA
    Then    User is at Upgrade Your Plan Page


  @Regression @Demo
  Scenario: 8 #Verifying ‘Upgrade Package Page’ from bottom tab

    Given  User is at the Home Page
    When   User clicks on Upgrade Package icon from bottom bar
    Then   User is at Upgrade Your Plan Page
    When   User taps on Download Curriculum
    Then   User is redirected to the mWeb

  @Regression @Demo
  Scenario: 9 #Verifying logout for Demo User

    Given  User is at the Home Page
    When   User Clicks on Profile tab
    Then   User is at Profile screen
    When   User clicks logout button
    Then   User is at Student portal Login Page

  @Regression @Demo
  Scenario: 10 #Verifying Contact Us for Demo User

    Given  User is at the Home Page
    When   User Clicks on Profile tab
    Then   User is at Profile screen
    And    User clicks on Contact Us
    Then   User is redirected to the Mail

  @Regression @Demo
  Scenario: 11 #Verifying 'how to Join Class' Card for Demo User

    Given   User is at the Home Page
    Then    Verify 'How to Join Class' Card for Demo User