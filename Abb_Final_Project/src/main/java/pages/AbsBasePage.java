package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public abstract class AbsBasePage {
    private final static String BASE_URL = System.getProperty("base.url");
    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;


    public AbsBasePage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#js-header-s3>.pr-4")
    List<WebElement> cards;
    public void openURL(String path) {
        driver.get(BASE_URL + path);
    }

    public void verifyPageTitle(String title){
        Assert.assertEquals(title,driver.getTitle());
    }


}
