Feature: Demo User Part 2
  Description: Test Automation for covering all possible cases of a Completed Demo User

  Background: User is Logged In

    Given  User is at Student portal master login Page
    When   User enters valid Phone no and password

      |Phone     |Password|
      |85171152007|hr26ec2 |


    And    User clicks on SUBMIT CTA
    Then   User is at the Home Page


  @Regression @Demo
  Scenario: 1 #Verifying 'Congratulations!' Card for Demo User

    Then   Verify Congratulations! Card is visible at the top


  @Regression @Demo
  Scenario: 2 #Verifying unlocked Certificate on Home Page

    Then   Verify Certificate on Home Page is unlocked

  @Regression @Demo
  Scenario: 3 #Verifying unlocked Certificate can be downloaded

    When  User taps on Download icon
    Then  Verify Certificate can be downloaded

  @Regression @Demo
  Scenario: 4 #Verifying Upgrade Your Plan Section on Home Page

    Then  Verify Upgrade Your Plan Section on Home Page