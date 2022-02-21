package StepDefinition;

import Base.BaseUtil;
import io.appium.java_client.MobileElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.Random;

public class Profile_Details_Screen extends BaseUtil {


    public String OLD_DOB;

    @When("User taps on Personal Information tab")
    public void user_taps_on_personal_information_tab() {

        _click(POP.Personal_info);

    }

    @Then("User should ne redirected to Profile Details screen")
    public void user_should_ne_redirected_to_profile_details_screen() {

        _wait(POP.Save_CTA);
        Assert.assertTrue(_is_displayed(POP.Save_CTA));

    }


    //Scenario: 1 #Verifying Updating Profile Page information

    ArrayList<String> AL;

    @When("User updates all the Profile page information")
    public void user_updates_all_the_profile_page_information() throws InterruptedException {

        //First Adding Values to be entered in ArrayList
        AL = new ArrayList<>();

        AL.add(getAlphaNumericString("Alpha",7)); //Student's First Name
        AL.add(getAlphaNumericString("Alpha",7)); // Student's Last Name
        AL.add(getAlphaNumericString("Alpha",7)); // Father's First name
        AL.add(getAlphaNumericString("Alpha",7)); // Mother's First Name
        AL.add(getAlphaNumericString("Numeric",10)); //Father's Phone Number
        AL.add(getAlphaNumericString("Alpha",5)+"@mailinator.com"); //Father's Email
        AL.add(getAlphaNumericString("Numeric",10)); //Mother's Phone Number
        AL.add(getAlphaNumericString("Alpha",5)+"@mailinator.com"); //Mother's Email
        AL.add(getAlphaNumericString("Alpha",6)); //City
        AL.add(getAlphaNumericString("Alpha",8)); //School


        //User clears and enters Student Name
        _cleartext(POP.Student_Name);
        _SendKeys(POP.Student_Name, AL.get(0)+" "+AL.get(1));

        //User clears and enters Father's Name
        Scrolling_to_element(POP.Father_Name);
        _cleartext(POP.Father_Name);
        _SendKeys(POP.Father_Name, AL.get(2)+" "+AL.get(1));

        //User clears and enters Mother's Name
        Scrolling_to_element(POP.Mother_Name);
        _cleartext(POP.Mother_Name);
        _SendKeys(POP.Mother_Name, AL.get(3)+" "+AL.get(1));

        //Storing previous value into AL Object at 10th index
        String Previous_Value = _get_text(POP.Grade);
        AL.add(Previous_Value);

        //User enters Grade from dropdown
        do {
            _click(POP.Grade);
            //wait for dropdown to appear
            _wait(POP.Grade_bottom_sheet);
            _random_options_from_dropdown(POP.Grade_bottom_sheet_values);

        } while (AL.get(10).equals(_get_text(POP.Grade)));

        //Storing previous value into AL Object at 11th index
        Scrolling_to_element(POP.Gender);
        String PreviousValue = _get_text(POP.Gender);
        AL.add(PreviousValue);

        //User enters Gender from dropdown
        do {
            _click(POP.Gender);
            //wait for dropdown to appear
            _wait(POP.Gender_bottom_sheet);
            _random_options_from_dropdown(POP.Gender_bottom_sheet_values);

        } while (AL.get(11).equals(_get_text(POP.Gender)));

        //User clears and enters Father's Phone Number
        Scrolling_to_element(POP.School_Name);
        _cleartext(POP.Father_Phone);
        _SendKeys(POP.Father_Phone, AL.get(4));

        //User clears and enters Father's Email
        _cleartext(POP.Father_Email);
        _SendKeys(POP.Father_Email, AL.get(5));

        //User clears and enters Mother's Phone Number
        _cleartext(POP.Mother_Phone);
        _SendKeys(POP.Mother_Phone, AL.get(6));

        //User clears and enters Mother's Email
        _cleartext(POP.Mother_Email);
        _SendKeys(POP.Mother_Email, AL.get(7));

        //Storing previous value into AL Object at 12th index
        AL.add(_get_text(POP.Country));

        //User enters Country from dropdown
        _click(POP.Country);

        //wait for dropdown to appear
        _wait(POP.Country_bottom_sheet);
        _selecting_particular_options_from_dropdown(POP.Country_bottom_sheet_values,"India | India Standard");

        //User clears and enters City
        Scrolling_to_element(POP.City);
        _cleartext(POP.City);
        _SendKeys(POP.City, AL.get(8));

        //User clears and enters School Name
        _cleartext(POP.School_Name);
        _SendKeys(POP.School_Name, AL.get(9));

    }

