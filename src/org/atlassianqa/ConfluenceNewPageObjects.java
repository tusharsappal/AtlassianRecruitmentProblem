package org.atlassianqa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfluenceNewPageObjects {

	WebDriver driver;
	public ConfluenceNewPageObjects(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		if (!"Add Page - TestSpace - Confluence".equals(driver.getTitle())) {
			// Alternatively, we could navigate to the login page, perhaps logging out first
			throw new IllegalStateException("This is not the login page");
		}		
	}

	// Grabbing the Blank Page Title Text Field	
	@FindBy(id="content-title")
	private WebElement blankPageTitleTextField;

	// Grabbing the Save Button
	@FindBy(id="rte-button-publish")
	private WebElement saveButton;		

	public boolean createNewPage(String pageTitle) {

		boolean isPageCreated = false;
		blankPageTitleTextField.sendKeys(pageTitle);
		saveButton.click();
		// We will check if we are redirected to the DashBoard
		// This signifies that we have successfully created the Page
		if (!"Dashboard - Confluence".equals(driver.getTitle())) {
			// Alternatively, we could navigate to the login page, perhaps logging out first
			isPageCreated = false;
			throw new IllegalStateException("This is not the login page");
		}
		// Else if we have landed to the Dashboard Page , we have successfully created the Page
		else {
			isPageCreated = true;
		}
		return isPageCreated;
	}

}
