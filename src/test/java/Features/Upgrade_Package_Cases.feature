Feature: Home Page Part 3
  Description: Test Automation for Upgrade Package Scenarios

  Background: User is Logged In

    Given  User is at Student portal master login Page

  @Regression @UpgradePackage
  Scenario: 1 #Verifying Upgrade Package Card in case of 5 or less classes are left

    When   User enters valid Phone no and password

      |Phone     |Password|
      |8130865152|hr26ec2 |


    And    User clicks on SUBMIT CTA
    Then   User is at the Home Page
    When   User is left with below classes in his account to be completed

      |ClassesLeft|
      |     5     |

    Then   Verify there is an Upgrade Now Card at the top of Home Page
    When   User clicks on Upgrade Now Card at the top of Home Page
    Then   User is at Upgrade Package Page
    When   User taps on Download Curriculum
    Then   User is redirected to the mWeb
    When   User navigates back using device back button
    Then   User is at Upgrade Package Page
    When   User taps on Buy This Plan CTA
    Then   User is redirected to the mWeb
    When   User navigates back using device back button
    Then   User is at Upgrade Package Page

  @Regression @UpgradePackage
  Scenario: 2 #Verifying Upgrade Package Card in case no classes are left

    When   User enters valid Phone no and password

      |Phone     |Password|
      |503670250 |hr26ec2 |
    #This is prod user

    And    User clicks on SUBMIT CTA
    Then   User is at the Home Page
    When   User is left with below classes in his account to be completed

      |ClassesLeft|
      |     0     |

    Then   Verify there is an Upgrade Now Card at the top of Home Page
    When   User clicks on Upgrade Now Card at the top of Home Page
    Then   User is at Upgrade Package Page
    When   User taps on Download Curriculum
    Then   User is redirected to the mWeb
    When   User navigates back using device back button
    Then   User is at Upgrade Package Page
    When   User taps on Buy This Plan CTA
    Then   User is redirected to the mWeb
    When   User navigates back using device back button
    Then   User is at Upgrade Package Page


  @Regression @CurriculumPageBackButton
  Scenario: 3 #Verifying back button of Curriculum Page

    When   User enters valid Phone no and password

      |Phone     |Password|
      |503670250 |hr26ec2 |
    #This is prod user

    And    User clicks on SUBMIT CTA
    Then   User is at the Home Page
    When   User is left with below classes in his account to be completed

      |ClassesLeft|
      |     0     |

    Then   Verify there is an Upgrade Now Card at the top of Home Page
    When   User clicks on Upgrade Now Card at the top of Home Page
    Then   User is at Upgrade Package Page
    When   User clicks on back button of Curriculum Page
    Then   User is at the Home Page

  @Regression @SchedulingFromHome
  Scenario: 4 #Verifying Class Schedule from Dashboard Screen

    When   User enters valid Phone no and password

      |Phone     |Password|
      |8130865152|hr26ec2 |
      |8433918423|hr26ec2 |

    And    User clicks on SUBMIT CTA
    Then   User is at the Home Page
    When   There is no Scheduled Class for a user to attend
    Then   Verify User can schedule a class from Home Screen