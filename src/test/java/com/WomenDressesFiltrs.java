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
//import pageObjects.WomenPage;
import resources.Skeleton;

import java.io.IOException;


public class WomenDressesFiltrs extends Skeleton {
    public WebDriver driver;
    //public static Logger log = LogManager.getLogger(Skeleton.class.getName());

    @BeforeTest
    public void beforeTest() throws IOException {
        driver = seleniumDriver();
        driver.manage().window().maximize();
        driver.get(properties.getProperty("url"));
        driver.findElement(By.xpath("//button[@class='cookie-overlay__close js-cookie-overlay__close']")).click();

    }

    @Test
    public void Filtrs() throws InterruptedException {

        WebDriverWait wdw = new WebDriverWait(driver, 6);
        //LandingPage lp = new LandingPage(driver);
        //WomenPage womenPage = lp.womanChoose();
        driver.findElement(By.xpath("//a[@href='https://shop.bestseller.com/pl/pl/bc/women/']")).click();
        driver.findElement(By.xpath("//button[@class='customer-club-popup__close js-customer-club--close']"));
        Actions akt = new Actions(driver);
        akt.moveToElement(driver.findElement(By.xpath("//div[@data-category-id='bc-women-all-dresses-navigation']"))).build().perform();
        driver.findElement(By.xpath("//a[@data-menu-category='bc-women-all-dresses-top-navigation']")).click();

        // select brand
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[3]/main[1]/aside[1]/div[5]/div[1]/div[2]/article[2]/header[1]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'NOISY MAY')]")).click();
        Thread.sleep(2000);

        // select kolor
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[3]/main[1]/aside[1]/div[5]/div[1]/div[2]/article[3]/header[1]")).click();
        driver.findElement(By.xpath("//a[@title='Uściślij według Kolor: Zielony']")).click();
        Thread.sleep(2000);

        // select price
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[3]/main[1]/aside[1]/div[5]/div[1]/div[2]/article[4]/header[1]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'0 - 150 PLN')]")).click();
        Thread.sleep(2000);

        // select size
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[3]/main[1]/aside[1]/div[5]/div[1]/div[2]/article[5]/header[1]")).click();
        //wdw.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(text(),'34 / XS')]"))));
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[3]/main[1]/aside[1]/div[5]/div[1]/div[2]/article[5]/section[1]/ul[1]/li[1]/h5[1]/a[1]")).click();
        Thread.sleep(2000);
        /*
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[3]/main[1]/aside[1]/div[5]/div[1]/div[2]/article[5]/section[1]/ul[1]/li[2]/h5[1]/a[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[3]/main[1]/aside[1]/div[5]/div[1]/div[2]/article[5]/section[1]/ul[1]/li[3]/h5[1]/a[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[3]/main[1]/aside[1]/div[5]/div[1]/div[2]/article[5]/section[1]/ul[1]/li[4]/h5[1]/a[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[3]/main[1]/aside[1]/div[5]/div[1]/div[2]/article[5]/section[1]/ul[1]/li[5]/h5[1]/a[1]")).click();
        Thread.sleep(2000);

         */
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[3]/main[1]/aside[1]/div[5]/div[1]/div[2]/article[5]/header[1]")).click();
        Thread.sleep(2000);

        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='refine__properties js-refine-filters']//span[@class='applied-filters__value'][contains(text(),'0 - 150 PLN')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='refine__properties js-refine-filters']//span[@class='applied-filters__value'][contains(text(),'Noisy May')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='refine__properties js-refine-filters']//span[@class='applied-filters__value'][contains(text(),'Zielony')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='refine__properties js-refine-filters']//span[@class='applied-filters__value'][contains(text(),'34')]")).isDisplayed());

    }




    @AfterTest
    public void closeWindow() {
        driver.close();
   }

}
