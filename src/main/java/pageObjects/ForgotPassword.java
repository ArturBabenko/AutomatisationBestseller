package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {


    public WebDriver driver;

    private By emailField = By.id("dwfrm_requestpassword_email");
    private By sendButton = By.id("dwfrm_requestpassword_send");
    private By emptyField = By.xpath("//span[@class='js-field-label error']");
    private String emptyFieldErrText = "E-mail: To pole jest wymagane.";
    private String wrongEmailTypeText = "E-mail: Wprowadź prawidłowy adres e-mail.";
    private By sendConfirmation = By.xpath("//h3[@class='password-reset__header js-password-reset-request-success']");
    private String sendTextConfirm = "OTRZYMALIŚMY ŻĄDANIE";


    public ForgotPassword(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement emailInput() {
        return driver.findElement(emailField);
    }
    public WebElement sendButton() {
        return driver.findElement(sendButton);
    }
    public String emptyField() {
        return driver.findElement(emptyField).getText();
    }
    public String emptyFieldErrText() { return emptyFieldErrText; }
    public String wrongEmailTypeText() { return wrongEmailTypeText; }
    public String sendConfirmation() {
        return driver.findElement(sendConfirmation).getText();
    }
    public String sendTextConfirm() { return sendTextConfirm; }

}
