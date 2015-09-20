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

	}

}
