package org.jawwy.page.componentes;

import org.jawwy.actions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainHeader {

    WebDriver driver;
    Actions actions;
    private final By COUNTRY_BTN = By.className("country-current");


    public MainHeader(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
    }

    public CountryModal ChangeCountry() {
        actions.click(COUNTRY_BTN);
        return new CountryModal(driver);

    }
}
