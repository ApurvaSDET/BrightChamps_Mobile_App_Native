package StepDefinition;

import Base.BaseUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import java.util.List;

public class Curriculum extends BaseUtil {

    @When("User clicks on Curriculum icon")
    public void user_clicks_on_curriculum_icon() {

        _click(PO.Curriculum_tab);

    }

    @Then("User is redirected to Curriculum Page")
    public void user_is_redirected_to_curriculum_page() {

        _wait(PO.Curriculum_Page);
        Assert.assertTrue(_is_displayed(PO.Curriculum_Page));
    }


    //Scenario: 1 #Verifying SESSION BOOKLET links on Completed Class Section

    @And("Verify SESSION BOOKLET link of all the completed class cards")
    public void verify_session_booklet_link_of_all_the_completed_class_cards() {

        //Fetching list of WebElements
        List<WebElement> Completed_Class_Cards = driver.findElements(PO.Completed_Class_Cards);

        //Using enhanced for loop to get the elements
        for (WebElement ele : Completed_Class_Cards)

        {
            //Clicking on Completed Class card
            ele.click();

            //Waiting for Completed Class details screen
            _wait(PO.SESSION_BOOKLET_Link);

            //Clicking on Session Booklet link
            _click(PO.SESSION_BOOKLET_Link);

            //waiting to redirect to mWeb
            _waitAbsence(PO.SESSION_BOOKLET_Link);

            //Navigating back to the app from mWeb
            driver.navigate().back();

            //Asserting if landed on Completed Class details screen
            _wait(PO.SESSION_BOOKLET_Link);

            //Navigating back to Curriculum Page from Completed Class details screen
            _click(PO.Curriculum_back_button);

            //Asserting if landed on Curriculum screen
            _wait(PO.Curriculum_Page);
        }

    }


    //Scenario: 2 #Verifying ASSIGNMENT links on Completed Class Section

    @And("Verify ASSIGNMENT link of all the completed class cards")
    public void verify_assignment_link_of_all_the_completed_class_cards() {

        //Fetching list of WebElements
        List<WebElement> Completed_Class_Cards = driver.findElements(PO.Completed_Class_Cards);

        //Using enhanced for loop to get the elements
        for (WebElement ele : Completed_Class_Cards)

        {
            //Clicking on Completed Class card
            ele.click();

            //Waiting for Completed Class details screen
            _wait(PO.Assignment_Link);

            //Clicking on Session Booklet link
            _click(PO.Assignment_Link);

            //waiting to redirect to mWeb
            _waitAbsence(PO.Assignment_Link);

            //Navigating back to the app from mWeb
            driver.navigate().back();

            //Asserting if landed on Completed Class details screen
            _wait(PO.Assignment_Link);

            //Navigating back to Curriculum Page from Completed Class details screen
            _click(PO.Curriculum_back_button);

            //Asserting if landed on Curriculum screen
            _wait(PO.Curriculum_Page);
        }


    }

    //Scenario: 3 #Verifying Upcoming Classes Section

    @When("User clicks on Upcoming Classes link")
    public void user_clicks_on_upcoming_classes_link() {

        _wait(PO.Upcoming_Class);
        _click(PO.Upcoming_Class);
    }

    @Then("User should be redirected to the Upcoming Classes Page")
    public void user_should_be_redirected_to_the_upcoming_classes_page() {

        _wait_till_element_available_in_dropdown(PO.Upcoming_Class_Cards, 5);
        Assert.assertTrue(driver.findElements(PO.Upcoming_Class_Cards).size()>1);

    }


}
