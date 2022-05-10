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

  @Regression @QRLogin
  Scenario: 3 #Verifying Login via QR

    And   User clicks on Login on Web
    Then  User is redirected to Login via QR code screen
    When  User clicks on back button of Page
    Then  User is at Profile screen

  @Regression @Chat
  Scenario: 4 #Verifying Chat with Teacher

    And   User clicks on Chat with Teacher
    When  User selects any random Category from Pop-up
    Then  User is at Chat Screen
    When  User clicks on back button of Page
    Then  User is at Profile screen

  @Regression @Chat
  Scenario: 5 #Verifying Help Centre on Chat Screen

    And   User clicks on Chat with Teacher
    When  User selects any random Category from Pop-up
    Then  User is at Chat Screen
    When  User clicks on Help icon
    Then  Verify Help pop-up should open
    When  User clicks on SUBMIT CTA on Pop-up
    Then  Toast message should appear
    When  User Selects any random feedback
    And   User clicks on SUBMIT CTA on Pop-up
    Then  User is at Mail Screen

  @Regression @Chat
  Scenario: 6 #Verifying Sending a text

    And   User clicks on Chat with Teacher
    When  User selects any random Category from Pop-up
    Then  User is at Chat Screen
    When  User clicks on Send icon
    Then  Toast message should appear
    When  User enters text in chat box
    And   User clicks on Send icon
    Then  Message should be Sent Successfully
    When  User clicks on back button of Page
    Then  User is at Profile screen
