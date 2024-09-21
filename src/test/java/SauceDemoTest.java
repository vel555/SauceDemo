import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SauceDemoTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void testAddToCart() {

        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.className("btn_action"));

        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");
        loginButton.click();


        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addToCartButton.click();


        WebElement cartIcon = driver.findElement(By.className("shopping_cart_link"));
        cartIcon.click();

        
        WebElement itemName = driver.findElement(By.className("inventory_item_name"));
        WebElement itemPrice = driver.findElement(By.className("inventory_item_price"));


        String expectedItemName = "Sauce Labs Backpack";
        String expectedItemPrice = "$29.99";


        Assert.assertEquals(itemName.getText(), expectedItemName, "Item name in cart does not match expected.");
        Assert.assertEquals(itemPrice.getText(), expectedItemPrice, "Item price in cart does not match expected.");
    }

    @AfterClass
    public void tearDown() {

        driver.quit();
    }
}