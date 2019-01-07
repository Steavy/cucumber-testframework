package com.cucumber.stepdefinitions;

import com.codeborne.selenide.Configuration;
import com.cucumber.helper.PropertyReader;
import cucumber.api.java.nl.Als;
import cucumber.api.java.nl.Dan;
import cucumber.api.java.nl.Gegeven;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginSteps {
    private PropertyReader propertyReader = new PropertyReader();
    private String browserName = propertyReader.getPropertyValue("browser.name");

    @Gegeven("^ik ben op de inlogpagina ben$")
    public void ikBenOpDeInlogpaginaBen() throws Throwable {
        Configuration.browser = browserName;
        open("http://www.testengeautomatiseerd.nl/cursus");
    }

    @Als("^ik inlog met user (.*) en met ww (.*)$")
    public void ikInlogMetUserCurusEnMetWwTester(String gebruiker, String wachtwoord) throws Throwable {
        $(byId("username")).setValue(gebruiker);
        $(byId("password")).setValue(wachtwoord).pressEnter();
    }

    @Dan("^moet ik naar de DAT homepage gaan$")
    public void moetIkNaarDeDATHomepageGaan() throws Throwable {
        $(byXpath("//li[@id='menu-item-1045']/a")).shouldHave(text("Blog"));
        $("img.site-logo").shouldBe(visible);
//        $(byXpath("//*[contains(text(), 'De Agile Testers - De beste Agile testers')]")).shouldHave(text("De Agile Testers - De beste Agile testers van Nederland"));
//        $("title").shouldHave(attribute("De Agile Testers - De beste Agile testers van Nederland"));
    }

    @Dan("^krijg ik een melding dat ik niet mag inloggen$")
    public void krijg_ik_een_melding_dat_ik_niet_mag_inloggen() throws Throwable {
        $(byXpath("//li[@id='menu-item-1045']/a")).shouldHave(text("Blog"));
    }
}