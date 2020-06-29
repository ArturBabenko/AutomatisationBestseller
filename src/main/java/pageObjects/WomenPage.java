package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WomenPage {

public WebDriver driver;

    private By clubPopup = By.xpath("//button[@class='customer-club-popup__close js-customer-club--close']");
    // locators for Dress Women Filtrs
    private By menuDresses = By.xpath("//div[@data-category-id='bc-women-all-dresses-navigation']");
    private By allDresses = By.xpath("//a[@data-menu-category='bc-women-all-dresses-top-navigation']");
    private By dropDownBrand = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[3]/main[1]/aside[1]/div[5]/div[1]/div[2]/article[2]/header[1]");
    private By noisyMay = By.xpath("//a[contains(text(),'NOISY MAY')]");
    private By dropDownColor = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[3]/main[1]/aside[1]/div[5]/div[1]/div[2]/article[3]/header[1]");
    private By colorGreen = By.xpath("//a[@title='Uściślij według Kolor: Zielony']");
    private By dropDownPrice = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[3]/main[1]/aside[1]/div[5]/div[1]/div[2]/article[4]/header[1]");
    private By zeroOneHunFifty = By.xpath("//a[contains(text(),'0 - 150 PLN')]");
    private By dropDownSize = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[3]/main[1]/aside[1]/div[5]/div[1]/div[2]/article[5]/header[1]");
    private By size34 = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[3]/main[1]/aside[1]/div[5]/div[1]/div[2]/article[5]/section[1]/ul[1]/li[1]/h5[1]/a[1]");
    private By size36 = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[3]/main[1]/aside[1]/div[5]/div[1]/div[2]/article[5]/section[1]/ul[1]/li[2]/h5[1]/a[1]");
    private By size38 = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[3]/main[1]/aside[1]/div[5]/div[1]/div[2]/article[5]/section[1]/ul[1]/li[3]/h5[1]/a[1]");
    private By filtrOnZeroOHF = By.xpath("//div[@class='refine__properties js-refine-filters']//span[@class='applied-filters__value'][contains(text(),'0 - 150 PLN')]");
    private By filtrOnNoisyMay = By.xpath("//div[@class='refine__properties js-refine-filters']//span[@class='applied-filters__value'][contains(text(),'Noisy May')]");
    private By filtrOnColorGreen = By.xpath("//div[@class='refine__properties js-refine-filters']//span[@class='applied-filters__value'][contains(text(),'Zielony')]");
    private By filtrOnSize34 = By.xpath("//div[@class='refine__properties js-refine-filters']//span[@class='applied-filters__value'][contains(text(),'34')]");
    private By filtrOnSize36 = By.xpath("//div[@class='refine__properties js-refine-filters']//span[@class='applied-filters__value'][contains(text(),'36')]");
    private By filtrOnSize38 = By.xpath("//div[@class='refine__properties js-refine-filters']//span[@class='applied-filters__value'][contains(text(),'38')]");

    public WomenPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement clubPopup() { return driver.findElement(clubPopup); }
    public WebElement menuDresses() {return driver.findElement(menuDresses);}
    public WebElement allDresses() {return driver.findElement(allDresses);}
    public WebElement dropDownBrand() {return driver.findElement(dropDownBrand);}
    public WebElement noisyMay() {return driver.findElement(noisyMay);}
    public WebElement dropDownColor() {return driver.findElement(dropDownColor);}
    public WebElement colorGreen() {return driver.findElement(colorGreen);}
    public WebElement dropDownPrice() {return driver.findElement(dropDownPrice);}
    public WebElement zeroOneHunFifty() {return driver.findElement(zeroOneHunFifty);}
    public WebElement dropDownSize() {return driver.findElement(dropDownSize);}
    public WebElement size34() {return driver.findElement(size34);}
    public WebElement size36() {return driver.findElement(size36);}
    public WebElement size38() {return driver.findElement(size38);}
    public WebElement filtrOnZeroOHF() {return driver.findElement(filtrOnZeroOHF);}
    public WebElement filtrOnNoisyMay() {return driver.findElement(filtrOnNoisyMay);}
    public WebElement filtrOnColorGreen() {return driver.findElement(filtrOnColorGreen);}
    public WebElement filtrOnSize34() {return driver.findElement(filtrOnSize34);}
    public WebElement filtrOnSize36() {return driver.findElement(filtrOnSize36);}
    public WebElement filtrOnSize38() {return driver.findElement(filtrOnSize38);}

}
