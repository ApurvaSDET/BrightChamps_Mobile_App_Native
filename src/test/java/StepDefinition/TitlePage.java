package StepDefinition;

import Base.BaseUtil;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import java.util.List;
import java.util.Map;

public class TitlePage extends BaseUtil {

    public static List<Map<String,String>> data;


    @Given("User is at Student portal Login Page")
    public void user_is_at_student_portal() {

        //waiting till landing on login screen
        _wait(PO.LoginWithPassword);

        //Asserting the Student Home Page
        Assert.assertTrue(_is_displayed(PO.LoginWithPassword));
    }


    //Scenario: 1 #Verifying login via email and password for Single user a/c

    @When("User clicks on 'Login Via Email ID' CTA")
    public void User_clicks_on_Login_Via_Email_ID_CTA() {

        _click(PO.LoginWithPassword);

    }

    @Then("User is at 'Login with Password' screen")
    public void user_is_at_login_with_password_screen() {

        _wait(PO.input_email);
        Assert.assertTrue(_is_displayed(PO.input_email));


    }
    @When("User enters valid email and password")
    public void user_enters_valid_email_and_password(DataTable dataTable) {

        //getting values from Datatable as a Key: Value pair in feature file
        data = dataTable.asMaps(String.class, String.class);

        _SendKeys(PO.input_email,data.get(0).get("Email"));
        _SendKeys(PO.input_password,data.get(0).get("Password"));

    }

    @And("User clicks on 'Login with Password' CTA")
    public void Sign_in_CTA_click(){

        _click(PO.sign_in_btn);
    }

    @Then("User is at the Home Page")
    public void user_is_redirected_to_the_home_page_() {

        //waiting for home page to load
        _wait(PO.Home_Page);
        //Asserting the Student Home Page
        Assert.assertTrue(_is_displayed(PO.Home_Page));

    }


    //Scenario: 2 #Verifying logout after login via email and password for Single user a/c

    @When("User Clicks on Profile tab")
    public void clicks_on_profile_tab() {

        _click(PO.profile_tab);

    }

    @Then("User is at Profile screen")
    public void user_is_at_profile_screen() {

        _wait(PO.Page_Title);
        Assert.assertEquals("Profile", _get_text(PO.Page_Title));
    }

    @When("User clicks logout button")
    public void user_clicks_logout_button() {

        swipeScreen(Direction.UP);
        _click(PO.logout_btn);

    }


    //Scenario: 3 #Verifying login via OTP using Mobile - Negative Test case

    @And("User enters Invalid Mobile no")
    public void user_enters_invalid_mobile_no(DataTable dataTable) {

        //getting values from Datatable as a Key: Value pair in feature file
        data = dataTable.asMaps(String.class, String.class);

        _SendKeys(PO.Enter_Mobile_No, data.get(0).get("Mobile"));

    }

    @When("User clicks on Login with OTP CTA")
    public void user_clicks_on_login_with_otp_cta() {

        //Clicking on Login CTA
        _click(PO.LoginWithOTP_CTA);

    }
    @Then("Error message should appear")
    public void error_message_should_appear() {

        //Asserting the error message for incorrect number format
        _wait(PO.Native_Toast_Message);
        Assert.assertEquals("please enter valid phone Number", _get_text(PO.Native_Toast_Message));

        //Waiting for Toast to disappear
        _waitAbsence(PO.Native_Toast_Message);

    }

    @When("User enters valid Mobile no")
    public void user_enters_valid_mobile_no(DataTable dataTable) {

        //getting values from Datatable as a Key: Value pair in feature file
        data = dataTable.asMaps(String.class, String.class);

        if (Platform.equalsIgnoreCase("Android"))
            _cleartext(PO.Enter_Mobile_No);
        else
            _cleartext(PO.Enter_Mobile_No_iOS);

        //Entering test data
        _SendKeys(PO.Enter_Mobile_No, data.get(0).get("Mobile"));

    }

    @Then("OTP sent Successful message should appear")
    public void otp_sent_successful_message_should_appear() {

        //Asserting the error message for incorrect number format
        _wait(PO.Toast_Message);
        Assert.assertTrue(_get_text(PO.Toast_Message).contains("Otp sent successfully to "));

        //Waiting for Toast to disappear
        _waitAbsence(PO.Toast_Message);
    }

    @And("User lands on Enter Verification Code Screen")
    public void user_lands_on_enter_verification_code_screen() {

        _wait(PO.Verify_OTP_CTA);
        Assert.assertTrue(_is_displayed(PO.Verify_OTP_CTA));

    }

