package org.jawwy;

import org.jawwy.actions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.jawwy.page.SubscriptionPage;
import org.jawwy.page.components.CountryModal;
import org.jawwy.page.components.MainHeader;
import org.jawwy.util.EyesWrapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.BeforeSuite;


import static org.jawwy.util.FilePath.WEBSITE_URL;

/**
 * This class serves as the base class for all test classes in the Jawwy test suite.
 * It sets up the WebDriver and initializes the page objects initializes instances of the MainHeader, CountryModal, and SubscriptionPage classes.
 * <P> It also creates an EyesWrapper object for visual testing using the Applitools Eyes SDK.</P>
 */
public class BaseTest {

    WebDriver driver;
    Actions actions;

    protected MainHeader mainHeader;
    protected CountryModal countryModal;
    protected SubscriptionPage subscriptionPage;
    protected EyesWrapper eyes;


    /**
     * This method is run once before all the test cases in the suite.
     * It sets up the Edge driver, disables geolocation and notifications, initializes the page objects,
     * maximizes the window, navigates to the website URL and initializes the Eyes wrapper for visual testing.
     */
    @BeforeSuite
    public void before() {
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        options.addArguments("disable-geolocation");
        options.addArguments("disable-notifications");
        driver = new EdgeDriver();
        actions = new Actions(driver);
        mainHeader = new MainHeader(driver);
        countryModal = new CountryModal(driver);
        subscriptionPage = new SubscriptionPage(driver);
        driver.manage().window().maximize();
        actions.getPage(WEBSITE_URL);
        eyes = new EyesWrapper(driver, "Edge");
    }


}
