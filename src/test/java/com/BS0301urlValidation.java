package com;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import resources.Skeleton;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BS0301urlValidation extends Skeleton {
    public WebDriver driver;
    //private static Logger log = LogManager.getLogger(urlValidation.class.getName());

    @BeforeTest
    public void beforeStart() throws IOException {
        driver = seleniumDriver();
        //log.info("Driver initialized");
        driver.manage().window().maximize();
        driver.get(properties.getProperty("url"));
        //log.info("Url navigation");
    }

    @Test
    public void urlValidation()  {

        Assert.assertEquals(driver.getTitle(),"Shop fashion | Find this season's trends on BESTSELLER.COM");
        //LandingPage landingPage = new LandingPage(driver);
        //Assert.assertFalse(landingPage.errorPage().isDisplayed());
        //log.info("Page title successfully equals");
    }

    @AfterTest
    public void closeWindow() {

        driver.close();
    }
}
