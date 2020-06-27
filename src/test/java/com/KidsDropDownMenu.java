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
import resources.Skeleton;

import java.io.IOException;

//import pageObjects.WomenPage;


public class KidsDropDownMenu extends Skeleton {
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
    public void dropDownsMenu() throws InterruptedException {

        WebDriverWait wdw = new WebDriverWait(driver, 6);
        //LandingPage lp = new LandingPage(driver);
        //WomenPage womenPage = lp.womanChoose();
        driver.findElement(By.xpath("//a[@href='https://shop.bestseller.com/pl/pl/bc/kids/']")).click();
        //wdw.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@class='customer-club-popup__close js-customer-club--close']"))));
        driver.findElement(By.xpath("//button[@class='customer-club-popup__close js-customer-club--close']"));

        Actions akt = new Actions(driver);
        akt.moveToElement(driver.findElement(By.xpath("//span[@data-menu-category='bc-kids-new-arrivals']"))).build().perform();
        driver.findElement(By.xpath("//span[@data-menu-category='bc-kids-new-arrivals']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='wide-menu__content__sub__group__headline']//span[@class='category-navigation__headline__text'][contains(text(),'Shop by category')]")).isDisplayed());

        //new born
        akt.moveToElement(driver.findElement(By.xpath("//span[@data-menu-category='bc-newborn']"))).build().perform();
        Thread.sleep(1000);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='wide-menu__third__group__column']//div[@class='trending-spot__header'][contains(text(),'Newborn New Arrivals')]")).isDisplayed());

        //mini
        akt.moveToElement(driver.findElement(By.xpath("//span[@data-menu-category='bc-mini']"))).build().perform();
        Thread.sleep(1000);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='wide-menu__third__group__column']//div[@class='trending-spot__header'][contains(text(),'Mini New Arrivals')]")).isDisplayed());

        //kids
        akt.moveToElement(driver.findElement(By.xpath("//span[@data-menu-category='bc-kids-kidswear']"))).build().perform();
        Thread.sleep(1000);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='wide-menu__third__group__column']//div[@class='trending-spot__header'][contains(text(),'Kids New Arrivals')]")).isDisplayed());

        //teens
        akt.moveToElement(driver.findElement(By.xpath("//span[@data-menu-category='bc-teens']"))).build().perform();
        Thread.sleep(1000);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='wide-menu__third__group__column']//div[@class='trending-spot__header'][contains(text(),'Teens New Arrivals')]")).isDisplayed());

        //brands
        akt.moveToElement(driver.findElement(By.xpath("//span[@data-menu-category='bc-kids-brands']"))).build().perform();
        Thread.sleep(1000);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='wide-menu__third__group wide-menu__third__group--open']//div[@class='trending-spot__header'][contains(text(),'BRAND SPOTLIGHT')]")).isDisplayed());

        //sale
        akt.moveToElement(driver.findElement(By.xpath("//span[@data-menu-category='bc-kids-sale-category']"))).build().perform();
        Thread.sleep(1000);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='wide-menu__third__group wide-menu__third__group--open']//span[@class='category-navigation__headline__text'][contains(text(),'By Category')]")).isDisplayed());


    }

    @AfterTest
    public void closeWindow() {
        driver.close();
   }

}
