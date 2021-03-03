package functionalities;

import utilities.ExtentReport;
import utilities.InputFromExcel;
import utilities.Waiting;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class BusinessValid {
	public static WebDriver driver;
	public static Waiting wait = new Waiting();
	// Creating an object of class extent report
	ExtentReport ex;

	Properties config = new Properties();

	public BusinessValid(WebDriver d, ExtentReport extent) throws IOException {
		// initializing the driver to global driver in this class
		driver = d;
		// creating a filereader object to read file"projec.properties" file
		FileReader reader = new FileReader("project.properties");
		config.load(reader);
		ex = extent;
	}

	@Test
	public void clickLogo() throws InterruptedException, IOException {
		wait.waitImplicit(driver);

		driver.findElement(By.cssSelector(config.getProperty("homepage"))).click();

		// Logging the action
		ex.actionLog("Clicked On Udemy Logo");

		wait.waitImplicit(driver);

		// Creating a screenshot driver and storing in scrFile.
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "\\screenshot\\Courses\\BusinessValid\\udemyLogo.png";
		// Now we take a screenshot
		FileUtils.copyFile(scrFile, new File(path));

		// Logging the action
		ex.screenShotLog("Snapshot:Clicked on Udemy Logo ", path);

		String parent = driver.getWindowHandle();

		// driver.findElement(By.xpath(config.getProperty("businessButton"))).click();
		driver.findElement(By.partialLinkText("Udemy for Business")).click();

		ex.actionLog("Switched Udemy Demo Form");

		wait.waitImplicit(driver);

		Set<String> wins = driver.getWindowHandles();
		for (String windows : wins) {
			if (windows.equals(parent)) {
			} else {
				driver.switchTo().window(windows);
			}
		}

	}

	// Set Required FormValues
	@Test
	public void setFormValues() throws Exception {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "\\screenshot\\Courses\\BusinessValid\\udemyForm1.png";
		// Now we take a screenshot
		FileUtils.copyFile(scrFile, new File(path));

		// Logging the action
		ex.screenShotLog("Snapshot:Udemy Demo Form Opened ", path);

		String[] feedData = InputFromExcel.businessValidInput();

		ex.actionLog("Enter the values in form");

		wait.waitImplicit(driver);

		driver.findElement(By.id(config.getProperty("fname"))).sendKeys(feedData[0]);
		driver.findElement(By.xpath(config.getProperty("lname"))).sendKeys(feedData[1]);
		driver.findElement(By.cssSelector(config.getProperty("email"))).sendKeys(feedData[2]);
		driver.findElement(By.cssSelector(config.getProperty("phone"))).sendKeys(feedData[3]);
		driver.findElement(By.cssSelector(config.getProperty("company"))).sendKeys(feedData[4]);
		driver.findElement(By.cssSelector(config.getProperty("title"))).sendKeys(feedData[5]);

		// Scroll Down the page 500 pixel vertically
		JavascriptExecutor jse2 = (JavascriptExecutor) driver;
		jse2.executeScript("scroll(0,500)");

		// Select Company Size from dropdown as "I'm a contractor / freelancer"
		WebElement ele = driver.findElement(By.cssSelector(config.getProperty("csize")));
		ele.click();

		wait.waitImplicit(driver);

		Select select1 = new Select(ele);
		select1.selectByValue("I'm a contractor / freelancer");

		// Select "Just myself" from the dropdown
		WebElement ele2 = driver.findElement(By.cssSelector(config.getProperty("myself")));
		ele2.click();

		wait.waitImplicit(driver);

		select1 = new Select(ele2);
		select1.selectByValue("Just myself");

		// Add Training Requirements (If Any)
		driver.findElement(By.cssSelector(config.getProperty("trainingReq"))).sendKeys(feedData[6]);

		wait.waitImplicit(driver);

		ex.actionLog("Form Values Filled");

		// Click on "Get In Touch" Button
		driver.findElement(By.cssSelector(config.getProperty("submit"))).click();

		wait.waitImplicit(driver);
		wait.waitImplicit(driver);
		wait.waitImplicit(driver);
		
		ex.actionLog("Submitted the form");
		
		scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		path = System.getProperty("user.dir") + "\\screenshot\\Courses\\BusinessValid\\SuccessPage.png";
		// Now we take a screenshot
		FileUtils.copyFile(scrFile, new File(path));

		// Logging the action
		ex.screenShotLog("Snapshot:Success Page", path);

		wait.waitImplicit(driver);
		
		ex.completeTest();
		
	}
}