package tests;

import org.testng.annotations.Test;
import pages.AuthPage;
import pages.CartPage;
import pages.InventoryPage;

import static org.testng.Assert.assertEquals;

public class CartTest extends BaseTest {

    @Test
    public void addItemAndVerifyInCart() {
        driver.get("https://www.saucedemo.com/");

        AuthPage authPage = new AuthPage(driver);
        authPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        String expectedName = inventoryPage.getFirstItemName();
        String expectedPrice = inventoryPage.getFirstItemPrice();
        inventoryPage.addFirstItemToCart();

        inventoryPage.goToCart();

        CartPage cartPage = new CartPage(driver);
        assertEquals(cartPage.getItemNameInCart(), expectedName, "Имя товара не совпадает");
        assertEquals(cartPage.getItemPriceInCart(), expectedPrice, "Стоимость товара не совпадает");
    }
}
