package StepDefinition;

import Base.BaseUtil;
import io.appium.java_client.MobileElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BaseUtil {

    //Scenario: 1 #Verifying back button of Re-scheduling Next Class screen

    @When("User Clicks on three dots button")
    public void user_clicks_on_three_dots_button() {

        _click(PO.triple_dots);

    }

    @Then("Dropdown should appear")
    public void dropdown_should_appear() {

        _wait(PO.Reschedule);
        Assert.assertTrue(_is_displayed(PO.Reschedule));

    }

    @When("User Selects Reschedule button")
    public void user_selects_reschedule_button() {

        _click(PO.Reschedule);

    }

    @Then("User is at Reschedule screen and Next class should be pre-selected")
    public void user_is_at_reschedule_screen_and_next_class_should_be_pre_selected() {

        _wait(PO.Next_Class_Selected);
        Assert.assertTrue(_is_displayed(PO.Next_Class_Selected));

    }

    @When("User clicks on back button")
    public void user_clicks_on_back_button() {

        _click(PO.Page_back_button);
    }

    @Then("User should be redirected to Home Page")
    public void user_should_be_redirected_to_home_page() {

        _wait(PO.triple_dots);
        Assert.assertTrue(_is_displayed(PO.triple_dots));

    }


    //Scenario: 2 #Verifying Re-scheduling Next Class

    @When("User selected next class date and time")
    public void user_selected_next_class_date_and_time() {

        _click(PO.Next_Class_date);
        _wait(PO.Select_date_bottom_sheet);

        _random_options_from_dropdown(PO.Bottom_Sheet_Elements_day);

        _wait(PO.Book_Your_Class_CTA);

        _click(PO.Next_Class_Time);
        _wait(PO.Select_time_bottom_sheet);

        _random_options_from_dropdown(PO.Bottom_Sheet_Elements_time);

    }

    @When("User clicks on Book your Slot CTA")
    public void user_clicks_on_book_your_slot_cta() {

        _wait(PO.Book_Your_Class_CTA);
        _click(PO.Book_Your_Class_CTA);

    }

    @Then("User should be able to successfully Reschedule the class")
    public void user_should_be_able_to_successfully_reschedule_the_class() {

        _wait(PO.Toast_Message);
        Assert.assertTrue(_get_text(PO.Toast_Message).contains("Your class has been rescheduled to"));

    }

    //Scenario: 3 #Verifying Re-scheduling All Class

    @Then("User is at Reschedule screen")
    public void user_is_at_reschedule_screen() {

        _wait(PO.All_Class);
        Assert.assertTrue(_is_displayed(PO.All_Class));

    }

    @When("User selects All Class tab")
    public void user_selects_all_class_tab() {

        _click(PO.All_Class);

        //Validating if All Class tab is selected
        _wait(PO.All_Class_Selected);
        Assert.assertTrue(_is_displayed(PO.All_Class_Selected));

    }

    @Then("By default three class per week should be shown")
    public void by_default_three_class_per_week_should_be_shown() throws InterruptedException {

        //Validating default no. of classes are shown
        Scrolling_to_element(PO.Book_Your_Class_CTA);

        try {

            if (Platform.equalsIgnoreCase("Android"))
                wait.until(ExpectedConditions.presenceOfElementLocated(PO.Fourth_class_dropdown));
            else
                wait.until(ExpectedConditions.presenceOfElementLocated(PO.Fourth_class_dropdown_ios));

            Assert.fail();
        }
        catch (TimeoutException e)
        {
            if (Platform.equalsIgnoreCase("Android"))
                Assert.assertTrue(_is_displayed(PO.Third_Class_dropdown));
            else
                Assert.assertTrue(driver.findElement(By.xpath("//*[@name='3rd Class']")).isDisplayed());
                //Assert.assertTrue(_is_displayed(PO.Third_Class_dropdown_ios));

        }

    }

    @When("User selects classes one by one")
    public void user_selects_classes_one_by_one() {

        _selecting_one_by_one_from_dropdown(PO.Number_of_Classes);

    }

    @Then("User should see the option to select date amd time based on number of classes selected")
    public void user_should_see_the_option_to_select_date_amd_time_based_on_number_of_classes_selected() {

        //Fetching list of WebElements
        List<MobileElement> dropdown_menu = driver.findElements(PO.Number_of_Classes);

        //Creating ArrayList and Random instance
        ArrayList<Integer> al = new ArrayList();

        //Using enhanced for loop to get the elements
        for (MobileElement ele : dropdown_menu)

        {
            ele.click();
            swipeScreen(Direction.UP);
            al.add(_get_WebElements_size(PO.Class_Per_week_count));

        }

        //Asserting all 4 classes slots wrt classes selected
        Assert.assertEquals("2", String.valueOf(al.get(0)));
        Assert.assertEquals("4", String.valueOf(al.get(1)));
        Assert.assertEquals("6", String.valueOf(al.get(2)));
        Assert.assertEquals("8", String.valueOf(al.get(3)));

    }

    @When("User selected all four classes date and time")
    public void user_selected_all_four_classes_date_and_time() {

        //Fetching list of WebElements
        List<WebElement> dropdown_menu = driver.findElements(PO.Class_Per_week_count);


        //Using enhanced for loop to get the elements
        for (WebElement ele : dropdown_menu) {

            ele.click();

            //Selecting any option from the available date/time
            if (Platform.equalsIgnoreCase("Android")) {
                _wait_till_element_available_in_dropdown(PO.Bottom_Sheet_Elements_Android, 5);
                _random_options_from_dropdown(PO.Bottom_Sheet_Elements_Android);
            }
            else
            {
                _wait_till_element_available_in_dropdown(PO.Bottom_Sheet_Elements, 5);
                _random_options_from_dropdown(PO.Bottom_Sheet_Elements);
            }

            _wait(PO.Book_Your_Class_CTA);
        }

    }

    @Then("User should be able to successfully Reschedule all the classes")
    public void user_should_be_able_to_successfully_reschedule_all_the_classes() {

        _wait(PO.Toast_Message);
        Assert.assertEquals("Your classes have been rescheduled!", _get_text(PO.Toast_Message));

    }

    //Scenario: 4 #Verifying No button on Cancel Class card

    @When("User Selects Cancel button")
    public void user_selects_cancel_button() {

        _click(PO.Cancel_button);

    }

    @Then("User is at Cancel screen")
    public void user_is_at_cancel_screen() {

        _wait(PO.Next_Class_Selected);
        Assert.assertTrue(_is_displayed(PO.Next_Class_Selected));

    }

    @When("User clicks on NO button")
    public void user_clicks_on_no_button() {

        swipeScreen(Direction.UP);
        _wait(PO.No_Cancel_button);
        _click(PO.No_Cancel_button);

    }

    //Scenario: 5 #Verifying YES button on Cancel Class card without selecting any reason

    @When("User clicks on YES button")
    public void user_clicks_on_yes_button() {

        swipeScreen(Direction.UP);
        _wait(PO.Yes_Cancel_button);
        _click(PO.Yes_Cancel_button);
    }

    @Then("User should be able to successfully Cancel the class")
    public void user_should_be_able_to_successfully_cancel_the_class() {

        _wait(PO.Toast_Message);
        Assert.assertTrue(_get_text(PO.Toast_Message).contains("has been cancelled!"));

    }

    //Scenario: 6 #Verifying YES button on Cancel Class card after selecting any reason

    @When("User select Cancellation reason")
    public void user_select_cancellation_reason() {

        swipeScreen(Direction.UP);
        _Select_random_options_(PO.Cancel_Reason, 6);

    }


    //Scenario: 7 #Verifying referral card on Home Page

    @When("User clicks on Know More CTA of referral card")
    public void user_clicks_on_know_more_cta_of_referral_card() throws InterruptedException {


        Scrolling_to_element(PO.Know_More_CTA);
        _click(PO.Know_More_CTA);

    }

    @Then("User is at Invite & Win Screen")
    public void User_at_Invite_Win_Screen() throws InterruptedException {

        _wait(PO.Leaderboard_link);
        Assert.assertEquals("Invite & Win", _get_text(PO.Page_Title));

    }

    @When("User clicks on Book Free Trial CTA of referral card")
    public void user_clicks_on_book_free_trial_cta_of_referral_card() throws InterruptedException {


        Scrolling_to_element(PO.Book_Free_Trial_CTA);
        _click(PO.Book_Free_Trial_CTA);

    }

    @Then("User should be redirected to mWeb")
    public void user_should_be_redirected_to_m_web() {

        _waitAbsence(PO.Book_Free_Trial_CTA);

    }

    @When("User taps device back button")
    public void User_taps_device_back_button() {

        //Reusing method to Navigate back to app
        _Navigate_BacktoApp();

    }

    @Then("User should be navigated to the same page")
    public void User_navigated_to_the_same_page() {

        _wait(PO.Book_Free_Trial_CTA);
        Assert.assertTrue(_is_displayed(PO.Book_Free_Trial_CTA));

    }


    //Scenario: 8 #Verifying COPY LINK on Invite Screen

    @When("User taps on Copy Link button")
    public void user_taps_on_share_link_button() {

        _click(POP.Share_Link);

    }

    @Then("Share bottom sheet should open")
    public void share_bottom_sheet_should_open() {

        _waitAbsence(POP.Share_Link);
        Assert.assertFalse(_is_displayed(POP.Share_Link));

    }

    @Then("User dismiss Share bottom sheet at OS level")
    public void User_dismiss_Share_bottom_sheet_at_OS_level() {

        driver.navigate().back();

    }

    @Then("Share bottom sheet should be dismissed")
    public void share_bottom_sheet_should_be_dismissed() {

        _wait(POP.Share_Link);
        Assert.assertTrue(_is_displayed(POP.Share_Link));
    }

    @And("Toast message should appear")
    public void toast_message_should_appear() {

        _wait(PO.Native_Toast_Message);
    }



    //Scenario: 9 #Verifying Know More CTA on Invite Screen

    @Then("User is at Policy Screen")
    public void User_is_at_Policy_Screen() throws InterruptedException {

        Thread.sleep(1000);
        Assert.assertEquals("Policy", _get_text(PO.Page_Title));

    }


    //Scenario: 10 #Verifying Leaderboard Screen

    @When("User clicks on Leaderboard link")
    public void User_clicks_on_Leaderboard_link() {

        _wait(PO.Leaderboard_link);
        _click(PO.Leaderboard_link);

    }

    @Then("User is at Leaderboard Screen")
    public void User_is_at_Leaderboard_Screen() {

        _wait(PO.Leaderboard_Page);
        Assert.assertTrue(_is_displayed(PO.Leaderboard_Page));

    }


}
