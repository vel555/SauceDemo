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


        usernameFielendId.sendKeys("standard_user");
        passwordFielendId.sendKeys("secret_sauce");
        loginButtonClassName.click();

        driver.quit();

    }
}
