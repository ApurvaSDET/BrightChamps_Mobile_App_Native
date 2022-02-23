Feature: Validating Profile Page
  Description: Test Automation for covering all possible cases for a Profile Page

  Background: User is Logged In

    Given User is at Student portal master login Page
    When  User enters valid Phone no and password

      |Phone     |Password|
      |8130865152|hr26ec2 |


    And   User clicks on SUBMIT CTA
    Then  User is at the Home Page
    When  User Clicks on Profile tab
    Then  User is at Profile screen
    When  User taps on Personal Information tab
    Then  User should ne redirected to Profile Details screen


  @Regression @Profile
  Scenario: 1 #Verifying Updating Profile Page information

    When User updates all the Profile page information
    And  User clicks on Save Button
    Then Profile Updated Success message should appear
    And  Profile Page should get updated

  @Regression1 @Profile
  Scenario: 2 #Verifying Updating Hobbies on Profile Page

    When User clicks on X button of Hobbies
    Then Hobbies should be deleted
    And  User clicks on Save Button
    #Then Verify if Hobbies are still deleted after Saving
    When User enters new Hobbies from Dropdown
    Then New Hobbies should be entered
    When User clicks on Save Button
    Then Profile Updated Success message should appear
    And  New hobbies should be updated on Profile Page


  @Regression @Profile
  Scenario: 3 #Validate Sub-heading on Profile Page

    And Verify Student Name as Sub-heading on Profile Page


  @Regression @Profile
  Scenario: 4 #Verifying Updating DOB from Calendar on Profile Page

    When User taps on DOB field
    Then DOB bottom sheet should open
    When User updated DOB
    And  Taps on Set CTA
    Then Newly selected DOB should appear on DOB field
    When User clicks on Save Button
    Then Profile Updated Success message should appear
    And  New DOB should be updated on Profile Page