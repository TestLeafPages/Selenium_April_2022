package challenges;

import org.testng.annotations.Test;



import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

public class LambdaTest {

	public RemoteWebDriver driver = null;
	String username = "r.hariprasad";
	String accessKey = "QAyCmKNLKeWGGh6ttuqQCdxImiDZNmFHgFxS3B3dBItzEscSOF";

	@BeforeTest
	public void setUp() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName", "Chrome");
		capabilities.setCapability("version", "103.0");
		capabilities.setCapability("platform", "Windows 10");
		capabilities.setCapability("resolution", "1024x768");
		capabilities.setCapability("build", "First Test");
		capabilities.setCapability("name", "Sample Test");
		capabilities.setCapability("network", true); // To enable network logs
		capabilities.setCapability("visual", true); // To enable step by step screenshot
		capabilities.setCapability("video", true); // To enable video recording
		capabilities.setCapability("console", true); // To capture console logs

		try {
			driver = new RemoteWebDriver(
					new URL("https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			System.out.println("Invalid grid URL");
		}
	}

	@Test(enabled = true)
	public void testScript() throws Exception {
		try {
			driver.get("http://leaftaps.com/opentaps/control/main");
			driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
			driver.findElement(By.id("password")).sendKeys("crmsfa");
			driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
			boolean displayed = driver.findElement(By.linkText("CRM/SFA")).isDisplayed();
			//Assert.assertTrue(displayed);
			if(displayed) {
				driver.executeScript("lambda-status=passed");	
			}else {
				driver.executeScript("lambda-status=failed");
			}
			
			driver.quit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
