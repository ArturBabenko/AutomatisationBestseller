package com;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.SearchPage;
import resources.Skeleton;

import java.io.IOException;


public class BS0203SearchMaxSymbols extends Skeleton {
    public WebDriver driver;
    //public static Logger log = LogManager.getLogger(Skeleton.class.getName());

    @Test
    public void maxSymbolSearch() throws IOException {

        driver = seleniumDriver();
        driver.manage().window().maximize();
        driver.get(properties.getProperty("url"));
        LandingPage lp = new LandingPage(driver);
        lp.popupCookie().click();
        SearchPage searchPage = lp.searchChoose();
        searchPage.searchField().sendKeys(searchPage.longText());
        searchPage.checkoutCart().click();
        int maxCharacter = searchPage.stringCount(searchPage.maxSymbolsText().getText());
        Assert.assertEquals(maxCharacter, 100);

    }

    @AfterTest
    public void closeWindow() {
        driver.close();
    }

}
