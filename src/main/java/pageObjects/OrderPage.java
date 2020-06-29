package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage {

public WebDriver driver;

    private By checkoutCart = By.xpath("//button[@value='Finalizacja zakupu']");
    private By firstNameForm = By.id("dwfrm_singleshipping_shippingAddress_addressFields_firstName");
    private By lastNameForm = By.id("dwfrm_singleshipping_shippingAddress_addressFields_lastName");
    private By addressForm = By.id("dwfrm_singleshipping_shippingAddress_addressFields_address1");
    private By postalCodeForm = By.id("dwfrm_singleshipping_shippingAddress_addressFields_postalCode");
    private By cityForm = By.id("dwfrm_singleshipping_shippingAddress_addressFields_city");
    private By buttonNext = By.xpath("//button[@value='Dalej']");
    private By telForm = By.xpath("//input[@type='tel']");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement checkoutCart() { return driver.findElement(checkoutCart); }
    public WebElement firstNameForm() { return driver.findElement(firstNameForm); }
    public WebElement lastNameForm() { return driver.findElement(lastNameForm); }
    public WebElement addressForm() { return driver.findElement(addressForm); }
    public WebElement postalCodeForm() { return driver.findElement(postalCodeForm); }
    public WebElement cityForm() { return driver.findElement(cityForm); }
    public WebElement buttonNext() { return driver.findElement(buttonNext); }
    public WebElement telForm() { return driver.findElement(telForm); }

}
