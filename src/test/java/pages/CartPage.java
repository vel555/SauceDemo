
package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    private final By itemName = By.className("inventory_item_name");
    private final By removeButton = By.id("remove-sauce-labs-backpack");

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