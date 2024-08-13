package datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TrelloLogin {
	public static WebDriver driver;
public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
	FileInputStream file = new FileInputStream("./src/test/resource/data.xlsx");
	Workbook workbook = WorkbookFactory.create(file);
	Sheet sheet = workbook.getSheet("details");
	Row browserRow = sheet.getRow(1);
	Cell browserCell = browserRow.getCell(1);
	String browserName = browserCell.getStringCellValue();
	if(browserName.equals("chrome"))
	{
		driver = new ChromeDriver();
	}
	else if(browserName.equals("Firefox"))
	{
		driver = new FirefoxDriver();
	}
	else if(browserName.equals("edge"))
	{
		driver = new EdgeDriver();
	}
	System.out.println(browserName);
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	Row urlRow = sheet.getRow(2);
	Cell urlCell = urlRow.getCell(1);
	driver.get(urlCell.getStringCellValue());
	Thread.sleep(1000);
	driver.findElement(By.cssSelector("a[data-uuid='MJFtCCgVhXrVl7v9HA7EH_login']")).click();
	Row userNameRow = sheet.getRow(3);	
	Cell userNameCell = userNameRow.getCell(1);
	driver.findElement(By.id("username")).sendKeys(userNameCell.getStringCellValue());
	driver.findElement(By.xpath("//span[text()= 'Continue']")).click();
	Row passwordRow = sheet.getRow(4);	
	Cell passwordCell = passwordRow.getCell(1);
	driver.findElement(By.id("password")).sendKeys(passwordCell.getStringCellValue());
	driver.findElement(By.id("login-submit")).submit();
	driver.manage().window().minimize();
	driver.quit();
}
}
