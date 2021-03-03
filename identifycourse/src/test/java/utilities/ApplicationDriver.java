package utilities;

import java.io.FileReader;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ApplicationDriver {
    // Create properties reference to read from properties file
    Properties p = new Properties();

    // Constructor to initialize reader object with our properties file and load it
    public ApplicationDriver() throws Exception {
        FileReader reader = new FileReader("project.properties");
        p.load(reader);
    }

    // Method to invoke Chrome driver
    public WebDriver ChromeDriver() throws Exception {
        WebDriver driver;

        DesiredCapabilities cap = new DesiredCapabilities();
        ChromeOptions options = new ChromeOptions();
        options.merge(cap);
        String huburl = "http://localhost:4444/wd/hub";
        driver = new RemoteWebDriver(new URL(huburl), options);

        // Get the value of baseURL by driver to open the website/web application
        driver.get(p.getProperty("baseUrl"));

        // Maximize the opened window
        driver.manage().window().maximize();
        return driver;
    }

    // Method to invoke Firefox driver
    public WebDriver FirefoxDriver() throws Exception {
        WebDriver driver;
        
        DesiredCapabilities cap = new DesiredCapabilities();
        FirefoxOptions options = new FirefoxOptions();
        options.merge(cap);
        String huburl = "http://localhost:4444/wd/hub";
        driver = new RemoteWebDriver(new URL(huburl), options);

        // Get the value of baseURL by driver to open the website/web application
        driver.get(p.getProperty("baseUrl"));

        // Maximize the opened window
        driver.manage().window().maximize();
        return driver;
    }

    public WebDriver InternetExplorer() throws Exception {
        WebDriver driver;

        DesiredCapabilities cap = new DesiredCapabilities();
        InternetExplorerOptions options = new InternetExplorerOptions();
        options.merge(cap);
        String huburl = "http://localhost:4444/wd/hub";
        driver = new RemoteWebDriver(new URL(huburl), options);
     
        // Get the value of baseURL by driver to open the website/web application
        driver.get(p.getProperty("baseUrl"));

        // Maximize the opened window
        driver.manage().window().maximize();
        return driver;
    }
}