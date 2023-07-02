package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingConfig {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\TestAutomation\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.demo.guru99.com/test/newtours/index.php");
		WebElement userNameTxtField = driver.findElement(By.name("userName"));

		
				userNameTxtField.sendKeys("test12");		// action on element
		Thread.sleep(3000);
		// For Password:
		WebElement passwordTxtField = driver.findElement(By.name("password"));
		passwordTxtField.sendKeys("123");
		Thread.sleep(3000);
		// To click on Submit button:
		driver.findElement(By.name("submit")).click();
		
		// Creating Verification Point
		String expectedLoginSuccessPageUrl = "https://www.demo.guru99.com/test/newtours/login_sucess.php";
		String actualLoginSuccessPageUrl = driver.getCurrentUrl();
		if(actualLoginSuccessPageUrl.equals(expectedLoginSuccessPageUrl)) {
			System.out.println("Positive login functionality test: Passed");
		}
		else {
			System.err.println("Positive login functionality test: Failed");
		}
		
		// Handling linkText
//		driver.findElement(By.linkText("SIGN-OFF")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.linkText("REGISTER")).click();
//		Thread.sleep(3000);
//		String expectedRegisterPageTitle = "Register: Mercury Tours"; 
//		String actualRegisterPageTitle = driver.getTitle();
//		if(actualRegisterPageTitle.equals(expectedRegisterPageTitle)) {
//			System.out.println("Register link functionality test: Passed");
//		}
//		else {
//			System.err.println("Register link functionality test: Failed");
//		}
		
		// amazon website
//		<input type="text" id="twotabsearchtextbox" value="" name="field-keywords" autocomplete="off" placeholder="Search Amazon" 
//		class="nav-input nav-progressive-attribute" dir="auto" tabindex="0" aria-label="Search Amazon" spellcheck="false">
		
		// Using ID strategy
//		String productToSearch = "samsung";
//		WebElement searchTxtField = driver.findElement(By.id("twotabsearchtextbox"));
//		searchTxtField.sendKeys(productToSearch);
//		Thread.sleep(3000);
//		driver.findElement(By.id("nav-search-submit-button")).click();
//		Thread.sleep(3000);
//		// Verification Point
//		String actualProductSearchPageUrl = driver.getCurrentUrl();
//		if(actualProductSearchPageUrl.contains(productToSearch)) {
//			System.out.println("Search functionality test: Passed");
//		}
//		else {
//		System.err.println("Search functionality test: Failed");
//		}

		
		
		
		driver.close();
		
	}
	
}
