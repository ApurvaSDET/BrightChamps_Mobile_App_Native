package PageObject;

import Base.BaseUtil;
import org.openqa.selenium.By;

public class PageObjectDemo {


    public By Reschedule_demo_CTA = By.xpath("//*[@"+BaseUtil.attributeID+"='Reschedule Now']");

    public By Reschedule_Reason = By.xpath("//*[@"+BaseUtil.attributeID+"='select_reason']");

    public By Select_Reason_sheet = By.xpath("//*[@"+BaseUtil.attributeText+"='Select Reason']");

    public By Demo_Certificate = By.xpath("//*[@"+BaseUtil.attributeID+"='demo_not_completed_certif_image']");

    public By Locked_icon_on_Demo_Certificate = By.xpath("//*[@"+BaseUtil.attributeID+"='lock_icon']");

    public By Download_certificate_CTA = By.xpath("//*[@"+BaseUtil.attributeText+"='Download Now']");

    public By Start_Creating = By.xpath("//*[@"+BaseUtil.attributeID+"='button']");

    public By Start_Creating_CTA_Visibility = By.xpath("//*[@"+BaseUtil.attributeText+"='Join our community Facebook']");

    public By Upgrade_Package_Bottom_Tab = By.xpath("//*[@"+BaseUtil.attributeID+"='demoCurriculum']");

    public By Contact_Us = By.xpath("//*[@"+BaseUtil.attributeID+"='contact_us_cta']");

    public By How_To_Join_Card = By.xpath("//*[@"+BaseUtil.attributeID+"='demo_join_web_info_card']");

    public By Video_Card_Text = By.xpath("//*[@"+BaseUtil.attributeText+"='Awesome projects by our champs']");

    public By Video_Card_Container_Android = By.xpath("//*[starts-with(@"+BaseUtil.attributeID+",'awesome_back_button')]/following-sibling::*/*/*");

    public By Video_Card_Container_iOS = By.xpath("//*[starts-with(@name,'awesome_back_button')]/preceding-sibling::*/*/*");

    public By X_button_Video_Container = By.xpath("//*[@"+BaseUtil.attributeID+"='youtube_view_crossClicked']");

    public By Next_Video_button = By.xpath("//*[@"+BaseUtil.attributeID+"='awseome_right_button_clicked']");

    public By Next_Video_button_disabled = By.xpath("//*[@"+BaseUtil.attributeID+"='awseome_right_button_disabled']");

    public By Previous_Video_button_disabled = By.xpath("//*[@"+BaseUtil.attributeID+"='awesome_back_button_disabled']");

    public By Previous_Video_button = By.xpath("//*[@"+BaseUtil.attributeID+"='awesome_back_button']");

    public By Demo_Completed_Banner = By.xpath("//*[@"+BaseUtil.attributeID+"='demo_completed_class_card']");

    public By Unlocked_Certificate_text = By.xpath("//*[@"+BaseUtil.attributeText+"='Hurray!! You unlocked the certificate']");

    public By Multiple_Users = By.xpath("//*[starts-with(@"+BaseUtil.attributeID+",'select_user_')]/*[@index='0']");

    public By Profile_Heading = By.xpath("//*[@"+BaseUtil.attributeID+"='profile_page_username']");

}
