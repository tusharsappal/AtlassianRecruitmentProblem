package org.atlassianqa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConflueneceHomePageObjects {

	public ConflueneceHomePageObjects(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}
	
}
