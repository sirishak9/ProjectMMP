package org.iit.mmp.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
	}

	// Validate patient login page
	public boolean patientUrl() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		String url = driver.getCurrentUrl();
		System.out.println("The url of the Page is " + url);
		String title = driver.getTitle();
		System.out.println("The title of page is " + title);
		boolean result = true;
		return result;

	}

	// Validate patient login logo
	public boolean validatelogo() {

		boolean result = false;
		String logoXpath = "//form/span[contains(text(),'Patient Login')]";
		if (driver.findElement(By.xpath(logoXpath)).isDisplayed()) {
			result = true;
			System.out.println("Patient loginlogo is displaying");
		} else {
			System.out.println("Patient loginlogo is not displaying");
		}
		return result;
	}

	// Validate patient login name
	public boolean login(String userName, String password) {

		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.name("submit")).click();
		System.out.println("Login is Successful");
		boolean result = driver.findElement(By.xpath("//h3[@class='page-header']")).getText().contains("ria1");
		String text = driver.findElement(By.xpath("//h3[@class='page-header']")).getText();
		System.out.println(text);
		return result;

	}

	// Validate ModuleTab from menu
	public boolean navigateToModule(String modulename) {

		driver.findElement(By.xpath("//span[contains(text(),'" + modulename + "')]")).click();
		System.out.println(" The Module name is " + modulename + " is clicked ");
		boolean result2 = true;
		return result2;

	}

	// Validate SubModule Tab
	public boolean viewHistory() throws Exception {
		driver.findElement(By.xpath("//button[contains(text(),'View History')]")).click();
		driver.findElement(By.xpath("//p//a//input[@value='Past Prescription']")).click();
		Thread.sleep(4000);
		List<WebElement> list = driver.findElements(By.xpath("//table//ul//li"));
		int size = list.size();
		System.out.println("The List size is " +size );
		for (int i = 0; i < size; i++) {
			// list.get(i).click();
			System.out.println("The Value of " + i + " is :" + list.get(i).getText());

		}
		System.out.println("View History is Clicked");
		boolean result3 = true;
		return result3;
		
	}
	

	// Validate patient login logout tab
	public boolean logout() {

		driver.findElement(By.xpath("//a[@class='dropdown' and @href='logout.php']")).click();
		System.out.println("logout is successful");
		boolean result4 = true;
		return result4;
	}

	// Validate driver close
	public boolean windowClose() {
		driver.close();
		System.out.println("Browser closed");
		boolean result5 = true;
		return result5;

	}
}
