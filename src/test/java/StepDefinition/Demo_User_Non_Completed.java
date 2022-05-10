package StepDefinition;

import Base.BaseUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Demo_User_Non_Completed extends BaseUtil {


    //Scenario: 1 #Verifying master login for demo a/c

    //Scenario: 2 #Verifying Reschedule Your Class feature for demo user

    @When("User Clicks on Reschedule class for demo user")
    public void user_clicks_on_reschedule_class_for_demo_user() {

        WebDriverWait wait = new WebDriverWait(driver,5);

        try {


            wait.until(ExpectedConditions.presenceOfElementLocated(POD.Reschedule_demo_CTA));
            _click(POD.Reschedule_demo_CTA);

        }

        catch (TimeoutException e)

        {
            _wait(PO.triple_dots);
            _click(PO.triple_dots);

            //wait for dropdown to appear
            _wait(PO.Reschedule);
            _click(PO.Reschedule);

        }

    }

    @Then("User should be on Reschedule your Class screen")
    public void user_should_be_on_reschedule_your_class_screen() {

        _wait(PO.Book_Your_Class_CTA);
        Assert.assertTrue(_is_displayed(PO.Book_Your_Class_CTA));

    }

    @When("User selected Reschedule Reason")
    public void user_selected_reschedule_reason() {

        _wait(PO.Book_Your_Class_CTA);

        //Selecting Reschedule Reason
        _click(POD.Reschedule_Reason);
        _wait(POD.Select_Reason_sheet);

        _random_options_from_dropdown(PO.Bottom_Sheet_Elements_reason);


    }

    @Then("User should be able to successfully Reschedule the demo class")
    public void user_should_be_able_to_successfully_reschedule_the_demo_class() {

        _wait(PO.Toast_Message);
        Assert.assertTrue(_is_displayed(PO.Toast_Message));

    }


    //Scenario: 3 #Verifying back button of Re-scheduling Trail Class screen

    @When("User Navigate to the Reschedule screen")
    public void user_navigate_to_the_reschedule_screen() {

        //Reusing above methods
        user_clicks_on_reschedule_class_for_demo_user();
        user_should_be_on_reschedule_your_class_screen();

    }

    @When("User clicks on back button of Reschedule Screen")
    public void user_clicks_on_back_button() {

        _click(PO.Page_back_button);
    }

    //Scenario: 4 #Validating error messages on Reschedule Screen


    @Then("Toast Message for Selecting Class Slot Should appear")
    public void toast_message_for_class_slot_should_appear() {

        _wait(PO.Native_Toast_Message);
        Assert.assertEquals("Select class slot!", _get_text(PO.Native_Toast_Message));

    }

    @When("User selects date")
    public void user_selects_date() {

        _click(PO.Next_Class_date);
        _wait(PO.Select_date_bottom_sheet);

        _random_options_from_dropdown(PO.Bottom_Sheet_Elements_day);

        _wait(PO.Book_Your_Class_CTA);

    }

    @When("User selects Time")
    public void user_selects_time() {


        _click(PO.Next_Class_Time);
        _wait(PO.Select_time_bottom_sheet);

        _random_options_from_dropdown(PO.Bottom_Sheet_Elements_time);

        _wait(PO.Book_Your_Class_CTA);

    }

    @Then("Toast Message for Selecting Reschedule Reason Should appear")
    public void toast_message_for_reschedule_should_appear() {

        _wait(PO.Native_Toast_Message);
        Assert.assertEquals("Select reschedule reason", _get_text(PO.Native_Toast_Message));
    }

    //Scenario: 5 #Verifying locked Certificate on Home Page

    @Then("Verify Certificate on Home Page is visible")
    public void verify_locked_certificate_on_home_page_is_visible() throws InterruptedException {

        Scrolling_to_element(POD.Locked_icon_on_Demo_Certificate);
        swipeScreen(Direction.UP);
        Assert.assertTrue(_is_displayed(POD.Locked_icon_on_Demo_Certificate));

    }

    @And("Verify Visible Certificate is locked")
    public void Verify_Visible_Certificate_is_locked() {

        //Validating Locked icon
        Assert.assertTrue(_is_displayed(POD.Locked_icon_on_Demo_Certificate));

        //validating Download Now CTA
        Assert.assertFalse(_is_displayed(POD.Download_certificate_icon));


    }

    //Scenario: 6 #Verifying Glimpse of Project section on Demo Home Page

    @When("When User scrolls down to the Awesome projects cards")
    public void when_user_scrolls_down_to_the_awesome_projects_cards() throws InterruptedException {

        Scrolling_to_element(POD.Start_Creating);

    }

    @Then("Verify user should be able to successfully play and close all the videos")
    public void verify_user_should_be_able_to_successfully_play_and_close_all_the_videos() {

        //Logic to Click on each videos till last available videos
        if (Platform.equalsIgnoreCase("Android"))
        {
            while(!_is_displayed(POD.Next_Video_button_disabled)) {

                //CLicking on each Video Card
                _click(POD.Video_Card_Container_Android);

                //Clicking on Next Button
                _click(POD.Next_Video_button);
            }

        }

        else
        {

            //Fetching list of WebElements
            List<WebElement> next_button = driver.findElements(POD.Next_Video_button);

            //Using enhanced for loop to get the elements
            for (WebElement ele : next_button)

            {
                //CLicking on each Video Card
                _click(POD.Video_Card_Container_iOS);

                //Clicking on Next Button
                ele.click();

            }

        }
    }

    //Scenario: 7 #Verifying ‘Start Creating’ CTA on Demo Home Page


    @When("User clicks on Start Creating CTA")
    public void user_clicks_on_start_creating_cta() throws InterruptedException {

        Scrolling_to_element(POD.Start_Creating);
        _click(POD.Start_Creating);

    }

    @When("User is at Upgrade Your Plan Page")
    public void User_is_at_Upgrade_Your_Plan_Page() {

        _wait(PO.Page_Title);
        Assert.assertTrue(_is_displayed(PO.Page_Title));

    }

    //Scenario: 8 #Verifying ‘Upgrade Package Page’ from bottom tab

    @When("User clicks on Upgrade Package icon from bottom bar")
    public void user_clicks_on_upgrade_package_icon_from_bottom_bar() {

        _click(POD.Upgrade_Package_Bottom_Tab);

    }


    //Scenario: 9 #Verifying logout for Demo User



    //Scenario: 10 #Verifying Contact Us for Demo User

    @When("User clicks on Contact Us")
    public void user_clicks_on_contact_us() {

        _wait(POD.Contact_Us);
        _click(POD.Contact_Us);

    }

    @Then("User is redirected to the Mail")
    public void user_is_redirected_to_the_mail(){

        _waitAbsence(POD.Contact_Us);
        Assert.assertFalse(_is_displayed(POD.Contact_Us));

    }


    //Scenario: 11 #Verifying 'how to Join Class' Card for Demo User

    @Then("Verify 'How to Join Class' Card for Demo User")
    public void Verify_how_to_Join_Class_Card_for_Demo_User() {

        _wait(POD.How_To_Join_Card);
        Assert.assertTrue(_is_displayed(POD.How_To_Join_Card));

    }

}
