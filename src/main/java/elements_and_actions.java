import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class elements_and_actions {
    WebDriver driver;
    WebDriverWait wait;
    public elements_and_actions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//*[@placeholder='بحث في Amazon.eg']")
    WebElement search;

    @FindBy (xpath = "(//*[@class='s-image'])[5]")
    WebElement select_item;

    @FindBy (name = "submit.add-to-registry.wishlist.unrecognized")
    WebElement wishlist;

    @FindBy (xpath = "//*[@class='a-spacing-small']")
    WebElement page_title;


    public void search_input(String input) {
        wait.until(ExpectedConditions.visibilityOf(search)).sendKeys(input);
        search.sendKeys(Keys.ENTER);
    }

    public void click_item() {
        wait.until(ExpectedConditions.elementToBeClickable(select_item)).click();
    }

    public void add_to_wishlist() {
        wait.until(ExpectedConditions.elementToBeClickable(wishlist)).click();
    }

    public String get_title() {
        wait.until(ExpectedConditions.visibilityOf(page_title)).getText();
        return page_title.getText();
    }
}
