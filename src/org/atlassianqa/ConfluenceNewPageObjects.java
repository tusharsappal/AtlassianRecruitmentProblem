package org.atlassianqa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfluenceNewPageObjects {
	
	public ConfluenceNewPageObjects(WebDriver driver) {

		PageFactory.initElements(driver, this);
		if (!(Configs.getNEWPAGETITLE().equals(driver.getTitle()))) {
			// Alternatively, we could navigate to the login page, perhaps logging out first
			throw new IllegalStateException("This is not the login page");
		}		
	}
	
	// Grabbing the Blank Page Title Text Field	
	@FindBy(id="content-title")
	private WebElement blankPageTitleTextField;
	
	// Grabbing the Page Contents Field
	@FindBy(id="tinymce")
	private WebElement blankPageContentsTextField;
	
	
	public void createNewPage(String pageTitle, String pageContents) {
		
		
	}
	
	
	
	

}
