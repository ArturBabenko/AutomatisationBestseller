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
import pageObjects.KidsPage;
import pageObjects.LandingPage;
import resources.Skeleton;

import java.io.IOException;

public class KidsDropDownMenu extends Skeleton {
    public WebDriver driver;
    //public static Logger log = LogManager.getLogger(Skeleton.class.getName());

    @BeforeTest
    public void beforeTest() throws IOException {
        driver = seleniumDriver();
        driver.manage().window().maximize();
        driver.get(properties.getProperty("url"));
    }

    @Test
    public void dropDownsMenu() throws InterruptedException {

        WebDriverWait wdw = new WebDriverWait(driver, 6);
        LandingPage lp = new LandingPage(driver);
        lp.popupCookie().click();
        KidsPage kidsPage = lp.kidsChoose();
        kidsPage.clubPopup();
        //New this week pop up section check
        Actions akt = new Actions(driver);
        akt.moveToElement(kidsPage.kidsNewArrivalsMenu()).build().perform();
        kidsPage.kidsNewArrivalsMenu().click(); // to close popUp window
        Assert.assertTrue(kidsPage.kidsNewArrivalsCheck().isDisplayed());
        //new born
        akt.moveToElement(kidsPage.kidsNewBornMenu()).build().perform();
        wdw.until(ExpectedConditions.visibilityOf(kidsPage.kidsNewBornCheck()));
        Assert.assertTrue(kidsPage.kidsNewBornCheck().isDisplayed());
        //mini
        akt.moveToElement(kidsPage.kidsMiniMenu()).build().perform();
        wdw.until(ExpectedConditions.visibilityOf(kidsPage.kidsMiniCheck()));
        Assert.assertTrue(kidsPage.kidsMiniCheck().isDisplayed());
        //kids
        akt.moveToElement(kidsPage.kidsKidsMenu()).build().perform();
        wdw.until(ExpectedConditions.visibilityOf(kidsPage.kidsKidsCheck()));
        Assert.assertTrue(kidsPage.kidsKidsCheck().isDisplayed());
        //teens
        akt.moveToElement(kidsPage.kidsTeensMenu()).build().perform();
        wdw.until(ExpectedConditions.visibilityOf(kidsPage.kidsTeensCheck()));
        Assert.assertTrue(kidsPage.kidsTeensCheck().isDisplayed());
        //brands
        akt.moveToElement(kidsPage.kidsBrandsMenu()).build().perform();
        wdw.until(ExpectedConditions.visibilityOf(kidsPage.kidsBrandsCheck()));
        Assert.assertTrue(kidsPage.kidsBrandsCheck().isDisplayed());
        //sale
        akt.moveToElement(kidsPage.kidsSaleMenu()).build().perform();
        wdw.until(ExpectedConditions.visibilityOf(kidsPage.kidsSaleCheck()));
        Assert.assertTrue(kidsPage.kidsSaleCheck().isDisplayed());
    }

    @AfterTest
    public void closeWindow() {
        driver.close();
   }
}
