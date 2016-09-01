package berichtenbox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by buiten.r on 17-02-2016.
 */
public class NieuwAfnemersPage_MO {

    protected static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(NieuwAfnemersPage_MO.class);

    private WebDriver driver;

    @FindBy(className = "page__body__content content content--nieuwe-organisaties")
    private WebElement intro;

    @FindBy(id = "acceptatie_afnemers_accept_afnemers")
    private WebElement akkoord;

    @FindBy(name = "next")
    private WebElement gaVerder;

    NieuwAfnemersPage_MO(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Boolean wordtPaginaGetoond()
    {
        String pageText;

        pageText = driver.findElement(By.tagName("body")).getText();

        if (pageText.toLowerCase().contains("volgende organisaties aangesloten"))
        {
            return true;
        }

        return false;
    }

    public boolean gaAkkoord()
    {
        akkoord.click();
        gaVerder.click();
        return true;
    }
}
