package leafGround;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ListBoxes {
	
	WebDriver driver;

	@BeforeSuite (groups="Intial")
	public void OpenLeafGround() {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\QA Tools\\Selenium\\drivers\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
			
		driver.get("http://www.leafground.com/");
	}
	
	@Test (groups="Intial")
	public void OpenListBoxPage() {
		WebElement dropdown= driver.findElement(By.linkText("Drop down"));
		dropdown.click();
	}
	
	@Test (groups="actions")
	public void dropdown1() {
		WebElement byindex =driver.findElement(By.id("dropdown1"));
		Select index=new Select(byindex);
		index.selectByIndex(1);
	}
	
	@Test (groups="actions")
	public void dropdown2() {
		
		WebElement bytext =driver.findElement(By.name("dropdown2"));
		Select visibletext=new Select(bytext);
		visibletext.selectByVisibleText("Selenium");
	}
	
	@Test (groups="actions")
	public void dropdown3(){	
		
		WebElement byvalue =driver.findElement(By.id("dropdown3"));
		Select value=new Select(byvalue);
		value.selectByValue("1");
	}		
		
	@Test (groups="actions")
	public void dropdown4(){
		WebElement count =driver.findElement(By.xpath("//*[@id='contentblock']/section/div[4]/select"));
		Select countoptions=new Select(count);
		List<WebElement> noofoptions=countoptions.getOptions();
		int finalcount=noofoptions.size();
		System.out.println(finalcount);
	}
	
	@Test (groups="actions")
	public void dropdown5(){
		
		WebElement sendkeys =driver.findElement(By.xpath("//*[@id='contentblock']/section/div[5]/select"));
		//Select usesendkeys=new Select(sendkeys);
		sendkeys.sendKeys(Keys.TAB);
		sendkeys.sendKeys(Keys.ARROW_DOWN);
		//sendkeys.sendKeys(Keys.ENTER);
		sendkeys.click();
		sendkeys.sendKeys(Keys.TAB);
	}
	
	@Test (groups="actions")
	public void dropdown6(){
		
		WebElement multiplebox =driver.findElement(By.xpath("//*[@id='contentblock']/section/div[6]/select"));
		Select select = new Select(multiplebox);
		Actions builder = new Actions(driver);
		builder.keyDown(Keys.CONTROL)
		.click(select.getOptions().get(2))
		.click(select.getOptions().get(3))
		.click(select.getOptions().get(4))
		.keyUp(Keys.CONTROL);
		builder.build().perform();
	}
	
	@AfterSuite (groups="final",dependsOnGroups={"Initial","actions"})
	public void CloseBroswer(){
	
		driver.quit();
		
	}

}
