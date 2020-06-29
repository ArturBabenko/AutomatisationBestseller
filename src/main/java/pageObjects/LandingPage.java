package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

public WebDriver driver;

    private By clubPopup = By.xpath("//button[@class='customer-club-popup__close js-customer-club--close']");
    private By login = By.xpath("//a[@class='servicebar__account__icon']");
    private By mens = By.xpath("//a[@href='https://shop.bestseller.com/pl/pl/bc/men/']");
    private By woman = By.xpath("//a[@href='https://shop.bestseller.com/pl/pl/bc/women/']");
    private By kids = By.xpath("//a[@href='https://shop.bestseller.com/pl/pl/bc/kids/']");
    private By popupCookie = By.xpath("//button[@class='cookie-overlay__close js-cookie-overlay__close']");
    private By whishlist = By.xpath("//a[@title='Lista życzeń']");
    private By cart = By.xpath("//a[@title='Przejdź do koszyka']");

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement popupCookie() {return driver.findElement(popupCookie);}

    public WebElement clubPopup() { return driver.findElement(clubPopup); }

    public LoginPage login() {

         driver.findElement(login).click();
        LoginPage loginPage = new LoginPage(driver);
         return loginPage;
    }

    public MenPage mensChoose() {

        driver.findElement(mens).click();
        MenPage menPage = new MenPage(driver);
        return menPage;
    }

    public WomenPage womanChoose() {

        driver.findElement(woman).click();
        WomenPage womanPage = new WomenPage(driver);
        return womanPage;
    }

    public KidsPage kidsChoose() {

        driver.findElement(kids).click();
        KidsPage kidsPage = new KidsPage(driver);
        return kidsPage;
    }
    public WhishlistPage whishlistChoose() {

        driver.findElement(whishlist).click();
        WhishlistPage whishlistPage = new WhishlistPage(driver);
        return whishlistPage;
    }

    public CartPage cartChoose() {

        driver.findElement(cart).click();
        CartPage cartPage = new CartPage(driver);
        return cartPage;
    }
    public OrderPage orderChoose() {

        driver.findElement(cart).click();
        OrderPage orderPage = new OrderPage(driver);
        return orderPage;
    }
}
