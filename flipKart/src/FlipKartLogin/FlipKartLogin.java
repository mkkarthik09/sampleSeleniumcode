package FlipKartLogin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class FlipKartLogin {

WebDriver driver;
	
	@BeforeSuite
	public void openwebsite(){
		
		System.setProperty("webdriver.chrome.driver", "D:\\QA Tools\\Selenium\\drivers\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://www.flipkart.com/");
	}

	@Test (groups="ValidScenario")
	public void Valid() {
					
		//1. Valid username, Password
		WebElement email=driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input"));
		email.clear();
		email.sendKeys("Your Valid Username");
		WebElement password=driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input"));
		password.clear();
		password.sendKeys("Your Valid Password");
		WebElement loginbutton=driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[3]/button"));
		loginbutton.click();
	}
	
	
	
		@Test (groups="ValidScenario",dependsOnMethods="Valid")
		public void logout(){
		//logout
		Actions action=new Actions(driver);
		WebElement myaccount=driver.findElement(By.xpath("//*[@id='container']/div/header/div[1]/div/div/div/div[3]/div[1]/div/div/div/span/div"));
		action.moveToElement(myaccount).build().perform();
		
		WebElement logout=driver.findElement(By.xpath("//*[@id='container']/div/header/div[1]/div/div/div/div[3]/div[1]/div/div/div/div/div/div[2]/div/ul/li[8]/a/div"));
		logout.click();
		}
	
	@Test (groups="InValidScenario")
	public void validusername(){
		//2. Valid username,invalid password
		
		WebElement email=driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input"));
		email.clear();
		email.sendKeys("Your Valid Username");
		WebElement password=driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input"));
		password.clear();
		password.sendKeys("Invalid Password");
		WebElement loginbutton=driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[3]/button"));
		loginbutton.click();
	}
	@Test (groups="InValidScenario")
	public void validpassword(){
		//3. Invalid username, valid password
		
		WebElement email=driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input"));
		email.clear();
		email.sendKeys("Invalid Username");
		WebElement password=driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input"));
		password.clear();
		password.sendKeys("Your Valid Password");
		WebElement loginbutton=driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[3]/button"));
		loginbutton.click();
	}
		//4. Invalid username,password
	@Test (groups="InValidScenario")
	public void Invalid(){
		
		WebElement email=driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input"));
		email.clear();
		email.sendKeys("Invalid Username");
		WebElement password=driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input"));
		password.clear();
		password.sendKeys("Invalid Password");
		WebElement loginbutton=driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[3]/button"));
		loginbutton.click();
	}
	
	@AfterSuite 
	public void closebrowser(){
		
		driver.quit();
		
	}

}
