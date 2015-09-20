package org.atlassianqa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ConfluenceTests {

	public static void main(String[] args) {
		
		// Initializing the WebDriver 
		WebDriver driver = new FirefoxDriver();
		
		// Navigating to the Login Page
		driver.navigate().to("https://tusharsappal.atlassian.net/");
		
		// Grabbing hold of all the page objects and the service methods provided by the LoginPage
		ConflueneceLoginPageObjects confluenceLogin = new ConflueneceLoginPageObjects(driver);
		
		confluenceLogin.login("sappal.tushar@gmail.com", "Accompany123");

	}

}
