package leafGround;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.Color;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.support.Color;

public class Button {
	 WebDriver driver;
	
	 @BeforeTest
	public void ButtonActions() {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\QA Tools\\Selenium\\drivers\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.get("http://www.leafground.com/");
		WebElement buttonlink=driver.findElement(By.xpath("//*[@id='post-153']/div[2]/div/ul/li[2]/a/h5"));
		buttonlink.click();
	}
		@Test (priority=0)
		public void HomeButton(){
		WebElement homebutton=driver.findElement(By.id("home"));
		homebutton.click();
		driver.navigate().back();
		/*WebElement buttonlink1=driver.findElement(By.xpath("//*[@id='post-153']/div[2]/div/ul/li[2]/a/h5"));
		buttonlink1.click();*/	
		}
		
		@Test (priority=1)
		public void PostionofButton(){
		WebElement positionbutton=driver.findElement(By.id("position"));
		Dimension dimension=positionbutton.getSize();
		System.out.println("Button dimension(x,y)="+dimension);
		}
		
		@Test (priority=2)
		public void ColorofButton() throws DecoderException, UnsupportedEncodingException{
		WebElement colorbutton=driver.findElement(By.id("color"));
		String buttoncolor =colorbutton.getCssValue("background-color");
		//System.out.println("Button color is "+buttoncolor);	
		
		
		/*System.out.println(buttoncolor);
		String hex = Color.fromString(buttoncolor).asHex();
		System.out.println(hex);
		
		String hexString = hex;    
		byte[] bytes = Hex.decodeHex(hexString.toCharArray());
		System.out.println(new String(bytes, "UTF-8"));*/
		
		/*Assert.assertEquals("some message", "rgba(144, 238, 144, 1)", buttoncolor);
		System.out.println(buttoncolor);
		String hex = buttoncolor.fromString(buttoncolor).asHex();
		System.out.println(hex);*/
		}
		
		@Test (priority=3)
		public void SizeofButton(){
		
		WebElement buttonsize=driver.findElement(By.id("size"));
		Integer hight=buttonsize.getSize().getHeight();
		Integer width=buttonsize.getSize().getWidth();
		
		System.out.println("button hight is "+hight );
		System.out.println("button width is "+width );
		
		driver.quit();
		}
	}


