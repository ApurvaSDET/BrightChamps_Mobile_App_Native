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

   public By Profile_screen = By.xpath("//*[@content-desc='Profile']");

   public By logout_btn = By.xpath("//*[@content-desc='log_out_cta']");

   public By triple_dots = By.xpath("//*[@content-desc='reschdule_homepage_option_clicked']");

   public By Reschedule = By.xpath("//*[@content-desc='reshedule_class']");

   public By Cancel_button = By.xpath("//*[@content-desc='cancel_class']");

   public By Number_of_Classes = By.xpath("//*[starts-with(@content-desc,'no_of_classes_')]");

   public By Next_Class_Selected = By.xpath("//*[@content-desc='next_class_selected']");

   public By Next_Class_date = By.xpath("//*[@text='Selected Day']");

   public By Select_date_bottom_sheet = By.xpath("//*[@text='Select Day']");

   public By Select_time_bottom_sheet = By.xpath("//*[@text='Select Time']");

   public By Bottom_Sheet_Elements = By.xpath("//*[starts-with(@content-desc,'select_')]");

   public By Next_Class_Time = By.xpath("//*[@text='Selected Time']");

   public By Class_Per_week_count = By.xpath("//*[starts-with(@content-desc,'selected_')]");

   public By Book_Your_Class_CTA = By.xpath("//*[@text='Book Your Slot']");

   public By Toast_Message = By.xpath("//*[@content-desc='toast']/*[@index='1']");

   public By Native_Toast_Message = By.xpath("//*[@content-desc='toast']/*[@index='0']");

   public By All_Class = By.xpath("//*[@content-desc='all_class']");

   public By All_Class_Selected = By.xpath("//*[@content-desc='all_class_selected']");

   public By Fourth_class_dropdown = By.xpath("//*[@content-desc='selected_day_4th Class']");

   public By Third_Class_dropdown = By.xpath("//*[@content-desc='selected_day_3rd Class']");

   public By Hidden_Menu = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]");

   public By Submit = By.xpath("//*[@text='SUBMIT']");

   public By No_Cancel_button = By.xpath("//*[@content-desc='cancel_no']");

   public By Yes_Cancel_button = By.xpath("//*[@content-desc='cancel_yes']");

   public By Cancel_Reason = By.xpath("//*[starts-with(@content-desc,'cancel_reason_')]");

   public By Book_Free_Trial_CTA = By.xpath("//*[@content-desc='free_trail']");

   public By Curriculum_tab = By.xpath("//*[@content-desc='curriculum']");

   public By Completed_Class_Cards = By.xpath("//*[starts-with(@content-desc,'completed_task_')]");

   public By Upcoming_Class_Cards = By.xpath("//*[starts-with(@content-desc,'upcoming_classes_')]");

   public By SESSION_BOOKLET_Link = By.xpath("//*[@content-desc='session_booklet']");

   public By Assignment_Link = By.xpath("//*[@content-desc='assignment']");

   public By Upcoming_Class = By.xpath("//*[@content-desc='upcoming_classes']");

   public By Share = By.xpath("//*[@text='Share The Joy']");

   public By Page_Title = By.xpath("//*[@content-desc='page_title']/*");

   public By Page_back_button = By.xpath("//*[@content-desc='page_back_button']");

   public By Remaining_Classes = By.xpath("//*[starts-with(@content-desc,'paid_class_summary_Remaining_')]");

   public By Upgrade_Now_Card = By.xpath("//*[@content-desc='upgrade_now_clicked']");

   public By Upgrade_Plan_Page = By.xpath("//*[@content-desc='Upgrade Package']");

   public By Buy_This_Plan_CTA = By.xpath("//*[@content-desc='Buy This Plan_clicked']");

   public By Download_Curriculum_CTA = By.xpath("//*[@content-desc='Download Curriculum_clicked']");

   public By No_Classes_Scheduled_Text = By.xpath("//*[starts-with(@content-desc,'next_class_error_info_')]");

   public By Schedule_classes_CTA_home = By.xpath("//*[@content-desc='paid_schedule_now_clicked']");

   public By Schedule_classes_Home_Page = By.xpath("//*[@content-desc='Schedule your classes']");


}
