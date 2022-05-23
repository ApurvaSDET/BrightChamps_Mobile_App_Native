package PageObject;

import Base.BaseUtil;
import org.openqa.selenium.By;

public class PageObjectBCBeans {


    public By Beans_Count = By.xpath("//*[@"+BaseUtil.attributeID+"='beans_count']");

    public By Know_More = By.xpath("//*[@"+BaseUtil.attributeID+"='beans_know_more']");

    public By Expand_icon = By.xpath("//*[@"+BaseUtil.attributeID+"='beans_expand']");

    public By X_Button = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.ImageView");

    public By X_Button_iOS = By.xpath("(//XCUIElementTypeOther[@name='1/1'])[5]/XCUIElementTypeOther[1]/XCUIElementTypeOther");

    public By Activities_Section = By.xpath("//*[starts-with(@"+BaseUtil.attributeText+",'Want to earn more beans?')]");

    public By Your_Beans_Bank = By.xpath("//*[@"+BaseUtil.attributeText+"='Your Beans Bank!']");

    public By Earning_Details = By.xpath("//*[starts-with(@"+BaseUtil.attributeID+",'beans_bank_earning_detail')]/*[1]");

    public By EarnedCardDetailScreen = By.xpath("//*[starts-with(@"+BaseUtil.attributeText+",'Wow! You currently have')]");


}

