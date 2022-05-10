package StepDefinition;

import Base.BaseUtil;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class Upgrade_Package extends BaseUtil {

    HomePage obj;

    @Given("User is at Student portal master login Page")
    public void user_is_at_student_portal_master_login() {

        //waiting till landing on login screen
        _wait(PO.LoginWithPassword);

        //*******************Logic to land on Master login Page*************************

       //Fetching coordinates of the Hidden element
        MobileElement Hidden_menu = (MobileElement) driver.findElement(PO.Hidden_Menu);

        int x = Hidden_menu.getLocation().getX();
        int y = Hidden_menu.getLocation().getY();

        //Scrolling randomly Day section
        TouchAction touchAction = new TouchAction(driver);
        for(int i=0; i<=7; i++)
            touchAction.tap(PointOption.point(x + 15, y + 20)).perform();

        //Asserting the Student Home Page
        _wait(PO.Submit);
        Assert.assertTrue(_is_displayed(PO.Submit));

    }


    //Scenario: 1 #Verifying Upgrade Package Card in case of 5 or fewer classes are left

    @When("User enters valid Phone no and password")
    public void user_enters_valid_phone_no_and_password(DataTable dataTable) {


        //getting values from Datatable as a Key: Value pair in feature file
        List<Map<String,String>> data = dataTable.asMaps(String.class, String.class);

        _SendKeys(PO.Master_Email,data.get(0).get("Phone"));
        _SendKeys(PO.Master_Password,data.get(0).get("Password"));

    }

    @And("User clicks on SUBMIT CTA")
    public void user_clicks_on_submit_cta() {

        _click(PO.Submit);

    }

    @When("User is left with below classes in his account to be completed")
    public void user_is_left_with_below_classes_in_his_account_to_be_completed(DataTable dataTable) throws InterruptedException {

        //Scrolling till Element is visible
        Scrolling_to_element(PO.Share);

        //getting values from Datatable as a Key: Value pair in feature file
        List<Map<String,String>> data = dataTable.asMaps(String.class, String.class);


        //Logic for <=5 classes remaining
        String result;
        if(Integer.parseInt(_get_text(PO.Remaining_Classes)) <=Integer.parseInt(data.get(0).get("ClassesLeft")))
            result = "Less than or equals to "+data.get(0).get("ClassesLeft")+" classes are remaining";
        else
            result = "More than "+data.get(0).get("ClassesLeft")+" classes are remaining";


        Assert.assertEquals("Less than or equals to "+data.get(0).get("ClassesLeft")+" classes are remaining", result);


    }

    @Then("Verify there is an Upgrade Now Card at the top of Home Page")
    public void verify_there_is_an_upgrade_now_card_at_the_top_of_home_page() {

        //Scrolling till Element is visible
        swipeScreen(Direction.DOWN);

        //Asserting Upgrade Card logic
        Assert.assertTrue(_is_displayed(PO.Upgrade_Now_Card));

    }

    @When("User clicks on Upgrade Now Card at the top of Home Page")
    public void user_clicks_on_upgrade_now_card_at_the_top_of_home_page() {

        _click(PO.Upgrade_Now_Card);
    }

    @Then("User is at Upgrade Package Page")
    public void user_is_at_upgrade_package_page() {

        _wait(PO.Page_Title);
        Assert.assertTrue(_is_displayed(PO.Page_Title));

    }

    @When("User taps on Download Curriculum")
    public void user_taps_on_download_curriculum() throws InterruptedException {

        //Scrolling till Download CTA
        Scrolling_to_element(PO.Buy_This_Plan_CTA);

        //Clicking on Download_CTA
        _click(PO.Download_Curriculum_CTA);

    }

    @Then("User is redirected to the mWeb")
    public void user_is_redirected_to_the_m_web() throws InterruptedException {

        _waitAbsence(PO.Download_Curriculum_CTA);

        //Waiting for mWeb to open
        Thread.sleep(2000);

    }

    @When("User navigates back using device back button")
    public void user_navigates_back_using_device_back_button() {

        //Navigating back to app
        _Navigate_BacktoApp();
    }

    @When("User taps on Buy This Plan CTA")
    public void user_taps_on_buy_this_plan_cta() {

        _wait(PO.Download_Curriculum_CTA);
        _click(PO.Buy_This_Plan_CTA);

    }



    //Scenario: 3 #Verifying back button of Curriculum Page

    @When("User clicks on back button of Page")
    public void user_clicks_on_back_button_of_curriculum_page() {

        _click(PO.Page_back_button);

    }

    //Scenario: 4 #Verifying Class Schedule from Dashboard Screen

    @When("There is no Scheduled Class for a user to attend")
    public void there_is_no_scheduled_class_for_a_user_to_attend() {

        //Creating Instance of StudentTitlePage to reuse Cancel methods from that Class
        obj = new HomePage();

        //Logic to Cancel all the Upcoming Class(if any) until there are no classes remaining
        while(!_is_displayed(PO.Schedule_classes_CTA_home)) {

            obj.user_clicks_on_three_dots_button();
            obj.dropdown_should_appear();
            obj.user_selects_cancel_button();
            obj.user_is_at_cancel_screen();
            obj.user_clicks_on_yes_button();
            obj.user_should_be_able_to_successfully_cancel_the_class();

        }

        //Validating No Upcoming class for a user
        _wait(PO.No_Classes_Scheduled_Text);
        Assert.assertTrue(_is_displayed(PO.No_Classes_Scheduled_Text));


    }

    @Then("Verify User can schedule a class from Home Screen")
    public void verify_user_can_schedule_a_class_from_home_screen() throws InterruptedException {

        //Clicking on Schedule Class CTA from Home Page
        _click(PO.Schedule_classes_CTA_home);

       //waiting for Schedule your classes screen
        _wait(PO.Page_Title);

        //Reusing methods from Rescheduling All Class scenario to schedule All the classes
        obj.by_default_three_class_per_week_should_be_shown();
        obj.user_selects_classes_one_by_one();
        obj.user_should_see_the_option_to_select_date_amd_time_based_on_number_of_classes_selected();
        obj.user_selected_all_four_classes_date_and_time();
        obj.user_clicks_on_book_your_slot_cta();
        obj.user_should_be_able_to_successfully_reschedule_all_the_classes();

    }

    //Scenario: 5 #Verifying Unlocked Certificates on Certificate Screen

    @When("User clicks on My Certificates")
    public void user_clicks_on_my_certificates() {

        _click(POP.MyCertificates);

    }

    @Then("User is redirected to My Certificates Screen")
    public void user_is_redirected_to_my_certificates_screen() {

        _wait(POP.MyCertificateScreen);
        Assert.assertTrue(_is_displayed(POP.MyCertificateScreen));

    }

    @Then("Verify Unlocked Certificate can be downloaded")
    public void verify_unlocked_certificate_can_be_downloaded() {

        List<WebElement> EarnedCertificates;

        if(Platform.equalsIgnoreCase("Android"))
            EarnedCertificates = driver.findElements(POP.EarnedCertifcates_Android); //Fetching list of WebElements in Adnroid
        else
            EarnedCertificates = driver.findElements(POP.EarnedCertifcates); //Fetching list of WebElements in iOS


        //Using enhanced for loop to get the elements
        for (WebElement ele : EarnedCertificates)

        {
            //Clicking on each Unlocked Certificates
            ele.click();

            //waiting to redirect to mWeb
            _waitAbsence(POP.MyCertificateScreen);

            //Navigating back to the app from mWeb
            _Navigate_BacktoApp();

            //Asserting if landed on My Certificates Screen
            _wait(POP.MyCertificateScreen);

        }

    }

    //Scenario: 6 #Verifying Locked Certificates on Certificate Screen

    @Then("Verify Locked Certificates should be available Under Upgrade Now Section")
    public void verify_locked_certificates_should_be_available_under_upgrade_now_section() throws InterruptedException {

        //Scrolling till Locked Ceretificates Screen
        Scrolling_to_element(POP.LockedCertifcates);

        //Swiping up to Scroll till end of the screen
        swipeScreen(Direction.UP);

        //Verifying if locked Certificates are visible
        Assert.assertTrue(_get_WebElements_size(POP.LockIcon) > 2);

    }


    @Then("Verify lock icon on all the locked Certificates")
    public void verify_lock_icon_on_all_the_locked_certificates() {

        //Verifying if locked Certificates are visible
        Assert.assertTrue(_get_WebElements_size(POP.LockIcon) > 2);

    }

    //Scenario: 7 #Verifying Upgrade Now CTA on Certificate Screen

    @When("User Clicks on Upgrade Now CTA")
    public void user_clicks_on_update_now() throws InterruptedException {

        //Scrolling till Locked Ceretificates Screen
        Scrolling_to_element(PO.LoginWithOTP_CTA);

        _click(PO.LoginWithOTP_CTA);

    }

    @Then("User is redirected to Upgrade Package Screen")
    public void userIsRedirectedToUpgradePackageScreen() {

        _wait(POP.UpgradePackage_Screen);
        Assert.assertTrue(_is_displayed(POP.UpgradePackage_Screen));

    }
}
