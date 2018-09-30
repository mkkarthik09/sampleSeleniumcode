package flipKart;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import FlipKartLogin.FlipKartLogin;

public class SearchFlipKart {
			 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*FlipKartLogin login=new FlipKartLogin();
		login.openwebsite();
		login.Valid();*/
		
		System.setProperty("webdriver.chrome.driver", "D:\\QA Tools\\Selenium\\drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://www.flipkart.com/");
		
		WebElement email=driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input"));
		email.clear();
		email.sendKeys("mk.karthik09@gmail.com");
		WebElement password=driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input"));
		password.clear();
		password.sendKeys("Whatever5833");
		WebElement loginbutton=driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[3]/button"));
		loginbutton.click();
		
		
		Actions action=new Actions(driver);
		WebElement myaccount=driver.findElement(By.xpath("//*[@id='container']/div/header/div[1]/div/div/div/div[3]/div[1]/div/div/div/span/div"));
		action.moveToElement(myaccount).build().perform();
		
		WebElement orders=driver.findElement(By.xpath("//*[@id='container']/div/header/div[1]/div/div/div/div[3]/div[1]/div/div/div/div/div/div[2]/div/ul/li[3]/a/div"));
		orders.click();
		
		WebElement searchbox=driver.findElement(By.name("q"));
		searchbox.sendKeys("ozone facewash for mens");
		searchbox.submit();
		
		WebElement searchbutton = driver.findElement(By.xpath("//*[@id='container']/div/header/div[1]/div/div/div/div[2]/form/div/div[2]/button/svg"));
		searchbutton.click();
		
		
		
		
		
	}

}
