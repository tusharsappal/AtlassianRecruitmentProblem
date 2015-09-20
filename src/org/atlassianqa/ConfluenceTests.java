package org.atlassianqa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.atlassianqa.Configs;

public class ConfluenceTests {

	public static void main(String[] args) {

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

	}

}
