package datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.reporters.jq.Main;

public class ReadTheDataFromPropertyFile {
	public static WebDriver driver;
public static void main(String[] args) throws IOException, InterruptedException {
	// access the file by giving the path/address of the file
	FileInputStream file = new FileInputStream("./src/test/resource/fbcommondata.properties");
	// create an object---properties class ---java
	Properties pobj = new Properties();
	// load the data ----load() ---- properties class
	pobj.load(file);
	// read the data ----getProperty()----properties class
	String browserName = pobj.getProperty("browser");
	System.out.println("browserName = " + browserName);
	// launch the browser
	if (browserName.equals("chrome"))
	{
		driver = new ChromeDriver();
		
	}
	else if (browserName.equals("firefox")) {
		driver = new FirefoxDriver();
	}
	else if (browserName.equals("edge")) {
		driver = new EdgeDriver();
	}
	//pre condition
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	// trigger the main url
	driver.get(pobj.getProperty("url"));
	Thread.sleep(1000);
	driver.findElement(By.id("email")).sendKeys(pobj.getProperty("email"));
	Thread.sleep(1000);
	driver.findElement(By.id("pass")).sendKeys(pobj.getProperty("password"));
	Thread.sleep(1000);
	driver.findElement(By.name("login")).submit();
	// post condition
	driver.manage().window().minimize();
	driver.quit();
	
}
}
