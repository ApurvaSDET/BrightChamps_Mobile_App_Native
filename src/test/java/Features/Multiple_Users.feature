Feature: Home Page Part 3 - Multiple Users with in a Single a/c
  Description: Test Automation for Multiple users under single a/c


  @Regression @MultipleDemoUsers
  Scenario: 1 #Verifying User lands on the same a/c when selected from dropdown on HomePage

    Given  User is at Student portal master login Page
    When   User enters valid Phone no and password

      |Phone     |Password|
      |7310000088|hr26ec2 |

    And    User clicks on SUBMIT CTA
    Then   User is at the Home Page
    When   User Clicks on Profile tab
    Then   User is at Profile screen
    And    Verify user should be able to select multiple users


  @Regression12 @MultiplePaidUsers
  Scenario: 2 #Verifying User lands on the same a/c when selected from dropdown on HomePage

    Given  User is at Student portal master login Page
    When   User enters valid Phone no and password

      |Phone     |Password|
      |9993550809|hr26ec2 |
      #This is a Prod User.

    And    User clicks on SUBMIT CTA
    Then   User is at the Home Page
    When   User Clicks on Profile tab
    Then   User is at Profile screen
    And    Verify user should be able to select multiple users