    @And("User clicks on Save Button")
    public void user_clicks_on_save_button() {

        //Clicking on SAVE button to update the newly entered data
       _click(POP.Save_CTA);

    }

    @Then("Profile Updated Success message should appear")
    public void profile_updated_success_message_should_appear() {

        //Waiting for Success message to appear
        _wait(PO.Toast_Message);

        //Asserting the success msg should disappear in few seconds
        _waitAbsence(PO.Toast_Message);
    }

    @And("Profile Page should get updated")
    public void profile_page_should_get_updated() throws InterruptedException {

        //Method to fetch Updated APIs
        POP.Save_back_forth();

        //Validating the Updated Fields
        Assert.assertEquals(AL.get(0)+" "+AL.get(1),_get_text(POP.Student_Name));
        Assert.assertNotEquals(AL.get(10),_get_text(POP.Grade));

        //Scrolling to get the content in view
        Scrolling_to_element(POP.Father_Name);

        //Validating the Updated Fields
        Assert.assertEquals(AL.get(2)+" "+AL.get(1),_get_text(POP.Father_Name));
        Assert.assertEquals(AL.get(3)+" "+AL.get(1),_get_text(POP.Mother_Name));

        //Scrolling to get the content in view
        Scrolling_to_element(POP.Gender);
        Assert.assertNotEquals(AL.get(11),_get_text(POP.Gender));

        //Scrolling to get the content in view
        Scrolling_to_element(POP.School_Name);

        //Validating the Updated Fields
        Assert.assertEquals(AL.get(4),_get_text(POP.Father_Phone));
        Assert.assertEquals(AL.get(5),_get_text(POP.Father_Email));
        Assert.assertEquals(AL.get(6),_get_text(POP.Mother_Phone));
        Assert.assertEquals(AL.get(7),_get_text(POP.Mother_Email));
        Assert.assertEquals(AL.get(8),_get_text(POP.City));
        Assert.assertEquals(AL.get(9),_get_text(POP.School_Name));
        Assert.assertEquals(AL.get(12),_get_text(POP.Country));

    }


    //Scenario: 2 #Verifying Updating Hobbies on Profile Page

    @When("User clicks on X button of Hobbies")
    public void user_clicks_on_x_button_of_hobbies() throws InterruptedException {

        Scrolling_to_element(POP.Hobbies);
        swipeScreen(Direction.UP);

        _selecting_one_by_one_from_dropdown(POP.Hobbies_Delete);

    }

    @Then("Hobbies should be deleted")
    public void hobbies_should_be_deleted() {

        Assert.assertTrue(driver.findElements(POP.Hobbies_Delete).isEmpty());

    }

    @Then("Verify if Hobbies are still deleted after Saving")
    public void Verify_if_Hobbies_are_still_deleted_after_Saving() throws InterruptedException {

        //Method to fetch Updated APIs
        POP.Save_back_forth();

        //Scrolling till Hobbies
        Scrolling_to_element(POP.Hobbies);
        swipeScreen(Direction.UP);

        //Validate if Hobbies are deleted after Saving
        hobbies_should_be_deleted(); //Reusing above methods

    }

    @When("User enters new Hobbies from Dropdown")
    public void user_enters_new_hobbies_from_dropdown() {

        //User enters multiple random Hobbies from dropdown
        for (int i = 0 ; i<5; i++) {

            //Invoking Hobbies dropdown
            _wait(POP.Hobbies);
            _click(POP.Hobbies);

            //wait for dropdown to appear
            _wait(POP.Hobbies_bottom_sheet);
            _random_options_from_dropdown(POP.Hobbies_bottom_sheet_values);
        }

    }

