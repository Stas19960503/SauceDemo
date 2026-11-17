package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AuthPage;

import static org.testng.Assert.assertTrue;

public class AuthPageTest extends BaseTest {

    private AuthPage authPage;

    @BeforeMethod
    public void initPage() {
       authPage = new AuthPage(driver);
    }

    @Test
    public void testSuccessfulLogin() {
        driver.get("https://www.saucedemo.com/");

        authPage.login("standard_user", "secret_sauce");

        assertTrue(driver.getCurrentUrl().contains("inventory.html"),
                "Не удалось войти в систему!");
    }

    @Test
    public void testInvalidLogin() {
        driver.get("https://www.saucedemo.com/");

        authPage.login("standard_user", "wrong_password");

        String error = authPage.getErrorMessage();
        assertTrue(error.contains("Username and password do not match"),
                "Нет ошибки о неверном пароле");
    }

    @Test
    public void testLockedOutUser() {
        driver.get("https://www.saucedemo.com/");

        authPage.login("locked_out_user", "secret_sauce");

        String error = authPage.getErrorMessage();
        assertTrue(error.contains("Sorry, this user has been locked out"),
                "Нет ошибки о блокировке");
    }

    @Test
    public void testEmptyFieldsLogin() {
        driver.get("https://www.saucedemo.com/");

        authPage.clickLoginButton();

        String error = authPage.getErrorMessage();
        assertTrue(error.contains("Username is required"),
                "Нет ошибки о пустом поле");
    }
}
