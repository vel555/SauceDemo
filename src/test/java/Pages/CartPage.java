


package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    private By itemName = By.className("inventory_item_name");
    private By removeButton = By.className("btn_remove");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getItemName() {
        return driver.findElement(itemName).getText();
    }

    public void removeItem() {
        driver.findElement(removeButton).click();
    }

    public boolean isCartEmpty() {
        return driver.findElements(itemName).isEmpty();
    }
}