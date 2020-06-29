package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WhishlistPage {

public WebDriver driver;

    private By clubPopup = By.xpath("//button[@class='customer-club-popup__close js-customer-club--close']");
    // locators for Dress Women Filtrs
    private By whishlistHeart1 = By.xpath("//img[@data-itemid='5714506910354']");
    private By whishlistHeart2 = By.xpath("//img[@data-itemid='5714626252846']");
    private By whishlistHeart3 = By.xpath("//img[@data-itemid='5714491397994']");

    public WhishlistPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement clubPopup() { return driver.findElement(clubPopup); }
    public WebElement whishlistHeart1() {return driver.findElement(whishlistHeart1);}
    public WebElement whishlistHeart2() {return driver.findElement(whishlistHeart2);}
    public WebElement whishlistHeart3() {return driver.findElement(whishlistHeart3);}

}
