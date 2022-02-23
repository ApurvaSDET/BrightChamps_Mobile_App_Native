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

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Hooks extends BaseUtil {

    static ADBExecutor adbExecutor = new ADBExecutor();
    public static String App_ID;

    //@BeforeAll
    public void _get_appID() throws IOException {

        String url = "apurvakushwaha_ty18QO:nKoiDb51xy1h9pQoTjPq";
        String abc = "https://api-cloud.browserstack.com/app-automate/recent_apps";

        String command = "curl -u "+url+" \\\n" +
                "-X GET "+abc;

        Process process = Runtime.getRuntime().exec(command);

        InputStream inputStream = process.getInputStream();

        Scanner s = new Scanner(inputStream).useDelimiter("\\A");
        String result = s.hasNext() ? s.next() : "";

        App_ID = "bs://"+StringUtils.substringBefore(StringUtils.substringAfter(result, "app_id\":\""), "\",");

        System.out.println(App_ID);
    }


    public void App_launch_On_PCloudy() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("pCloudy_Username", "ishu.kush@gmail.com");
        capabilities.setCapability("pCloudy_ApiKey", "rmt4p5cjj8g56wzn9gfys3kj");
        capabilities.setCapability("pCloudy_DurationInMinutes", 60);
        capabilities.setCapability("newCommandTimeout", 600);
        capabilities.setCapability("launchTimeout", 90000);
        capabilities.setCapability("pCloudy_DeviceFullName", "GOOGLE_Pixel2_Android_11.0.0_c2579");
        capabilities.setCapability("platformVersion", "9.0.0");
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
        wait = new WebDriverWait(driver, 10);
    }

    @Before
    public void App_launch_On_BrowserStackCloud() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", "apurvakushwaha_ty18QO");
        caps.setCapability("browserstack.key", "nKoiDb51xy1h9pQoTjPq");

        // Set URL of the application under test
        caps.setCapability("app", "bs://6eedc6bc5db477dee50b16965b784b131ea98d0a");

        // Specify device and os_version for testing
        caps.setCapability("device", "Google Pixel 3");
        caps.setCapability("os_version", "9.0");

        // Set other BrowserStack capabilities
        caps.setCapability("project", "BrightChamps");
        caps.setCapability("build", "BrightChamps_APP-TestBuild-01");
        caps.setCapability("name", "BrightChamps_APP");
        caps.setCapability("browserstack.networkLogs", "true");


        // Initialise the remote AppiumDriver using BrowserStack remote URL
        // and desired capabilities defined above
        URL url = new URL("http://hub.browserstack.com/wd/hub");
        driver = new AppiumDriver(url, caps);
        wait = new WebDriverWait(driver, 20);

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
