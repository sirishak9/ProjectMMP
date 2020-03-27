package org.iit.mmp.pages;

import java.util.HashMap;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage {
	private WebDriver driver;

	public ProfilePage(WebDriver driver) {
		this.driver = driver;
	}

	public HashMap<String, String> profile() throws InterruptedException {

		Random rd = new Random();
		HashMap<String, String> hMap = new HashMap<String, String>();

		// click the profile menu
		driver.findElement(By.xpath("//span[contains(text(),'Profile')]")).click();

		// title
		driver.findElement(By.className("panel-title"));

		// fname
		WebElement fn = driver.findElement(By.id("fname"));
		fn.sendKeys("FirstName" + (char) (65 + rd.nextInt(26)));
		hMap.put("Fname", fn.getAttribute("Value"));

		// lname
		WebElement ln = driver.findElement(By.id("lname"));
		ln.sendKeys("LastName" + (char) (65 + rd.nextInt(26)));
		hMap.put("Lname", ln.getAttribute("Value"));

		// licence
		WebElement license = driver.findElement(By.id("licn"));
		int lisendvalue = rd.nextInt(999999999);
		license.sendKeys("" + lisendvalue);
		hMap.put("License", license.getAttribute("Value"));

		// ssn
		WebElement sSN = driver.findElement(By.id("ssn"));
		int ssnsendvalue = rd.nextInt(999999999);
		sSN.sendKeys("" + ssnsendvalue);
		hMap.put("SSN", sSN.getAttribute("Value"));

		// Address
		WebElement address = driver.findElement(By.id("addr"));
		address.sendKeys("abcd,Main Street");
		hMap.put("Address", address.getAttribute("Value"));

		// Age
		WebElement age = driver.findElement(By.id("age"));
		int agesendvalue = rd.nextInt(99);
		age.sendKeys("" + agesendvalue);
		hMap.put("Age", age.getAttribute("Value"));

		// weight
		WebElement weight = driver.findElement(By.id("weight"));
		int weightsendvalue = rd.nextInt(99);
		weight.sendKeys("" + weightsendvalue);
		hMap.put("Weight", weight.getAttribute("Value"));

		// height
		WebElement height = driver.findElement(By.id("height"));
		int heightsendvalue = rd.nextInt(99);
		height.sendKeys("" + heightsendvalue);
		hMap.put("Height", height.getAttribute("Value"));

		// City
		WebElement city = driver.findElement(By.id("city"));
		city.sendKeys("Tampa");
		hMap.put("City", city.getAttribute("Value"));

		// Stete
		WebElement state = driver.findElement(By.id("state"));
		state.sendKeys("Florida");
		hMap.put("State", state.getAttribute("Value"));

		// Zipcode
		WebElement zipcode = driver.findElement(By.id("city"));
		int zip = rd.nextInt(99999);
		zipcode.sendKeys("" + zip);
		hMap.put("Zipcode", zipcode.getAttribute("Value"));

		// Edit/SAve Button
		WebElement edit = driver.findElement(By.id("Ebtn"));
		edit.click();
		Thread.sleep(2000);
		
		WebElement save = driver.findElement(By.id("Sbtn"));
		save.click();
		
		driver.switchTo().alert().accept();
		return hMap;


	}

}
