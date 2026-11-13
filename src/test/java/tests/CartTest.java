package tests;

import org.testng.annotations.Test;
import pages.AuthPage;
import pages.CartPage;
import pages.InventoryPage;

import static org.testng.Assert.assertEquals;

public class CartTest extends BaseTest {

    @Test
    public void testAddSpecificItemToCart() {
        driver.get("https://www.saucedemo.com/");

        AuthPage authPage = new AuthPage(driver);
        authPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);

        String itemToBuy = "Sauce Labs Backpack";
        String expectedPrice = inventoryPage.getItemPriceByName(itemToBuy);

        inventoryPage.addItemToCart(itemToBuy);

        inventoryPage.goToCart();

        CartPage cartPage = new CartPage(driver);

        assertEquals(cartPage.getItemNameInCart(), itemToBuy,
                "Имя товара в корзине не совпадает с ожидаемым!");

        assertEquals(cartPage.getItemPriceInCart(), expectedPrice,
                "Цена товара в корзине не совпадает с ценой на витрине!");
    }
}
