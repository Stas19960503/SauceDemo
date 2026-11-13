package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStepTwoPage extends BasePage {

    private By totalPrice = By.className("summary_total_label");
    private By finishButton = By.id("finish");

    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
    }

    public String getTotalPrice() {
        return getText(totalPrice);
    }

    public void clickFinish() {
        click(finishButton);
    }
}
