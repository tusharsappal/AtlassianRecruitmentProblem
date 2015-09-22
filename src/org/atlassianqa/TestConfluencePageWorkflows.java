package org.atlassianqa;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestConfluencePageWorkflows {

	// This Method will check the new Page Creation Workflow
	@Test
	public void testNewConfluenecePageCreation() {

		// Assigning the default values to the checks
		boolean isNewPageCreated = false;
		boolean isNewPageCreationButtonVisible = false;
		boolean isNotificationButtonVisible = false;

		// Initializing the WebDriver 
		WebDriver driver = new FirefoxDriver();

		// Navigating to the Login Page
		driver.navigate().to(Configs.getHOMEPAGEURL());

		// Grabbing hold of all the page objects and the service methods provided by the LoginPage
		ConflueneceLoginPageObjects confluenceLogin = new ConflueneceLoginPageObjects(driver);

		confluenceLogin.login(Configs.getUSERNAME(), Configs.getPASSWORD());

		/*We are now logged in , we will be checking the Landing Page (Home Page ), title etc to see if 
		 we have landed on the correct page */

		/* We will try to create a page
		 * If the user is able to see the create Button , he/she is authorized to create one
		 * We will be creating a page with the title only and will see if we are successfully redirected
		 * to the DashBoard Page , as all the Page creation workflow end up taking the user on the Dashboard page  
		 */

		//Grabbing hold of all the page objects from the Confluence HomePage

		ConflueneceHomePageObjects confluenceHomePage = new ConflueneceHomePageObjects(driver);
		// We are checking if the user is logged in , he / she will be able to view the Notification Button
		isNotificationButtonVisible = confluenceHomePage.isNotificationButtonVisisble();

		isNewPageCreationButtonVisible = confluenceHomePage.isCreateButtonVisible();

		// We will check if the user is logged in by seeing that the Notification Button is visible
		// if the notification button is visible we will say that the user is logged in 

		if (isNotificationButtonVisible == true) {


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
		else {
			Assert.fail("The User is not Logged in , please make sure that the user is logged in ");
		}


		driver.close();
	}


	// This method will check the restriction workflow
	@Test
	public void testRestrictionsWorkflows() {

		boolean isRestrcitionDialogOptionsVisible = false;
		boolean isNotificationsIconDisplayed = false;

		// Initializing the WebDriver 
		WebDriver driver = new FirefoxDriver();

		// Navigating to the Existing Page URL
		driver.navigate().to(Configs.getExistingPageURL());

		// Grabbing hold of all the page objects and the service methods provided by the LoginPage
		ConflueneceLoginPageObjects confluenceLogin = new ConflueneceLoginPageObjects(driver);

		// Fetching the Credentials from the Config file , we will try logging in 
		confluenceLogin.login(Configs.getUSERNAME(), Configs.getPASSWORD());

		// Grabbing all the Objects of the Existing Page in Conflunece 		
		ConfluencePopulatedPageObjects confPopulated =  new ConfluencePopulatedPageObjects(driver);

		// Checking if the  Notifications link is shown the , user is successfully logged in 

		isNotificationsIconDisplayed= confPopulated.isNotificationIconDisplayed();

		confPopulated.clickRestrictionsLink();

		// Grabbing all the objects on the Restrictions Dialog
		ConfluencePageRestrcitionsObjects confRestrict = new ConfluencePageRestrcitionsObjects(driver);

		isRestrcitionDialogOptionsVisible = confRestrict.isRestrcitionsDialogOptionsVisible();

		if (isNotificationsIconDisplayed == true) {
			if (isRestrcitionDialogOptionsVisible == false) {

				Assert.fail("The Restrcitions Dialog did not opened for this user");
			}
			else
			{
				confRestrict.closeRestrictionDialog();
				// We will verify that we land to the page itself after the restrictions dialog is closed
				// We will be verifying this by verifying the presence of the Edit Button and the Page Title
				confPopulated.isEditConfluencerPageButtonVisible();
				String pageTitleOnRestrictionDialogClosed = confPopulated.getPageTitle();

				if (!pageTitleOnRestrictionDialogClosed.equals(Configs.getExistingPageTitle()))
				{
					Assert.fail("Either the Restrictions Dialog is not closed , or there is an issue navigating to the page");
				}						
			}
		}
		else {
			Assert.fail("The User is not logged in , please make sure that the user is logged in");
		}

		driver.close();

	}

}
