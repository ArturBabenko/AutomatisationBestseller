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
        driver.findElement(By.xpath("//button[@class='cookie-overlay__close js-cookie-overlay__close']")).click();

    }

    @Test
    public void whishlistCheck() throws InterruptedException {

        WebDriverWait wdw = new WebDriverWait(driver, 6);
        LandingPage lp = new LandingPage(driver);
        pageObjects.MenPage menPage = lp.mensChoose();

        driver.findElement(By.xpath("//button[@class='customer-club-popup__close js-customer-club--close']"));
        Actions akt = new Actions(driver);
        akt.moveToElement(driver.findElement(By.xpath("//span[@data-menu-category='bc-men-shoes']"))).build().perform();
        driver.findElement(By.xpath("//a[contains(@href, 'flip-flops')]")).click();
        driver.findElement(By.xpath("//div[@class = 'heart' and @data-wishlist-id='5714506910354']")).click();
        driver.findElement(By.xpath("//li[contains(@class,'category-navigation__item')]//a[contains(@class,'category-navigation__link')][contains(text(),'Sandals')]")).click();
        wdw.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class = 'heart' and @data-wishlist-id='5714626252822']"))));
        driver.findElement(By.xpath("//div[@class = 'heart' and @data-wishlist-id='5714626252822']")).click();
        driver.findElement(By.xpath("//a[@title='Przejdź do kategorii: Clothing']")).click();

        driver.findElement(By.xpath("//li[contains(@class,'category-navigation__item')]//a[contains(@class,'category-navigation__link')][contains(text(),'Jeans')]")).click();
        driver.findElement(By.xpath("//div[@class = 'heart' and @data-wishlist-id='5714909608483']")).click();

        driver.findElement(By.xpath("//a[@title='Lista życzeń']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//img[@data-itemid='5714506910354']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//img[@data-itemid='5714626252822']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//img[@data-itemid='5714909608483']")).isDisplayed());

    }
    

    @AfterTest
    public void closeWindow() { driver.close(); }

}