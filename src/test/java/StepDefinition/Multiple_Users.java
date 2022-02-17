package StepDefinition;

import Base.BaseUtil;
import io.cucumber.java.en.And;
import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class Multiple_Users extends BaseUtil {


    @And("Verify user should be able to select multiple users")
    public void user_selects_each_account() {

        ArrayList<String> alObject = new ArrayList<>();

        List<WebElement> User_Names = driver.findElements(POD.Multiple_Users);

        //Using enhanced for loop to store the a/c names in ArrayList alObject

        for (WebElement ele : User_Names) {
            alObject.add(ele.getText());
        }

        //Fetching list of WebElements


        //Using enhanced for loop to get the elements
        int count = 0;
        for (WebElement ele : User_Names)
        {

            //Clicking on each user
            ele.click();

            //Validate Header on Profile Page
            Assert.assertEquals(alObject.get(count), _get_text(POD.Profile_Heading));

            //Validating if Home Page of Same User is Opened
            _click(PO.Home_Page_tab);
            _wait(PO.Home_Page);

            //Validate Header text on Home Page
            Assert.assertEquals("Welcome "+StringUtils.substringBefore(alObject.get(count), " "), _get_text(PO.Home_Page));
            count++;

            //Navigating back to Profile Page
            _click(PO.profile_tab);
            _wait(PO.Profile_screen);
        }

    }

}