    @When("User Clicks on Resend OTP link")
    public void user_clicks_on_resend_otp_link() {

        _click(PO.Resend_OTP);

    }

    @Then("OTP resend message should appear")
    public void otp_resend_message_should_appear() {

        otp_sent_successful_message_should_appear();

    }

    @When("User enters Invalid OTP")
    public void user_enters_invalid_otp() {

        _SendKeys(PO.Enter_OTP, getAlphaNumericString("Numeric",4));
    }

    @And("Clicks on Verify OTP CTA")
    public void clicks_on_verify_otp_cta() {

        _click(PO.Verify_OTP_CTA);
    }

    @Then("Incorrect OTP message should appear")
    public void incorrect_otp_message_should_appear() {

        //Asserting the error message for incorrect number format
        _wait(PO.Native_Toast_Message);
        Assert.assertEquals("Please Enter a valid otp code", _get_text(PO.Native_Toast_Message));

    }


    //Scenario Outline: 4 #Verifying login with E-mail/Passwords - All negative test cases

    @When("User enters {string} and {string} combination")
    public void User_enters_Invalid_email_and_password_combination(String InvalidEmail, String Password) {

        _SendKeys(PO.input_email, InvalidEmail);
        _SendKeys(PO.input_password, Password);

    }

    @Then("Proper {string} should appear")
    public void Proper_validation_message_should_appear(String Validation_Message) {

        _wait(PO.Native_Toast_Message);
        Assert.assertEquals(Validation_Message, _get_text(PO.Native_Toast_Message));

    }


    //Scenario: 5 #Verifying Forgot Password feature

    @When("User clicks on forgot password link")
    public void user_clicks_on_forgot_password_link() {

        _click(PO.forgot_password);
    }

    @Then("User is redirected to forgot password screen")
    public void user_is_redirected_to_forgot_password_screen() {

        _wait(PO.Reset_CTA);
        Assert.assertTrue(_is_displayed(PO.Reset_CTA));

    }

    @And("User enters valid Email address")
    public void user_enters_valid_email_address(DataTable dataTable) {

        //getting values from Datatable as a Key: Value pair in feature file
        data = dataTable.asMaps(String.class, String.class);

        driver.findElement(PO.input_email).sendKeys(data.get(0).get("Email"));

    }

    @And("Click on RESET PASSWORD CTA")
    public void click_on_reset_password_cta() {

        _click(PO.Reset_CTA);
    }

    @Then("Success alert should appear")
    public void success_alert_should_appear() {

        //Asserting the error message for incorrect number format
        _wait(PO.Toast_Message);
        Assert.assertEquals("An email has been sent to "+data.get(0).get("Email")+". Please follow the instructions to reset your password.", _get_text(PO.Toast_Message));

    }


    //Scenario: 6 #Verifying User is not registered bottom sheet

    @When("User enters Unregistered Mobile no")
    public void user_enters_unregistered_mobile_no(io.cucumber.datatable.DataTable dataTable) {

        //getting values from Datatable as a Key: Value pair in feature file
        data = dataTable.asMaps(String.class, String.class);

        _SendKeys(PO.Enter_Mobile_No, data.get(0).get("Mobile"));

    }

    @Then("User is not registered bottom sheet should appear")
    public void user_is_not_registered_bottom_sheet_should_appear() {

        _wait(PO.Unregistered_bottom_sheet);
        Assert.assertTrue(_is_displayed(PO.Unregistered_bottom_sheet));

    }

    @When("User clicks on Book Free Trial bottom Sheet CTA")
    public void user_clicks_on_book_free_trial_bottom_Sheet_CTA() {

        _click(PO.Book_Free_Trial_Class_Bottom_Sheet);
    }

    @Then("User is redirected to mWeb View")
    public void user_is_redirected_to_m_web_view() {

        _wait(PO.Page_Title);
        Assert.assertEquals("Book Your First Trial Class", _get_text(PO.Page_Title));

    }


    //Scenario: 7 #Verifying Book Free Trial Class Now on Login Page

    @When("User clicks on Book Free Trial Class Now CTA")
    public void user_clicks_on_book_free_trial_class_now_cta() {

        _click(PO.Book_Free_Trial_Class_Now_CTA);
    }

    //Scenario Outline: 8 #Verifying forgot password - All negative test cases

    @When("User enters {string}")
    public void User_enters_Invalid_email(String InvalidEmail) {

        _SendKeys(PO.input_email, InvalidEmail);

    }


}
