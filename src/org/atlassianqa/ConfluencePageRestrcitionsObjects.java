package org.atlassianqa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfluencePageRestrcitionsObjects {

	public ConfluencePageRestrcitionsObjects(WebDriver driver) {	

		PageFactory.initElements(driver, this);
		//Since we know on to which page we would be landing , we have hard coded the value here
	}
	
	// Grabbing the Restrictions DropDown Element
	@FindBy(className="restrictions-dialog-option")
	private WebElement restrictionsDialogOptions;
	
	@FindBy(id="page-restrictions-dialog-close-button")
	private WebElement pageRestrcitionsCloseButton;
	
	
	public boolean isRestrcitionsDialogOptionsVisible() {
		return restrictionsDialogOptions.isDisplayed();
	}
	
	public void closeRestrictionDialog() {		
		pageRestrcitionsCloseButton.click();
	}
}


