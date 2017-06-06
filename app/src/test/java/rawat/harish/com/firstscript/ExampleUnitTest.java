package rawat.harish.com.firstscript;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    AppiumDriver driver;

    @Before
    public void setUp() {

        DesiredCapabilities caps = new DesiredCapabilities();

        /*
        "deviceName": "bserver77",
  "platformName": "Android",
  "udid": "1115fbb2d80f0b05",
  "version": "6.0.1",
  "appPackage": "de.beit.msg.littleHelper",
  "appActivity": "de.beit.msg.littleHelper.activity.SplashActivity"

         */
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "bserver77");
        caps.setCapability("udid", "1115fbb2d80f0b05");
        caps.setCapability(MobileCapabilityType.BROWSER_NAME, "");
        caps.setCapability(CapabilityType.VERSION, "6.0.1");
        caps.setCapability("appPackage", "de.beit.msg.littleHelper");
        caps.setCapability("appActivity", "de.beit.msg.littleHelper.activity.SplashActivity");
        caps.setCapability("noReset", true);

        try {
            driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps) {
                @Override
                public WebElement scrollTo(String s) {
                    return null;
                }

                @Override
                public WebElement scrollToExact(String s) {
                    return null;
                }
            };

        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void testFirstCalculator() throws InterruptedException {
        //driver.findElement(By.id("permission_allow_button")).click();

        try {
          //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("permission_allow_button")));
            Thread.sleep(10000);
            driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();

        }catch (InterruptedException toex){

        }

        driver.performTouchAction(new TouchAction(driver));

        try {
            Thread.sleep(10000);
            driver.findElement(By.id("user")).sendKeys("lhshopnoro");
            driver.findElement(By.id("password")).sendKeys("Portal4.0");;
            driver.findElement(By.id("button_save")).click();
        }catch (TimeoutException toex){

        }

    }


    @After
    public void End() {
        driver.closeApp();
    }

}