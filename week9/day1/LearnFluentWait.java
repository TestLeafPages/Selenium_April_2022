package week9.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnFluentWait {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/appear.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
		
		Wait wait = new FluentWait(driver)
				.withTimeout(Duration.ofSeconds(1))
				.pollingEvery(Duration.ofMillis(250));
				
		
		//Step1: Create object for WebDriverWait
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		
		//Step2: Apply the expected condition
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//b[contains(text(),'Voila')]"))));
		
		String text = driver.findElement(By.xpath("//b[contains(text(),'Voila')]")).getText();
		
		System.out.println(text);
		
		
		
		
	}

}
