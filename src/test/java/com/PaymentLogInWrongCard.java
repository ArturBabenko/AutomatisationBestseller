package com;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class PaymentLogInWrongCard extends Skeleton {
    public WebDriver driver;

    @BeforeTest
    public void beforeTest() throws IOException {
        driver = seleniumDriver();
        driver.manage().window().maximize();
        driver.get(properties.getProperty("url"));
    }

    @Test
    public void payWrongCardLogIn() throws InterruptedException {

        WebDriverWait wdw = new WebDriverWait(driver, 6);
        LandingPage lp = new LandingPage(driver);
        lp.popupCookie().click();
        lp.clubPopup();
        LoginPage loginPage = lp.login();
        loginPage.emailInput().sendKeys(properties.getProperty("email"));
        loginPage.passwordInput().sendKeys(properties.getProperty("password"));
        loginPage.rememberBox().click();
        loginPage.loginButton().click();
        lp.cartChoose();
        pageObjects.OrderPage orderPage = lp.orderChoose();
        wdw.until(ExpectedConditions.visibilityOf(orderPage.checkoutCart()));
        orderPage.checkoutCart().click();
        orderPage.firstNameForm().sendKeys(properties.getProperty("name"));
        orderPage.lastNameForm().sendKeys(properties.getProperty("lastname"));
        orderPage.addressForm().sendKeys(properties.getProperty("address"));
        orderPage.postalCodeForm().sendKeys(properties.getProperty("postalcode"));
        orderPage.cityForm().sendKeys(properties.getProperty("city"));
        orderPage.buttonNext().click();
        wdw.until(ExpectedConditions.visibilityOf(orderPage.telForm()));
        orderPage.telForm().sendKeys(properties.getProperty("telnumber"));
        orderPage.buttonNext().click();

        // HERE I HAVE TO FIND SOLUTION FOR HIDDEN CHECKBOX
        driver.findElement(By.xpath("//span[@class='js-field-label']")).click();

    }
/*
    @AfterTest
    public void closeWindow() { driver.close(); }

 */

}