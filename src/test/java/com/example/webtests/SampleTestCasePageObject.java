package com.example.webtests;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.example.pages.ExercisePage;
import com.example.pages.LessonPage;

/**
 * Sample Selenium test using page objects
 *
 */
public class SampleTestCasePageObject {
	/**
     * The {@link WebDriver} instance which is used to perform browser interactions with.
     */
	private WebDriver driver;
	 
	/**
	 * Instantiate the {@link WebDriver}
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
	}
	
	/**
     * Runs a simple test using page objects
     */
	@Test
	public void testSampleTestCasePageObject() {
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
