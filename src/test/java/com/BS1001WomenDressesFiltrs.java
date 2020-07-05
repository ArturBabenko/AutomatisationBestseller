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
import pageObjects.WomenPage;
import resources.Skeleton;

import java.io.IOException;


public class BS1001WomenDressesFiltrs extends Skeleton {
    public WebDriver driver;
    //public static Logger log = LogManager.getLogger(Skeleton.class.getName());

    @BeforeTest
    public void beforeTest() throws IOException {
        driver = seleniumDriver();
        driver.manage().window().maximize();
        driver.get(properties.getProperty("url"));
    }

    @Test
    public void Filtrs() throws InterruptedException {

        WebDriverWait wdw = new WebDriverWait(driver, 6);
        LandingPage lp = new LandingPage(driver);
        lp.popupCookie().click();
        pageObjects.WomenPage womenPage = lp.womanChoose();
        womenPage.clubPopup();
        Actions akt = new Actions(driver);
        akt.moveToElement(womenPage.menuDresses()).build().perform();
        womenPage.allDresses().click();
        // select brand
        womenPage.dropDownBrand().click();
        womenPage.noisyMay().click();
        wdw.until(ExpectedConditions.visibilityOf(womenPage.filtrOnNoisyMay()));
        // select color
        womenPage.dropDownColor().click();
        womenPage.colorGreen().click();
        wdw.until(ExpectedConditions.visibilityOf(womenPage.filtrOnColorGreen()));
        // select price
        womenPage.dropDownPrice().click();
        womenPage.zeroOneHunFifty().click();
        wdw.until(ExpectedConditions.visibilityOf(womenPage.filtrOnZeroOHF()));
        // select size
        womenPage.dropDownSize().click();

        if (womenPage.size34().isDisplayed()) {
            womenPage.size34().click();
            wdw.until(ExpectedConditions.visibilityOf(womenPage.filtrOnSize34()));
            Assert.assertTrue(womenPage.filtrOnSize34().isDisplayed());
        }

        if (womenPage.size36().isDisplayed()) {
            womenPage.size36().click();
            wdw.until(ExpectedConditions.visibilityOf(womenPage.filtrOnSize36()));
            Assert.assertTrue(womenPage.filtrOnSize36().isDisplayed());
        }

        if (womenPage.size38().isDisplayed()) {
            womenPage.size38().click();
            wdw.until(ExpectedConditions.visibilityOf(womenPage.filtrOnSize38()));
            Assert.assertTrue(womenPage.filtrOnSize38().isDisplayed());
        }

        womenPage.dropDownSize().click();

        Assert.assertTrue(womenPage.filtrOnZeroOHF().isDisplayed());
        Assert.assertTrue(womenPage.filtrOnNoisyMay().isDisplayed());
        Assert.assertTrue(womenPage.filtrOnColorGreen().isDisplayed());

        }

        @AfterTest
        public void closeWindow() {
            driver.close();
        }
}
