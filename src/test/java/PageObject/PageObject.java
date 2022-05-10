package PageObject;

import Base.BaseUtil;
import org.openqa.selenium.By;

public class PageObject {

   public By LoginWithPassword = By.xpath("//*[@"+BaseUtil.attributeID+"='loginType_phoneNum_selected']");

   public By LoginWithOTP_CTA = By.xpath("//*[@"+BaseUtil.attributeID+"='button']");

   public By input_email = By.xpath("//*[@"+BaseUtil.attributeText+"='Enter Email Id']");

   public By input_password = By.xpath("//*[@"+BaseUtil.attributeText+"='Enter Password']");

   public By Enter_Mobile_No = By.xpath("//*[@"+BaseUtil.attributeID+"='country_code']/following-sibling::*");

   public By Enter_Mobile_No_iOS = By.xpath("//*[@"+BaseUtil.attributeID+"='country_code']/following-sibling::*/*");

   public By Verify_OTP_CTA = By.xpath("//*[@"+BaseUtil.attributeID+"='verify_otp']");

   public By Resend_OTP = By.xpath("//*[@"+BaseUtil.attributeID+"='resend_otp']");

   public By Enter_OTP = By.xpath("//*[starts-with(@"+BaseUtil.attributeText+",'Otp has been sent to this mobile number')]/following-sibling::*");

   public By sign_in_btn = By.xpath("//*[@"+BaseUtil.attributeID+"='button'][2]");

   public By forgot_password = By.xpath("//*[@"+BaseUtil.attributeID+"='button']");

   public By Reset_CTA = By.xpath("//*[@"+BaseUtil.attributeID+"='reset_password']");

   public By Book_Free_Trial_Class_Bottom_Sheet = By.xpath("//*[@"+BaseUtil.attributeText+"='Begin Your First Class Today']/following-sibling::*[@"+BaseUtil.attributeID+"='button']");

   public By Book_Free_Trial_Class_Now_CTA = By.xpath("//*[@"+BaseUtil.attributeID+"='book_free_trial_class']");

   public By Unregistered_bottom_sheet = By.xpath("//*[@"+BaseUtil.attributeText+"='User is not registered! No Worries!']");

   public By Master_Email = By.xpath("//*[@"+BaseUtil.attributeText+"='Enter Mobile Number']");

   public By Master_Password = By.xpath("//*[@"+BaseUtil.attributeText+"='Enter Password']");

   public By Home_Page = By.xpath("//*[@"+BaseUtil.attributeID+"='welcome_username']");

   public By Home_Page_tab = By.xpath("//*[@"+BaseUtil.attributeID+"='home']");

   public By profile_tab = By.xpath("//*[@"+BaseUtil.attributeID+"='Profile']");

   public By logout_btn = By.xpath("//*[@"+BaseUtil.attributeID+"='log_out_cta']");

   public By triple_dots = By.xpath("//*[@"+BaseUtil.attributeID+"='reschdule_homepage_option_clicked']");

   public By Reschedule = By.xpath("//*[@"+BaseUtil.attributeID+"='reshedule_class']");

   public By Cancel_button = By.xpath("//*[@"+BaseUtil.attributeID+"='cancel_class']");

   public By Number_of_Classes = By.xpath("//*[starts-with(@"+BaseUtil.attributeID+",'no_of_classes_')]");

   public By Next_Class_Selected = By.xpath("//*[@"+BaseUtil.attributeID+"='next_class_selected']");

   public By Next_Class_date = By.xpath("//*[@"+BaseUtil.attributeID+"='select_day']");

   public By Select_date_bottom_sheet = By.xpath("//*[@"+BaseUtil.attributeText+"='Select Day']");

   public By Select_time_bottom_sheet = By.xpath("//*[@"+BaseUtil.attributeText+"='Select Time']");

   public By Bottom_Sheet_Elements = By.xpath("//*[starts-with(@"+BaseUtil.attributeText+",'Select')]/parent::*/following-sibling::*/*/*/*/*[starts-with(@"+BaseUtil.attributeID+",'select_')]");

   public By Bottom_Sheet_Elements_Android = By.xpath("//*[starts-with(@"+BaseUtil.attributeID+",'select_')]");

   public By Bottom_Sheet_Elements_day = By.xpath("//*[starts-with(@"+BaseUtil.attributeID+",'select_day_')]");

   public By Bottom_Sheet_Elements_time = By.xpath("//*[starts-with(@"+BaseUtil.attributeID+",'select_slot_')]");

   public By Bottom_Sheet_Elements_reason = By.xpath("//*[starts-with(@"+BaseUtil.attributeID+",'select_reason_')]");

