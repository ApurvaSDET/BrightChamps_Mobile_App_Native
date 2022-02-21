Feature: Profile Page
  Description: Test Automation for covering all possible cases of Profile Page

  Background: User is Logged In

    Given  User is at Student portal master login Page
    When   User enters valid Phone no and password

      |Phone     |Password|
      |8130865152|hr26ec2 |


    And    User clicks on SUBMIT CTA
    Then   User is at the Home Page
    When   User Clicks on Profile tab
    Then   User is at Profile screen

  @Regression @ReferFriend
  Scenario: 1 #Verifying Refer a friend Section using CTA

    When  User taps on Refer a friend tab
    Then  User should be navigated to Refer a friend screen
    When  User taps on Book Free Trial for Your Friends CTA
    Then  User should be navigated to mWeb
    When  User navigates back using device back button
    Then  User should be navigated to Refer a friend screen


  @Regression @ReferFriend
  Scenario: 2 #Verifying Refer a friend Section using Share Link

    When  User taps on Refer a friend tab
    Then  User should be navigated to Refer a friend screen
    When  User taps on Share Link button
    Then  Share bottom sheet should open
    When  User navigates back using device back button
    Then  Share bottom sheet should be dismissed
    #And   Toast message should appear


  @Regression @ReferFriend
  Scenario: 3 #Verifying back button of Refer screen

    When  User taps on Refer a friend tab
    Then  User should be navigated to Refer a friend screen
    When  User taps on back button on screen
    Then  User is at Profile screen


  @Regression @ContactUs
  Scenario: 4 #Verifying Contact Us for Paid User

    And   User clicks on Contact Us
    Then  User is redirected to the Mail