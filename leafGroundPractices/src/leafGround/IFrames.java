package leafGround;

import java.awt.Frame;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.SwitchToFrame;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class IFrames {
	WebDriver driver;
	@BeforeSuite
	public void Alerts(){
		System.setProperty("webdriver.chrome.driver", "D:\\QA Tools\\Selenium\\drivers\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
			
		driver.get("http://www.leafground.com/");
	
		WebElement Alerts= driver.findElement(By.cssSelector("a.wp-categories-link.maxheight[href*='frame']"));
		Alerts.click();
		
	}
	@Test
	public void HandleFrames(){
		
		WebElement iframe1=driver.findElement(By.xpath("//*[@id='wrapframe']/iframe"));
		driver.switchTo().frame(iframe1);
		
		WebElement nestedframeclickme=driver.findElement(By.id("Click"));
		nestedframeclickme.click();
		driver.switchTo().defaultContent();
		
		
		
		WebElement iframeOuter=driver.findElement(By.cssSelector("iframe[src*='page']"));
		driver.switchTo().frame(iframeOuter);
		
		WebElement iframeinner=driver.findElement(By.xpath("//*[@id='frame2']"));
		driver.switchTo().frame(iframeinner);
		WebElement clickme=driver.findElement(By.id("Click1"));
		clickme.click();
		
		driver.switchTo().defaultContent();
		
				
		//Total no of frames in a page
		/*JavascriptExecutor exe = (JavascriptExecutor) driver;
		Integer numberOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());
		System.out.println("Number of iframes on the page are " + numberOfFrames);*/
		
		List<WebElement> iframeElements1 = driver.findElements(By.tagName("iframe"));
		System.out.println("The total number of iframes are " + iframeElements1.size());
		
	}
	}

