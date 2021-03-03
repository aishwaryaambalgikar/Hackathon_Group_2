package utilities;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

@Test
public class ExtentReport {

	String file = System.getProperty("user.dir") + "\\Extented_Report\\";
	String extentReportImage;

	ExtentTest extentTest;
	// Create object of extent report and specify the report file path.
	ExtentReports extent;

	public ExtentReport(String filename) {
		String extentReportFile = file + filename;

		// Create object of extent report and specify the report file path.
		extent = new ExtentReports(extentReportFile, false);

		// Start the test using the ExtentTest class object.
		// ExtentTest extentTest = extent.startTest("Identifying Courses", "Hackathon");
	}

	public void createTest(String testName) {
		extentTest = extent.startTest(testName, "Hackathon");
	}

	public void actionLog(String action) {
		// Logging the action
		extentTest.log(LogStatus.INFO, action);
	}

	public void screenShotLog(String action, String path) {
		// Logging the screenshot
		extentTest.log(LogStatus.INFO, action + extentTest.addScreenCapture(path));
	}

	public void completeTest() {

		// close report
		extent.endTest(extentTest);

	}

	public void finishReport() {
		extent.flush();
	}
}