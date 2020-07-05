package com;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.SearchPage;
import resources.Skeleton;

import java.io.IOException;


public class BS0202SearchSpaces extends Skeleton {
    public WebDriver driver;
    //public static Logger log = LogManager.getLogger(Skeleton.class.getName());

    @Test
    public void spaceSearch() throws IOException {

        driver = seleniumDriver();
        driver.manage().window().maximize();
        driver.get(properties.getProperty("url"));
        LandingPage lp = new LandingPage(driver);
        lp.popupCookie().click();
        SearchPage searchPage = lp.searchChoose();
        searchPage.searchField().sendKeys("     ");
        searchPage.checkoutCart().click();
        String abc = searchPage.itemTextCount().getText();
        Assert.assertNotEquals(searchPage.itemCount(abc), 0);

    }

    @AfterTest
    public void closeWindow() {
        driver.close();
    }

}
