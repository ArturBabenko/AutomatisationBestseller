package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {


    public WebDriver driver;

    private By emailField = By.xpath("//fieldset/div[1]/input"); // dynamic id didn't stop me, i know xpath :)
    private By passwordField = By.xpath("//input[@type='password']");
    private By remember = By.xpath("//label[@for='dwfrm_login_rememberme']");
    private By loginButton = By.name("dwfrm_login_login");
    private By loginError = By.xpath("//div[@class='login__form-error']");
    private By doNotRememberPass = By.xpath("//a[@class='login__link-passwordreset']");
    private By isLogin = By.xpath("//a[@title='Wyloguj się']");
    private String expectedMsg = "Niestety, to nie pasuje do naszych rekordów. Sprawdź pisownię i spróbuj ponownie.";
    private By emptyField = By.xpath("//span[contains(text(),'To pole jest wymagane.')]");
    private String emptyErrMsg = "To pole jest wymagane.";


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // i use methods, because when bestseller team change something i web code i will chang it only above
    public WebElement emailInput() {
        return driver.findElement(emailField);
    }
    public WebElement passwordInput() {
        return driver.findElement(passwordField);
    }
    public WebElement rememberBox(){
        return driver.findElement(remember);
    }
    public WebElement loginButton(){
        return driver.findElement(loginButton);
    }
    public String loginError(){
        return driver.findElement(loginError).getText();
    }
    public WebElement isLogin() {return driver.findElement(isLogin);}
    public String expectedMsg() {return expectedMsg;}
    public String emptyField(){
        return driver.findElement(emptyField).getText();
    }
    public String emptyErrMsg() {return emptyErrMsg;}
    public ForgotPassword forgotPassword() {
        driver.findElement(doNotRememberPass).click();
        ForgotPassword fp = new ForgotPassword(driver);
        return fp;
    }

}
