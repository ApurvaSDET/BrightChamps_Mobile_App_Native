package StepDefinition;

import Base.BaseUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Profile_Page extends BaseUtil {



    //Scenario: 1 #Verifying Refer a friend Section using CTA

    @When("User taps on Invite & Win tab")
    public void user_taps_on_invite_tab() {


        _click(POP.Invite);

    }

    @Then("User should be navigated to Refer a friend screen")
    public void user_should_be_navigated_to_refer_a_friend_screen() {

        _wait(POP.Book_Free_Trial_Friends_CTA);
        Assert.assertTrue(_is_displayed(POP.Book_Free_Trial_Friends_CTA));

    }

    @When("User taps on Book Free Trial for Your Friends CTA")
    public void user_taps_on_book_free_trial_for_your_friends_cta() {

        _click(POP.Book_Free_Trial_Friends_CTA);

    }

    @Then("User should be navigated to mWeb")
    public void user_should_be_navigated_to_mWeb() {

        _waitAbsence(POP.Book_Free_Trial_Friends_CTA);

    }


    //Scenario: 2 #Verifying Contact Us for Paid User


    //Scenario: 3 #Verifying Login via QR

    @Then("User clicks on Login on Web")
    public void user_clicks_on_login_on_web() {

        swipeScreen(Direction.UP); //Swiping Up to get QR Login in View
        _click(POP.QRLogin);
    }

    @Then("User is redirected to Login via QR code screen")
    public void user_is_redirected_to_login_via_qr_code_screen() {

        _wait(POP.qrloginlink);
        Assert.assertTrue(_is_displayed(POP.qrloginlink));

    }

    //Scenario: 4 #Verifying Chat with Teacher

    @Then("User clicks on Chat with Teacher")
    public void user_clicks_on_chat_with_teacher() {

        _click(POP.ChatwithTeacher);

    }

    @When("User selects any random Category from Pop-up")
    public void user_selects_any_random_category_from_pop_up() {

        try {

            //Waiting for Category Pop-up
            wait.until(ExpectedConditions.presenceOfElementLocated(POP.Category_PopUp_Header));

            //Selecting any Random Category
            if(Platform.equalsIgnoreCase("Android"))
                _Select_random_options_(POP.Category_PopUp_List,7);
            else
                _Select_random_options_(POP.Category_Chat_List_iOS,7);


            //Click on Sbmit CTA
            _click(PO.LoginWithOTP_CTA);

        }
        catch (TimeoutException e){
            e.getMessage();
        }

    }

    @Then("User is at Chat Screen")
    public void user_is_at_chat_screen() {

        //Waiting for Chat Screen
        _wait(POP.TextBox);

        //Asserting the Chat Screen with text box
        Assert.assertTrue(_is_displayed(POP.TextBox));

    }



    //Scenario: 5 #Verifying Help Centre on Chat Screen

    @When("User clicks on Help icon")
    public void user_clicks_on_help_icon() {

        _click(POP.ChatHelp);

    }

    @Then("Verify Help pop-up should open")
    public void verify_help_pop_up_should_open() {

        //Waiting for Chat Help pop-up
        _wait(POP.ChatHelp_bottomsheet);

        //Asserting the Chat Help pop-up
        Assert.assertTrue(_is_displayed(POP.ChatHelp_bottomsheet));

    }

    @And("User clicks on SUBMIT CTA on Pop-up")
    public void user_clicks_on_submit_cta() {

        //Clicking on SUBMIT CTA
        _click(PO.LoginWithOTP_CTA);

    }

    @When("User Selects any random feedback")
    public void user_selects_any_random_feedback() {

        //Selecting any Random Category
        if(Platform.equalsIgnoreCase("Android"))
            _Select_random_options_(POP.Category_PopUp_List,1);
        else
            _Select_random_options_(POP.Category_PopUp_List_iOS,1);


    }

    @Then("User is at Mail Screen")
    public void user_is_at_mail_screen() {

        _waitAbsence(PO.LoginWithOTP_CTA);
        Assert.assertFalse(_is_displayed(PO.LoginWithOTP_CTA));

    }


    //Scenario: 6 #Verifying Sending a text

    @When("User clicks on Send icon")
    public void user_clicks_on_send_icon() {

        _click(POP.SendIcon);

    }

    @When("User enters text in chat box")
    public void user_enters_text_in_chat_box() {

        _SendKeys(POP.TextBox, "AutomationTest");

    }

    @Then("Message should be Sent Successfully")
    public void message_should_be_sent_successfully() {

        Assert.assertTrue(_is_displayed(POP.TextBox));

    }

}
