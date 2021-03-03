package tests;

import functionalities.*;
import utilities.*;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

@Test
public class CoursesValid {
	// Declaration of needed variables
	public static WebDriver driver;
	public static Waiting wait = new Waiting();

	// Creating an object of class extent report
	ExtentReport ex = new ExtentReport("ReportValid.html");

	// Create properties reference to read from properties file
	Properties p = new Properties();

	// Constructor to initialize reader object with our properties file and load it
	public CoursesValid() throws Exception {
		FileReader reader = new FileReader("project.properties");
		p.load(reader);
		
		ex.createTest("Business Valid");
	}

	@BeforeSuite
	public void setDriver() throws Exception {
		// driver initialization
		MainDriver obj = new MainDriver();
		driver = obj.mainDriver(ex);

		// Logging the action
		ex.actionLog("Browser Launched");

		// Letting the program to go to sleep for 2 seconds so that the page can load
		// and we can take screenshot.
		wait.waitImplicit(driver);

		// Creating a screenshot driver and storing in scrFile.
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "\\screenshot\\Courses\\HomePage.png";

		// Now we take a screenshot
		FileUtils.copyFile(scrFile, new File(path));

		// Logging the screenshot
		ex.screenShotLog("Snapshot: Home Page", path);
	}

	@Test(priority=1)
	// To Retrieve Udemy Demo Form
	public void business() throws Exception {
		
		BusinessValid b = new BusinessValid(driver, ex);
		
		// Method to click on Udemy Logo
		b.clickLogo();
		
		// Method to Provide FormValues to Udemy Demo Form
		b.setFormValues();
		
	}

	@AfterSuite
	public void closeTheBrowser() {
		// Close the browser
		driver.quit();

		// Logging the action
		ex.actionLog("Browser closed");

		// writing everything to document
		ex.completeTest();
		ex.finishReport();
	}
}
