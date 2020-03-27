package org.iit.mmp.tests;

import java.util.HashMap;
import java.util.Set;

import org.iit.mmp.pages.LoginPage;
import org.iit.mmp.pages.ProfilePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProfileTest {
	WebDriver driver;
	@Test
	
	public void profile() throws InterruptedException{
	
	WebDriverManager.chromedriver().setup();		
	driver = new ChromeDriver();
	
	driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
	
	LoginPage lp =new LoginPage(driver);
	lp.login("ria1","Ria12345");
	Thread.sleep(3000);
	
	ProfilePage pp = new ProfilePage(driver);
	HashMap<String,String> hMap=pp.profile();
	Set<String> keySetValues = hMap.keySet();
	for(String key : keySetValues)
	{
		System.out.println("Key is ::"   + key);
		System.out.println("Value is ::" +hMap.get(key));
	}
	}
}
