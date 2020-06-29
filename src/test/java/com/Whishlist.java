package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import resources.Skeleton;

import java.io.IOException;

public class Whishlist extends Skeleton {
    public WebDriver driver;

    @BeforeTest
    public void beforeTest() throws IOException {
        driver = seleniumDriver();
        driver.manage().window().maximize();
        driver.get(properties.getProperty("url"));

    }

    @Test
    public void whishlistCheck() throws InterruptedException {

        WebDriverWait wdw = new WebDriverWait(driver, 6);
        LandingPage lp = new LandingPage(driver);
        lp.popupCookie().click();
        pageObjects.MenPage menPage = lp.mensChoose();
        menPage.clubPopup();
        Actions akt = new Actions(driver);
        akt.moveToElement(menPage.menShoesPopUp()).build().perform();
        menPage.menFlipFlop().click();
        menPage.flipFlopHeart().click();
        menPage.menSandals().click();
        wdw.until(ExpectedConditions.visibilityOf(menPage.sandalsHeart()));
        menPage.sandalsHeart().click();
        menPage.menClothingMenu().click();
        menPage.menJeans().click();
        wdw.until(ExpectedConditions.visibilityOf(menPage.jeansHeart()));
        menPage.jeansHeart().click();
        pageObjects.WhishlistPage whishlistPage = lp.whishlistChoose();

        Assert.assertTrue(whishlistPage.whishlistHeart1().isDisplayed());
        Assert.assertTrue(whishlistPage.whishlistHeart2().isDisplayed());
        Assert.assertTrue(whishlistPage.whishlistHeart3().isDisplayed());

    }

    @AfterTest
    public void closeWindow() {
        driver.close();
    }
}