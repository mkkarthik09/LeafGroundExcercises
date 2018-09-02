package leafGround;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Images {
	WebDriver driver;
	
	@BeforeTest
	public void TL_Images(){
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","D:\\QA Tools\\Selenium\\drivers\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS );
		driver.manage().window().maximize();
		
		driver.get("http://www.leafground.com/");
		WebElement images=driver.findElement(By.xpath("//*[@id='post-153']/div[2]/div/ul/li[4]/a/img"));
		images.click();
	}
	
	@Test (priority=0)
	public void HomeImage(){
		//WebElement homeimage=driver.findElement(By.xpath("//*[@id='contentblock']/section/div[1]/div/div/img"));
		WebElement homeimage=driver.findElement(By.tagName("img"));
		homeimage.click();
		
		driver.navigate().back();
		}
	
	@Test (priority=1)
	public void brokenimage(){
		WebElement brokenimage=driver.findElement(By.xpath("//*[@id='contentblock']/section/div[2]/div/div/img"));
		
		Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", brokenimage);
	    if (!ImagePresent)
	    {
	         System.out.println("Image not displayed.");
	    }
	    else
	    {
	        System.out.println("Image displayed.");
	    }
	    }
					
	    @Test (priority=2)
		public void ThridImage(){
	    WebElement	thirdimage=driver.findElement(By.xpath("//*[@id='contentblock']/section/div[3]/div/div/img"));
	    thirdimage.click();
	    
	    driver.quit();
		
	}
	}

