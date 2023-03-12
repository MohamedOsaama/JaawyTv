package org.jawwy.page.components;

import org.jawwy.actions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * This class represents the main header component of the subscription page.
 * It provides functionality to change the country by clicking the country button.
 */
public class MainHeader {

    /**
     * The WebDriver object used to interact with the web browser.
     */
    private WebDriver driver;

    /**
     * The Actions object used to perform various actions on the web page.
     */
    private Actions actions;

    /**
     * The By locator for the country button.
     */
    private final By COUNTRY_BTN = By.className("country-current");

    /**
     * Constructor for the MainHeader class.
     *
     * @param driver the WebDriver object to use.
     */
    public MainHeader(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
    }

    /**
     * Clicks the country button to open the country modal and returns a new instance of the CountryModal class.
     *
     * @return a new instance of the CountryModal class.
     */
    public CountryModal changeCountry() {
        actions.click(COUNTRY_BTN);
        return new CountryModal(driver);
    }
}