    @Then("New Hobbies should be entered")
    public void new_hobbies_should_be_entered() {

        Assert.assertFalse(driver.findElements(POP.Hobbies_Delete).isEmpty());

    }

    @And("New hobbies should be updated on Profile Page")
    public void new_hobbies_should_be_updated_on_profile_page() throws InterruptedException {

        //Method to fetch Updated APIs
        POP.Save_back_forth();

        //Scrolling till Hobbies
        Scrolling_to_element(POP.Hobbies);
        swipeScreen(Direction.UP);

        //Validate if Hobbies are deleted after Saving
        new_hobbies_should_be_entered(); //Reusing above methods

    }


    //Scenario: 3 #Validate Sub-heading on Profile Page

    @And("Verify Student Name as Sub-heading on Profile Page")
    public void verify_student_name_as_sub_heading_on_profile_page() {

        Assert.assertEquals(_get_text(POP.Profile_Sub_Heading) , _get_text(POP.Student_Name));
    }


    //Scenario: 4 #Verifying Updating DOB from Calendar on Profile Page

    @When("User taps on DOB field")
    public void user_taps_on_dob_field() throws InterruptedException {

        //Scrolling till element is visible
        Scrolling_to_element(POP.Father_Phone);

        //Fetching DOB Value
        OLD_DOB = _get_text(POP.DOB);

        //CLicking to invoke DOB bottom sheet
        _click(POP.DOB);

    }

    @Then("DOB bottom sheet should open")
    public void dob_bottom_sheet_should_open() {

        //Validating DOB bottom sheet
        _wait(POP.DOB_Bottom_Sheet);
        Assert.assertTrue(_is_displayed(POP.DOB_Bottom_Sheet));

    }

    @When("User updated DOB")
    public void user_updated_dob() throws InterruptedException {

        //To fetch Random Value
        Random rand = new Random();

        //Fetching coordinates of the Day element
        MobileElement DOB_Day = (MobileElement) driver.findElement(POP.DOB_Day_bottom_sheet);

        int x = DOB_Day.getLocation().getX();
        int y = DOB_Day.getLocation().getY();

        //Scrolling randomly Day section
        for(int i=0; i<=rand.nextInt(10)+2; i++)
            scroll(driver,x+50, y+350, x+50,y+150);



        //Fetching coordinates of the Month element
        MobileElement DOB_Month = (MobileElement) driver.findElement(POP.DOB_Month_bottom_sheet);

        int x1 = DOB_Month.getLocation().getX();
        int y1 = DOB_Month.getLocation().getY();

        //Scrolling randomly Day section
        for(int i=0; i<=rand.nextInt(10)+2; i++)
            scroll(driver,x1+100, y1+350, x1+100,y1+150);


        //Fetching coordinates of the Year element
        MobileElement DOB_Year = (MobileElement) driver.findElement(POP.DOB_Year_bottom_sheet);

        int x2 = DOB_Year.getLocation().getX();
        int y2 = DOB_Year.getLocation().getY();

        //Scrolling randomly Day section
        for(int i=0; i<=rand.nextInt(10)+2; i++)
            scroll(driver,x2+70, y2+350, x2+70,y2+150);


    }

    @And("Taps on Set CTA")
    public void taps_on_set_cta() {

        //CLick on Set CTA
        _click(POP.SET_CTA);

    }

    @Then("Newly selected DOB should appear on DOB field")
    public void newly_selected_dob_should_appear_on_dob_field() {

        //Waiting till DOB field appears
        _wait(POP.DOB);

        //Validating New DOB should be updated on OLD DOB
        Assert.assertNotEquals(OLD_DOB, _get_text(POP.DOB));

    }

    @And("New DOB should be updated on Profile Page")
    public void new_dob_should_be_updated_on_profile_page() throws InterruptedException {

        //Method to fetch Updated APIs
        POP.Save_back_forth();

        //Scrolling till Hobbies
        Scrolling_to_element(POP.DOB);

        //Validate if Hobbies are deleted after Saving
        newly_selected_dob_should_appear_on_dob_field(); //Reusing above methods

    }

}
