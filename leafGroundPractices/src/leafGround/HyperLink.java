package leafGround;

import java.awt.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HyperLink {
	WebDriver driver;
	
	@BeforeTest
	public void TL_HyperLink() {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\QA Tools\\Selenium\\drivers\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.get("http://www.leafground.com/");
		WebElement buttonlink=driver.findElement(By.xpath("//*[@id='post-153']/div[2]/div/ul/li[3]/a/img"));
		buttonlink.click();
	}
		@Test (priority=0)
		public void HomePage(){
		WebElement homepage=driver.findElement(By.linkText("Go to Home Page"));
		homepage.click();
		driver.navigate().back();
		
		/*WebElement buttonlink1=driver.findElement(By.xpath("//*[@id='post-153']/div[2]/div/ul/li[3]/a/img"));
		buttonlink1.click();*/
		}
		
		@Test (priority=1)
		public void WithoutClikingMe(){
		WebElement link2=driver.findElement(By.partialLinkText("without clicking me"));
		link2.click();
		
		driver.navigate().back();
		}
		
		@Test (priority=2)
		public void BrokenLink(){
		WebElement link3=driver.findElement(By.partialLinkText("broken"));
		link3.click();
		
		//assertTrue(driver.getTitle().contains("404"));
		boolean errorpage = driver.getPageSource().contains("404");
		
		if (errorpage=true){
			System.out.println("broken page");
		}
		else{
			System.out.println("active page");
		};
		
		driver.navigate().back();
		}
		
		@Test (priority=3)
		public void HomeLinkAgain(){
		
		WebElement homelink2= driver.findElement(By.xpath("//*[@id='contentblock']/section/div[4]/div/div/a"));
		homelink2.click();
		
		driver.navigate().back();
		java.util.List<WebElement> Alllinks = driver.findElements(By.tagName("a"));
		Integer countoflinks=Alllinks.size();
		System.out.println(countoflinks);
		
		driver.quit();
		}
	}


