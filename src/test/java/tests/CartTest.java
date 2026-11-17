package tests;

import org.testng.annotations.Test;
import pages.AuthPage;
import pages.CartPage;
import pages.InventoryPage;

import static org.testng.Assert.assertEquals;

public class CartTest extends BaseTest {

    @Test
    public void testAddAnyItemToCart() {
        driver.get("https://www.saucedemo.com/");
        AuthPage authPage = new AuthPage(driver);
        authPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);

        String expectedName = inventoryPage.getAnyItemName();
        String expectedPrice = inventoryPage.getAnyItemPrice();

        inventoryPage.addAnyItemToCart();

        inventoryPage.goToCart();

        CartPage cartPage = new CartPage(driver);

        assertEquals(cartPage.getItemNameInCart(), expectedName,
                "Имя товара в корзине не совпадает с тем, что был на витрине!");

        assertEquals(cartPage.getItemPriceInCart(), expectedPrice,
                "Цена товара в корзине не совпадает с ценой на витрине!");
    }
}
