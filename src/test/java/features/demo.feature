#language:nl

  Functionaliteit: : Controleer meerdere berichten

    @GEVALIDEERD
    Abstract Scenario: 1. Login op mijnoverheid.nl en controleer berichten

      Gegeven mijnoverheid is opgestart
      Als gebruiker met bsn "900078054" is ingelogd met digid
      Dan Controleer of bericht "<titel>" van "<verzender>" op mijnoverheid is ontvangen op "<ontvangstdatum>"

      Voorbeelden:
      | titel                      | verzender            | ontvangstdatum    |
      | upo                        | douwe egberts        | 8 apr.            |
      | upo                        | landbouw             | 28 jun.           |