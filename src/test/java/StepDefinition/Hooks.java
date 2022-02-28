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

        if(this.pCloudy_DeviceFullName == null) {

                if (new pCloudy_APIs_Utility()._get_active_device_list().contains("full_name\":\"Google_Pixel5_Android_11.0.0_21d59"))
                    this.pCloudy_DeviceFullName = "Google_Pixel5_Android_11.0.0_21d59";

                else if (new pCloudy_APIs_Utility()._get_active_device_list().contains("full_name\":\"GOOGLE_Pixel6_Android_12.0.0_1c082"))
                    this.pCloudy_DeviceFullName = "GOOGLE_Pixel6_Android_12.0.0_1c082";

                else if (new pCloudy_APIs_Utility()._get_active_device_list().contains("full_name\":\"Google_Pixel2XL_Android_11.0.0_4fd7e"))
                    this.pCloudy_DeviceFullName = "Google_Pixel2XL_Android_11.0.0_4fd7e";

                else if (new pCloudy_APIs_Utility()._get_active_device_list().contains("full_name\":\"Samsung_GalaxyA71_Android_11.0.0_fe4a3"))
                    this.pCloudy_DeviceFullName = "Samsung_GalaxyA71_Android_11.0.0_fe4a3";

                else if (new pCloudy_APIs_Utility()._get_active_device_list().contains("full_name\":\"Samsung_GalaxyA31_Android_11.0.0_32c0a"))
                    this.pCloudy_DeviceFullName = "Samsung_GalaxyA31_Android_11.0.0_32c0a";

                else if (new pCloudy_APIs_Utility()._get_active_device_list().contains("full_name\":\"Samsung_GalaxyM12_Android_11.0.0_22a76"))
                    this.pCloudy_DeviceFullName = "Samsung_GalaxyM12_Android_11.0.0_22a76";

                else if (new pCloudy_APIs_Utility()._get_active_device_list().contains("full_name\":\"Samsung_GalaxyF12_Android_11.0.0_53b39"))
                    this.pCloudy_DeviceFullName = "Samsung_GalaxyF12_Android_11.0.0_53b39";

                else if (new pCloudy_APIs_Utility()._get_active_device_list().contains("full_name\":\"Oneplus_8_Android_11.0.0_c4689"))
                    this.pCloudy_DeviceFullName = "Oneplus_8_Android_11.0.0_c4689";

                else if (new pCloudy_APIs_Utility()._get_active_device_list().contains("full_name\":\"Oneplus_Nord_Android_11.0.0_a1ff3"))
                    this.pCloudy_DeviceFullName = "Oneplus_Nord_Android_11.0.0_a1ff3";

                else if (new pCloudy_APIs_Utility()._get_active_device_list().contains("full_name\":\"Oneplus_7Pro_Android_10.0.0_b2d65"))
                    this.pCloudy_DeviceFullName = "Oneplus_7Pro_Android_10.0.0_b2d65";

                else if (new pCloudy_APIs_Utility()._get_active_device_list().contains("full_name\":\"Google_Pixel3_Android_12.0.0_a6091"))
                    this.pCloudy_DeviceFullName = "Google_Pixel3_Android_12.0.0_a6091";

                else if (new pCloudy_APIs_Utility()._get_active_device_list().contains("full_name\":\"Google_Pixel2_Android_11.0.0_c2579"))
                        this.pCloudy_DeviceFullName = "Google_Pixel2_Android_11.0.0_c2579";

                else if (new pCloudy_APIs_Utility()._get_active_device_list().contains("full_name\":\"Samsung_GalaxyS8Plus_Android_9.0.0_2e32c"))
                    this.pCloudy_DeviceFullName = "Samsung_GalaxyS8Plus_Android_9.0.0_2e32c";

                else if (new pCloudy_APIs_Utility()._get_active_device_list().contains("full_name\":\"Samsung_GalaxyNote8_Android_9.0.0_7db62"))
                    this.pCloudy_DeviceFullName = "Samsung_GalaxyNote8_Android_9.0.0_7db62";

                else if (new pCloudy_APIs_Utility()._get_active_device_list().contains("full_name\":\"Samsung_GalaxyS10_Android_9.0.0_01e83"))
                    this.pCloudy_DeviceFullName = "Samsung_GalaxyS10_Android_9.0.0_01e83";

                else if (new pCloudy_APIs_Utility()._get_active_device_list().contains("full_name\":\"Samsung_SamsungGalaxyS9Plus_Android_10.0.0_d332a"))
                    this.pCloudy_DeviceFullName = "Samsung_SamsungGalaxyS9Plus_Android_10.0.0_d332a";

                else if (new pCloudy_APIs_Utility()._get_active_device_list().contains("full_name\":\"Oneplus_7_Android_9.0.0_f3b35"))
                    this.pCloudy_DeviceFullName = "Oneplus_7_Android_9.0.0_f3b35";

                else if (new pCloudy_APIs_Utility()._get_active_device_list().contains("full_name\":\"Oneplus_OnePlus6_Android_10.0.0_1688c"))
                    this.pCloudy_DeviceFullName = "Oneplus_OnePlus6_Android_10.0.0_1688c";

        }

    }

    @Before(order=1)
    public void App_launch_On_PCloudy() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("pCloudy_Username", "apurva.kushwaha@brightchamps.com");
        capabilities.setCapability("pCloudy_ApiKey", "t3652ybnsqzp64g59z7qfqkf");
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
