Feature: Title Page
  Description: Test Automation for Login, Logout

  Background: User is Logged In

    Given  User is at Student portal Login Page

  @Regression @SmokeTest @TitlePage
  Scenario: 1 #Verifying login via email and password

    When   User clicks on 'Login Via Email ID' CTA
    Then   User is at 'Login with Password' screen
    When   User enters valid email and password

      |Email|Password|
      |apurva.kushwaha@mailinator.com|qwerty  |
      |prathyusha.m@brightchamps.com |prat2021|

    And    User clicks on 'Login with Password' CTA
    Then   User is at the Home Page


  @Regression @SmokeTest @TitlePage
  Scenario: 2 #Verifying logout after login via email and password for Single user a/c

    When   User clicks on 'Login Via Email ID' CTA
    Then   User is at 'Login with Password' screen
    When   User enters valid email and password

      |Email|Password|
      |apurva.kushwaha@mailinator.com|qwerty  |
      |prathyusha.m@brightchamps.com |prat2021|

    And    User clicks on 'Login with Password' CTA
    Given  User is at the Home Page
    When   User Clicks on Profile tab
    Then   User is at Profile screen
    When   User clicks logout button
    Then   User is at Student portal Login Page

  @Regression @TitlePage
  Scenario: 3 #Verifying login via OTP using Mobile - Negative Test case

    When   User enters Invalid Mobile no

      |Mobile|
      |123|

    When   User clicks on Login with OTP CTA
    Then   Error message should appear
    When   User enters valid Mobile no

      |Mobile|
      |8433918423|
      |8130865152|

    And    User clicks on Login with OTP CTA
    Then   OTP sent Successful message should appear
    And    User lands on Enter Verification Code Screen
    When   User Clicks on Resend OTP link
    Then   OTP resend message should appear
    When   User enters Invalid OTP
    And    Clicks on Verify OTP CTA
    Then   Incorrect OTP message should appear
    When   User clicks on back button
    Then   User is at Student portal Login Page

  @Regression @TitlePage
  Scenario Outline: 4 #Verifying login with E-mail/Passwords - All negative test cases

    When   User clicks on 'Login Via Email ID' CTA
    Then   User is at 'Login with Password' screen
    When   User enters "<Invalid Email>" and "<Password>" combination
    And    User clicks on 'Login with Password' CTA
    Then   Proper "<Validation Message>" should appear

    Examples:
      |Invalid Email                    |Password |Validation Message                         |
      |                                 |qwerty   |Must be a valid email address              |
      |apurva.kushwaha@mailinator.com   |         |Enter Password                             |
      |apurva.kushwaha@mailinator.com   |password |Invalid email and password                 |
      |apurva.kushwaha@brightchamps.com |qwer     |Password must be at least 6 characters long|


  @Regression @TitlePage
  Scenario: 5 #Verifying Forgot Password feature

    When   User clicks on 'Login Via Email ID' CTA
    Then   User is at 'Login with Password' screen
    When   User clicks on forgot password link
    Then   User is redirected to forgot password screen
    When   User enters valid Email address

      |Email|
      |apurva.kushwaha@mailinator.com|

    And    Click on RESET PASSWORD CTA
    Then   Success alert should appear

  @Regression @TitlePage
  Scenario: 6 #Verifying User is not registered bottom sheet

    When   User enters Unregistered Mobile no

      |Mobile|
      |8310000077|

    When   User clicks on Login with OTP CTA
    Then   User is not registered bottom sheet should appear
    When   User clicks on Book Free Trial bottom Sheet CTA
    Then   User is redirected to mWeb View

  @Regression @TitlePage
  Scenario: 7 #Verifying Book Free Trial Class Now on Login Page

    When   User clicks on Book Free Trial Class Now CTA
    Then   User is redirected to mWeb View

  @Regression @TitlePage
  Scenario Outline: 8 #Verifying forgot password - All negative test cases

    When   User clicks on 'Login Via Email ID' CTA
    Then   User is at 'Login with Password' screen
    When   User clicks on forgot password link
    Then   User is redirected to forgot password screen
    When   User enters "<Invalid Email>"
    And    Click on RESET PASSWORD CTA
    Then   Proper "<Validation Message>" should appear

    Examples:
      |Invalid Email                    |Validation Message                  |
      |                                 |Please enter valid email address.   |
      |apurva.kushwaha                  |Please enter valid email address.   |
      |apurva.kushwaha@brightchamps.com |User with that email does not exist.|

  @Regression @TitlePage
  Scenario: 9 #Verifying Forgot Password Back Button

    When   User clicks on 'Login Via Email ID' CTA
    Then   User is at 'Login with Password' screen
    When   User clicks on forgot password link
    Then   User is redirected to forgot password screen
    When   User clicks on back button
    Then   User is at 'Login with Password' screen