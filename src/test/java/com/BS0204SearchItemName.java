package com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.SearchPage;
import resources.Skeleton;

import java.io.IOException;


public class BS0204SearchItemName extends Skeleton {
    public WebDriver driver;
    //public static Logger log = LogManager.getLogger(Skeleton.class.getName());

    @Test
    public void itemNameSearch() throws IOException {
        //WebDriverWait wdw = new WebDriverWait(driver, 6);
        driver = seleniumDriver();
        driver.manage().window().maximize();
        driver.get(properties.getProperty("url"));
        LandingPage lp = new LandingPage(driver);
        lp.popupCookie().click();
        SearchPage searchPage = lp.searchChoose();
        searchPage.searchField().sendKeys(searchPage.clothName());
        searchPage.checkoutCart().click();
        //wdw.until(ExpectedConditions.visibilityOf(searchPage.clothNameFiltr()));
        Assert.assertTrue(searchPage.wordSearch(searchPage.firstItemCheck().getText(), searchPage.clothName()));
        Assert.assertTrue(searchPage.wordSearch(searchPage.fiveItemCheck().getText(), searchPage.clothName()));
        Assert.assertTrue(searchPage.wordSearch(searchPage.tenItemCheck().getText(), searchPage.clothName()));

    }

    @AfterTest
    public void closeWindow() {
        driver.close();
    }
}
