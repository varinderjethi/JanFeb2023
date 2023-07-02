package testNGbasics1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTesting {
WebDriver driver;
	
	@BeforeClass(alwaysRun=true)
	public void initialization() {
		System.setProperty("webdriver.chrome.driver", "E:\\TestAutomation\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com");
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);	// Selenium 4 -> Duration.ofSeconds(15)
		driver.manage().deleteAllCookies();
		
	}

	@AfterMethod(alwaysRun=true)
	public void backToHomePage() {
		driver.findElement(By.id("nav-logo-sprites")).click();
	}
		
	@AfterClass(alwaysRun=true)
	public void tearDown() {
		
		driver.close();
	}
	
	@Test(dataProvider = "positiveSearchData", groups = "E2E Test")
	public void positiveSearchFunctionalityTest(String product) {
	     driver.findElement(By.id("twotabsearchtextbox")).sendKeys(product);
	     driver.findElement(By.id("nav-search-submit-button")).click();
	     String actualTitle = driver.getTitle();
	     String expectedTitle = "Amazon.com : " + product;
	     
	     // Assertion -> creating validation point
	     Assert.assertEquals(actualTitle, expectedTitle);
	     Assert.assertTrue(driver.getCurrentUrl().contains(product));
	     Assert.assertFalse(!driver.getTitle().contains(product));
	}
	
	@DataProvider
	public String[] positiveSearchData() {
		String[] searchProduct = {"apple","orange","samsung"};
		return searchProduct;
	}
	
	@Test(dataProvider = "positiveMenuLinkData", groups = {"E2E Test", "Regression Test"})
	public void PositiveMenuLinkFunctionalityTest(String link) {
		driver.findElement(By.linkText(link)).click();
		 String actualTitle = driver.getTitle();
	     String expectedTitle = "Amazon.com: " + link;
	     
	     // Assertion -> creating validation point
	     Assert.assertEquals(actualTitle, expectedTitle);
	     Assert.assertTrue(driver.getCurrentUrl().contains(link.replace(" ", "")));
	     Assert.assertFalse(!driver.getTitle().contains(link));
		
	}
	
	@DataProvider
	public String[] positiveMenuLinkData() {
		String[] menuLink = {"Books","Amazon Basics","Today's Deals"};
		return menuLink;
	}
	

}
