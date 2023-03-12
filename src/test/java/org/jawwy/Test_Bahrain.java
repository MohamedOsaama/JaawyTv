package org.jawwy;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.jawwy.util.FilePath.*;

public class Test_Bahrain extends BaseTest {


    /**
     * Bahrain Tests
     */
    @BeforeTest
    public void BeforeTest() {
        eyes.setBatch("Bahrain Tests");
        eyes.openEyes(driver, "Bahrain  Tests");
        mainHeader.changeCountry();
        eyes.checkWindow("Before Change country", false);
            countryModal.select("Bahrain");
    }

    @Test( description = "Validate Full Screen For Bahrain")
    public void testBahrainVisuals() {
        eyes.checkWindow("bahrain full screen", true);
        eyes.closeEyes();
    }

    @Test(priority = 1, description = "ValidateTypes")
    public void testTypes() {
        Assert.assertEquals(subscriptionPage.getPackageNamesDisplayed(0), LITE);
        Assert.assertEquals(subscriptionPage.getPackageNamesDisplayed(1), CLASSIC);
        Assert.assertEquals(subscriptionPage.getPackageNamesDisplayed(2), PREMIUM);
    }

    @Test(priority = 1, description = "Validate Prices and Currencies")
    public void testPrices() {
        Assert.assertEquals(subscriptionPage.getPackagePriceDisplayed(0), BAHRAIN_LITE_PRICE);
        Assert.assertEquals(subscriptionPage.getPackagePriceDisplayed(1), BAHRAIN_CLASSIC_PRICE);
        Assert.assertEquals(subscriptionPage.getPackagePriceDisplayed(2), BAHRAIN_PREMIUM_PRICE);
    }


}
