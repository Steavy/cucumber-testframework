#language: nl
  Functionaliteit: Inloggen
  Als PO van Adactin wil ik kunnen inloggen op de Adactin website

#  Achtergrond: inlogpagina is geladen


  @Smoketest
  Scenario: Succesvol inloggen
    Gegeven ik ben op de adactin inlogpagina
    Als ik inlog met user Cucumbertestuser en met ww cucumbertestuser
    Dan moet ik succesvol ingelogd zijn met user Cucumbertestuser

  @Regressie
  Scenario: Fout inloggen
    Gegeven ik ben op de adactin inlogpagina
    Als ik inlog met user Cucumbertestuser en met ww tester
    Dan krijg ik een melding dat ik niet mag inloggen

#  Scenario: Met onjuist inloggen krijg je foutmelding
#    Gegeven ik ben op de inlogpagina "testengeautomatiseerd.nl/cursus" ben
#    Als ik inlog met user {test} en met ww {test}
#    Dan moet ik een foutmelding krijgen dat ik niet kan worden aangemeld
#    En dat mijn gebruikersnaam en/of wachtwoord onjuist is
#
#  Scenario Outline: Met juiste en onjuiste gegevens inloggen krijg je verschillende resultaten
#    Gegeven ik ben op de inlogpagina van de DAT site
#    Als ik inlog met user <gebruiker> en met ww <wachtwoord>
#    Dan moet ik naar de <pagina> page gaan
#  Voorbeelden:
#  |gebruiker | wachtwoord | pagina |
#  |cursus    | tester     | DAT    |
#  |test      | test       | Inlog  |