package PageObject;

import org.openqa.selenium.By;

public class PageObjectDemo {


    public By Reschedule_demo_CTA = By.xpath("//*[@content-desc='Reschedule Now']");

    public By Reschedule_Reason = By.xpath("//*[@content-desc='select_reason']");

    public By Select_Reason_sheet = By.xpath("//*[@text='Select Reason']");

    public By Demo_Certificate = By.xpath("//*[@content-desc='demo_not_completed_certif_image']");

    public By Locked_icon_on_Demo_Certificate = By.xpath("//*[@content-desc='lock_icon']");

    public By Download_certificate_CTA = By.xpath("//*[@content-desc='button']/*");

    public By Start_Creating = By.xpath("//*[@content-desc='button']/*");

    public By Upgrade_Package_Bottom_Tab = By.xpath("//*[@content-desc='demoCurriculum']");

    public By Contact_Us = By.xpath("//*[@content-desc='contact_us_cta']");

    public By How_To_Join_Card = By.xpath("//*[@content-desc='demo_join_web_info_card']");

    public By Video_Card_Text = By.xpath("//*[@text='Awesome projects by our champs']");

    public By Video_Card_Container = By.xpath("//*[starts-with(@content-desc,'awesome_back_button')]/following-sibling::*/*/*");

    public By X_button_Video_Container = By.xpath("//*[@content-desc='youtube_view_crossClicked']");

    public By Next_Video_button = By.xpath("//*[@content-desc='awseome_right_button_clicked']");

    public By Next_Video_button_disabled = By.xpath("//*[@content-desc='awseome_right_button_disabled']");

    public By Previous_Video_button_disabled = By.xpath("//*[@content-desc='awesome_back_button_disabled']");

    public By Previous_Video_button = By.xpath("//*[@content-desc='awesome_back_button']");

    public By Demo_Completed_Banner = By.xpath("//*[@content-desc='welcome_username']/following-sibling::*/*[starts-with(@text,'Congratulations!')]");

    public By Unlocked_Certificate_text = By.xpath("//*[@text='Hurray!! You unlocked the certificate']");

    public By Multiple_Users = By.xpath("//*[starts-with(@content-desc,'select_user_')]/*[@index='0']");

    public By Profile_Heading = By.xpath("//*[@content-desc='profile_page_username']");

}
