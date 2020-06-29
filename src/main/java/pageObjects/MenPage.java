package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MenPage {

public WebDriver driver;

    private By clubPopup = By.xpath("//button[@class='customer-club-popup__close js-customer-club--close']");
    private By twoForTShort = By.xpath("//a[contains(@href, 'jack-and-jones-5')]");
    private By tShirt = By.cssSelector("a[data-itemid*='5714912447949']");
    private By sizeSelect = By.xpath("//a[contains(@title, 'Wybierz Rozmiar: ')]");
    //not specified T-shirt size because I'm testing discount feature and any available size can be used
    private By cartAdd = By.id("add-to-cart");
    private By cartOpen = By.xpath("//a[@title='Przejdź do koszyka']");
    private By addOne = By.linkText("+");
    private By priceOneElement = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[3]/main[1]/div[2]/div[1]/section[2]/div[1]/div[2]/div[2]/div[1]/em[1]");
    private By priceTwoElements = By.xpath("//span[@class='cart-summary__subtotal__value']");
    private By itemOnPage = By.xpath("//span[@class='search-options-bar__count']");
    //below variables for Whishlist
    private By menShoesPopUp = By.xpath("//span[@data-menu-category='bc-men-shoes']");
    private By menFlipFlop = By.xpath("//a[contains(@href, 'flip-flops')]");
    private By flipFlopHeart = By.xpath("//div[@class = 'heart' and @data-wishlist-id='5714506910354']");
    private By menSandals = By.xpath("//li[contains(@class,'category-navigation__item')]//a[contains(@class,'category-navigation__link')][contains(text(),'Sandals')]");
    private By sandalsHeart = By.xpath("//div[@class = 'heart' and @data-wishlist-id='5714626252846']");
    private By menClothingMenu = By.xpath("//a[@title='Przejdź do kategorii: Clothing']");
    private By menJeans = By.xpath("//li[contains(@class,'category-navigation__item')]//a[contains(@class,'category-navigation__link')][contains(text(),'Jeans')]");
    private By jeansHeart = By.xpath("//div[@class = 'heart' and @data-wishlist-id='5714491397994']");
    //below variables for Sort Check
    private By menClothing = By.xpath("//span[@data-menu-category='bc-men-fashion']");
    private By menJeansPopUp = By.xpath("//div[@class='wide-menu__third__group wide-menu__third__group--open']//a[@class='category-navigation__link'][contains(text(),'Jeans')]");
    private By sortSelect = By.xpath("//div[@class='search-options-bar js-search-options-bar']//div[@class='sorting-controls']//select");
    private String selectValue = "https://shop.bestseller.com/pl/pl/bc/men/clothing/jeans/?srule=SSO_Price-high-to-low&start=0&sz=60";
    private By firstItemPrice = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[3]/main[1]/div[7]/div[3]/div[1]/article[1]/div[1]/p[2]/em[1]");
    private By fourItemPrice = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[3]/main[1]/div[7]/div[3]/div[4]/article[1]/div[1]/p[2]/em[1]");
    //below variables for Cart Page
    private By flipFlopItem01 = By.xpath("//img[@data-itemid='5714506910354']");
    private By sizeSelected = By.xpath("//ul[@class='swatch size' and li[contains(@class, 'swatch__item--selected')]]");

    public MenPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement clubPopup() { return driver.findElement(clubPopup); }
    public WebElement twoForTShort() { return driver.findElement(twoForTShort); }
    public WebElement tShirt() { return driver.findElement(tShirt); }
    public WebElement sizeSelect() { return driver.findElement(sizeSelect); }
    public WebElement cartAdd() { return driver.findElement(cartAdd); }
    public WebElement cartOpen() { return driver.findElement(cartOpen); }
    public WebElement addOne() { return driver.findElement(addOne); }
    public WebElement priceOneElement() { return driver.findElement(priceOneElement); }
    public WebElement priceTwoElements() { return driver.findElement(priceTwoElements); }
    public WebElement itemOnPage() { return driver.findElement(itemOnPage); }
    //methods for whishlist
    public WebElement menShoesPopUp() { return driver.findElement(menShoesPopUp); }
    public WebElement menFlipFlop() { return driver.findElement(menFlipFlop); }
    public WebElement flipFlopHeart() { return driver.findElement(flipFlopHeart); }
    public WebElement menSandals() { return driver.findElement(menSandals); }
    public WebElement sandalsHeart() { return driver.findElement(sandalsHeart); }
    public WebElement menClothingMenu() { return driver.findElement(menClothingMenu); }
    public WebElement menJeans() { return driver.findElement(menJeans); }
    public WebElement jeansHeart() { return driver.findElement(jeansHeart); }
    //below methods for Sort check
    public WebElement menClothing() { return driver.findElement(menClothing); }
    public WebElement menJeansPopUp() { return driver.findElement(menJeansPopUp); }
    public WebElement sortSelect() { return driver.findElement(sortSelect); }
    public String selectValue() { return selectValue; }
    public WebElement firstItemPrice() { return driver.findElement(firstItemPrice); }
    public WebElement fourItemPrice() { return driver.findElement(fourItemPrice); }
    //below methods for Cart Page
    public WebElement flipFlopItem01() { return driver.findElement(flipFlopItem01); }
    public WebElement sizeSelected() { return driver.findElement(sizeSelected); }




    public boolean priceCompare(String a, String b) {
        // here I receive prices for one/two items in string
        // and here i split strings by patterns below, convert to int and compare
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
    public int itemCount(String abc) { // metod convert string items on page to int type
        String[] parts = abc.split(" ");
        String part2 = parts[1];
        int abcInt = Integer.parseInt(part2);

        return abcInt;
    }

    public boolean priceHighToLow(String a, String b) {

        String[] partsA = a.split(" ");
        String part1a = partsA[0];
        part1a = part1a.replaceAll(",", ".");
        double oneItem = Double.parseDouble(part1a);

        String[] partsB = b.split(" ");
        String part1b = partsB[0];
        part1b = part1b.replaceAll(",", ".");
        double twoItem = Double.parseDouble(part1b);

        if (oneItem >= twoItem)
            return true;
        return false;
    }

}
