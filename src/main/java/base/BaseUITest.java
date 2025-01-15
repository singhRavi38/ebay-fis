package base;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.CommonUtils;

@Slf4j
public class BaseUITest {

    @BeforeTest
    public void init() throws Exception {
        if (DriverFactory.getDriver() == null) {
            log.info("--- No Driver Exists ---");
            log.info("--- Creating New Driver Instance ---");
            DriverFactory.initiateDriver();
        }
        log.info("--- Opening application URL ---");
        DriverFactory.getDriver().get(CommonUtils.getProperty("appurl"));
    }

    @AfterTest
    public void tearOut() {
        DriverFactory.getDriver().quit();
        log.info("--- Tearing out the Driver ---");
    }
}
