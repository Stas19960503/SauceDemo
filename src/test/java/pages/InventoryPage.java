package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {
    private WebDriver driver;
    private By firstItemName = By.cssSelector(".inventory_item_name");
    private By firstItemPrice = By.cssSelector(".inventory_item_price");
    private By firstAddToCartButton = By.cssSelector(".btn_inventory");
    private By cartIcon = By.className("shopping_cart_link");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getFirstItemName() {
        return driver.findElement(firstItemName).getText();
    }

    public String getFirstItemPrice() {
        return driver.findElement(firstItemPrice).getText();
    }

    public void addFirstItemToCart() {
        driver.findElement(firstAddToCartButton).click();
    }

    public void goToCart() {
        driver.findElement(cartIcon).click();
    }
}
