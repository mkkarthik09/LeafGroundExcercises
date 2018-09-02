package leafGround;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Alerts {
	WebDriver driver;
	@BeforeSuite
	public void Alerts(){
		System.setProperty("webdriver.chrome.driver", "D:\\QA Tools\\Selenium\\drivers\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
			
		driver.get("http://www.leafground.com/");
	
		WebElement Alerts= driver.findElement(By.cssSelector("a.wp-categories-link.maxheight[href*='Alert']"));
		Alerts.click();
		
	}
	@Test
	public void HandleAlerts(){
		
				
		WebElement Alertbox=driver.findElement(By.xpath("//*[@id='contentblock']/section/div[1]/div/div/button"));
		Alertbox.click();
		driver.switchTo().alert().accept();
		
		WebElement confirmbox= driver.findElement(By.xpath("//*[@id='contentblock']/section/div[2]/div/div/button"));
		confirmbox.click();
		driver.switchTo().alert().accept();
		
		WebElement promptbox= driver.findElement(By.xpath("//*[@id='contentblock']/section/div[3]/div/div/button"));
		promptbox.click();
		driver.switchTo().alert().sendKeys("Test Leaf-Leaf Ground");;
		driver.switchTo().alert().accept();
		
		WebElement Result1=driver.findElement(By.id("result1"));
		String ResultText=Result1.getText();
		System.out.println(ResultText);
		
		WebElement linebreaks=driver.findElement(By.xpath("//*[@id='contentblock']/section/div[4]/div/div/button"));
		linebreaks.click();
		
		String linebreaks_text=driver.switchTo().alert().getText();
		System.out.println(linebreaks_text);
		driver.switchTo().alert().accept();
	}
	}
	
	


