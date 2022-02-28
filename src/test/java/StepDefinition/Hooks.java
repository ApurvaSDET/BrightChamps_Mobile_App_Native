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
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
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

        if(this.pCloudy_DeviceManafacturerValue == null) {

            if (new pCloudy_APIs_Utility()._get_active_device_list().contains("manufacturer\":\"Google")) {
            this.pCloudy_DeviceManafacturerValue = "Google";
            } else if (new pCloudy_APIs_Utility()._get_active_device_list().contains("manufacturer\":\"Samsung")) {
            this.pCloudy_DeviceManafacturerValue = "Samsung";
            } else if (new pCloudy_APIs_Utility()._get_active_device_list().contains("manufacturer\":\"Motorola")) {
            this.pCloudy_DeviceManafacturerValue = "Motorola";
            }
        }

    }

    @Before(order=1)
    public void App_launch_On_PCloudy() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("pCloudy_Username", "apurva.kushwaha@brightchamps.com");
        capabilities.setCapability("pCloudy_ApiKey", "t3652ybnsqzp64g59z7qfqkf");
        capabilities.setCapability("pCloudy_DurationInMinutes", 60);
        capabilities.setCapability("newCommandTimeout", 600);
        capabilities.setCapability("launchTimeout", 90000);
        capabilities.setCapability("pCloudy_DeviceManafacturer", pCloudy_DeviceManafacturerValue);
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


    public void App_launch() throws MalformedURLException {

        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability("deviceName", adbExecutor.getDeviceInformation("ro.product.model"));
        cap.setCapability("udid", adbExecutor.udid());
        cap.setCapability("platformName", adbExecutor.getDeviceInformation("net.bt.name"));
        cap.setCapability("platformVersion", adbExecutor.getDeviceInformation("ro.build.version.release"));
        cap.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir")+"/src/test/resources/apk/prod/app-arm64-v8a-release.apk");
        cap.setCapability("appPackage","com.brightchamps.learner");
        cap.setCapability("appActivity","com.brightchamps.learner.MainActivity");
        cap.setCapability("autoGrantPermissions", true);
        cap.setCapability("automationName","uiautomator2");
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver(url,cap );
        wait = new WebDriverWait(driver, 30);
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
