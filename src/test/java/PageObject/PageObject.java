package PageObject;

import org.openqa.selenium.By;

public class PageObject {


   public By LoginWithPassword = By.xpath("//*[@resource-id='loginWithPassBtn']");

   public By input_email = By.xpath("//*[@resource-id='input_email']/*/android.view.View/android.widget.EditText");

   public By input_password = By.xpath("//*[@resource-id='input_password']/*/android.view.View/android.widget.EditText");

   public By sign_in_btn = By.xpath("//*[@resource-id='sign_in_btn']");

   public By Master_Email = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.widget.EditText");

   public By Master_Password = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.widget.EditText");

   public By Home_Page = By.xpath("//*[@content-desc='welcome_username']");

   public By Home_Page_tab = By.xpath("//*[@content-desc='home']");

   public By profile_tab = By.xpath("//*[@content-desc='Profile']");

   public By Profile_screen = By.xpath("//*[@text='Profile']");

   public By logout_btn = By.xpath("//*[@content-desc='log_out_cta']");

   public By triple_dots = By.xpath("//*[@content-desc='top_view']/following-sibling::*[@index='1']");

   public By Reschedule = By.xpath("//*[@content-desc='reshedule_class']");

   public By Cancel_button = By.xpath("//*[@content-desc='cancel_class']");

   public By Number_of_Classes = By.xpath("//android.widget.HorizontalScrollView/*/*");

   public By Next_Class_Selected = By.xpath("//*[@content-desc='next_class_selected']");

   public By Back_button = By.xpath("//*[@text='Reschedule your Classes']/preceding-sibling::*");

   public By Next_Class_date = By.xpath("//*[starts-with(@text,'Selected Day')]");

   public By Select_date_bottom_sheet = By.xpath("//*[@text='Select Day']");

   public By Select_time_bottom_sheet = By.xpath("//*[@text='Select Time']");

   public By Bottom_Sheet_Elements = By.xpath("//*[starts-with(@text,'Select')]/following-sibling::*/*/*/*");

   public By Next_Class_Time = By.xpath("//*[starts-with(@text,'Selected Time')]");

   public By Class_Per_week_count = By.xpath("//*[starts-with(@text,'Selected')]/parent::*");

   public By Book_Your_Class_CTA = By.xpath("//*[@text='Book Your Slot']");

   public By Toast_Message_Reschedule = By.xpath("//*[starts-with(@text,'Your class has been rescheduled to')]");

   public By Toast_Message_Reschedule_all_class = By.xpath("//*[starts-with(@text,'Your classes have been rescheduled!')]");

   public By Toast_Message_Cancel = By.xpath("//*[ends-with(@text,'has been cancelled!')]");

   public By All_Class = By.xpath("//*[@content-desc='all_class']");

   public By All_Class_Selected = By.xpath("//*[@content-desc='all_class_selected']");

   public By Fourth_class_dropdown = By.xpath("//*[@content-desc='selected_day_4th Class']");

   public By Third_Class_dropdown = By.xpath("//*[@content-desc='selected_day_3rd Class']");

   public By Cancel_Class_Card = By.xpath("//*[@text='Cancel Class']");

   public By Hidden_Menu = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]");

   //public By Toast = By.xpath("//android.widget.Toast[1]");

   public By Submit = By.xpath("//*[@text='SUBMIT']");

   public By No_Cancel_button = By.xpath("//*[@content-desc='cancel_no']");

   public By Yes_Cancel_button = By.xpath("//*[@content-desc='cancel_yes']");
   //*[starts-with(@text,'Are you sure')]/following-sibling::*
   public By Cancel_Reason = By.xpath("//*[starts-with(@content-desc,'cancel_reason_')]");

   public By Book_Free_Trial_CTA = By.xpath("//*[@content-desc='free_trail']");

   public By Curriculum_tab = By.xpath("//*[@content-desc='curriculum']");

   public By Curriculum_Page = By.xpath("//*[@content-desc='completed_classes_selected']");

   public By Completed_Class_Cards = By.xpath("//*[starts-with(@content-desc,'completed_task_')]");

   public By Upcoming_Class_Cards = By.xpath("//*[starts-with(@content-desc,'upcoming_classes_')]");

   public By SESSION_BOOKLET_Link = By.xpath("//*[@text='SESSION BOOKLET']/following-sibling::*/*");

   public By Assignment_Link = By.xpath("//*[@text='ASSIGNMENTS']/following-sibling::*/*");

   public By Curriculum_back_button = By.xpath("//*[@text='PROJECT']/parent::*/parent::*/parent::*/preceding-sibling::*/*");

   public By Upcoming_Class = By.xpath("//*[@content-desc='upcoming_classes']");

   public By Share = By.xpath("//*[@text='Share The Joy']");

   public By Remaining_Classes = By.xpath("//*[@text='Total class']/preceding-sibling::*[@index='2']");

   public By Curriculum_Back_button = By.xpath("//*[@text='Upgrade Package']/preceding-sibling::*");

   public By Upgrade_Now_Card = By.xpath("//*[@text='Upgrade Now']");

   public By Upgrade_Plan_Page = By.xpath("//*[@text='Upgrade Package']");

   public By Buy_This_Plan_CTA = By.xpath("//*[@text='Buy This Plan']");

   public By Download_Curriculum_CTA = By.xpath("//*[@text='Download Curriculum']");

   public By No_Classes_Scheduled_Text = By.xpath("//*[@text=\"You don't have any classes scheduled\"]");

   public By Schedule_classes_CTA_home = By.xpath("//*[@text='Schedule classes']");

   public By Schedule_classes_Home_Page = By.xpath("//*[@text='Schedule your classes']");


}
