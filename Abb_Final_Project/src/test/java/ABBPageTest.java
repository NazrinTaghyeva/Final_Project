import driver.DriverFactory;
import exceptions.DriverNotSupported;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ABBPage;

public class ABBPageTest {
    private WebDriver driver;

    @BeforeMethod
    public void init() throws DriverNotSupported {
        this.driver = new DriverFactory().getDriver();
    }

    @Test
    public void checkPageTitle() {
        new ABBPage(driver).openURL("");
        new ABBPage(driver).verifyPageTitle("ABB - Müasir, Faydalı, Universal");
    }

    @AfterMethod
    public void close() {
        if (this.driver != null) {
            this.driver.close();
            this.driver.quit();
        }

    }
}
