package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

public WebDriver driver;

    private By cartContainsValue = By.xpath("//span[@class='cart-item__content--reduced value']");
    private By itemRemove = By.xpath("//button[@value='Usuń']");


    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement cartContainsValue() { return driver.findElement(cartContainsValue); }
    public WebElement itemRemove() { return driver.findElement(itemRemove); }

}
