package berichtenbox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by buiten.r on 17-02-2016.
 */
public class BerichtenBoxPage {

    protected static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(BerichtenBoxPage.class);

    private WebDriver driver;
    private List<String> gefilterdeItems = new ArrayList<String>();

    @FindBy(name = "select_all")
    private WebElement selecteerAlle;

    @FindBy(className = "slats__list")
    private WebElement lijstmetBerichten;

    public BerichtenBoxPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wordtPaginaGetoond();
    }

   private Boolean wordtPaginaGetoond()
    {
        if (selecteerAlle.isDisplayed()) {
            if (filterBerichten()) {
                return true;
            }
        }
        return false;
    }

    private Boolean filterBerichten()
    {
        List<WebElement> items = lijstmetBerichten.findElements(By.tagName("li"));

        for (WebElement item : items)
        {
           if (item.getText().contains("Selecteer")) {
               gefilterdeItems.add(item.getText().toLowerCase().replace("\n","|"));
           }
        }

        return true;
    }

    public Boolean zoekBericht(String afzender, String titel, String ontvangstdatum)
    {
        for (String item : gefilterdeItems)
        {
            if (item.contains(afzender) && item.contains(titel) && item.contains(ontvangstdatum))
                return true;
        }

        return false;

    }


}
