package com;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.SearchPage;
import resources.Skeleton;

import java.io.IOException;


public class BS0205SearchExistItemNumber extends Skeleton {
    public WebDriver driver;
    //public static Logger log = LogManager.getLogger(Skeleton.class.getName());

    @Test
    public void itemNumberSearch() throws IOException {
        //WebDriverWait wdw = new WebDriverWait(driver, 6);
        driver = seleniumDriver();
        driver.manage().window().maximize();
        driver.get(properties.getProperty("url"));
        LandingPage lp = new LandingPage(driver);
        lp.popupCookie().click();
        SearchPage searchPage = lp.searchChoose();
        searchPage.searchField().sendKeys(searchPage.existItemID());
        searchPage.checkoutCart().click();
        //wdw.until(ExpectedConditions.visibilityOf(searchPage.clothNameFiltr()));
        Assert.assertTrue(searchPage.existItemCheck().isDisplayed());
    }

    @AfterTest
    public void closeWindow() {
        driver.close();
    }
}
