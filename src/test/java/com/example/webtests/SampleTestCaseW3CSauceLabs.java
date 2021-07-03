package com.example.webtests;

import com.example.pages.ExercisePage;
import com.example.pages.LessonPage;
import com.saucelabs.junit.ConcurrentParameterized;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import static org.junit.Assert.assertTrue;

/**
 * Demonstrates how to write a JUnit test that runs tests against Sauce Labs using multiple browsers in parallel.
 */
@RunWith(ConcurrentParameterized.class)
public class SampleTestCaseW3CSauceLabs {
    /**
     * Your Sauce Labs username
     */
    public static final String USERNAME = System.getenv("SAUCE_USERNAME");

    /**
     * Your Sauce Labs access key
     */
    public static final String ACCESS_KEY = System.getenv("SAUCE_ACCESS_KEY");

    /**
     * URL for Sauce Labs
     */
    public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.eu-central-1.saucelabs.com:443/wd/hub";

    /**
     * Represents the browser to be used as part of the test run.
     */
    protected String browserName;
    /**
     * Represents the operating system to be used as part of the test run.
     */
    protected String platformName;
    /**
     * Represents the version of the browser to be used as part of the test run.
     */
    protected String browserVersion;
    /**
     * Instance variable which contains the Sauce Job Id.
     */
    protected String sessionId;

    /**
     * The {@link WebDriver} instance which is used to perform browser interactions with.
     */
    protected WebDriver driver;

    /**
     * The buildName represents the Sauce Labs build name for which tests inside this class shall be run
     */
    public static String buildName = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

    /**
     * storing each test's name as per name of the JUnit Test method name running as part of above build
     */
    @Rule
    public TestName testName = new TestName() {
        public String getMethodName() {
            return String.format("%s", super.getMethodName());
        }
    };

    /**
     * Constructs a new instance of the test.  The constructor requires three string parameters, which represent the operating
     * system, version and browser to be used when launching a Sauce VM.  The order of the parameters should be the same
     * as that of the elements within the {@link #browsersStrings()} method.
     *
     * @param browserName
     * @param browserVersion
     * @param platformName
     */

    public SampleTestCaseW3CSauceLabs(String browserName, String browserVersion, String platformName) {
        super();
        this.browserName = browserName;
        this.browserVersion = browserVersion;
        this.platformName = platformName;
    }

    /**
     * @return a LinkedList containing String arrays representing the browser combinations the test should be run against. The values
     * in the String array are used as part of the invocation of the test constructor
     */
    @ConcurrentParameterized.Parameters
    public static LinkedList<String[]> browsersStrings() {
        LinkedList<String[]> browsers = new LinkedList<String[]>();

        // mac OS Big Sur, Chrome Latest
        browsers.add(new String[]{"chrome", "latest", "macOS 11"});

        // Windows 10, Firefox Latest
        browsers.add(new String[]{"firefox", "latest", "Windows 10"});

        // windows 8.1, IE 11
        browsers.add(new String[]{"internet explorer", "11", "Windows 8.1"});

        return browsers;
    }

    /**
     * Constructs a new {@link RemoteWebDriver} instance which is configured to use the capabilities defined by the {@link #browserName},
     * {@link #browserVersion} and {@link #platformName} instance variables, and which is configured to run against ondemand.saucelabs.com, using
     * the username
     *
     * @throws Exception if an error occurs during the creation of the {@link RemoteWebDriver} instance.
     */
    @Before
    public void setUp() throws Exception {
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("browserName", browserName);
        sauceOptions.setCapability("browserVersion", browserVersion);
        sauceOptions.setCapability("platformName", platformName);
        sauceOptions.setCapability("build",buildName);
        sauceOptions.setCapability("name", testName.getMethodName());
        sauceOptions.setCapability("extendedDebugging ",true);
        sauceOptions.setCapability("capturePerformance",true);
        sauceOptions.setCapability("sauce:options",sauceOptions);
        driver = new RemoteWebDriver(new URL(URL), sauceOptions);

        this.sessionId = (((RemoteWebDriver) driver).getSessionId()).toString();

        String message = String.format("SauceOnDemandSessionID=%1$s", this.sessionId);
        System.out.println(message);
    }

    /**
     * Runs a simple test using page objects
     */
    @Test
    public void testSampleTestCaseSauceLabs() {
        LessonPage lessonPage = new LessonPage(driver, "emphasis");
        ExercisePage exercisePage = lessonPage.getExercise();

        assertTrue(exercisePage.isShowAnswerBtnPresent());

        exercisePage.enterAnswer("The music video for Rihanna's song **American Oxygen** depicts various moments from American history, including the inauguration of Barack Obama.");

        assertTrue(exercisePage.isAnswerCorrect());
    }

    /**
     * Closes the {@link WebDriver} instance
     */
    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
