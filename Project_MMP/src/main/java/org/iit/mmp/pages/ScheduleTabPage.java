package org.iit.mmp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ScheduleTabPage {
	WebDriver driver;
	public ScheduleTabPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public void profileTab() throws Exception {
		
	
	driver.findElement(By.xpath("//span[contains(text(),'Schedule Appointment')]")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("//input[@type='submit']")).click();
    Thread.sleep(5000);
   
    driver.findElement(By.xpath("//h4[contains(text(),'Dr.Beth')]//ancestor::ul/following-sibling::button")).click();
    System.out.println(driver.getTitle());
    WebElement frameEle = driver.findElement(By.id("myframe"));
    driver.switchTo().frame(frameEle);
    driver.findElement(By.id("datepicker")).click();
    driver.findElement(By.xpath("//span[text()='Next']")).click();
    driver.findElement(By.linkText("2")).click();
    Thread.sleep(3000);
    Select select = new Select(driver.findElement(By.id("time")));
    select.selectByIndex(2);
//    List<WebElement> options = select.getOptions();
//    System.out.println(options);
//    options.get(2).click();
    Thread.sleep(3000);
    driver.findElement(By.id("ChangeHeatName")).click();
    System.out.println(driver.getTitle());
    Thread.sleep(3000);
    driver.switchTo().defaultContent();
    driver.findElement(By.id("sym")).sendKeys("Fever");
    driver.findElement(By.xpath("//input[@value='Submit']")).click();
    System.out.println(driver.getTitle());
    Thread.sleep(3000);
    System.out.println("Table Row Contents" + driver.findElement(By.xpath("//table/tbody/tr[1]")).getText());
    Thread.sleep(3000);
    driver.quit();
	}

}
