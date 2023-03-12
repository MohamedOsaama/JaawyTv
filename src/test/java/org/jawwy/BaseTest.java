package org.jawwy;

import org.jawwy.actions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.jawwy.page.SubscriptionPage;
import org.jawwy.page.componentes.CountryModal;
import org.jawwy.page.componentes.MainHeader;
import org.jawwy.util.EyesWrapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.BeforeSuite;


import static org.jawwy.util.FilePath.websiteUrl;

public class BaseTest {

    WebDriver driver;
    Actions actions;

    protected MainHeader mainHeader;
    protected CountryModal countryModal;
    protected SubscriptionPage subscriptionPage;
    protected EyesWrapper eyes;

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
        actions.getPage(websiteUrl);
        eyes = new EyesWrapper(driver, "Edge");
    }


}
