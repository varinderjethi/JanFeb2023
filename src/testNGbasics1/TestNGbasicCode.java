package testNGbasics1;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestNGbasicCode {
	// @Test -> test annotation to create test method
	
		@Test
		public void handlingWindows() {
			System.setProperty("webdriver.chrome.driver", "E:\\TestAutomation\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://the-internet.herokuapp.com/windows");
			
			driver.findElement(By.linkText("Click Here")).click();	// new window will open
			driver.findElement(By.linkText("Click Here")).click();
			
			Set<String> handles = driver.getWindowHandles();
			
			Iterator<String> it = handles.iterator();
			
			while(it.hasNext()) {
				String handle = it.next();
				driver.switchTo().window(handle);
				System.out.println(driver.getTitle());
				System.out.println(driver.getCurrentUrl());
				driver.close();
				
				
			}
		}

		@Test
		public void handlingAlert() {
			System.setProperty("webdriver.chrome.driver", "E:\\TestAutomation\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://demo.guru99.com/test/delete_customer.php");
			
			driver.findElement(By.name("cusid")).sendKeys("test");
			driver.findElement(By.name("submit")).click();
			
			String alert1 = driver.switchTo().alert().getText();
			System.out.println(alert1);
			driver.switchTo().alert().accept();			// click on OK
			
			 String alert2 = driver.switchTo().alert().getText();
			 System.out.println(alert2);
			 driver.switchTo().alert().accept();
			 driver.close();
		}

}
