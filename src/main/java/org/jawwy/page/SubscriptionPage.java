package org.jawwy.page;

import org.jawwy.actions.Actions;
import org.jawwy.page.componentes.MainHeader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SubscriptionPage {

    MainHeader mainHeader;
    WebDriver driver;
    Actions actions;

    private final By PLAN_NAMES = By.xpath("*//strong[@class='plan-title']");
    private final By PLAN_PRICES = By.xpath("//div[@class='price']");


    public SubscriptionPage(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        mainHeader = new MainHeader(driver);
    }

    public String getPackageNamesDisplayed(int index) {
        return actions.getElementTextFromElementsList(PLAN_NAMES, index);
    }

    public String getPackagePriceDisplayed(int index) {
        return actions.getElementTextFromElementsList(PLAN_PRICES, index);
    }
}


