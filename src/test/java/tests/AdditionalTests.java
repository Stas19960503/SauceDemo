package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.AuthPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AdditionalTests extends BaseTest {

    @Test
    public void testInvalidLogin() {
        driver.get("https://www.saucedemo.com/");
        new AuthPage(driver).login("standard_user", "wrong_password");
        String error = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        assertTrue(error.contains("Username and password do not match"), "Нет ошибки о неверном пароле");
    }

    @Test
    public void testLockedOutUser() {
        driver.get("https://www.saucedemo.com/");
        new AuthPage(driver).login("locked_out_user", "secret_sauce");
        String error = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        assertTrue(error.contains("Sorry, this user has been locked out"), "Нет ошибки о блокировке");
    }

    @Test
    public void testEmptyFieldsLogin() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("login-button")).click();
        String error = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        assertTrue(error.contains("Username is required"), "Нет ошибки о пустом поле");
    }

    @Test
    public void testRemoveItemFromCart() {
        driver.get("https://www.saucedemo.com/");
        new AuthPage(driver).login("standard_user", "secret_sauce");
        driver.findElement(By.cssSelector(".btn_inventory")).click();
        driver.findElement(By.cssSelector(".btn_inventory")).click();
        String badge = driver.findElement(By.className("shopping_cart_badge")).getText();
        assertEquals(badge, "1", "Количество товаров в корзине не равно 1");
    }

    @Test
    public void testSortByPrice() {
        driver.get("https://www.saucedemo.com/");
        new AuthPage(driver).login("standard_user", "secret_sauce");
        driver.findElement(By.className("product_sort_container")).click();
        driver.findElement(By.cssSelector("[value='lohi']")).click();
        String firstPrice = driver.findElement(By.className("inventory_item_price")).getText();
        assertEquals(firstPrice, "$7.99", "Сортировка по цене не работает");
    }
}
