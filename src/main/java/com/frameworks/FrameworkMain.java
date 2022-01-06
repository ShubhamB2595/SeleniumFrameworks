package com.frameworks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utility.BaseClass;
import com.utility.ExcelUtils;

public class FrameworkMain {

	static WebDriver driver;
	static ExcelUtils excelUtil;

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", "I:\\Selenium\\Selenium Frameworks\\libraries\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		excelUtil = new ExcelUtils(BaseClass.FILE_PATH);
		excelUtil.setExcelFile(BaseClass.FILE_PATH, BaseClass.SHEET_NAME);
		
		driver.get("https://www.ebay.com/");
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.xpath("//input[@id='userid']")).sendKeys(excelUtil.getCellData(1, 1).toString());
		driver.findElement(By.xpath("//button[@id='signin-continue-btn']")).click();
		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.close();
		

	}

}
