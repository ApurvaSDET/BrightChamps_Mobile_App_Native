package PageObject;

import Base.BaseUtil;
import org.openqa.selenium.By;

public class PageObjectProfile {


    public By Personal_info = By.xpath("//*[@"+BaseUtil.attributeID+"='personal_information_cta']");

    public By Validation_Text = By.xpath("//*[starts-with(@"+BaseUtil.attributeText+",'Please')]");

    public By Invite = By.xpath("//*[@"+BaseUtil.attributeID+"='Invite & Win']");

    public By Book_Free_Trial_Friends_CTA = By.xpath("//*[@"+BaseUtil.attributeID+"='free_trail']");

    public By Share_Link = By.xpath("//*[@"+BaseUtil.attributeText+"='COPY LINK']");

    public By Save_CTA = By.xpath("//*[@"+BaseUtil.attributeID+"='save']");

    public By Page_back_button = By.xpath("//*[@"+BaseUtil.attributeID+"='page_back_button']");

    public By DOB = By.xpath("//*[@"+BaseUtil.attributeID+"='input_date_of_birth']/*");

    public By SET_CTA = By.xpath("//*[@"+BaseUtil.attributeText+"='Set']");

    public By DOB_Bottom_Sheet = By.xpath("//*[@"+BaseUtil.attributeText+"='Select Date of Birth']");

    public By Profile_Sub_Heading = By.xpath("//*[@"+BaseUtil.attributeID+"='profile_page_username']");

    public By Student_Name = By.xpath("//*[@"+BaseUtil.attributeID+"='input_student_name']");

    public By Mother_Name = By.xpath("//*[@"+BaseUtil.attributeID+"='input_mother_name']");

    public By Father_Name = By.xpath("//*[@"+BaseUtil.attributeID+"='input_father_name']");

    public By Father_Phone = By.xpath("//*[@"+BaseUtil.attributeID+"='input_father_phone_number']");

    public By Mother_Phone = By.xpath("//*[@"+BaseUtil.attributeID+"='input_mother_phone_number']");

    public By Father_Email = By.xpath("//*[@"+BaseUtil.attributeID+"='input_father_email_id']");

    public By Mother_Email = By.xpath("//*[@"+BaseUtil.attributeID+"='input_mother_email_id']");

    public By City = By.xpath("//*[@"+BaseUtil.attributeID+"='input_city']");

    public By School_Name = By.xpath("//*[@"+BaseUtil.attributeID+"='input_school_name']");

    public By Grade = By.xpath("//*[@"+BaseUtil.attributeID+"='input_grade']/*");

    public By Gender = By.xpath("//*[@"+BaseUtil.attributeID+"='input_gender']/*");

    public By Hobbies = By.xpath("//*[@"+BaseUtil.attributeText+"='Hobbies']");

    public By Hobbies_Delete = By.xpath("//*[@"+BaseUtil.attributeID+"='profile_edit_cross_icon']");

    public By Hobbies_bottom_sheet = By.xpath("//*[@"+BaseUtil.attributeText+"='Select Hobbies']");

    public By Country = By.xpath("//*[@"+BaseUtil.attributeID+"='input_country']/*");

    public By Grade_bottom_sheet = By.xpath("//*[@"+BaseUtil.attributeText+"='Select Grade']");

    public By Gender_bottom_sheet = By.xpath("//*[@"+BaseUtil.attributeText+"='Select Gender']");

    public By Country_bottom_sheet = By.xpath("//*[@"+BaseUtil.attributeText+"='Select Country']");

    public By DOB_Day_bottom_sheet = By.xpath("//*[@resource-id='com.brightchamps.learner:id/pickerWrapper']/*[@index='0']");

    public By DOB_Month_bottom_sheet = By.xpath("//*[@resource-id='com.brightchamps.learner:id/pickerWrapper']/*[@index='1']");

    public By DOB_Year_bottom_sheet = By.xpath("//*[@resource-id='com.brightchamps.learner:id/pickerWrapper']/*[@index='2']");

    public By DOB_Day_bottom_sheet_iOS = By.xpath("//XCUIElementTypePickerWheel[@index='0']");

    public By DOB_Month_bottom_sheet_iOS = By.xpath("//XCUIElementTypePickerWheel[@index='1']");

    public By DOB_Year_bottom_sheet_iOS = By.xpath("//XCUIElementTypePickerWheel[@index='2']");

    public By Bottom_sheet_values = By.xpath("//*[starts-with(@"+BaseUtil.attributeText+",'Select')]/following-sibling::*/*/*/*/*/*");

    public By Bottom_sheet_values_Android = By.xpath("//*[starts-with(@"+BaseUtil.attributeText+",'Select')]/following-sibling::*/*/*/*/*");

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
