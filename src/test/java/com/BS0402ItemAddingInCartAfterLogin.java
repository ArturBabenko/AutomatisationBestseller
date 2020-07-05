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
import pageObjects.LoginPage;
import resources.Skeleton;

import java.io.IOException;

public class BS0402ItemAddingInCartAfterLogin extends Skeleton {
    public WebDriver driver;

    @BeforeTest
    public void beforeTest() throws IOException {
        driver = seleniumDriver();
        driver.manage().window().maximize();
        driver.get(properties.getProperty("url"));
    }

    @Test
    public void itemAddingInCartAfterLogIn() throws InterruptedException {

        WebDriverWait wdw = new WebDriverWait(driver, 6);
        LandingPage lp = new LandingPage(driver);
        lp.popupCookie().click();
        pageObjects.MenPage menPage = lp.mensChoose();
        menPage.clubPopup();
        Actions akt = new Actions(driver);
        akt.moveToElement(menPage.menShoesPopUp()).build().perform();
        menPage.menFlipFlop().click();
        menPage.flipFlopItem01().click();
        menPage.sizeSelect().click();
        wdw.until(ExpectedConditions.visibilityOf(menPage.sizeSelect()));
        Thread.sleep(2000);
        menPage.cartAdd().click();
        Thread.sleep(2000);
        pageObjects.CartPage cartPage = lp.cartChoose();
        LoginPage loginPage = lp.login();
        loginPage.emailInput().sendKeys(properties.getProperty("email"));
        loginPage.passwordInput().sendKeys(properties.getProperty("password"));
        loginPage.loginButton().click();
        lp.cartChoose();
        Assert.assertTrue(cartPage.cartContainsValue().isDisplayed());
        Assert.assertEquals(cartPage.cartContainsValue().getText(),"5714506910354");

    }

    @AfterTest
    public void closeWindow() { driver.close(); }

}