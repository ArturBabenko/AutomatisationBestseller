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

public class CartAfterPageRefresh extends Skeleton {
    public WebDriver driver;

    @BeforeTest
    public void beforeTest() throws IOException {
        driver = seleniumDriver();
        driver.manage().window().maximize();
        driver.get(properties.getProperty("url"));
        driver.findElement(By.xpath("//button[@class='cookie-overlay__close js-cookie-overlay__close']")).click();

    }

    @Test
    public void itemInCartAfterLogIn() throws InterruptedException {

        WebDriverWait wdw = new WebDriverWait(driver, 6);
        LandingPage lp = new LandingPage(driver);
        pageObjects.MenPage menPage = lp.mensChoose();

        driver.findElement(By.xpath("//button[@class='customer-club-popup__close js-customer-club--close']"));
        Actions akt = new Actions(driver);
        akt.moveToElement(driver.findElement(By.xpath("//span[@data-menu-category='bc-men-shoes']"))).build().perform();
        driver.findElement(By.xpath("//a[contains(@href, 'flip-flops')]")).click();
        driver.findElement(By.xpath("//img[@data-itemid='5714506910354']")).click();
        menPage.sizeSelect().click();
        wdw.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='swatch size' and li[contains(@class, 'swatch__item--selected')]]")));
        menPage.cartAdd().click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@title='Przejdź do koszyka']")).click();
        driver.get(properties.getProperty("url"));
        driver.findElement(By.xpath("//a[@title='Przejdź do koszyka']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='cart-item__content--reduced value']")).isDisplayed());


    }

    @AfterTest
    public void closeWindow() { driver.close(); }

}