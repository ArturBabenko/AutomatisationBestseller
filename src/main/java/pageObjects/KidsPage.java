package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KidsPage {

public WebDriver driver;

    private By clubPopup = By.xpath("//button[@class='customer-club-popup__close js-customer-club--close']");
    private By kidsNewArrivalsMenu = By.xpath("//span[@data-menu-category='bc-kids-new-arrivals']");
    private By kidsNewArrivalsCheck = By.xpath("//div[@class='wide-menu__content__sub__group__headline']//span[@class='category-navigation__headline__text'][contains(text(),'Shop by category')]");
    private By kidsNewBornMenu = By.xpath("//span[@data-menu-category='bc-newborn']");
    private By kidsNewBornCheck = By.xpath("//div[@class='wide-menu__third__group__column']//div[@class='trending-spot__header'][contains(text(),'Newborn New Arrivals')]");
    private By kidsMiniMenu = By.xpath("//span[@data-menu-category='bc-mini']");
    private By kidsMiniCheck = By.xpath("//div[@class='wide-menu__third__group__column']//div[@class='trending-spot__header'][contains(text(),'Mini New Arrivals')]");
    private By kidsKidsMenu = By.xpath("//span[@data-menu-category='bc-kids-kidswear']");
    private By kidsKidsCheck = By.xpath("//div[@class='wide-menu__third__group__column']//div[@class='trending-spot__header'][contains(text(),'Kids New Arrivals')]");
    private By kidsTeensMenu = By.xpath("//span[@data-menu-category='bc-teens']");
    private By kidsTeensCheck = By.xpath("//div[@class='wide-menu__third__group__column']//div[@class='trending-spot__header'][contains(text(),'Teens New Arrivals')]");
    private By kidsBrandsMenu = By.xpath("//span[@data-menu-category='bc-kids-brands']");
    private By kidsBrandsCheck = By.xpath("//div[@class='wide-menu__third__group wide-menu__third__group--open']//div[@class='trending-spot__header'][contains(text(),'BRAND SPOTLIGHT')]");
    private By kidsSaleMenu = By.xpath("//span[@data-menu-category='bc-kids-sale-category']");
    private By kidsSaleCheck = By.xpath("//div[@class='wide-menu__third__group wide-menu__third__group--open']//span[@class='category-navigation__headline__text'][contains(text(),'By Category')]");


    public KidsPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement clubPopup() { return driver.findElement(clubPopup); }
    public WebElement kidsNewArrivalsMenu() { return driver.findElement(kidsNewArrivalsMenu); }
    public WebElement kidsNewArrivalsCheck() { return driver.findElement(kidsNewArrivalsCheck); }
    public WebElement kidsNewBornMenu() { return driver.findElement(kidsNewBornMenu); }
    public WebElement kidsNewBornCheck() { return driver.findElement(kidsNewBornCheck); }
    public WebElement kidsMiniMenu() { return driver.findElement(kidsMiniMenu); }
    public WebElement kidsMiniCheck() { return driver.findElement(kidsMiniCheck); }
    public WebElement kidsKidsMenu() { return driver.findElement(kidsKidsMenu); }
    public WebElement kidsKidsCheck() { return driver.findElement(kidsKidsCheck); }
    public WebElement kidsTeensMenu() { return driver.findElement(kidsTeensMenu); }
    public WebElement kidsTeensCheck() { return driver.findElement(kidsTeensCheck); }
    public WebElement kidsBrandsMenu() { return driver.findElement(kidsBrandsMenu); }
    public WebElement kidsBrandsCheck() { return driver.findElement(kidsBrandsCheck); }
    public WebElement kidsSaleMenu() { return driver.findElement(kidsSaleMenu); }
    public WebElement kidsSaleCheck() { return driver.findElement(kidsSaleCheck); }


}
