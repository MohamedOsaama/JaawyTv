

package org.jawwy.actions;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/**
 * The Actions class provides methods for interacting with the WebDriver, such as
 * clicking on an element, hovering over an element, and checking if an element is displayed.
 *
 * @author [Mohammed Osama]
 * @version 1.0
 * @since [12/3/2023]
 */
public class Actions {

    /**
     * Constructor for the Actions class that sets the WebDriver
     *
     * @param driver The WebDriver to use
     */
    public Actions(WebDriver driver) {
        Actions.driver = driver;
    }


    /**
     * The driver used to interact with the website
     */
    private static WebDriver driver;

    /**
     * The element being interacted with
     */
    private WebElement element;

    /**
     * The list of elements being interacted with
     */
    private List<WebElement> elements;

    /**
     * Navigates to the specified URL
     *
     * @param url The URL to navigate to
     * @return The Actions object
     */
    public Actions getPage(String url) {
        driver.get(url);
        return this;
    }

    /**
     * Moves the mouse to the specified element
     *
     * @param locator The locator of the element to move the mouse to
     * @return The Actions object
     */
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

    /**
     * Clicks on the specified element
     *
     * @param locator The locator of the element to click on
     * @return The Actions object
     */
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

    /**
     * Checks if the specified element is displayed
     *
     * @param locator The locator of the element to check
     * @return True if the element is displayed, false otherwise
     */
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

    /**
     * Gets the text of an element from a list of elements
     *
     * @param locator The locator of the list of elements
     * @param index   The index of the element to get the text of
     * @return The text of the specified element
     */
    public String getElementTextFromElementsList(By locator, int index) {
        elements = driver.findElements(locator);
        element = elements.get(index);
        return element.getText();
    }
}
