package com.trello.qsp.genericutility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
public WebDriver driver;
public WebdriverUtility webdriverutils = new WebdriverUtility();
public JavaUtility javautils = new JavaUtility(); 
public FileUtility fileutils = new FileUtility();
public ExcelUtility excelutils = new ExcelUtility();


@BeforeMethod
public void precondition() throws IOException
{
String browserName = fileutils.readTheDataFromPropertyFile("browser");
if(browserName.equals("chrome"))
{
	driver = new ChromeDriver();
}else if(browserName.equals("edge"))
{
	driver = new EdgeDriver();
}

else if(browserName.equals("firefox"))
{
	driver = new FirefoxDriver();
}
driver.manage().window().maximize();
webdriverutils.implicitWait(driver);
driver.get(fileutils.readTheDataFromPropertyFile("url"));
}
@AfterMethod
public void postCondition()
{
	driver.manage().window().minimize();
	driver.quit();
}
public void failedTestCase(String FailedMethod) throws IOException
{
	String ldt = LocalDateTime.now().toString().replace(':', '-');
	TakesScreenshot ts = (TakesScreenshot)driver;
	File tempFile = ts.getScreenshotAs(OutputType.FILE);
	File permFile = new File("./src/test/resource/defectshot/"+ldt+FailedMethod+"defect.png");
	FileUtils.copyFile(tempFile, permFile);
	
}
}
