package com.example.webtests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

/**
 * Sample test executed on Sauce Labs
 *
 */
public class SampleSauceChromeW3CTest {
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
    public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY +  "@ondemand.saucelabs.com:80/wd/hub";

    /**
     * Execute a simple test on Sauce Labs
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("recordVideo", "false");
        sauceOptions.setCapability("recordScreenshots", "false");
        sauceOptions.setCapability("screenResolution", "1280x800");

        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setExperimentalOption("w3c", true);
        browserOptions.setCapability("platformName", "Windows 10");
        browserOptions.setCapability("browserVersion", "91.0");
        browserOptions.setCapability("sauce:options", sauceOptions);

        WebDriver driver = new RemoteWebDriver(new URL(URL), browserOptions);

        /**
         * Goes to Sauce Lab's guinea-pig page and prints title
         */

        driver.get("https://saucelabs.com/test/guinea-pig");
        System.out.println("title of page is: " + driver.getTitle());

        WebElement iAmALink = driver.findElement(By.id("i am a link"));
        iAmALink.click();

        driver.quit();
    }
}