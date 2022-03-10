package StepDefinition;

import Base.BaseUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

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

}
