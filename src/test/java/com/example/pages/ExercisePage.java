package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Represents a lessons page
 *
 */
public class ExercisePage extends Page {
	@FindBy(id="editor_1-1")
	private WebElement textBox;
	
	@FindBy(id="btn_answer_1-1")
	private WebElement showAnswerBtn;
	
	/**
	 * Constructor of the class
	 * @param driver The instance of the {@link WebDriver}
	 */
	public ExercisePage (WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * Checks if the show answer button is present in the page
	 * @return true if is present, false otherwise
	 */
	public boolean isShowAnswerBtnPresent() {
		return isElementPresent(By.id("btn_answer_1-1"));
	}
	
	/**
	 * Checks if the correct answer popup is present in the page
	 * @return true if is present, false otherwise
	 */
	public boolean isAnswerCorrect() {
		return isElementPresent(By.xpath("//body/div[5]"));
	}

	/**
	 * Enters an answer in the corresponding text box
	 * @param text The answer to enter
	 */
	public void enterAnswer(String text) {
		textBox.clear();
		textBox.sendKeys(text);
	}
}
