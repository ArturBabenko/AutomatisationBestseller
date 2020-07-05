package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {

public WebDriver driver;

    private By checkoutCart = By.xpath("//button[@class='search__submit']");
    private By itemTextCount = By.xpath("//span[@class='search-options-bar__count']");
    private By searchField = By.xpath("//input[@name='q']");
    // max symbols
    private By maxSymbolsText = By.xpath("//span[@class='plp-content__search-phrase']");


    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement checkoutCart() { return driver.findElement(checkoutCart); }
    public WebElement itemTextCount() {return driver.findElement(itemTextCount);}
    public WebElement searchField() {return driver.findElement(searchField);}
    public WebElement maxSymbolsText() {return driver.findElement(maxSymbolsText);}

    public int itemCount(String abc) { // metod convert string items on page to int type
        String[] parts = abc.split(" ");
        String part2 = parts[1];
        String part3 = parts[2];
        String unityPart = part2+part3;
        int abcInt = Integer.parseInt(unityPart);
        return abcInt;
    }

    public String longText() {
        String a = "0";
        for (int i = 0; i < 256; i++) {
            a+=i;
        }
        return a;
    }

    public int stringCount(String string) {
        int count = 0;
        for(int i = 0; i < string.length(); i++) {
            if(string.charAt(i) != ' ')
                count++;
        }
        return count;
    }
}

