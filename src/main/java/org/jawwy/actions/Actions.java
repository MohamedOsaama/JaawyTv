package org.jawwy.actions;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class Actions {


    public Actions(WebDriver driver) {
        Actions.driver = driver;
    }


    private static WebDriver driver;

    private WebElement element;
    private List<WebElement> elements;

    public Actions getPage(String url) {
        driver.get(url);
        return this;
    }

    public Actions moveToElement(By locator) {


        try {
            if (checkIfElementDisplayed(locator)) {
                org.openqa.selenium.interactions.Actions actions = new org.openqa.selenium.interactions.Actions(driver);
                actions.moveToElement(driver.findElement(locator)).perform();
                System.out.println("Mouse is hovering on " + locator.getClass().getName() + " in the screen");

            }
        } catch (NoSuchElementException e) {
            System.out.println("Element not found , Driver cannot locate the element");
            e.printStackTrace();
        }

        return this;
    }

    public Actions click(By locator) {

        try {
            if (checkIfElementDisplayed(locator)) {
                System.out.println(element.getText() + "  is clicked ...");
                element.click();
            }


        } catch (ElementClickInterceptedException e) {
            e.printStackTrace();
            System.out.println(locator + " is not displayed");
        }
        return this;
    }

    public boolean checkIfElementDisplayed(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            element = driver.findElement(locator);
            System.out.println(element + "  displayed");
            return true;
        } catch (Exception exception) {
            System.out.println(element + " is not displayed");
        }
        return false;
    }



    public String getElementTextFromElementsList(By locator, int index) {
        elements = driver.findElements(locator);
        element = elements.get(index);
        return element.getText();

    }

}
