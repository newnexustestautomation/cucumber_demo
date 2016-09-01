package berichtenbox;

import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by buiten.r on 17-02-2016.
 */
public class MainPage_MO {

    protected static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(MainPage_MO.class);

    private WebDriver driver;

    @FindBy(className = "page__header__banner__page_title")
    private WebElement idText;

    @FindBy(linkText = "Berichtenbox")
    private WebElement berichtenboxButton;

    @FindBy(linkText = "Lopende zaken")
    private WebElement lopendezakenButton;

    @FindBy(linkText = "Uitloggen")
    private WebElement uitloggenButton;

    @FindBy(linkText = "Persoonlijke gegevens")
    private WebElement persoonlijkegegevensButton;

    @FindBy(linkText = "Home")
    private WebElement homeButton;

    public MainPage_MO(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Boolean wordtPaginaGetoond()
    {
        String pageText;
        pageText = driver.findElement(By.tagName("body")).getText();

        if (persoonlijkegegevensButton.isDisplayed()) {
            return true;
        }
        else {
            return false;
        }
    }

    public Boolean openBerichtenboxPagina()
    {
        berichtenboxButton.click();

        return true;
    }

    public Boolean loguitPagina()
    {
        uitloggenButton.click();
        try {
            Thread.sleep(2000);
        }catch (InterruptedException ex)
        {
            return false;
        }
        return true;
    }
}
