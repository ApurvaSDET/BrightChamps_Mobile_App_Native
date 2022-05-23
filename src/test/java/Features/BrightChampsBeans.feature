Feature: BrightChamps Beans
  Description: Test Automation for Rescheduling and Cancellation on Student Portal

  Background: User is Logged In

    Given  User is at Student portal Login Page
    When   User clicks on 'Login Via Email ID' CTA
    Then   User is at 'Login with Password' screen
    When   User enters valid email and password

      |Email|Password|
      |apurva.kushwaha@mailinator.com|qwerty  |
      |prathyusha.m@brightchamps.com |prat2021|

    And    User clicks on 'Login with Password' CTA
    Then   User is at the Home Page


  @Regression @BCBeans
  Scenario: 1 #Verifying BrightChamps Beans Screen and back button

    When   User Clicks on BC Beans icon on Home Page
    Then   User should be redirected to BrightChamps Beans Screen
    When   User clicks on back button
    Then   User is at the Home Page


  @Regression @BCBeans
  Scenario: 2 #Verifying BrightChamps Beans Progress Map in Full Screen

    When   User Clicks on BC Beans icon on Home Page
    Then   User should be redirected to BrightChamps Beans Screen
    When   User clicks on Expand icon
    Then   User should be redirected to Full View Map Screen
    When   User taps on X button
    Then   User should be redirected to BrightChamps Beans Screen

  @Regression @BCBeans
  Scenario: 3 #Verifying BrightChamps Beans Know More Screen and back button

    When   User Clicks on BC Beans icon on Home Page
    Then   User should be redirected to BrightChamps Beans Screen
    When   User clicks on Know More Button
    Then   User should be redirected to BrightChamps Beans Page
    When   User clicks on back button
    Then   User should be redirected to BrightChamps Beans Screen

  @Regression @BCBeans
  Scenario: 4 #Verifying BrightBEANS Bank Screen and Back Button

    When   User Clicks on BC Beans icon on Home Page
    Then   User should be redirected to BrightChamps Beans Screen
    When   User clicks on Yours Beans Bank button
    Then   User should be redirected to BrightBEANS Bank Screen
    When   User clicks on back button
    Then   User should be redirected to BrightChamps Beans Screen

  @Regression @BCBeans
  Scenario: 5 #Verifying Earining Details Card on BrightBEANS Bank Screen

    When   User Clicks on BC Beans icon on Home Page
    Then   User should be redirected to BrightChamps Beans Screen
    When   User clicks on Yours Beans Bank button
    Then   User should be redirected to BrightBEANS Bank Screen
    And    Verify all the Earning details card on BrightBEANS Bank Screen


