package Test;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Pages.AuthPage;
import Pages.InventoryPage;
import Pages.CartPage;

public class SauceDemoTests extends BaseTest {

    private AuthPage authPage;
    private InventoryPage inventoryPage;
    private CartPage cartPage;

    @BeforeClass
    public void setUp() {
        super.setUp();
        authPage = new AuthPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
    }

    @Test
    public void testSuccessfulLogin() {
        authPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html",
                "User is not redirected to inventory page after login.");
    }

    @Test
    public void testInvalidLogin() {
        authPage.login("invalid_user", "invalid_password");
        Assert.assertTrue(authPage.getErrorMessage().contains("Username and password do not match"),
                "Expected error message is not displayed.");
    }

    @Test(dependsOnMethods = {"testSuccessfulLogin"})
    public void testAddToCart() {
        inventoryPage.addToCart();
        inventoryPage.viewCart();
        Assert.assertEquals(cartPage.getItemName(), "Sauce Labs Backpack",
                "Item name in cart does not match expected.");
    }

    @Test(dependsOnMethods = {"testAddToCart"})
    public void testRemoveFromCart() {
        cartPage.removeItem();
        Assert.assertTrue(cartPage.isCartEmpty(), "Cart should be empty after removing item.");
    }

    @Test(dependsOnMethods = {"testSuccessfulLogin"})
    public void testEmptyCart() {
        inventoryPage.viewCart();
        Assert.assertTrue(cartPage.isCartEmpty(), "Cart should be empty on first visit.");
    }
}
