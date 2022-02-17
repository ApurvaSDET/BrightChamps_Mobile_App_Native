package PageObject;

import org.openqa.selenium.By;

public class PageObjectDemo {


    public By Reschedule_demo_CTA = By.xpath("//*[@text='Reschedule Now']");

    public By Reschedule_Reason = By.xpath("//*[@text='Selected Reason']");

    public By Select_Reason_sheet = By.xpath("//*[@text='Select Reason']");

    public By Validation_Message_Select_Slot = By.xpath("//*[@text='Select class slot!']");

    public By Validation_Message_Select_Reschedule_Reason = By.xpath("//*[@text='Select reschedule reason']");

    public By Demo_Certificate = By.xpath("//*[@text='Talent Discovery Certificate']/preceding-sibling::*[@index='0']");

    public By Locked_icon_on_Demo_Certificate = By.xpath("//*[@text='Talent Discovery Certificate']/preceding-sibling::*[@index='1']");

    public By Download_certificate_CTA = By.xpath("//*[@text='Download Now']");

    public By Upgrade_your_Plan = By.xpath("//*[@text='Upgrade your plan']");

    public By Back_button_demo_Reschedule_screen = By.xpath("//*[@text='Reschedule your Class']/preceding-sibling::*");

    public By Start_Creating = By.xpath("//*[@text='Start Creating']");

    public By Upgrade_Package_Bottom_Tab = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]");

    public By Contact_Us = By.xpath("//*[@content-desc='contact_us_cta']");

    public By How_To_Join_Card = By.xpath("//*[@text='How to Join Class ?']/parent::*");

    public By Video_Card_Text = By.xpath("//*[@text='Awesome projects by our champs']");

    public By Video_Card_Container = By.xpath("//*[@text='Awesome projects by our champs']/following-sibling::*/*[@index='1']");

    public By X_button_Video_Container = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.widget.TextView");

    public By Next_Video_button = By.xpath("//*[@text='Awesome projects by our champs']/following-sibling::*/*[@index='2']");

    //public By Previous_Video_button = By.xpath("//*[@text='Awesome projects by our champs']/following-sibling::*/*[@index='0']");

    public By Demo_Completed_Banner = By.xpath("//*[@content-desc='welcome_username']/following-sibling::*/*[starts-with(@text,'Congratulations!')]");

    public By Unlocked_Certificate_text = By.xpath("//*[@text='Hurray!! You unlocked the certificate']");

    public By Multiple_Users = By.xpath("//*[@text='Time Zone']/preceding-sibling::*[@index='1']/*/*[@index='0']");

    public By Profile_Heading = By.xpath("//*[@text='Time Zone']/preceding-sibling::*[@index='0']/*[@index='1']");

}
