package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.MenPage;
import resources.Skeleton;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class BS0601MenTshirtSale extends Skeleton {
    public WebDriver driver;
    //public static Logger log = LogManager.getLogger(Skeleton.class.getName());

    @BeforeTest
    public void beforeTest() throws IOException {
        driver = seleniumDriver();
        driver.manage().window().maximize();
        driver.get(properties.getProperty("url"));
    }

    @Test
    //(dataProvider = "getItem") first try with data provider but cod was not so dynamic as below
    public void dwaZaTShort() throws InterruptedException {

        WebDriverWait wdw = new WebDriverWait(driver, 6);
        LandingPage lp = new LandingPage(driver);
        lp.popupCookie().click();
        pageObjects.MenPage menPage = lp.mensChoose();
        menPage.clubPopup();
        menPage.twoForTShort().click();
        //for (int i = 1; i <= menPage.itemCount(menPage.itemOnPage().getText()); i++) {
        // uncomment above and you can test all elements on page
        for (int i = 1; i <= 10; i++) {
            // just make testing for first 10 elements, to make it faster
            driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[3]/main[1]/div[7]/div[3]/div["+i+"]/article[1]/figure[1]/a[1]/img[1]")).click();
        //step by step xpath allow me to use fori for all items check available on page

        wdw.until(ExpectedConditions.visibilityOf(menPage.priceOneElement()));
        String priceOneElement = menPage.priceOneElement().getText();
        wdw.until(ExpectedConditions.visibilityOf(menPage.sizeSelect()));
        menPage.sizeSelect().click();
            wdw.until(ExpectedConditions.visibilityOf(menPage.sizeSelected()));
        // hm.. dynamic class name.. done! ;)
        menPage.cartAdd().click();
        Thread.sleep(2000);
        menPage.cartOpen().click();
        wdw.until(ExpectedConditions.visibilityOf(menPage.addOne()));
        menPage.addOne().click();
        Thread.sleep(3000);
        String priceTwoElements = menPage.priceTwoElements().getText();
        Assert.assertTrue(menPage.priceCompare(priceOneElement,priceTwoElements));
        pageObjects.CartPage cartPage = lp.cartChoose();
        cartPage.itemRemove().click();
        lp.mensChoose();
        lp.mensChoose();
        //second click because some times appears pop-up window for non registered user
            //do not have to check before test is popup appeared and close it
        menPage.twoForTShort().click();
        }
    }

    @AfterTest
    public void closeWindow() {
        driver.close();
   }
}
