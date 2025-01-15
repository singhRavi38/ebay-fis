package utils;

import base.DriverFactory;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

@Slf4j
public class CommonUtils {

    @SneakyThrows
    public static String getProperty(String propertyName) {
        FileInputStream input = new FileInputStream(".\\src\\test\\resources\\config.properties");
        Properties prop = new Properties();
        prop.load(input);
        return prop.getProperty(propertyName);
    }

    public static void waitForPresenceOfElement(String xpath) {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(60));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    public static void switchToNewlyOpenedWindow() {
        String parent = DriverFactory.getDriver().getWindowHandle();
        for (String windows : DriverFactory.getDriver().getWindowHandles()) {
            if (!windows.equals(parent))
                DriverFactory.getDriver().switchTo().window(windows);
        }
    }

    public static Response callRestInterfaceGet(String endpointFullURL) {
        log.debug("Calling REST interface using GET");

        RequestSpecification request = RestAssured.given();
        request.accept("application/json, text/plain, */*")
                .log().uri()
                .log().parameters();
        return request.
                when().
                get(endpointFullURL);
    }
}
