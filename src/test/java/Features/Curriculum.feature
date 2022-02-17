Feature: Home Page Part 2 - Curriculum Page
  Description: Test Automation for covering all possible cases of a Curriculum Page for Paid users on Home Page

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
    When   User clicks on Curriculum icon
    Then   User is redirected to Curriculum Page

  @Regression @Completed
  Scenario: 1 #Verifying SESSION BOOKLET links on Completed Class Section

    And    Verify SESSION BOOKLET link of all the completed class cards

  @Regression @Completed
  Scenario: 2 #Verifying ASSIGNMENT links on Completed Class Section

    When   Verify ASSIGNMENT link of all the completed class cards

  @Regression @Completed
  Scenario: 3 #Verifying Upcoming Classes Section

    When   User clicks on Upcoming Classes link
    Then   User should be redirected to the Upcoming Classes Page