package berichtenbox;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by buiten.r on 17-02-2016.
 */
public class LoginPage_MijnOverheid
{
    protected static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(LoginPage_MijnOverheid.class);

    private WebDriver driver;

    private NieuwAfnemersPage_MO nieuweafnemers;

    @FindBy(className = "actions__left--button")
    private WebElement loginButton;

    @FindBy(id = "authentication_digid_username")
    private WebElement usernameTextBox;

    @FindBy(id = "authentication_wachtwoord")
    private WebElement passwordTextBox;

    public LoginPage_MijnOverheid(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

     public Boolean login(Long bsn) {

         String username = "";
         String password = "";

         if (Long.compare(bsn, 900071321) == 0) {
             username = "Vervoer03";
             password = "E=0&Tp04";
         } else if (Long.compare(bsn, 900071576) == 0) {
             username = "TkpCapTest2";
             password = "6J!sgdZh";
         } else if (Long.compare(bsn, 900071588) == 0) {
             username = "TkpCapTest3";
             password = "RG0@pl%r";
         } else if (Long.compare(bsn, 900078054) == 0) {
             username = "KPNp05";
             password = "Pensioen005!";
         }

        try {

            if (!username.isEmpty() && !password.isEmpty()){
                usernameTextBox.sendKeys(username);
                passwordTextBox.sendKeys(password);
                if (loginButton.isDisplayed()) {
                    loginButton.click();
                    Thread.sleep(5000);
                } else {
                    return false;
                }

                waitForPageToLoad();

                NieuwAfnemersPage_MO page = new NieuwAfnemersPage_MO(driver);
                if (page.wordtPaginaGetoond())
                {
                    page.gaAkkoord();
                }

            } else {
                log.error("Kan username en password niet bepalen voor bsn " + bsn);
                return false;
            }

            return true;
        }catch (Exception ex)
        {
            log.error("Kan username en password niet invullen." + ex.getMessage() + " " + ex.getCause());
            return false;
        }

    }

    public void waitForPageToLoad() {
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return (((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
            }
        });//Here DEFAULT_WAIT_TIME is a integer correspond to wait time in seconds
    }
}
