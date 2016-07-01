package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Represents a lessons page
 *
 */
public class LessonPage extends Page {
	/**
	 * Represents the Start Exercise button
	 */
	private WebElement startExerciseBtn;
	
	/**
	 * Constructor of the class
	 * @param driver The instance of the {@link WebDriver}
	 * @param lesson The lessons represented by this class
	 */
	public LessonPage (WebDriver driver, String lesson) {
		this.driver = driver;
		driver.get(baseUrl + lesson + ".html");
		startExerciseBtn = driver.findElement(By.cssSelector("button.button-primary.button-next"));
	}
	
	/**
	 * Method to get the page exercise
	 * @return Object that represents the page exercise
	 */
	public ExercisePage getExercise() {
		startExerciseBtn.click();
		
		ExercisePage page = new ExercisePage(driver);
		
		PageFactory.initElements(driver, page);
		
		return page;
	}

}
