Feature: Home Page Part 3
  Description: Test Automation for Upgrade Package Scenarios and Paid Certificates

  Background: User is Logged In

    Given  User is at Student portal master login Page

  @Regression @UpgradePackage
  Scenario: 1 #Verifying Upgrade Package Card in case of 5 or less classes are left

    When   User enters valid Phone no and password

      |Phone     |Password|
      |8433918423|hr26ec2 |


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
      |96646771  |hr26ec2 |
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


  @Regression @CurriculumPageBackButton
  Scenario: 3 #Verifying back button of Curriculum Page

    When   User enters valid Phone no and password

      |Phone     |Password|
      |96646771  |hr26ec2 |
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
    When   User clicks on back button of Page
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


  @Regression @PaidCertificate
  Scenario: 5 #Verifying Unlocked Certificates on Certificate Screen

    When   User enters valid Phone no and password

      |Phone     |Password|
      |8130865152|hr26ec2 |

    And    User clicks on SUBMIT CTA
    Then   User is at the Home Page
    When   User Clicks on Profile tab
    Then   User is at Profile screen
    When   User clicks on My Certificates
    Then   User is redirected to My Certificates Screen
    And    Verify Unlocked Certificate can be downloaded

  @Regression @PaidCertificate
  Scenario: 6 #Verifying Locked Certificates on Certificate Screen

    When   User enters valid Phone no and password

      |Phone     |Password|
      |8130865152|hr26ec2 |

    And    User clicks on SUBMIT CTA
    Then   User is at the Home Page
    When   User Clicks on Profile tab
    Then   User is at Profile screen
    When   User clicks on My Certificates
    Then   User is redirected to My Certificates Screen
    Then   Verify Locked Certificates should be available Under Upgrade Now Section
    And    Verify lock icon on all the locked Certificates


  @Regression @PaidCertificate
  Scenario: 7 #Verifying Upgrade Now CTA on Certificate Screen

    When   User enters valid Phone no and password

      |Phone     |Password|
      |507952953|hr26ec2 |
      #This is Prod User

    And    User clicks on SUBMIT CTA
    Then   User is at the Home Page
    When   User Clicks on Profile tab
    Then   User is at Profile screen
    When   User clicks on My Certificates
    Then   User is redirected to My Certificates Screen
    When   User Clicks on Upgrade Now CTA
    Then   User is redirected to Upgrade Package Screen


  @Regression @PaidCertificate
  Scenario: 8 #Verifying back button on Certificate Screen

    When   User enters valid Phone no and password

      |Phone     |Password|
      |8130865152|hr26ec2 |

    And    User clicks on SUBMIT CTA
    Then   User is at the Home Page
    When   User Clicks on Profile tab
    Then   User is at Profile screen
    When   User clicks on My Certificates
    Then   User is redirected to My Certificates Screen
    When   User clicks on back button
    Then   User is at Profile screen