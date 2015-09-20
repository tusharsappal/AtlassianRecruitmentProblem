package org.atlassianqa;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.*;

import org.junit.Assert;

public class TestConfluencePageWorkflows {

	@Test
	public void testNewConfluenecePageCreation() {

		// Asigning the default values to the checks
		boolean isNewPageCreated = false;
		boolean isNewPageCreationButtonVisible = false;

		// Initializing the WebDriver 
		WebDriver driver = new FirefoxDriver();

		// Navigating to the Login Page
		driver.navigate().to(Configs.getHOMEPAGEURL());
		
		// Grabbing hold of all the page objects and the service methods provided by the LoginPage
		ConflueneceLoginPageObjects confluenceLogin = new ConflueneceLoginPageObjects(driver);

		confluenceLogin.login(Configs.getUSERNAME(), Configs.getPASSWORD());

		// TODO:- Adding a method to signify that the user is actually logged in the webportal

		/*We are now logged in , we will be checking the Landing Page (Home Page ), title etc to see if 
		 we have landed on the correct page */

		/* We will try to create a page
		 * If the user is able to see the create Button , he/she is authorized to create one
		 * We will be creating a page with the title only and will see if we are successfully redirected
		 * to the DashBoard Page , as all the Page creation workflow end up taking the user on the Dashboard page  
		 */
		
		//Grabbing hold of all the page objects from the Confluence HomePage

		ConflueneceHomePageObjects confluenceHomePage = new ConflueneceHomePageObjects(driver);
		isNewPageCreationButtonVisible = confluenceHomePage.isCreateButtonVisible();
		
		// We will click on the create button only if the Create Button is visible
		
		if (isNewPageCreationButtonVisible == true) {
			
			confluenceHomePage.clickOnCreateButton();
			
			ConfluenceNewPageObjects newPage = new ConfluenceNewPageObjects(driver);
			
			// We are creating a new page with the title and leaving the page contents as blank
			isNewPageCreated = newPage.createNewPage(Configs.getNewPageTitle());

			// Checking if the new page is created or not 
			if (isNewPageCreated == false) {
				Assert.fail("The New Confluenece Page was not created");
			}
		}
		
		else {
			Assert.fail("The Create Button is not visible");
		}
	}

}
