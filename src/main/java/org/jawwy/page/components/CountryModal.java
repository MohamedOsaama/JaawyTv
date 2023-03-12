package org.jawwy.page.components;

import org.jawwy.actions.Actions;
import org.jawwy.page.SubscriptionPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**This file defines the CountryModal class,
 * <P> which represents the modal that appears when the user clicks the country button on the main header. It contains methods
 * to select a country from the available options (Kuwait, Saudi Arabia, and Bahrain). <P/> * The class uses an Actions object to interact with the web elements
 */
public class CountryModal {
    WebDriver driver;
    Actions actions;
    private final By COUNTRY_MODAL = By.id("country-selct");
    private final By KUWAIT_LOCATOR = By.id("kw");
    private final By SAUDI_LOCATOR = By.id("sa");
    private final By BAHRAIN_LOCATOR = By.id("bh");

    /**
     * Creates a new instance of the `CountryModal` class.
     *
     * @param driver the WebDriver object used to interact with the web page
     */
    public CountryModal(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
    }

    /**
     * Selects a country from the country modal.
     *
     * @param country the name of the country to select (valid values are "kuwait", "saudi", and "Bahrain")
     * @return a new instance of the `SubscriptionPage` class
     */
    public SubscriptionPage select(String country) {
        actions.moveToElement(COUNTRY_MODAL);
        switch (country) {
            case "kuwait": {
                actions.click(KUWAIT_LOCATOR);
                break;
            }
            case "saudi": {
                actions.click(SAUDI_LOCATOR);
                break;
            }
            case "Bahrain": {
                actions.click(BAHRAIN_LOCATOR);
                break;
            }
            default: {
                System.out.println("Invalid country name provided!");
            }
        }
        return new SubscriptionPage(driver);
    }
}
