package org.atlassianqa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConflueneceHomePageObjects {

	public ConflueneceHomePageObjects(WebDriver driver) {

		PageFactory.initElements(driver, this);
		if (!"Dashboard - Confluence".equals(driver.getTitle())) {
			// Alternatively, we could navigate to the login page, perhaps logging out first
			throw new IllegalStateException("This is not the login page");
		}
	}

	// Grabbing the Spaces Menu Hyper Link 
	@FindBy(id="space-menu-link")
	private WebElement spaceMenuLink;

	// Grabbing the People Directory Hyper Link 
	@FindBy(id="people-directory-link")
	private WebElement peopleDirectoryLink;

	// Grabbing the Quick Create Button
	@FindBy(id="quick-create-page-button")
	private WebElement quickCreateButton;
	
	// Grabbing the Notification Anchor
	@FindBy(id="notifications-anchor")
	private WebElement notificationButton;

	public void clickOnCreateButton() {
		quickCreateButton.click();
	}
	
	public boolean isCreateButtonVisible() {
		return quickCreateButton.isDisplayed();
	}
	
	public boolean isNotificationButtonVisisble() {
		return notificationButton.isDisplayed();
	}
}
