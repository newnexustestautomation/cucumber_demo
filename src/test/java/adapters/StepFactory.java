package adapters;

import cucumber.api.Scenario;
import org.apache.log4j.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by buiten.r on 24-11-2015.
 */

public class StepFactory
{
    protected static Logger log = Logger.getLogger(StepFactory.class);
    protected static WebDriver driver;

    public StepFactory()
    {

    }

    public void teardownTest(Scenario scenario)
    {
        destroyDriver(scenario);
    }

    protected void initDriver()
    {

        //System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        // DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        //capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        //capabilities.setCapability("requireWindowFocus", true);

        if (driver == null  ) {
            driver = new SafariDriver();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
        }

    }

    public WebDriver getDriver()
    {
        return driver;
    }

    protected void destroyDriver(Scenario scenario)
    {
        if (driver != null) {

            try {
                if (scenario.isFailed()) {
                    final byte[] screenshot = ((TakesScreenshot) driver)
                            .getScreenshotAs(OutputType.BYTES);
                    scenario.embed(screenshot, "image/png");
                }
            } finally {
                driver.quit();
            }
        }

        driver = null;
    }
}
