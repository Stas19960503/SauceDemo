package tests;

import org.testng.annotations.Test;
import pages.*;

import static org.testng.Assert.assertEquals;

public class CheckoutTest extends BaseTest {

    @Test
    public void testFullCheckoutFlow() {
        driver.get("https://www.saucedemo.com/");

        AuthPage authPage = new AuthPage(driver);
        authPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addItemToCart("Sauce Labs Backpack");
        inventoryPage.goToCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckout();

        CheckoutStepOnePage stepOnePage = new CheckoutStepOnePage(driver);
        stepOnePage.fillCheckoutInfo("Иван", "Иванов", "123456");

        CheckoutStepTwoPage stepTwoPage = new CheckoutStepTwoPage(driver);
        System.out.println("Итоговая сумма: " + stepTwoPage.getTotalPrice());
        stepTwoPage.clickFinish();

        CheckoutCompletePage completePage = new CheckoutCompletePage(driver);
        assertEquals(completePage.getCompleteMessage(), "Thank you for your order!",
                "Заказ не был успешно оформлен");
    }
}
