package StepDefinition;

import Base.BaseUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Demo_User_Completed extends BaseUtil {

    //Scenario: 1 #Verifying 'Congratulations!' Card for Demo User

    @Then("Verify Congratulations! Card is visible at the top")
    public void verify_card_is_visible_at_the_top() {

        _wait(POD.Demo_Completed_Banner);
        Assert.assertTrue(_is_displayed(POD.Demo_Completed_Banner));

    }


    //Scenario: 2 #Verifying unlocked Certificate on Home Page

    @Then("Verify Certificate on Home Page is unlocked")
    public void verify_certificate_on_home_page_is_unlocked() {

        //Verifying unlock certificate text
        Assert.assertTrue(_is_displayed(POD.Unlocked_Certificate_text));

        //Verifying if locked icon is removed
        Assert.assertFalse(_is_displayed(POD.Locked_icon_on_Demo_Certificate));

    }

    //Scenario: 3 #Verifying unlocked Certificate can be downloaded

    @When("User taps on Download CTA")
    public void user_taps_on_download_cta() throws InterruptedException {

        //Tapping on Download CTA
        Scrolling_to_element(POD.Download_certificate_CTA);
        _click(POD.Download_certificate_CTA);

    }

    @Then("Verify Certificate can be downloaded")
    public void verify_certificate_can_be_downloaded() {

        //Waiting till home page is invisible
        _waitAbsence(POD.Download_certificate_CTA);
    }

    //Scenario: 4 #Verifying Upgrade Your Plan Section on Home Page

    @Then("Verify Upgrade Your Plan Section on Home Page")
    public void verify_upgrade_your_plan_section_on_home_page() throws InterruptedException {

        //Scrolling till element is visible
        Scrolling_to_element(PO.Buy_This_Plan_CTA);

        //Validating Upgrade Your Plan Section on Home Page
        Assert.assertTrue(_is_displayed(PO.Download_Curriculum_CTA));

    }


}
