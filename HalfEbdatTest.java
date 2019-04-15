import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
//meant Ebay 
public class HalfEbdatTest {
	
	WebDriver driver; 
	
	@BeforeMethod
	public void setU() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\chromeDriver\\chromedriver.exe");
	
		driver = new ChromeDriver(); 
		driver.manage().window().maximize(); 
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		driver.get("https://reg.ebay.com/reg/PartialReg?ru=https%3A%2F%2Fwww.ebay.com%2F");
	}
	@DataProvider
	public Iterator<Object[]> getTestData(){
		ArrayList<Object[]> testData = TestUtil.getDatafromExcel();
		return testData.iterator();
		
 
	}
	
	@Test(dataProvider ="getTestData")
	public void halfEbayRegPageTest(String firstName, String lastName, String e, String password) {	
	
		driver.findElement(By.xpath("//*[@id=\"firstname\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"firstname\"]")).sendKeys(firstName);
		
		driver.findElement(By.xpath("//*[@id=\"lastname\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"lastname\"]")).sendKeys(lastName);
		
		driver.findElement(By.xpath("//*[@id=\"email\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(e);
		
		driver.findElement(By.xpath("//*[@id=\"PASSWORD\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"PASSWORD\"]")).sendKeys(password);
	
}
	@AfterMethod
	public void TeadDown() {
		driver.quit();
	}
	
}
