package com.ebay.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.utility.BaseClass;
import com.utility.ExcelUtils;

public class LogicPageTest {

	WebDriver driver;
	ExcelUtils excelUtil;

	@BeforeTest
	public void setup() throws Exception {

		System.setProperty("webdriver.chrome.driver",
				"I:\\\\Selenium\\\\Selenium Frameworks\\\\libraries\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		excelUtil = new ExcelUtils(BaseClass.FILE_PATH);
		excelUtil.setExcelFile(BaseClass.FILE_PATH, BaseClass.SHEET_NAME);
	}

	@Test
	public void testSignIn() throws Exception {

		driver.get("https://www.ebay.com/");
		driver.findElement(By.linkText("Sign in")).click();
		for (int i = 1; i <= excelUtil.getRowCountInSheet(); i++) {
			// driver.findElement(By.xpath("//input[@id='userid']")).clear();
			System.out.println(excelUtil.getCellData(i, 1));
			driver.findElement(By.xpath("//input[@id='userid']")).sendKeys(excelUtil.getCellData(i, 1));

			driver.findElement(By.xpath("//button[@id='signin-continue-btn']")).click();
			Thread.sleep(3000);
			driver.navigate().refresh();
		}
	}

	@AfterTest
	public void closeBrowser() {

		driver.close();
	}

}
