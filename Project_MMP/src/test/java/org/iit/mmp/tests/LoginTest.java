package org.iit.mmp.tests;

import org.iit.mmp.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LoginTest {
	WebDriver driver;

	@Test(description = "US_001 Validating the Login Page for ViewHistory")
	public void login() {

		// calling Patient login page and its methods
		LoginPage lp = new LoginPage(driver);
		lp.patientUrl();
		lp.login("ria1","Ria12345");
		//lp.login("summer", "Test123@");
		//lp.login("winben", "Test123@");
		lp.navigateToModule("Profile");
		lp.viewHistory();
	}
}
