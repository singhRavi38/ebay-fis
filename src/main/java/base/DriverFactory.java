package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.CommonUtils;

public class DriverFactory {
    static ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    public static void initiateDriver() throws Exception {
        String requiredBrowser = CommonUtils.getProperty("browser");
        switch (requiredBrowser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver",".\\src\\test\\resources\\chromedriver.exe");
                DRIVER.set(new ChromeDriver());
                break;
            case "headless":
                DRIVER.set(new ChromeDriver());
                break;
            case "edge":
                DRIVER.set(new EdgeDriver());
                break;
            case "firefox":
                DRIVER.set(new FirefoxDriver());
                break;
            default:
                throw new Exception("Invalid browser name provided, Please provide a valid browser name");
        }
    }

    public static WebDriver getDriver() {
        return DRIVER.get();
    }
}