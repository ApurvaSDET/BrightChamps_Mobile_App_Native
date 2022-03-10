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

  @Regression @Invite&Win @Referral
  Scenario: 1 #Verifying Invite & Win Section using CTA

    When  User taps on Invite & Win tab
    Then  User is at Invite & Win Screen
    When  User clicks on back button of Page
    Then  User is at Profile screen

  @Regression @ContactUs
  Scenario: 2 #Verifying Contact Us for Paid User

    And   User clicks on Contact Us
    Then  User is redirected to the Mail