   public By Next_Class_Time = By.xpath("//*[@"+BaseUtil.attributeID+"='select_slot']");

   public By Class_Per_week_count = By.xpath("//*[starts-with(@"+BaseUtil.attributeID+",'select_')]");

   public By Book_Your_Class_CTA = By.xpath("//*[@"+BaseUtil.attributeID+"='button']");

   public By Toast_Message = By.xpath("//*[@"+BaseUtil.attributeID+"='toast']/*[@index='1']");

   public By Native_Toast_Message = By.xpath("//*[@"+BaseUtil.attributeID+"='toast']/*[@index='0']");

   public By All_Class = By.xpath("//*[@"+BaseUtil.attributeID+"='all_class']");

   public By All_Class_Selected = By.xpath("//*[@"+BaseUtil.attributeID+"='all_class_selected']");

   public By Fourth_class_dropdown = By.xpath("//*[@"+BaseUtil.attributeID+"='select_day'][4]");

   public By Third_Class_dropdown = By.xpath("//*[@"+BaseUtil.attributeID+"='select_day'][3]");

   public By Fourth_class_dropdown_ios = By.xpath("//*[@"+BaseUtil.attributeID+"='4th Class']");

   public By Third_Class_dropdown_ios = By.xpath("//*[@"+BaseUtil.attributeID+"='3rd Class']");

   public By Hidden_Menu = By.xpath("//*[@"+BaseUtil.attributeID+"='hidden_menu']");

   public By Submit = By.xpath("//*[@"+BaseUtil.attributeText+"='Login']");

   public By No_Cancel_button = By.xpath("//*[@"+BaseUtil.attributeID+"='cancel_no']");

   public By Yes_Cancel_button = By.xpath("//*[@"+BaseUtil.attributeID+"='cancel_yes']");

   public By Cancel_Reason = By.xpath("//*[starts-with(@"+BaseUtil.attributeID+",'cancel_reason_')]");

   public By Know_More_CTA = By.xpath("//*[@"+BaseUtil.attributeText+"='Share The Joy']/following-sibling::*");

   public By Referral_Card_Android = By.xpath("//*[@text='Whats More?']/preceding-sibling::*/android.widget.ImageView");

   public By Referral_Card_iOS = By.xpath("//*[@name='How its Work? Leaderboard']/following-sibling::*/*");

   public By Leaderboard_link = By.xpath("//*[@"+BaseUtil.attributeText+"='Leaderboard']");

   public By Leaderboard_Page = By.xpath("//*[@"+BaseUtil.attributeText+"='You have referred']");

   public By Book_Free_Trial_CTA = By.xpath("//*[@"+BaseUtil.attributeID+"='free_trail']");

   public By Curriculum_tab = By.xpath("//*[@"+BaseUtil.attributeID+"='curriculum']");

   public By Completed_Class_Cards = By.xpath("//*[starts-with(@"+BaseUtil.attributeID+",'completed_task_')]");

   public By Upcoming_Class_Cards = By.xpath("//*[starts-with(@"+BaseUtil.attributeID+",'upcoming_classes_')]");

   public By SESSION_BOOKLET_Link = By.xpath("//*[@"+BaseUtil.attributeID+"='session_booklet']");

   public By Assignment_Link = By.xpath("//*[@"+BaseUtil.attributeID+"='assignment']");

   public By Upcoming_Class = By.xpath("//*[@"+BaseUtil.attributeID+"='upcoming_classes']");

   public By Share = By.xpath("//*[@"+BaseUtil.attributeText+"='Share The Joy']");

   public By Page_Title = By.xpath("//*[@"+BaseUtil.attributeID+"='page_title']/*");

   public By Page_back_button = By.xpath("//*[@"+BaseUtil.attributeID+"='page_back_button']");

   public By Remaining_Classes = By.xpath("//*[starts-with(@"+BaseUtil.attributeID+",'paid_class_summary_Remaining_')]");

   public By Upgrade_Now_Card = By.xpath("//*[@"+BaseUtil.attributeID+"='upgrade_now_clicked']");

   public By Buy_This_Plan_CTA = By.xpath("//*[@"+BaseUtil.attributeID+"='Buy This Plan_clicked']");

   public By Download_Curriculum_CTA = By.xpath("//*[@"+BaseUtil.attributeID+"='Download Curriculum_clicked']");

   public By No_Classes_Scheduled_Text = By.xpath("//*[starts-with(@"+BaseUtil.attributeID+",'next_class_error_info_')]");

   public By Schedule_classes_CTA_home = By.xpath("//*[@"+BaseUtil.attributeID+"='paid_schedule_now_clicked']");


}
