package org.atlassianqa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ConfluencePopulatedPageObjects {
	
	public ConfluencePopulatedPageObjects(WebDriver driver) {

		PageFactory.initElements(driver, this);
		//Since we know on to which page we would be landing , we have hard coded the value here
		
		String webPageTitle = "Sample Test Page - TestSpace - Confluence";
		if (!webPageTitle.equals(driver.getTitle())) {
			// Alternatively, we could navigate to the login page, perhaps logging out first
			throw new IllegalStateException("This is not the desired page");
		}
	}

}
