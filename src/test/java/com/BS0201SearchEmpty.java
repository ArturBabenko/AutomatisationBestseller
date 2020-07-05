package com;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.SearchPage;
import resources.Skeleton;

import java.io.IOException;


public class BS0201SearchEmpty extends Skeleton {
    public WebDriver driver;
    //public static Logger log = LogManager.getLogger(Skeleton.class.getName());

    @Test
    public void emptySearch() throws IOException {

        driver = seleniumDriver();
        driver.manage().window().maximize();
        driver.get(properties.getProperty("url"));
        LandingPage lp = new LandingPage(driver);
        lp.popupCookie().click();
        SearchPage searchPage = lp.searchChoose();
        searchPage.checkoutCart().click();
        String abc = searchPage.itemTextCount().getText();
        Assert.assertNotEquals(searchPage.itemCount(abc), 0);

    }

    @AfterTest
    public void closeWindow() {
        driver.close();
    }

}
