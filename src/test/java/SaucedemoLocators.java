import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SaucedemoLocators {
    @Test
    public void locators(){

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");

        WebElement usernameFielendId = driver.findElement(By.id("user-name"));
        WebElement passwordFielendId = driver.findElement(By.id("password"));

        WebElement usernameFielendName = driver.findElement(By.name("user-name"));
        WebElement passwordFielendName = driver.findElement(By.name("password"));

        WebElement loginButtonClassName = driver.findElement(By.className("btn_action"));

        WebElement inputFieledTagName = driver.findElement(By.tagName("input"));

        //WebElement linkText = driver.findElement(By.linkText("standard_user"));

        //WebElement partialLinkText = driver.findElement(By.partialLinkText("standard"));

        By xpathByAttribute = By.xpath("//input[@id='user-name']");

        By xpathByText = By.xpath("//input[text()='Username']");

        By xpathPartialAttribute = By.xpath("//input[contains(@class,'input')]");

        By xpathPartialText = By.xpath("//span[contains(text(),'Backpack')]");

        By xpathAncestor = By.xpath("//*[text()='Sauce Labs Backpack']//ancestor::div");

        By xpathDescendant = By.xpath("//div[@class='inventory_list']//descendant::span");

        By xpathFollowing = By.xpath("//*[text()='Sauce Labs Backpack']//following::button");

        By xpathParent = By.xpath("//span[text()='Sauce Labs Backpack']/parent::div");

        By xpathPreceding = By.xpath("//*[text()='Sauce Labs Backpack']//preceding::div");

        By xpathAndCondition = By.xpath("//input[@class='input_error form_input' and @type='text']");


        By cssClass = By.cssSelector(".btn_action");

        By cssMultiClass = By.cssSelector(".inventory_item_name.inventory_item_label");

        By cssParentChild = By.cssSelector(".shopping_cart_link .shopping_cart_badge");

        By cssId = By.cssSelector("#user-name");

        By cssTagName = By.cssSelector("input");


        By cssTagClass = By.cssSelector("input.input_error");

        By cssAttribute = By.cssSelector("[type='text']");

        By cssAttributeRegex = By.cssSelector("[class~=input]");

        By cssAttributeStartsWith = By.cssSelector("[id^='user']");

        By cssAttributeEndsWith = By.cssSelector("[id$='name']");

        By cssAttributeContains = By.cssSelector("[id*='name']");

        usernameFielendId.sendKeys("standard_user");
        passwordFielendId.sendKeys("secret_sauce");
        loginButtonClassName.click();

        driver.quit();

    }
}
