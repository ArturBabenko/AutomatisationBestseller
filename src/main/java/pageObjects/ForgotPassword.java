package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {


    public WebDriver driver;

    private By emailField = By.id("dwfrm_requestpassword_email");
    private By sendButton = By.id("dwfrm_requestpassword_send");


    public ForgotPassword(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement emailInput() {
        return driver.findElement(emailField);
    }

    public WebElement sendButton() {
        return driver.findElement(sendButton);
    }

}
