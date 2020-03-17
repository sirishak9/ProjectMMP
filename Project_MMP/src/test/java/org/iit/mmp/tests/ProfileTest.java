package org.iit.mmp.tests;

import org.iit.mmp.pages.LoginPage;
import org.iit.mmp.pages.ProfilePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProfileTest {
	WebDriver driver;
	@Test(description="US_001 Validating the ProfileTab on the Page")
	public void profile() throws Exception {
		WebDriverManager.chromedriver().setup();		
		driver = new ChromeDriver();
		
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		
		LoginPage lp =new LoginPage(driver);
		lp.login("ria1","Ria12345");
		ProfilePage pf = new ProfilePage(driver);
		pf.profileTab();
	}

}
