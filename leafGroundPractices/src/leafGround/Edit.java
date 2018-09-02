package leafGround;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Edit {
	WebDriver driver;

	@BeforeTest
	public void OpenLeafGround() {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\QA Tools\\Selenium\\drivers\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		driver.get("http://www.leafground.com/");
		WebElement edit= driver.findElement(By.xpath("//*[@id='post-153']/div[2]/div/ul/li[1]/a/img"));
		edit.click();
	}
	
	@Test (priority=0)
	public void Entertext(){
		
		WebElement emailid=driver.findElement(By.id("email"));
		emailid.sendKeys("mk.karthik09@gmail.com");
	}
		
	@Test (priority=1)
	public void appendtext(){
		WebElement append=driver.findElement(By.xpath("//*[@id='contentblock']/section/div[2]/div/div/input"));
		append.sendKeys("karthik.mk");
		append.sendKeys(Keys.TAB);
	}
	
	@Test (priority=2)
	public void getdeafulttext(){
		WebElement defaulttext=driver.findElement(By.name("username"));
		String enteredtext=defaulttext.getAttribute("Value");
		System.out.println(enteredtext);
	}
	
	@Test (priority=3)
	public void cleartext(){
		WebElement cleartext=driver.findElement(By.xpath("//*[@id='contentblock']/section/div[4]/div/div/input"));
		cleartext.clear();		
		
		WebElement disabled=driver.findElement(By.xpath("//*[@id='contentblock']/section/div[5]/div/div/input"));
		String disabledResult= disabled.getAttribute("disabled");
		//String str = String.valueOf(disabledResult);
		
		if (disabledResult.equals("true"))
		{System.out.println("DISABLED");}
		else
		{System.out.println("ENABLED");};
	}
	
	@AfterTest
	public void quitbrowser() throws InterruptedException{
		Thread.sleep(5000);
		driver.quit();	
	}
		
		
	}


