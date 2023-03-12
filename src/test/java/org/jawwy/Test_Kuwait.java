package org.jawwy;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.jawwy.util.FilePath.*;

public class Test_Kuwait extends BaseTest {


    /**
     * Kuwait Tests
     */
    @BeforeTest
    public void BeforeTest() {

        eyes.setBatch("Kuwait Tests");
        eyes.openEyes(driver, "Kuwait  Tests");
        mainHeader.changeCountry();
        eyes.checkWindow("Before Change country", false);
        countryModal.select("kuwait");
    }

    @Test( description = "Validate Full Screen For Kuwait")
    public void testKuwaitVisuals() {
        eyes.checkWindow("Kuwait full screen", true);
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
        Assert.assertEquals(subscriptionPage.getPackagePriceDisplayed(0), KUWAIT_LITE_PRICE);
        Assert.assertEquals(subscriptionPage.getPackagePriceDisplayed(1), KUWAIT_CLASSIC_PRICE);
        Assert.assertEquals(subscriptionPage.getPackagePriceDisplayed(2), KUWAIT_PREMIUM_PRICE);
    }



}
