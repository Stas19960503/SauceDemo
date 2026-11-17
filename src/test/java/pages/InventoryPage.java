package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;

public class InventoryPage extends BasePage {

    private By cartIcon = By.className("shopping_cart_link");
    private By allItems = By.className("inventory_item");
    private By itemNames = By.className("inventory_item_name");
    private By itemPrices = By.className("inventory_item_price");
    private By addToCartButtons = By.tagName("button");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public void addAnyItemToCart() {
        WebElement firstItemCard = wait.until(org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated(allItems));
        WebElement addButton = firstItemCard.findElement(addToCartButtons);
        addButton.click();
    }

    public String getAnyItemName() {
        return wait.until(org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated(itemNames)).getText();
    }

    public String getAnyItemPrice() {
        return wait.until(org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated(itemPrices)).getText();
    }

    public void addItemToCart(String itemName) {
        By itemNameLocator = By.xpath("//div[text()='" + itemName + "']");

        By addButtonLocator = RelativeLocator.with(By.tagName("button")).below(itemNameLocator);

        click(addButtonLocator);
    }

    public void goToCart() {
        click(cartIcon);
    }
}
