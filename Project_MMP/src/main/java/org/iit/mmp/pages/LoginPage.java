package org.iit.mmp.pages;

import java.util.List;

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

	public void patientUrl() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");

	}

	public void login(String userName, String password) {

		driver.findElement(By.id("username")).sendKeys(userName);

		driver.findElement(By.id("password")).sendKeys(password);

		driver.findElement(By.name("submit")).click();

	}

	public void navigateToModule(String modulename) {

		driver.findElement(By.xpath("//span[contains(text(),'" + modulename + "')]")).click();
	}

	public void viewHistory() {
		driver.findElement(By.xpath("//button[contains(text(),'View History')]")).click();
		driver.findElement(By.xpath("//p//a//input[@value='Past Prescription']")).click();
		List<WebElement> list = driver.findElements(By.xpath("//table//ul//li"));
		for (int i = 0; i < list.size(); i++) {
			// list.get(i).click();
			System.out.println("The Value of " + i + " is :" + list.get(i).getText());

		}

	}

	public void logout() {
		driver.quit();
	}
}
