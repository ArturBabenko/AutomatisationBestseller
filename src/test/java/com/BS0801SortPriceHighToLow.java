package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import resources.Skeleton;

import java.io.IOException;

public class BS0801SortPriceHighToLow extends Skeleton {
    public WebDriver driver;

    @BeforeTest
    public void beforeTest() throws IOException {
        driver = seleniumDriver();
        driver.manage().window().maximize();
        driver.get(properties.getProperty("url"));
       }

    @Test
    public void priceHighToLow() throws InterruptedException {

        WebDriverWait wdw = new WebDriverWait(driver, 6);
        LandingPage lp = new LandingPage(driver);
        lp.popupCookie().click();
        pageObjects.MenPage menPage = lp.mensChoose();
        menPage.clubPopup();
        Actions akt = new Actions(driver);
        akt.moveToElement(menPage.menClothing()).build().perform();
        wdw.until(ExpectedConditions.visibilityOf(menPage.menJeansPopUp()));
        menPage.menJeansPopUp().click();
        wdw.until(ExpectedConditions.visibilityOf(menPage.sortSelect()));
        Select s = new Select(menPage.sortSelect());
        s.selectByValue(menPage.selectValue());
        String a = menPage.firstItemPrice().getText();
        String b = menPage.fourItemPrice().getText();
        Assert.assertTrue(menPage.priceHighToLow(a,b));
    }

    @AfterTest
    public void closeWindow() { driver.close(); }
}