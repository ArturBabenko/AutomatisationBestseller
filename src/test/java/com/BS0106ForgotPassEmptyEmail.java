package com;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Skeleton;

import java.io.IOException;


public class BS0106ForgotPassEmptyEmail extends Skeleton {
    public WebDriver driver;
    //public static Logger log = LogManager.getLogger(Skeleton.class.getName());

    @Test(dataProvider = "getData")
    public void LogInWrongData(String email) throws IOException {

        driver = seleniumDriver();
        driver.manage().window().maximize();
        driver.get(properties.getProperty("url"));
        LandingPage lp = new LandingPage(driver);
        lp.popupCookie().click();
        LoginPage loginPage = lp.login();

       ForgotPassword fp = loginPage.forgotPassword();
       fp.emailInput().sendKeys(email);
       fp.sendButton().click();
        Assert.assertEquals(fp.emptyField(), fp.emptyFieldErrText());
    }

    @DataProvider

    public Object[] getData() {
    Object[] data = new Object[1];
    data[0] = "";
    return data;

    }

    @AfterTest
    public void closeWindow() {
        driver.close();
    }
}
