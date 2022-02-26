package StepDefinition;

import Base.BaseUtil;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Map;

public class TitlePage extends BaseUtil {

    @Given("User is at Student portal Login Page")
    public void user_is_at_student_portal() {

     /*   try {

            wait.until(ExpectedConditions.presenceOfElementLocated(PO.AcceptCookies));
            _click(PO.AcceptCookies);
        }
        catch (TimeoutException e)
        {
            e.getMessage();
        }
*/


        //waiting till landing on login screen
        _wait(PO.LoginWithPassword);

        //Asserting the Student Home Page
        Assert.assertTrue(_is_displayed(PO.LoginWithPassword));
    }

    @When("User clicks on 'Login with Password' CTA")
    public void user_clicks_on_login_with_password_cta() {

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
        List<Map<String,String>> data = dataTable.asMaps(String.class, String.class);

        _SendKeys(PO.input_email,data.get(0).get("Email"));
        _SendKeys(PO.input_password,data.get(0).get("Password"));

    }

    @And("User clicks on Sign-in CTA")
    public void Sign_in_CTA_click(){

        _click(PO.sign_in_btn);
    }

    //Scenario: 1 #Verifying login via email and password for Single user a/c

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

        _click(PO.logout_btn);

    }


}
