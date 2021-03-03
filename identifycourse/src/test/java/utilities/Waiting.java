package utilities;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;

public class Waiting {

	@SuppressWarnings("deprecation")
	public void waitImplicit(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
}