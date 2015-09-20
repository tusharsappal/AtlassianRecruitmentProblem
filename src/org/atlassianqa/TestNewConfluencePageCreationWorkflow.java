package org.atlassianqa;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.*;

import org.junit.Assert;

public class TestNewConfluencePageCreationWorkflow {
	
	@Test
	public void testNewConfluenecePageCreation() {
		
		boolean isNewPageCreated = false;
		// Initializing the WebDriver 
		WebDriver driver = new FirefoxDriver();

		// Navigating to the Login Page
		driver.navigate().to(Configs.getHOMEPAGEURL());

		// Grabbing hold of all the page objects and the service methods provided by the LoginPage
		ConflueneceLoginPageObjects confluenceLogin = new ConflueneceLoginPageObjects(driver);

		confluenceLogin.login(Configs.getUSERNAME(), Configs.getPASSWORD());

		/*We are now logged in , we will be checking the Landing Page (Home Page ), title etc to see if 
		 we have landed on the correct page */
		
		// Grabbing hold of all the page objects from the Confluence HomePage
		
		ConflueneceHomePageObjects confluenceHomePage = new ConflueneceHomePageObjects(driver);
		
		/* We will try to create a page
		 * If the user is able to see the create Button , he/she is authorized to create one
		 * The Second check would be to actually verify that the Page has been created , by checking its 
		 * presence in the list of the pages listed  
		 */
		confluenceHomePage.clickOnCreateButton();
		
		ConfluenceNewPageObjects newPage = new ConfluenceNewPageObjects(driver);
		// We are creating a new page with the title and leaving the page contents as blank
		isNewPageCreated = newPage.createNewPage(Configs.getNewPageTitle());
		
		// Checking if the new page is created or not 
		Assert.assertTrue(isNewPageCreated);
		
	}
	
}
