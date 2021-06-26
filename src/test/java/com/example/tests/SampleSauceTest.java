package com.example.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

/**
 * Sample test executed on Sauce Labs
 *
 */
public class SampleSauceTest {
	/**
	 * Your Sauce Labs username
	 */
	public static final String USERNAME = "YOUR_USERNAME";
	
	/**
	 * Your Sauce Labs access key
	 */
	public static final String ACCESS_KEY = "YOUR_ACCESS_KEY";
	
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

		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setCapability("platform", "Windows 7");
		caps.setCapability("version", "43.0");

		WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
		
	    /**
	     * Inserting new code for setting up RemoteWebDriver using ChromeOptions
	     * Since usage of DesiredCapabilities in JAVA is deprecated hence ChromeOptions class can be used to
	     * customize and configure a ChromeDriver session
	     * NOTE: In Browser Version for Chrome use 75.0 or later as these are the supported Browser Version for W3C
	     * 	ChromeOptions options = new ChromeOptions();
             * 	options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WIN8_1);
             * 	options.setCapability(CapabilityType.BROWSER_VERSION, "75.0");
             * 	WebDriver driver = new RemoteWebDriver(new URL(URL), options);
	     */

	    /**
	     * Goes to Sauce Lab's guinea-pig page and prints title
	     */
	
	    driver.get("https://saucelabs.com/test/guinea-pig");
	    System.out.println("title of page is: " + driver.getTitle());
	
	    driver.quit();
	}
}
