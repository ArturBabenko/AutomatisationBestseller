package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Skeleton;

import java.io.IOException;


public class LogInCorrectData extends Skeleton {
    public WebDriver driver;
    //public static Logger log = LogManager.getLogger(Skeleton.class.getName());

    @Test(dataProvider = "getData")
    public void loginCorrectData(String email, String password) throws IOException {
        driver = seleniumDriver();
        driver.manage().window().maximize();
        driver.get(properties.getProperty("url"));
        WebDriverWait wdw = new WebDriverWait(driver, 6);
        LandingPage lp = new LandingPage(driver);
        lp.popupCookie().click();
        LoginPage loginPage = lp.login();
        loginPage.emailInput().sendKeys(email);
        loginPage.passwordInput().sendKeys(password);
        loginPage.rememberBox().click();
        loginPage.loginButton().click();

        wdw.until(ExpectedConditions.visibilityOf(loginPage.isLogin()));
        Assert.assertTrue(loginPage.isLogin().isDisplayed());


    }

    @DataProvider

    public Object[][] getData() {
    Object[][] data = new Object[3][2];
    data[0][0] = "bestsellerselenium@mailinator.com";
    data[0][1] = "123456";
    data[1][0] = "adminbestsellerselenium@mailinator.com";
    data[1][1] = "123456";
    data[2][0] = "designerbestsellerselenium@mailionator.com";
    data[2][1] = "123456";

    return data;

    }

    @AfterTest
    public void closeWindow() {
        driver.close();
    }
}
