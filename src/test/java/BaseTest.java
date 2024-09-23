import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    WebDriver driver;
    @BeforeClass
    public void setUp() {

        driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");
    }
    @AfterClass
    public void tearDown() {

        driver.quit();
    }
}
