package StepDefinition;


import ADBExecutor.ADBExecutor;
import Base.BaseUtil;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.lang.StringUtils;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pCloudy_APIs.pCloudy_APIs_Utility;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Hooks extends BaseUtil {

    @Before(order=0)
    public void _get_appID() throws IOException {

        if(this.pCloudy_DeviceFullName == null) {
            //Initializing Static String Variable by Calling method in BaseUtil
            pCLoudy_Device_Full_Name();
        }

    }

    @Before(order=1)
    public void App_launch_On_PCloudy() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("pCloudy_Username", System.getenv("pCloudy_Username"));
        capabilities.setCapability("pCloudy_ApiKey", System.getenv("pCloudy_ApiKey"));
        capabilities.setCapability("pCloudy_DurationInMinutes", 60);
        capabilities.setCapability("newCommandTimeout", 120);
        capabilities.setCapability("launchTimeout", 600);
        capabilities.setCapability("pCloudy_DeviceFullName", pCloudy_DeviceFullName);
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "uiautomator2");
        capabilities.setCapability("pCloudy_ApplicationName", "app-arm64-v8a-release.apk");
        capabilities.setCapability("appPackage", "com.brightchamps.learner");
        capabilities.setCapability("appActivity", "com.brightchamps.learner.MainActivity");
        capabilities.setCapability("pCloudy_WildNet", "true");
        capabilities.setCapability("pCloudy_EnableVideo", "true");
        capabilities.setCapability("pCloudy_EnablePerformanceData", "true");
        capabilities.setCapability("pCloudy_EnableDeviceLogs", "true");

        // Initialise the remote AppiumDriver using BrowserStack remote URL
        // and desired capabilities defined above

        URL url = new URL("https://device.pcloudy.com/appiumcloud/wd/hub");
        driver = new AppiumDriver(url, capabilities);
        wait = new WebDriverWait(driver, 15);
    }

    //@Before
    public void App_launch() throws MalformedURLException, InterruptedException {

        //Creating DesiredCapabilities object
        DesiredCapabilities cap = new DesiredCapabilities();

        //Putting Condition for launching either on Android or iOS
        if (Platform.equalsIgnoreCase("Android"))

            {
                cap.setCapability("deviceName", adbExecutor.getDeviceInformation("ro.product.model"));
                cap.setCapability("udid", adbExecutor.udid());
                cap.setCapability("platformName", adbExecutor.getDeviceInformation("net.bt.name"));
                cap.setCapability("platformVersion", adbExecutor.getDeviceInformation("ro.build.version.release"));
                cap.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "/src/test/resources/apk/prod/app-arm64-v8a-release.apk");
                cap.setCapability("appPackage", "com.brightchamps.learner");
                cap.setCapability("appActivity", "com.brightchamps.learner.MainActivity");
                cap.setCapability("autoGrantPermissions", true);
                cap.setCapability("automationName", "uiautomator2");

            }

        //Putting Condition for launching either on Android or iOS
        if (Platform.equalsIgnoreCase("iOS"))

            {
                cap.setCapability("platformName", "iOS");
                cap.setCapability("platformVersion", "15.3.1");
                cap.setCapability("deviceName", "iPhone12 Mini");
                cap.setCapability("resetOnSessionStartOnly", true);
                cap.setCapability("automationName", "XCUITest");
                cap.setCapability("bundleId", "com.brightchamps.learner.ios");
                //cap.setCapability("app", "/Users/apurvakushwaha/Desktop/Learner.ipa");
                cap.setCapability("udid", "00008101-000C50863A91001E");
                cap.setCapability("wdaStartupRetries", "4");
                cap.setCapability("iosInstallPause","8000" );
                cap.setCapability("wdaStartupRetryInterval", "20000");
            }


        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver(url,cap );
        wait = new WebDriverWait(driver, 30);

        //Handling Notificiation Alert in iOS
        //if (Platform.equalsIgnoreCase("iOS"))
            //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@name='Allow']"))).click();

    }

    @After
    public void TearDownTest(Scenario scenario) throws InterruptedException {
        if (scenario.isFailed()) {
            //Take a screenshot after waiting for a sec...
            Thread.sleep(1000);
            final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");

        }

        if (driver != null)
            driver.quit();

    }

}
