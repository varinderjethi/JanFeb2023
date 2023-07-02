package testNGbasics1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGannotations {
	// Assertion - to create validation point
	   // Verification Vs Validation -> will notify test case as pass or fail based on assertion -> 
//																									1. comparing actual vs expected 2. if actual is true 3. if actual is false   

public class UsingAnnotationsAndKeywords {
	// 1:12:16
	WebDriver driver;
	
	@BeforeMethod(alwaysRun=true)
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
	public void tearDown() {
		
		driver.close();
	}
	
	@Test(groups = {"Smoke Test", "Regression Test"})
	public void positiveSearchFunctionalityTest() {
	     driver.findElement(By.id("twotabsearchtextbox")).sendKeys("apple");
	     driver.findElement(By.id("nav-search-submit-button")).click();
	     String actualTitle = driver.getTitle();
	     String expectedTitle = "Amazon.com : apple";
	     
	     // Assertion -> creating validation point
	     Assert.assertEquals(actualTitle, expectedTitle);
	     Assert.assertTrue(driver.getCurrentUrl().contains("apple"));
	     Assert.assertFalse(!driver.getTitle().contains("apple"));
	}
	
	
	
	@Test(groups = {"Smoke Test", "Integration Test" ,"Regression Test"})
	public void PositiveMenuLinkFunctionalityTest() {
		driver.findElement(By.linkText("Amazon Basics")).click();
		 String actualTitle = driver.getTitle();
	     String expectedTitle = "Amazon.com: Amazon Basics";
	     
	     // Assertion -> creating validation point
	     Assert.assertEquals(actualTitle, expectedTitle);
	     Assert.assertTrue(driver.getCurrentUrl().contains("AmazonBasics"));
	     Assert.assertFalse(!driver.getTitle().contains("Amazon Basics"));
		
	}
	
}

}
