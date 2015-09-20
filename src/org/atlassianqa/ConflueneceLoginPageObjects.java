package org.atlassianqa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConflueneceLoginPageObjects {

	public ConflueneceLoginPageObjects(WebDriver driver) {

		PageFactory.initElements(driver, this);
		// Check that we're on the right page.
		if (!"Atlassian Cloud".equals(driver.getTitle())) {
			// Alternatively, we could navigate to the login page, perhaps logging out first
			throw new IllegalStateException("This is not the login page");
		}
	}

	// Grabbing the UserName Text Field 
	@FindBy(name="username")
	public WebElement userNameTextField;

	// Grabbing the Password Text Field
	@FindBy(name="password")
	public WebElement passwordTextField;

	// Grabbing the Login Button
	@FindBy(id="login")
	public WebElement loginButton;

	public void login (String userName, String password)
	{
		// Using the Grabbed WebElements , we will be logging in
		userNameTextField.sendKeys(userName);
		passwordTextField.sendKeys(password);
		loginButton.click();

	}

}
