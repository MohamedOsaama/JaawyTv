package org.jawwy;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.management.openmbean.KeyAlreadyExistsException;

import static org.jawwy.util.FilePath.*;


public class Test_SaudiArabia extends BaseTest {


    /**
     * SA Tests
     */
    @BeforeTest
    public void BeforeTest() {
        eyes.setBatch("Saudi Arabia Tests");
        eyes.openEyes(driver, "Saudi Arabia  Tests");
    }

    @Test(priority = 0, description = "Validate Full Screen For Saudi")
    public void testSaudiVisuals() {
        eyes.checkWindow("Saudi full screen", true);
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
        Assert.assertEquals(subscriptionPage.getPackagePriceDisplayed(0), SAUDI_LITE_PRICE);
        Assert.assertEquals(subscriptionPage.getPackagePriceDisplayed(1), SAUDI_CLASSIC_PRICE);
        Assert.assertEquals(subscriptionPage.getPackagePriceDisplayed(2), SAUDI_PREMIUM_PRICE);
    }


}

