package com.example.webtests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Sample test executed on Sauce Labs
 *
 */
public class SampleSauceAndroidWebTest {
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
    public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.us-west-1.saucelabs.com:443/wd/hub";

    /**
     * Execute a simple test on Sauce Labs
     * @param args
     * @throws MalformedURLException
     */
    public static void main(String[] args) throws MalformedURLException {

        DesiredCapabilities caps = DesiredCapabilities.android();
        caps.setCapability("appiumVersion", "1.9.1");
        caps.setCapability("deviceName","Samsung Galaxy S9 WQHD GoogleAPI Emulator");
        caps.setCapability("deviceOrientation", "portrait");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("platformVersion", "9.0");
        caps.setCapability("platformName","Android");

        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);

        /**
         * Goes to Sauce Lab's guinea-pig page and prints title
         */

        driver.get("https://saucelabs.com/test/guinea-pig");
        System.out.println("title of page is: " + driver.getTitle());

        driver.quit();
    }
}