
package org.jawwy.page;

import org.jawwy.actions.Actions;
import org.jawwy.page.components.MainHeader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * This class represents the Subscription page of the website.
 * It contains methods to get the names and prices of the displayed subscription packages.
 */

public class SubscriptionPage {
    MainHeader mainHeader;
    WebDriver driver;
    Actions actions;

    /**
     * XPath selectors for the plan names and prices on the Subscription page.
     */
    private final By PLAN_NAMES = By.xpath("*//strong[@class='plan-title']");
    private final By PLAN_PRICES = By.xpath("//div[@class='price']");

    /**
     * Constructs a new SubscriptionPage object.
     *
     * @param driver the WebDriver instance to use for interacting with the page
     */
    public SubscriptionPage(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        mainHeader = new MainHeader(driver);
    }

    /**
     * Gets the name of the subscription package displayed at the specified index.
     *
     * @param index the index of the package to get the name for
     * @return a string representing the name of the package
     */
    public String getPackageNamesDisplayed(int index) {
        return actions.getElementTextFromElementsList(PLAN_NAMES, index);
    }

    /**
     * Gets the price of the subscription package displayed at the specified index.
     *
     * @param index the index of the package to get the price for
     * @return a string representing the price of the package
     */
    public String getPackagePriceDisplayed(int index) {
        return actions.getElementTextFromElementsList(PLAN_PRICES, index);
    }
}