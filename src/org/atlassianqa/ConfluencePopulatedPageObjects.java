package org.atlassianqa;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfluencePopulatedPageObjects {

	WebDriver driver;

	public ConfluencePopulatedPageObjects(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
		//Since we know on to which page we would be landing , we have hard coded the value here

		String webPageTitle = "Sample Test Page - TestSpace - Confluence";
		if (!webPageTitle.equals(driver.getTitle())) {
			// Alternatively, we could navigate to the login page, perhaps logging out first
			throw new IllegalStateException("This is not the desired Confluence Page");
		}
	}

	// Grabbing The Edit Hyper Link
	@FindBy(id="editPageLink")
	private WebElement editPageLink;

	// Grabbing the Watching Link
	@FindBy(id="watch-content-button")
	private WebElement watchContentButton;

	//Grabbing the ShareContent Link
	@FindBy(id="shareContentLink")
	private WebElement shareContentLink;

	// Grabbing the ActionMenuLink
	@FindBy(id="action-menu-link")
	private WebElement actionMenuLink;

	// Grabbing the Restrictions Link
	@FindBy(id="action-page-permissions-link")
	private WebElement restrctionsLink;

	// Grabbing the NOtification Anchor Link
	@FindBy(id="notifications-anchor")
	private WebElement notificationsLink;


	public void clickEditConfluencePageLink() {
		editPageLink.click();
	}

	public void clickWatchingPageLink() {
		watchContentButton.click();
	}

	public void clickActionMenuLink() {
		actionMenuLink.click();		
	}

	public void clickRestrictionsLink() {

		clickActionMenuLink();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		restrctionsLink.click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);				
	}

	public boolean isEditConfluencerPageButtonVisible() {
		return editPageLink.isDisplayed();
	}

	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public boolean isNotificationIconDisplayed() {
		return notificationsLink.isDisplayed();
	}

}
