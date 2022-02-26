package PageObject;

import Base.BaseUtil;
import org.openqa.selenium.By;

public class PageObjectProfile {


    public By Personal_info = By.xpath("//*[@content-desc='personal_information_cta']");

    public By Validation_Text = By.xpath("//*[starts-with(@text,'Please')]");

    public By Refer_Friend = By.xpath("//*[@content-desc='refer_a_friend_cta']");

    public By Book_Free_Trial_Friends_CTA = By.xpath("//*[@content-desc='free_trail']");

    public By Share_Link = By.xpath("//*[@text='SHARE LINK']");

    public By Save_CTA = By.xpath("//*[@text='Save']");

    public By Page_back_button = By.xpath("//*[@content-desc='page_back_button']");

    public By DOB = By.xpath("//*[@text='Date of Birth']/following-sibling::*");

    public By SET_CTA = By.xpath("//*[@text='Set']");

    public By DOB_Bottom_Sheet = By.xpath("//*[@text='Select Date of Birth']");

    public By Profile_Sub_Heading = By.xpath("//*[@content-desc='profile_page_username']");

    public By Student_Name = By.xpath("//*[@text='Student Name']/following-sibling::*");

    public By Mother_Name = By.xpath("//*[@text='Mother Name']/following-sibling::*");

    public By Father_Name = By.xpath("//*[@text='Father Name']/following-sibling::*");

    public By Father_Phone = By.xpath("//*[@text=\"Father's Phone No\"]/following-sibling::*");

    public By Mother_Phone = By.xpath("//*[@text=\"Mother's Phone No\"]/following-sibling::*");

    public By Father_Email = By.xpath("//*[@text=\"Father's Email ID\"]/following-sibling::*");

    public By Mother_Email = By.xpath("//*[@text=\"Mother's Email ID\"]/following-sibling::*");

    public By City = By.xpath("//*[@text='City']/following-sibling::*");

    public By School_Name = By.xpath("//*[@text='School Name']/following-sibling::*");

    public By Grade = By.xpath("//*[@text='Grade']/following-sibling::*");

    public By Gender = By.xpath("//*[@text='Gender']/following-sibling::*");

    public By Hobbies = By.xpath("//*[@text='Hobbies']/following-sibling::*");

    public By Hobbies_Delete = By.xpath("//*[@text='Hobbies']/parent::*/*/*/*");

    public By Hobbies_bottom_sheet = By.xpath("//*[@text='Select Hobbies']");

    public By Country = By.xpath("//*[@text='Country']/following-sibling::*");

    public By Grade_bottom_sheet = By.xpath("//*[@text='Select Grade']");

    public By Gender_bottom_sheet = By.xpath("//*[@text='Select Gender']");

    public By Country_bottom_sheet = By.xpath("//*[@text='Select Country']");

    public By DOB_Day_bottom_sheet = By.xpath("//*[@resource-id='com.brightchamps.learner:id/pickerWrapper']/*[@index='0']");

    public By DOB_Month_bottom_sheet = By.xpath("//*[@resource-id='com.brightchamps.learner:id/pickerWrapper']/*[@index='1']");

    public By DOB_Year_bottom_sheet = By.xpath("//*[@resource-id='com.brightchamps.learner:id/pickerWrapper']/*[@index='2']");

    public By Hobbies_bottom_sheet_values = By.xpath("//*[@text='Select Hobbies']/following-sibling::*/*/*/*");

    public By Grade_bottom_sheet_values = By.xpath("//*[@text='Select Grade']/following-sibling::*/*/*/*");

    public By Gender_bottom_sheet_values = By.xpath("//*[@text='Select Gender']/following-sibling::*/*/*/*");

    public By Country_bottom_sheet_values = By.xpath("//*[@text='Select Country']/following-sibling::*/*/*/*/*");


    //Method to Save and navigate back to Profile screen then Navigating back to Profile Details screen to fetch Updated APIs
    public void Save_back_forth() {

        //Navigating back to Profile screen
        BaseUtil._click(this.Page_back_button);
        BaseUtil._wait(this.Personal_info);

        //Navigating to Profile Details Screen and Scrolling till Hobbies section
        BaseUtil._click(this.Personal_info);
        BaseUtil._wait(this.Save_CTA);

    }

}
