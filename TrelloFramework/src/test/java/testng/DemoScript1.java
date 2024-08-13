package testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DemoScript1 {
WebDriver driver;
@BeforeClass
public void preCondition()
{
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
@AfterClass
public void postCondition()
{
	driver.manage().window().minimize();
	driver.quit();
}
@Test(priority = 3)
public void fbLogin() throws InterruptedException
{
	driver.get("https://www.facebook.com/");
	driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
	driver.findElement(By.id("pass")).sendKeys("123");
	driver.findElement(By.name("login")).submit();
	Thread.sleep(2000);
}
@Test(priority = 1)
public void vtigerLogin() throws InterruptedException
{
	driver.get("https://demo.vtiger.com/vtigercrm/");
	WebElement userNameTextField = driver.findElement(By.id("username"));
	userNameTextField.clear();
	userNameTextField.sendKeys("admin");
	WebElement passwordTextField = driver.findElement(By.id("password"));
	passwordTextField.clear();
	passwordTextField.sendKeys("admin");
	driver.findElement(By.xpath("//button[text() = 'Sign in']")).submit();
	Thread.sleep(2000);
	}
@Test(priority = 2)
public void trelloLogin() throws InterruptedException
{
driver.get("https://trello.com/");
driver.findElement(By.xpath("//div[contains(@class, 'Buttonsstyles__ButtonGroup')]/a[text() = 'Log in']")).click();
driver.findElement(By.id("username")).sendKeys("shruthipl7760@gmail.com");
driver.findElement(By.id("login-submit")).submit();
driver.findElement(By.id("password")).sendKeys("Shreyu@918");
driver.findElement(By.id("login-submit")).submit();
Thread.sleep(2000);
}

}