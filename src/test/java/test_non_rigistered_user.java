import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class test_non_rigistered_user {
    WebDriver driver;
    elements_and_actions actions;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.amazon.eg");
        actions = new elements_and_actions(driver);
    }

    @Test
    public void test_scenario() {
        actions.search_input("shoes");
        actions.click_item();
        actions.add_to_wishlist();

        Assert.assertEquals(actions.get_title(),"تسجيل الدخول", "passed");
    }

    @AfterClass
    public void end_case() {
        driver.quit();
    }
}
