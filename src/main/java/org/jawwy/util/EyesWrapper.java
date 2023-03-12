package org.jawwy.util;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.EyesRunner;
import com.applitools.eyes.MatchLevel;
import com.applitools.eyes.selenium.*;
import com.applitools.eyes.selenium.fluent.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Calendar;

import static org.jawwy.util.FilePath.APPLITOOLS_API_KEY;

public class EyesWrapper {
    Configuration configuration;

    Calendar startedAt;

    EyesRunner runner;
    Eyes eyes;
    WebDriver driver;

    String appName;

    final int waitBeforeScreenshots = 5000;


    /**
     * Method To open the eyes
     * @ param, appName, going to be website for now
     * @ param, driver,  web driver instance
     */
    public EyesWrapper(WebDriver driver, String appName) {

        this.driver = driver;
        this.appName = appName;
        runner = new ClassicRunner();
        eyes = new Eyes(runner);
        configuration = new Configuration();
        startedAt = Calendar.getInstance();

        setConfig();
        eyes.setConfiguration(configuration);


    }


    /**
     * Method To open the eyes
     *
     * @see EyesWrapper
     * .setApiKey()
     * <p/>apiKey The Applitools API key to use for authentication.
     * .setServerUrl()
     * <p/>serverUrl The URL of the Applitools server to use
     * .setHostApp()
     * .setBatch()
     * .setTestName()
     * .setMatchLevel()
     * .setWaitBeforeScreenshots(waitBeforeScreenshots);
     */
    public EyesWrapper setConfig() {

        configuration.setApiKey(APPLITOOLS_API_KEY).setHostApp(appName).setMatchLevel(MatchLevel.LAYOUT2).setWaitBeforeScreenshots(waitBeforeScreenshots).setStitchMode(StitchMode.CSS);

        return this;

    }


    /**
     * Method To open the eyes
     * @ param, driver ,current thread driver instance
     */

    public EyesWrapper openEyes(WebDriver driver, String testName) {

        eyes.open(driver, appName, testName);
        return this;
    }

    /**
     * @implNote Tag name should be elaborative
     * @ param, tagName, screen name
     * @ param, full screenshot or no
     */
    public void checkWindow(String tagName, boolean fully) {

        eyes.check(Target.window().fully(fully).withName(tagName));

    }


    /**
     * Set batch information for the test run.
     *
     * @param testName The name of the test to run.
     * @return The current instance of the wrapper.
     */
    public EyesWrapper setBatch(String testName) {
        // Create a batch info object with the given test name.
        BatchInfo batchInfo = new BatchInfo(testName);
        // Set the "notify on completion" flag for the batch.
        batchInfo.setNotifyOnCompletion(true);
        // Set the batch information for the eyes object.
        eyes.setBatch(batchInfo);
        // Return the current instance of the wrapper.
        return this;
    }


    /**
     * Method To close Eyes instance
     */
    public void closeEyes() {
        if (eyes != null) {
            eyes.close(false);

        }
    }




    /**
     * @ param, locator, element name
     */

    public void validateElement(By locator) {
        eyes.checkElement(locator);
        eyes.close();
    }




}


