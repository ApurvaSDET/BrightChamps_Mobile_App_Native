Feature: Title Page
  Description: Test Automation for Login, Logout

  Background: User is Logged In

    Given  User is at Student portal Login Page
    When   User clicks on 'Login with Password' CTA
    Then   User is at 'Login with Password' screen
    When   User enters valid email and password

      |Email|Password|
      |apurva.kushwaha@mailinator.com|qwerty  |
      |prathyusha.m@brightchamps.com |prat2021|

    And    User clicks on Sign-in CTA


  @Regression @SmokeTest
  Scenario: 1 #Verifying login via email and password

    Then   User is at the Home Page

  @Regression @SmokeTest
  Scenario: 2 #Verifying logout after login via email and password for Single user a/c

    Given  User is at the Home Page
    When   User Clicks on Profile tab
    Then   User is at Profile screen
    When   User clicks logout button
    Then   User is at Student portal Login Page