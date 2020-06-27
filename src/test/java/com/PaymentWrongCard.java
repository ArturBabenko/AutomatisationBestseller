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

public class PaymentWrongCard extends Skeleton {
    public WebDriver driver;

    @BeforeTest
    public void beforeTest() throws IOException {
        driver = seleniumDriver();
        driver.manage().window().maximize();
        driver.get(properties.getProperty("url"));
        driver.findElement(By.xpath("//button[@class='cookie-overlay__close js-cookie-overlay__close']")).click();

    }

    @Test
    public void payWrongCard() throws InterruptedException {

        WebDriverWait wdw = new WebDriverWait(driver, 6);
        LandingPage lp = new LandingPage(driver);
        pageObjects.MenPage menPage = lp.mensChoose();

        driver.findElement(By.xpath("//button[@class='customer-club-popup__close js-customer-club--close']"));
        LoginPage loginPage = lp.login();
        loginPage.emailInput().sendKeys("bestsellerselenium@mailinator.com");
        loginPage.passwordInput().sendKeys("123456");
        loginPage.rememberBox().click();
        loginPage.loginButton().click();

        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@title='Przejdź do koszyka']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@value='Finalizacja zakupu']")).click();

        driver.findElement(By.id("dwfrm_singleshipping_shippingAddress_addressFields_firstName")).sendKeys("Artur");
        driver.findElement(By.id("dwfrm_singleshipping_shippingAddress_addressFields_lastName")).sendKeys("Babenko");
        driver.findElement(By.id("dwfrm_singleshipping_shippingAddress_addressFields_address1")).sendKeys("ul. Jana Matejki");
        driver.findElement(By.id("dwfrm_singleshipping_shippingAddress_addressFields_postalCode")).sendKeys("72-100");
        driver.findElement(By.id("dwfrm_singleshipping_shippingAddress_addressFields_city")).sendKeys("Goleniów");

        driver.findElement(By.xpath("//button[@value='Dalej']")).click();
        driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("733368459");
        driver.findElement(By.xpath("//button[@value='Dalej']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[@class='js-field-label']")).click();

        // HERE I HAVE TO FIND SOLUTION FOR HIDDEN CHECKBOX


    }
/*
    @AfterTest
    public void closeWindow() { driver.close(); }

 */

}