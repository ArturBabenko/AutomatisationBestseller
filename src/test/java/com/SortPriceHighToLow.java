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

public class SortPriceHighToLow extends Skeleton {
    public WebDriver driver;

    @BeforeTest
    public void beforeTest() throws IOException {
        driver = seleniumDriver();
        driver.manage().window().maximize();
        driver.get(properties.getProperty("url"));
        driver.findElement(By.xpath("//button[@class='cookie-overlay__close js-cookie-overlay__close']")).click();

    }

    @Test
    public void priceHighToLow() throws InterruptedException {

        WebDriverWait wdw = new WebDriverWait(driver, 6);
        LandingPage lp = new LandingPage(driver);
        pageObjects.MenPage menPage = lp.mensChoose();

        driver.findElement(By.xpath("//button[@class='customer-club-popup__close js-customer-club--close']"));
        Actions akt = new Actions(driver);
        akt.moveToElement(driver.findElement(By.xpath("//span[@data-menu-category='bc-men-fashion']"))).build().perform();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/div[7]/div[2]/div[37]/div[11]/div[1]/div[3]/a[1]")).click();
        //wdw.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//aside[@class='plp__refine']//select"))));
        Thread.sleep(2000);
        Select s = new Select(driver.findElement(By.xpath("//div[@class='search-options-bar js-search-options-bar']//div[@class='sorting-controls']//select")));
        s.selectByValue("https://shop.bestseller.com/pl/pl/bc/men/clothing/jeans/?srule=SSO_Price-high-to-low&start=0&sz=60");
        Thread.sleep(2000);
        String a = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[3]/main[1]/div[7]/div[3]/div[1]/article[1]/div[1]/p[2]/em[1]")).getText();
        String b = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[3]/main[1]/div[7]/div[3]/div[4]/article[1]/div[1]/p[2]/em[1]")).getText();
        Assert.assertTrue(menPage.priceHighToLow(a,b));


    }
    

    @AfterTest
    public void closeWindow() { driver.close(); }



}