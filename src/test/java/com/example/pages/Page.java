package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

/**
 * Abstract class with common fields and methods
 *
 */
public abstract class Page {
	/**
     * The {@link WebDriver} instance which is used to perform browser interactions with.
     */
	protected WebDriver driver;
	
	/**
	 * The base URL of the page to test
	 */
    protected final String baseUrl = "http://eherrera.net/markdowntutorial/tutorial/";
    
    /**
     * Checks if an element is present in the page
     * @param by To locate the element
     * @return true if is present, false otherwise
     */
    protected boolean isElementPresent(By by) {
    	boolean present = true;
        try {
        	driver.findElement(by);
        } catch (NoSuchElementException e) {
        	present = false;
        }
        
        return present;
	}

}
