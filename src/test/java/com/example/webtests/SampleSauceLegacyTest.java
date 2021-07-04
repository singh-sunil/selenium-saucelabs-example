package com.example.webtests;

import com.example.config.SauceConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Sample test executed on Sauce Labs
 *
 */
public class SampleSauceLegacyTest {
	/**
	 * Your Sauce Labs username
	 */
	public static final String USERNAME = SauceConfig.USERNAME;
	
	/**
	 * Your Sauce Labs access key
	 */
	public static final String ACCESS_KEY = SauceConfig.ACCESS_KEY;
	
	/**
	 * URL for Sauce Labs
	 */
	public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + SauceConfig.DATA_CENTER_US_WEST_PLUS_HUB_ENDPOINT;

	/**
	 * Execute a simple test on Sauce Labs
	 * @param args
	 * @throws MalformedURLException
	 */
	public static void main(String[] args) throws MalformedURLException {

		DesiredCapabilities caps = DesiredCapabilities.chrome();
		//caps.setCapability("platform", "macOS 10.15");
		//caps.setCapability("version", "91.0");
		//caps.setCapability("platform", "OS X 10.11");
		//caps.setCapability("version", "54.0");
		caps.setCapability("platform", "Windows 10");
		caps.setCapability("version", "latest");
		caps.setCapability("recordVideo", "true");
		caps.setCapability("recordScreenshots", "false");
		caps.setCapability("screenResolution", "1280x800");

		WebDriver driver = new RemoteWebDriver(new URL(URL), caps);

	    /**
	     * Goes to Sauce Lab's guinea-pig page and prints title
	     */
	
	    driver.get("https://saucelabs.com/test/guinea-pig");
	    System.out.println("title of page is: " + driver.getTitle());
	
	    driver.quit();
	}
}
