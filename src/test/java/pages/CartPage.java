package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;
    private By itemName = By.cssSelector(".inventory_item_name");
    private By itemPrice = By.cssSelector(".inventory_item_price");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getItemNameInCart() {
        return driver.findElement(itemName).getText();
    }

    public String getItemPriceInCart() {
        return driver.findElement(itemPrice).getText();
    }
}
