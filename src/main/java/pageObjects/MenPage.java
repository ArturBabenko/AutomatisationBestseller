package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MenPage {

public WebDriver driver;

    private By twoForTShort = By.xpath("//a[contains(@href, 'jack-and-jones-5')]");
    private By tShirt = By.cssSelector("a[data-itemid*='5714912447949']");
    private By sizeSelect = By.xpath("//a[contains(@title, 'Wybierz Rozmiar: ')]");
    private By cartAdd = By.id("add-to-cart");
    private By cartOpen = By.xpath("//a[@title='Przejdź do koszyka']");
    private By addOne = By.linkText("+");
    private By priceOneElement = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[3]/main[1]/div[2]/div[1]/section[2]/div[1]/div[2]/div[2]/div[1]/em[1]");
    private By priceTwoElements = By.xpath("//span[@class='cart-summary__subtotal__value']");
    private By itemOnPage = By.xpath("//span[@class='search-options-bar__count']");

    public MenPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement twoForTShort() { return driver.findElement(twoForTShort); }
    public WebElement tShirt() { return driver.findElement(tShirt); }
    public WebElement sizeSelect() { return driver.findElement(sizeSelect); }
    public WebElement cartAdd() { return driver.findElement(cartAdd); }
    public WebElement cartOpen() { return driver.findElement(cartOpen); }
    public WebElement addOne() { return driver.findElement(addOne); }
    public WebElement priceOneElement() { return driver.findElement(priceOneElement); }
    public WebElement priceTwoElements() { return driver.findElement(priceTwoElements); }
    public WebElement itemOnPage() { return driver.findElement(itemOnPage); }

    public boolean priceCompare(String a, String b) {
        // here I recieve prices for one/two items in string
        // and here i split strings by patterns below convert to int and compare
        // method returns true if 2*item price with discount
        String[] partsA = a.split(" ");
        String part1a = partsA[0];
        part1a = part1a.replaceAll(",", ".");
        double oneItem = Double.parseDouble(part1a);

        String[] partsB = b.split(" ");
        String part1b = partsB[0];
        part1b = part1b.replaceAll(",", ".");
        double twoItem = Double.parseDouble(part1b);

        if (!(2*oneItem == twoItem))
            return true;
        return false;
    }
    public int itemCount(String abc) {
        String[] parts = abc.split(" ");
        String part2 = parts[1];
        int abcInt = Integer.parseInt(part2);

        return abcInt;
    }
}
