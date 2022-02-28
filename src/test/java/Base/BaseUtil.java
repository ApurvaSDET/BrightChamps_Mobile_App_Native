package Base;

import ADBExecutor.ADBExecutor;
import PageObject.PageObject;
import PageObject.PageObjectDemo;
import PageObject.PageObjectProfile;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pCloudy_APIs.pCloudy_APIs_Utility;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class BaseUtil {


    public static AppiumDriver driver;
    public static Properties Pro;
    public static WebDriverWait wait;
    public static ADBExecutor adbExecutor = new ADBExecutor();
    public static String pCloudy_DeviceFullName;
    public PageObject PO = new PageObject();
    public PageObjectDemo POD = new PageObjectDemo();
    public PageObjectProfile POP = new PageObjectProfile();

    public static String valueForTheGivenKey(String name) {

        File file = new File(System.getProperty("user.dir")+"/src/test/resources/Element_Locators_Properties_file/Android_locator.properties");
        FileInputStream fis;
        try {
            fis = new FileInputStream(file);
            Pro = new Properties();
            Pro.load(fis);
        } catch (Exception e) {
            System.out.println("Error Message is --- " + e.getMessage());
        }

        return Pro.getProperty(name);
    }

    public AppiumDriver getDriver() {
        return this.driver;
    }

    public static boolean isClickable(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void enableGPS() {
        adbExecutor.enableGPSGlobally();
    }


    // Performs swipe from the center of screen
    // @param dir the direction of swipe

    public void swipeScreen(BaseUtil.Direction dir) {

        // Animation default time:
        //  - Android: 300 ms
        //  - iOS: 200 ms

        final int ANIMATION_TIME = 300; // ms

        final int PRESS_TIME = 300; // ms

        int edgeBorder = 20; // better avoid edges
        PointOption pointOptionStart, pointOptionEnd;

        // init screen variables
        Dimension dims = driver.manage().window().getSize();

        // init start point = center of screen
        pointOptionStart = PointOption.point(dims.width / 2, dims.height /4);

        switch (dir) {
            case DOWN: // center of footer
                pointOptionEnd = PointOption.point(dims.width / 2, dims.height - edgeBorder);
                break;
            case UP: // center of header
                pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);
                break;
            case LEFT: // center of left side
                pointOptionEnd = PointOption.point(edgeBorder, dims.height / 2);
                break;
            case RIGHT: // center of right side
                pointOptionEnd = PointOption.point(dims.width - edgeBorder, dims.height / 2);
                break;
            default:
                throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
        }

        // execute swipe using TouchAction
        try {
            new TouchAction(driver)
                    .press(pointOptionStart)
                    // a bit more reliable when we add small wait
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
        } catch (Exception e) {
            System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
            return;
        }

        // always allow swipe action to complete
        try {
            Thread.sleep(ANIMATION_TIME);
        } catch (InterruptedException e) {
            // ignore
        }
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public static void _wait(By value){

        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(value));
        }
        catch (TimeoutException e)
        {
            Assert.fail();
        }

    }

    public static void _waitAbsence(By value){

        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(value));
        }
        catch (TimeoutException e)
        {
            Assert.fail();
        }

    }

    public static void _SendKeys(By value, String text){

        driver.findElement(value).sendKeys(text);

    }

    public static void waitForGivenSec(int i) {
        driver.manage().timeouts().implicitlyWait(i, TimeUnit.SECONDS);
    }


    public static void _click(By value){

        try {
            driver.findElement(value).click();
        }
        catch (NoSuchElementException | StaleElementReferenceException e)
        {
            if(e.getMessage().contains("stale element reference"))
            {
                e.getMessage();
            }
            else
            {
                Assert.fail();
            }

        }

    }
    public static void _clickID(String value){

        driver.findElementByAccessibilityId(value).click();

    }

    public static void _cleartext(By value){

        driver.findElement(value).clear();

    }

    public static String _get_text(By value) {

        String text = null;

        try {
            text = driver.findElement(value).getText();
        }
        catch (NoSuchElementException | StaleElementReferenceException e)
        {
            if(e.getMessage().contains("stale element reference"))
                e.getMessage();

            else
                Assert.fail();
        }

        return text;
    }

    public static boolean _is_displayed(By xpath) {


        try
        {
            return driver.findElement(xpath).isDisplayed();
        }
        catch (NoSuchElementException | StaleElementReferenceException err)
        {
            return err.getMessage().contains("stale element reference");
        }
    }

    public static int _CurrentTimestamp(){

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        String minute = StringUtils.substringBefore(StringUtils.substringAfter(timestamp.toString(), ":"), ":");

        return Integer.parseInt(minute);

    }

    public void Scrolling_to_element(By locator) throws InterruptedException {

        //Timestamp before method execution
        int beforeTime =  _CurrentTimestamp();


        //Scrolling till visibility of the element
        while(!_is_displayed(locator))

        {
            scroll(driver,500, 1150, 500,550);
            if (_CurrentTimestamp() >= beforeTime+2)
                break;

        }

    }


    public void scroll(AppiumDriver driver, int start_x_offset, int start_y_offset, int end_x_offset, int end_y_offset) throws InterruptedException {

        TouchAction t = new TouchAction(driver);

        t.press(PointOption.point(start_x_offset,start_y_offset))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(end_x_offset,end_y_offset)).release().perform();

        Thread.sleep(1000);

    }

    public String _converted_date(String date)

    {

        String New_date_format = null;

        // Creating an empty HashMap
        HashMap<String, String> hash_map = new HashMap();

        // Mapping String values to String keys
        hash_map.put("Jan", "01");
        hash_map.put("Feb", "02");
        hash_map.put("Mar", "03");
        hash_map.put("Apr", "04");
        hash_map.put("May", "05");
        hash_map.put("Jun", "06");
        hash_map.put("Jul", "07");
        hash_map.put("Aug", "08");
        hash_map.put("Sep", "09");
        hash_map.put("Oct", "10");
        hash_map.put("Nov", "11");
        hash_map.put("Dec", "12");

        if(date.contains(","))
        {
            //Seperating month from original date
            String initial_date = StringUtils.substringBefore(date, " ");

            //Converting month into numberic using HashMap
            String converted_month = hash_map.get(initial_date);


            //Seperating Year from original date
            String Year = StringUtils.substringAfter(date, ", ");

            //Seperating DATE from original date
            String DATE = StringUtils.substringBefore(StringUtils.substringAfter(date, " "), ",");

            if (DATE.length() == 1) {
                DATE = "0" + DATE;
            }

            New_date_format = DATE + "-" + converted_month + "-" + Year;


        }

        else {

            //Seperating month from original date
            String initial_date = StringUtils.substringBefore(StringUtils.substringAfter(date, " "), " ");


            //Converting month into numberic using HashMap
            String converted_month =  hash_map.get(initial_date);

            //Seperating Year from original date
            String Year = StringUtils.substringAfter(StringUtils.substringAfter(date, " "), " ");

            //Seperating DATE from original date
            String DATE = StringUtils.substringBefore(date, " ");

            if(DATE.length()==1)
            {
                DATE = "0"+DATE;
            }

            New_date_format = DATE+"-"+converted_month+"-"+Year;


        }

        return New_date_format;
    }


    public static void _random_options_from_dropdown(By locator){

        //Fetching list of WebElements
        List<WebElement> dropdown_menu = driver.findElements(locator);

        //Creating ArrayList and Random instance
        ArrayList<WebElement> al = new ArrayList();
        Random rand = new Random();

        //Using enhanced for loop to get the elements
        for (WebElement ele : dropdown_menu)

        {

            al.add(ele);

        }

        //Clicking on random values from the dropdown
        try {
            al.get(rand.nextInt(dropdown_menu.size())).click();
        }
        catch (ElementClickInterceptedException e)
        {
            try {
                al.get(rand.nextInt(dropdown_menu.size())).click();
            }
            catch (ElementClickInterceptedException err)
            {
                try {
                    al.get(rand.nextInt(dropdown_menu.size())).click();
                }
                catch (ElementClickInterceptedException Er)
                {
                    al.get(rand.nextInt(dropdown_menu.size())).click();
                }
            }
        }

    }

    public static void _Select_random_options_(By locator, int size){

        //Fetching list of WebElements
        List<WebElement> dropdown_menu = driver.findElements(locator);

        //Creating ArrayList and Random instance
        ArrayList<WebElement> al = new ArrayList();
        Random rand = new Random();

        //Using enhanced for loop to get the elements
        for (WebElement ele : dropdown_menu)

        {

            al.add(ele);

        }

        //Clicking on random values from the dropdown
        try {
            al.get(rand.nextInt(size)).click();
        }
        catch (ElementClickInterceptedException e)
        {
            try {
                al.get(rand.nextInt(dropdown_menu.size())).click();
            }
            catch (ElementClickInterceptedException err)
            {
                al.get(rand.nextInt(dropdown_menu.size())).click();
            }
        }

    }

    public static void _selecting_particular_options_from_dropdown(By locator, String value_from_dropdown){

        //Fetching list of WebElements
        List<WebElement> dropdown_menu = driver.findElements(locator);

        //Using enhanced for loop to get the elements
        for (WebElement ele : dropdown_menu) {

            // Here we will verify if link (item) is equal to particular value
            if (ele.getAttribute("text").contains(value_from_dropdown)) {

                // if yes then click on link (item)
                ele.click();

                // break the loop or come out of loop
                break;

            }
        }

    }

    public static int _get_WebElements_size(By value) {

        try {
            return driver.findElements(value).size();
        } catch (NoSuchElementException e) {
            Assert.fail();
            return 0;
        }

    }

    public static int _get_current_time_in_sec(){

        LocalDateTime date = LocalDateTime.now();
        return date.toLocalTime().toSecondOfDay();

    }

    public static void _wait_till_element_available_in_dropdown(By locator, int waitTime){

        //Logic to Wait till elements are available in dropdown
        int Time_after_click = _get_current_time_in_sec();
        while(driver.findElements(locator).isEmpty())
        {
            if(!(Time_after_click+waitTime>=_get_current_time_in_sec())) {
                Assert.fail();
                break;
            }

        }

    }


    public static void _selecting_one_by_one_from_dropdown(By locator){

        //Fetching list of WebElements
        List<WebElement> dropdown_menu = driver.findElements(locator);

        //Using enhanced for loop to get the elements
        for (WebElement ele : dropdown_menu)

        {

            try {
                ele.click();
            }
            catch (StaleElementReferenceException e)
            {
                e.getMessage();
            }

        }


    }


    // function to generate a random string of length n
    public static String getAlphaNumericString(String value, int n)
    {

        String AlphaNumericString= null;

        // chose a Character random from this String
        switch (value) {
            case "Alpha":
                AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                        + "abcdefghijklmnopqrstuvxyz";
                break;

            case "Numeric":
                AlphaNumericString = "987654321";
                break;
        }
        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }

    public void pCLoudy_Device_Full_Name() throws IOException {

        ArrayList<String> DeviceNames = new ArrayList<String>();

        DeviceNames.add("Google_Pixel5_Android_11.0.0_21d59");
        DeviceNames.add("GOOGLE_Pixel6_Android_12.0.0_1c082");
        DeviceNames.add("Google_Pixel2XL_Android_11.0.0_4fd7e");
        DeviceNames.add("Samsung_GalaxyA71_Android_11.0.0_fe4a3");
        DeviceNames.add("Samsung_GalaxyA31_Android_11.0.0_32c0a");
        DeviceNames.add("Oneplus_8_Android_11.0.0_c4689");
        DeviceNames.add("Samsung_GalaxyM12_Android_11.0.0_22a76");
        DeviceNames.add("Samsung_GalaxyF12_Android_11.0.0_53b39");
        DeviceNames.add("Google_Pixel2XL_Android_11.0.0_4fd7e");
        DeviceNames.add("Oneplus_Nord_Android_11.0.0_a1ff3");
        DeviceNames.add("Oneplus_7Pro_Android_10.0.0_b2d65");
        DeviceNames.add("Google_Pixel3_Android_12.0.0_a6091");
        DeviceNames.add("Google_Pixel2_Android_11.0.0_c2579");
        DeviceNames.add("Samsung_GalaxyS8Plus_Android_9.0.0_2e32c");
        DeviceNames.add("Samsung_GalaxyNote8_Android_9.0.0_7db62");
        DeviceNames.add("Samsung_GalaxyS10_Android_9.0.0_01e83");
        DeviceNames.add("Samsung_SamsungGalaxyS9Plus_Android_10.0.0_d332a");
        DeviceNames.add("Oneplus_7_Android_9.0.0_f3b35");
        DeviceNames.add("Oneplus_OnePlus6_Android_10.0.0_1688c");


        //Storing pCloudy Response in a String
        String API_Response = new pCloudy_APIs_Utility()._get_active_device_list();


        // Iterator to iterate the cityNames
        Iterator iterator = DeviceNames.iterator();

        while (iterator.hasNext()) {

            //Storing next Element of AL in String
            String nextDevice = iterator.next().toString();

            if (API_Response.contains(nextDevice)) {
                this.pCloudy_DeviceFullName = nextDevice;
                break;
            }

        }

    }
}
