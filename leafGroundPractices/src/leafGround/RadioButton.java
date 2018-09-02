package leafGround;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class RadioButton {
	WebDriver driver;
	@BeforeSuite
	public void RadioButton() {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\QA Tools\\Selenium\\drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
			
		driver.get("http://www.leafground.com/");
	
		WebElement RadioButton= driver.findElement(By.cssSelector("a.wp-categories-link.maxheight[href*='radio']"));
		RadioButton.click();
		
		
		WebElement RadioButton1= driver.findElement(By.id("yes"));
		RadioButton1.click();
		
		Boolean DeafultSelection=driver.findElement(By.xpath("//*[@id='contentblock']/section/div[2]/div/div/input[2]")).isSelected();
		 //System.out.println("Default Radio button selection Status: "+DeafultSelection);
				
		if (DeafultSelection.equals(true)){
			System.out.println("'Checked' has been chosen by default");
		}
		else{
			System.out.println("'UnChecked' has been chosen by default");}
		
		
	
		WebElement ageselection=driver.findElement(By.xpath("//*[@id='contentblock']/section/div[3]/div/div/input[2]"));
		Boolean isSelected=ageselection.isSelected();
		
		if (isSelected.equals(true)){
			System.out.println("Age has chosen already");
		}
		else{
			ageselection.click();
		}
		
		}
		
	
}


