package com.example.mobileapptests;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class SampleSauceAndroidAppTest {

    /**
     * Your Sauce Labs username
     */
    public static final String USERNAME = "singhsunil3012";

    /**
     * Your Sauce Labs access key
     */
    public static final String ACCESS_KEY = "2df60e08-1cd4-4b19-bce2-ecb80182f515";

    /**
     * URL for Sauce Labs
     */
    public static final String SAUCELABS_HUB_URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.us-west-1.saucelabs.com:443/wd/hub";

    /**
     * Execute a simple test on Sauce Labs
     * @param args
     * @throws MalformedURLException
     */
    public static void  main(String[] args) throws MalformedURLException {

        DesiredCapabilities caps = DesiredCapabilities.android();
        caps.setCapability("appiumVersion", "1.9.1");
        caps.setCapability("deviceName","Google Pixel C GoogleAPI Emulator");
        caps.setCapability("deviceOrientation", "portrait");
        //caps.setCapability("browserName", "");
        caps.setCapability("platformVersion","8.1");
        caps.setCapability("platformName","Android");
        caps.setCapability("app", "https://github.com/saucelabs/sample-app-mobile/releases/download/2.3.0/Android.SauceLabs.Mobile.Sample.app.2.3.0.apk?raw=true");
        WebDriver driver = new AndroidDriver<WebElement>( new URL(SAUCELABS_HUB_URL), caps);

        WebElement emailInput = driver.findElement(By.id("fbemail"));
        emailInput.sendKeys("SauceIsAwesome@email.com");
        assertEquals(emailInput.getText(), "SauceIsAwesome@email.com");

        driver.quit();
    }
}
