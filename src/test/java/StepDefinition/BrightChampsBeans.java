package StepDefinition;

import Base.BaseUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BrightChampsBeans extends BaseUtil {

    //Scenario: 1 #Verifying BrightChamps Beans Screen and back button

    @When("User Clicks on BC Beans icon on Home Page")
    public void user_clicks_on_bc_beans_icon_on_home_page() {

        //User click on Beans icon on Home Page
        _click(POB.Beans_Count);

    }


    @Then("User should be redirected to BrightChamps Beans Screen")
    public void user_should_be_redirected_to_bright_champs_beans_screen() {

        //Waiting to land on BrightChamps Beans Screen
        _wait(PO.Page_Title);

        //Validating if User landed on the Same Page
        Assert.assertEquals("BrightChamps Beans", _get_text(PO.Page_Title));

    }


    //Scenario: 2 #Verifying BrightChamps Beans Progress Map in Full Screen

    @When("User clicks on Expand icon")
    public void user_clicks_on_expand_icon() throws InterruptedException {

        //Scroll till Exspand icon on BrightChamps Beans Screen
        Scrolling_to_element(POB.Expand_icon);

        //Clicking on Expand icon
        _click(POB.Expand_icon);

    }

    @Then("User should be redirected to Full View Map Screen")
    public void user_should_be_redirected_to_full_view_map_screen() {

        if(Platform.equalsIgnoreCase("Android")) {

            //Wait to land on Fill Map View Screen
            _wait(POB.X_Button);

            //Validating Full Map View Screen
            Assert.assertTrue(_is_displayed(POB.X_Button));
        }
        else
        {
            //Wait to land on Fill Map View Screen
            _wait(POB.X_Button_iOS);

            //Validating Full Map View Screen
            Assert.assertTrue(_is_displayed(POB.X_Button_iOS));

        }

    }

    @When("User taps on X button")
    public void user_taps_on_x_button() {

        //Clicking on Close icon
        if(Platform.equalsIgnoreCase("Android"))
            _click(POB.X_Button);
        else
            _click(POB.X_Button_iOS);

    }


    //Scenario: 3 #Verifying BrightChamps Beans Know More Screen and back button

    @When("User clicks on Know More Button")
    public void user_clicks_on_know_more_button() throws InterruptedException {

        //Scroll till Exspand icon on BrightChamps Beans Screen
        Scrolling_to_element(POB.Know_More);

        //Clicking on Expand icon
        _click(POB.Know_More);

    }


    @Then("User should be redirected to BrightChamps Beans Page")
    public void user_should_be_redirected_to_bright_champs_beans_page() throws InterruptedException {

        //Waiting to land on BrightChamps Beans Screen
        _wait(POB.Activities_Section);

        //Validating if User landed on the Same Page
        Assert.assertEquals("Want to earn more beans? Here's how!", _get_text(POB.Activities_Section));


    }

    //Scenario: 4 #Verifying BrightBEANS Bank Screen and Back Button

    @When("User clicks on Yours Beans Bank button")
    public void user_clicks_on_yours_beans_bank_button() {

        _click(POB.Your_Beans_Bank);

    }


    @Then("User should be redirected to BrightBEANS Bank Screen")
    public void user_should_be_redirected_to_bright_beans_bank_screen() throws InterruptedException {

        //Waiting to land on BrightBEANS Bank Screen
        if(Platform.equalsIgnoreCase("Android"))
            _wait(POB.Earning_Details);
        else
            Thread.sleep(1000);

        //Validating if User landed on the Same Page
        Assert.assertEquals("BrightBEANS Bank", _get_text(PO.Page_Title));

    }


    //Scenario: 5 #Verifying BrightBEANS Bank Screen

    @Then("Verify all the Earning details card on BrightBEANS Bank Screen")
    public void verify_all_the_earning_details_cards_on_bright_beans_bank_screen() throws InterruptedException {

        //Scrolling up to make all Earnings Visible
        swipeScreen(Direction.UP);

        //Fetching list of WebElements
        List<WebElement> EarnedCards = driver.findElements(POB.Earning_Details);

        String EarnedCardName;

        //Using enhanced for loop to get the elements
        for (WebElement ele : EarnedCards)

        {

          //Storing Name on Earned Cards in String Variable
          EarnedCardName = ele.getText();

          //Clicking on each Cards
          ele.click();

          //Waiting for User to land on Earned Card Details Screen
            if(Platform.equalsIgnoreCase("Android"))
                _wait(POB.EarnedCardDetailScreen);
            else
                Thread.sleep(1000);

          //Validating if User lands on the Same Card which he has clicked
          Assert.assertEquals(EarnedCardName, _get_text(PO.Page_Title));

          //Navigating back to the Previous Screen
          _click(PO.Page_back_button);

          //Resuing above method to validate
          user_should_be_redirected_to_bright_beans_bank_screen();

        }


    }


}
