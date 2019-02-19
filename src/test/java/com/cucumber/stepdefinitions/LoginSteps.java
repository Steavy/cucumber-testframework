package com.cucumber.stepdefinitions;

import com.codeborne.selenide.Configuration;
import com.cucumber.helper.PropertyReader;
import cucumber.api.java.nl.Als;
import cucumber.api.java.nl.Dan;
import cucumber.api.java.nl.Gegeven;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginSteps {
    private PropertyReader propertyReader = new PropertyReader();
    private String browserName = propertyReader.getPropertyValue("browser.name");

    @Gegeven("^ik ben op de adactin inlogpagina$")
    public void ikBenOpDeAdactinInlogpagina() throws Throwable {
        Configuration.browser = browserName;
        open("http://adactin.com/HotelApp/");
    }

    @Als("^ik inlog met user (.*) en met ww (.*)$")
    public void ikInlogMetUserCurusEnMetWwTester(String gebruiker, String wachtwoord) throws Throwable {
        $(byId("username")).setValue(gebruiker);
        $(byId("password")).setValue(wachtwoord).pressEnter();
    }

    @Dan("^moet ik succesvol ingelogd zijn met user (.*)$")
    public void moetIkSuccesvolIngelogdZijn(String gebruiker) throws Throwable {
      //  $(byId("username_show")).shouldHave(text("Hello " + gebruiker + "!"));
        $(byXpath("//td[contains(@class, 'welcome_menu')]/a[1]")).shouldHave(text("Search Hotel"));
        $(byXpath("//input[@id='username_show']")).shouldHave(value("Hello " + gebruiker + "!"));
        $(byId("username_show")).shouldHave(value("Hello " + gebruiker + "!"));
        $(".logo").shouldBe(visible);
        $(".header_title > img").shouldBe(visible);
        $(".login_title").shouldHave(text("Search Hotel"));
       // $("title").shouldHave(attribute("AdactinIn.com - Search Hotel"));
    }

    @Dan("^krijg ik een melding dat ik niet mag inloggen$")
    public void krijg_ik_een_melding_dat_ik_niet_mag_inloggen() throws Throwable {
        $(".auth_error > b").shouldHave(text("Invalid Login details or Your Password might have expired."));
    }
}