package Tests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public class LoginTest {


    static AppiumBy loginmenu = new AppiumBy.ByAccessibilityId("Login");
    static AppiumBy usernameInputfield = new AppiumBy.ByAccessibilityId("input-email");
    static AppiumBy passwordInputfield = new AppiumBy.ByAccessibilityId("input-password");
    static AppiumBy loginButton = new AppiumBy.ByAccessibilityId("button-LOGIN");

    static By okButton = new By.ById("android:id/button1");


    @Test
    public static void loginFunctionTest() throws InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setPlatformVersion("11.0");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setDeviceName("Emulator");
        options.setAppPackage("com.wdiodemoapp");
        options.setAppActivity("com.wdiodemoapp.MainActivity");

        try {

            AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
            Thread.sleep(2000);
            driver.findElement(loginmenu).click();
            driver.findElement(usernameInputfield).sendKeys("username@gmail.com");
            driver.findElement(passwordInputfield).sendKeys("parola123");
            driver.findElement(loginButton).click();
            driverWait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));

            driver.findElement(okButton).click();
            Thread.sleep(2000);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }



    }
}
