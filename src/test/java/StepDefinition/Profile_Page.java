package StepDefinition;

import Base.BaseUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Profile_Page extends BaseUtil {



    //Scenario: 1 #Verifying Refer a friend Section using CTA

    @When("User taps on Refer a friend tab")
    public void user_taps_on_refer_a_friend_tab() {


        _click(POP.Refer_Friend);

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


    //Scenario: 2 #Verifying Refer a friend Section using Share Link

    @When("User taps on Share Link button")
    public void user_taps_on_share_link_button() {

        _click(POP.Share_Link);

    }

    @Then("Share bottom sheet should open")
    public void share_bottom_sheet_should_open() {

        _waitAbsence(POP.Share_Link);
        Assert.assertFalse(_is_displayed(POP.Share_Link));

    }

    @Then("Share bottom sheet should be dismissed")
    public void share_bottom_sheet_should_be_dismissed() {

        _wait(POP.Share_Link);
        Assert.assertTrue(_is_displayed(POP.Share_Link));
    }

    @And("Toast message should appear")
    public void toast_message_should_appear() {

        _wait(PO.Native_Toast_Message);
        Assert.assertTrue(_is_displayed(PO.Native_Toast_Message));

    }

    //Scenario: 3 #Verifying back button of Refer screen

    @When("User taps on back button on screen")
    public void user_taps_on_back_button_on_screen() {

        _click(PO.Page_back_button);

    }

    //Scenario: 4 #Verifying Contact Us for Paid User

}
