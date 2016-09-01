package berichtenbox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by buiten.r on 16-02-2016.
 */
public class StartPage_MijnOverheid {

    protected static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(StartPage_MijnOverheid.class);

    private WebDriver driver;

    @FindBy(id = "tabs-mijnoverheid")
    private WebElement idText;

    @FindBy(linkText="Inloggen")
    private WebElement inlogButton;

    public StartPage_MijnOverheid(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Boolean wordtPaginaGetoond()
    {
        String pageText;
        pageText = driver.findElement(By.tagName("body")).getText();

        if (pageText.toLowerCase().contains("ervaar het gemak")){
            return true;
        }
        else {
            return false;
        }
    }



    public Boolean openLoginPagina()
    {
        if (inlogButton.isDisplayed()) {
            inlogButton.click();
            waitForPageToLoad();
            return true;
        } else {
            return false;
        }

    }

    public void waitForPageToLoad() {
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return (((org.openqa.selenium.JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
            }
        });//Here DEFAULT_WAIT_TIME is a integer correspond to wait time in seconds
    }
}
