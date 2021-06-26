package com.example.tests;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

/**
 * Sample test executed on Sauce Labs
 *
 */
public class SampleSauceTest1 {
    /**
     * Your Sauce Labs username
     */
    public static final String USERNAME = "oauth-sunilsingh4y06-109df";

    /**
     * Your Sauce Labs access key
     */
    public static final String ACCESS_KEY = "7b413e9e-70cb-43a6-9755-c989815b78b3";

    /**
     * URL for Sauce Labs
     */
    public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

    /**
     * Execute a simple test on Sauce Labs
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        ChromeOptions options = new ChromeOptions();
        options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WIN8_1);
        options.setCapability(CapabilityType.BROWSER_VERSION, "75.0");
        WebDriver driver = new RemoteWebDriver(new URL(URL), options);
        /*DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "Windows 7");
        caps.setCapability("version", "43.0");

        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);*/

        /**
         * Goes to Sauce Lab's guinea-pig page and prints title
         */

        driver.get("https://saucelabs.com/test/guinea-pig");
        System.out.println("title of page is: " + driver.getTitle());

        driver.quit();
    }
}
