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
    // item name
    private String clothName = "Marynarka";
    private By clothNameFiltr = By.xpath("//a[@title='marynarka']");
    private By firstItemCheck = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[3]/main[1]/div[5]/div[3]/div[1]/article[1]/div[1]/header[1]/a[1]");
    private By fiveItemCheck = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[3]/main[1]/div[5]/div[3]/div[5]/article[1]/div[1]/header[1]/a[1]");
    private By tenItemCheck = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[3]/main[1]/div[5]/div[3]/div[10]/article[1]/div[1]/header[1]/a[1]");
    //exist item id and non exist
    private String existItemID = "5714507460919";
    private By existItemCheck = By.xpath("//img[@data-itemid='5714507460919']");
    private String nonExistItemID = "57145074609190000";
    private By nonExistItemCheck = By.xpath("//img[@data-itemid='57145074609190000']");
    // spec char
    private String specChars = "!@#$%^&*()";
    private By errorMsg = By.xpath("//div[@class='plp-content__searched-for']");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement checkoutCart() { return driver.findElement(checkoutCart); }
    public WebElement itemTextCount() {return driver.findElement(itemTextCount);}
    public WebElement searchField() {return driver.findElement(searchField);}
    public WebElement maxSymbolsText() {return driver.findElement(maxSymbolsText);}
    public WebElement clothNameFiltr() {return driver.findElement(clothNameFiltr);}
    public String clothName() {return clothName;}
    public WebElement firstItemCheck() {return driver.findElement(firstItemCheck);}
    public WebElement fiveItemCheck() {return driver.findElement(fiveItemCheck);}
    public WebElement tenItemCheck() {return driver.findElement(tenItemCheck);}
    public String existItemID() {return existItemID;}
    public WebElement existItemCheck() {return driver.findElement(existItemCheck);}
    public String nonExistItemID() {return nonExistItemID;}
    public WebElement nonExistItemCheck() {return driver.findElement(nonExistItemCheck);}
    public String specChars() {return specChars;}
    public WebElement errorMsg() {return driver.findElement(errorMsg);}

    public int itemCount(String abc) { // metod convert string items on page to int type
        String[] parts = abc.split(" ");
        String part2 = parts[1];
        String part3 = parts[2];
        String unityPart = part2+part3;
        int abcInt = Integer.parseInt(unityPart);
        return abcInt;
    }

    public String longText() { // generate long string
        String a = "0";
        for (int i = 0; i < 256; i++) {
            a+=i;
        }
        return a;
    }

    public int stringCount(String string) { // count symbols in string
        int count = 0;
        for(int i = 0; i < string.length(); i++) {
            if(string.charAt(i) != ' ')
                count++;
        }
        return count;
    }

    public boolean wordSearch(String sentence, String word) { // check if word exist in sentences
        if ( sentence.toLowerCase().indexOf(word.toLowerCase()) != -1 ) { return true; }
        else { return false; }
    }
}

