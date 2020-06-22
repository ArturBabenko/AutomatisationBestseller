package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

public WebDriver driver;

    private By login = By.xpath("//a[@class='servicebar__account__icon']");
    private By mens = By.xpath("//a[@href='https://shop.bestseller.com/pl/pl/bc/men/']");

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

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

}
