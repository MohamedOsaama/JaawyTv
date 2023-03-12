package org.jawwy.page.componentes;

import org.jawwy.actions.Actions;
import org.jawwy.page.SubscriptionPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CountryModal {
    WebDriver driver;
    Actions actions;
    private final By COUNTRY_MODAL = By.id("country-selct");
    private final By kuwaitLocator = By.id("kw");
    private final By saudiLocator = By.id("sa");
    private final By bahrainLocator = By.id("bh");

    public CountryModal(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);

    }

    public SubscriptionPage select(String country) {
        actions.moveToElement(COUNTRY_MODAL);
        switch (country) {
            case "kuwait": {

                actions.click(kuwaitLocator);
                break;
            }
            case "saudi": {

                actions.click(saudiLocator);
                break;
            }
            case "Bahrain": {

                actions.click(bahrainLocator);
                break;
            }
            default: {
                System.out.println("Invalid country name provided!");
            }
        }
        return new SubscriptionPage(driver);


    }
}
