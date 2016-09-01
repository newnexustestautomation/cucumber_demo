package adapters;

import berichtenbox.*;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.nl.Als;
import cucumber.api.java.nl.Dan;
import cucumber.api.java.nl.En;
import cucumber.api.java.nl.Gegeven;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;


/**
 * Created by buiten.r on 09-05-2016.
 */

public class MijnOverheidSteps  extends StepFactory{

    @Before
    public void Start() {
        initDriver();
    }

    @After
    public void Stop(Scenario scenario) {
        //Assert.assertTrue("Kan niet uitloggen.", new MainPage_MO(driver).loguitPagina());
        teardownTest(scenario);
    }

    @Gegeven("^Testcase \"([^\"]*)\" met gebruiker \"([^\"]*)\"$")
    public void Testcase_met_gebruiker(String arg1, String arg2) throws Throwable {
        // Express the Regexp above with the code you wish you had
    }

    @Gegeven("^mijnoverheid is opgestart$")
    public void mijnoverheid_is_opgestart() throws Throwable {

        // Express the Regexp above with the code you wish you had
        String url = "http://toets.mijnoverheid.nl";
        driver.get(url);
        driver.manage().window().maximize();
        Assert.assertTrue("Toets.mijnoverheid.nl kan niet worden opgestart", new StartPage_MijnOverheid(driver).wordtPaginaGetoond());
    }

    @En("^Controleer of bericht \"([^\"]*)\" op mijnoverheid is ontvangen op \"([^\"]*)\"$")
    public void Controleer_of_bericht_op_mijnoverheid_is_ontvangen_op(String arg1, String arg2) throws Throwable {

        // Express the Regexp above with the code you wish you had
        Assert.assertTrue("Kan berichtenbox pagina niet openen", new MainPage_MO(driver).openBerichtenboxPagina());
        Assert.assertTrue("Kan bericht niet vinden", new BerichtenBoxPage(driver).zoekBericht("","Uniform Pensioen Overzicht",""));

    }

    @Als("^gebruiker met bsn \"([^\"]*)\" is ingelogd met digid$")
    public void gebruiker_met_bsn_is_ingelogd_met_digid(Long bsn) throws Throwable {

        // Express the Regexp above with the code you wish you had
        Assert.assertTrue("Kan niet inloggen met digid.",new StartPage_MijnOverheid(driver).openLoginPagina());
        Assert.assertTrue("Kan niet inloggen.", new LoginPage_MijnOverheid(driver).login(bsn));
        Assert.assertTrue("Is niet ingelogd.", new MainPage_MO(driver).wordtPaginaGetoond());
    }

    @Dan("^Controleer of bericht \"([^\"]*)\" van \"([^\"]*)\" op mijnoverheid is ontvangen op \"([^\"]*)\"$")
    public void Controleer_of_bericht_van_op_mijnoverheid_is_ontvangen_op(String titel, String afzender, String ontvangstdatum) throws Throwable {
        // Express the Regexp above with the code you wish you had
        Assert.assertTrue("Kan berichtenbox pagina niet openen.", new MainPage_MO(driver).openBerichtenboxPagina());
        Assert.assertTrue("Kan bericht niet vinden.", new BerichtenBoxPage(driver).zoekBericht(titel.toLowerCase(),afzender.toLowerCase(),ontvangstdatum.toLowerCase()));
    }

    @En("^meld gebruiker af$")
    public void meld_gebruiker_af() throws Throwable {
        // Express the Regexp above with the code you wish you had

    }

}
