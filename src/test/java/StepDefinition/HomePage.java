package StepDefinition;

import Base.BaseUtil;
import io.appium.java_client.MobileElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

    @Then("User is at Edit Reschedule screen")
    public void User_is_at_Edit_Reschedule_screen() {

        _wait(PO.Book_Your_Class_CTA);
        Assert.assertTrue(_is_displayed(PO.Book_Your_Class_CTA));

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

    @When("User Selects 'Not available for next Class' option")
    public void User_Selects_Not_available_for_next_Class_option() {

        _wait(PO.Not_Available_Next_Class);
        _click(PO.Not_Available_Next_Class);

    }

    @And("User taps on Submit CTA")
    public void User_taps_on_Submit_CTA() {



         _wait(PO.Submit_CTA);
         _click(PO.Submit_CTA);

    }

    @Then("User is at Reschedule Next Class screen")
    public void User_is_at_Reschedule_Next_Class_screen() {

        _wait(PO.Submit_CTA);
        Assert.assertTrue(_is_displayed(PO.Submit_CTA));

    }

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



    @Then("User should be able to successfully Reschedule the class")
    public void user_should_be_able_to_successfully_reschedule_the_class() {

        _wait(PO.Toast_Message);
        Assert.assertTrue(_get_text(PO.Toast_Message).contains("Your class has been rescheduled to"));

    }

    //Scenario: 3 #Verifying Re-scheduling All Class

    @When("User Selects 'Update Entire Schedule' option")
    public void User_Selects_Update_Entire_Schedule_option() {

        _wait(PO.Update_Entire_Schedule);
        _click(PO.Update_Entire_Schedule);

    }

    @Then("By default three class per week should be shown")
    public void by_default_three_class_per_week_should_be_shown() throws InterruptedException {

        //Validating default no. of classes are shown
        Scrolling_to_element(PO.Disclaimer_Text);

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
                Assert.assertTrue(_is_displayed(PO.Third_Class_dropdown_ios));

        }

    }

    @When("User selects classes one by one")
    public void user_selects_classes_one_by_one() {

        _selecting_one_by_one_from_dropdown(PO.Number_of_Classes);

    }

    @Then("User should see the option to select date amd time based on number of classes selected")
    public void user_should_see_the_option_to_select_date_amd_time_based_on_number_of_classes_selected() throws InterruptedException {

        //Fetching list of WebElements
        List<MobileElement> dropdown_menu = driver.findElements(PO.Number_of_Classes);

        //Creating ArrayList and Random instance
        ArrayList<Integer> al = new ArrayList();

        //Using enhanced for loop to get the elements
        int count =0;
        for (MobileElement ele : dropdown_menu)

        {
            count++;
            ele.click();
            if(count!=4)
                Scrolling_to_element(PO.Disclaimer_Text); //Scrolling till Element is visible

            Thread.sleep(500);
            al.add(_get_WebElements_size(PO.Class_Per_week_count));

        }

        //Asserting all 4 classes slots wrt classes selected
        Assert.assertEquals("2", String.valueOf(al.get(0)));
        Assert.assertEquals("4", String.valueOf(al.get(1)));
        Assert.assertEquals("6", String.valueOf(al.get(2)));

        if(Platform.equalsIgnoreCase("Android"))
            Assert.assertEquals("7", String.valueOf(al.get(3)));
        else
            Assert.assertEquals("8", String.valueOf(al.get(3)));

    }

    @When("User selected all four classes date and time")
    public void user_selected_all_four_classes_date_and_time() throws InterruptedException {

        //Fetching list of WebElements
        List<WebElement> dropdown_menu = driver.findElements(PO.Class_Per_week_count);


        //Using enhanced for loop to get the elements
        for (WebElement ele : dropdown_menu) {

            ele.click();

            //Selecting any option from the available date/time
            PO.Select_slot();

            //Scrolling till Element is visible
            Scrolling_to_element(PO.Book_Your_Class_CTA);
            _wait(PO.Book_Your_Class_CTA);
        }

        if(Platform.equalsIgnoreCase("Android")) {

            //Swiping up to select 2nd Time Slot
            swipeScreen(Direction.DOWN);
            _click(PO.Class_1_Select_Time);
            PO.Select_slot();


            //Scrolling till Element is visible
            Scrolling_to_element(PO.Book_Your_Class_CTA);
            _click(PO.Class_4_Select_Time);
            PO.Select_slot();
        }

    }

    @Then("User should be able to successfully Reschedule all the classes")
    public void user_should_be_able_to_successfully_reschedule_all_the_classes() {

        _wait(PO.Toast_Message);
        Assert.assertEquals("Your classes have been rescheduled!", _get_text(PO.Toast_Message));

    }

    //Scenario: 4 #Verifying Adding More Classes feature

    @When("User Selects 'Complete Your Course Fast' option")
    public void User_Selects_Complete_Your_Course_Fast_option() {

        _wait(PO.Fast_Course_Completion);
        _click(PO.Fast_Course_Completion);

    }

    @Then("User is at Add More Classes screen")
    public void User_is_at_Add_More_Classes_screen() {

        _wait(PO.Disclaimer_Text);
        Assert.assertTrue(_is_displayed(PO.Disclaimer_Text));

    }


    //Scenario: 5 #Verifying No button on Cancel Class card


    @Then("User navigates to Cancel screen")
    public void user_is_at_cancel_screen() {

        swipeScreen(Direction.UP);
        _wait(PO.No_Cancel_button);
        Assert.assertTrue(_is_displayed(PO.No_Cancel_button));

    }

    @When("User clicks on NO button")
    public void user_clicks_on_no_button() {

        _wait(PO.No_Cancel_button);
        _click(PO.No_Cancel_button);

    }

    //Scenario: 6 #Verifying YES button on Cancel Class card without selecting any reason

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

    //Scenario: 7 #Verifying YES button on Cancel Class card after selecting any reason

    @When("User select Cancellation reason")
    public void user_select_cancellation_reason() {

        swipeScreen(Direction.UP);
        _Select_random_options_(PO.Cancel_Reason, 6);

    }


    //Scenario: 8 #Verifying referral card on Home Page

    @When("User clicks on Know More CTA of referral card")
    public void user_clicks_on_know_more_cta_of_referral_card() throws InterruptedException {


        Scrolling_to_element(PO.Know_More_CTA);
        _click(PO.Know_More_CTA);

    }

    @Then("User is at Invite & Win Screen")
    public void User_at_Invite_Win_Screen() {

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


    //Scenario: 9 #Verifying COPY LINK on Invite Screen

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



    //Scenario: 10 #Verifying Know More CTA on Invite Screen

    @When("User clicks on referral card of Invite & Win Screen")
    public void User_clicks_on_referral_card_of_Invite_Win_Screen() {

        if(Platform.equalsIgnoreCase("Android"))
            _click(PO.Referral_Card_Android);
        else
            _click(PO.Referral_Card_iOS);

    }

    @Then("User is at Policy Screen")
    public void User_is_at_Policy_Screen() throws InterruptedException {

        Thread.sleep(1000);
        Assert.assertEquals("Policy", _get_text(PO.Page_Title));

    }


    //Scenario: 11 #Verifying Leaderboard Screen

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


    //Scenario: 12 #Verifying global House Banner

    @When("User clicks on global house banner")
    public void user_clicks_on_global_house_banner() {

       //Clearing Data of Test User from DB before Running this Test
       _getResult(valueForTheGivenKey("DeleteGlobalHouseEntry"), null, null);

       //Waiting for Global House Banner
        _wait(PO.Global_House);

       //Redirecting to Global House Screen
       _click(PO.Global_House);

    }


    @Then("User should be redirected to Global House Screen")
    public void user_should_be_redirected_to_global_house_screen() {

        //Waiting to land on Global House Page
        _wait(PO.Page_Title);

        //Validating Global House Page
        Assert.assertEquals("Global House", _get_text(PO.Page_Title));

    }

    @When("User selects all the Preference")
    public void user_selects_all_the_preference() throws InterruptedException {

        //Scrolling till Submit CTA
        Scrolling_to_element(PO.Book_Your_Class_CTA);

        //Selecting all the 3 Slots
        //Fetching list of WebElements
        List<WebElement> slots = driver.findElements(PO.Global_House_slots);

        //Using enhanced for loop to get the elements
        for (WebElement ele : slots)

        {
            //Selecting Date/Time Slot CTA
            try {
                ele.click();
            }
            catch (StaleElementReferenceException e)
            {
                ele.click();
            }

            //Selecting Day/Time from Bittom Sheet
            _wait_till_element_available_in_dropdown(PO.Bottom_Sheet_Elements_Android, 5);
            _random_options_from_dropdown(PO.Global_House_slot_bottom_sheet);

        }

    }

    @Then("User clicks on Submit CTA")
    public void Submit_cta_should_get_enabled() {

        _click(PO.Book_Your_Class_CTA);

    }

    @Then("Verify Congratulations! message on Global House Screen")
    public void verify_congratulations_message_on_global_house_screen() throws InterruptedException {

        //Scrolling till top
        swipeScreen(Direction.DOWN);

        //Scrolling till Congratulations!! Message
        Scrolling_to_element(PO.Global_House_Congrats);

        //Asserting the Success message
        Assert.assertEquals(valueForTheGivenKey("Success_Message_GH"),
                _get_text(PO.Global_House_Successsfull_Entry));

    }



}
