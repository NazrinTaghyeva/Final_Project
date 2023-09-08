import driver.DriverFactory;
import exceptions.DriverNotSupported;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BankPage;

public class BankTest {
    private WebDriver driver;

    @BeforeMethod
    public void init() throws DriverNotSupported {
        this.driver = new DriverFactory().getDriver();
    }

    @Test
    public void checkNewWindow() {
        new BankPage(driver).openURL("");
        new BankPage(driver).pageTitleShouldBeOpenNewWindow("ABB mobile – Sadə və sürətli");
    }

    @Test
    public void verifyPage(){
        new BankPage(driver).openURL("");
        new BankPage(driver).clickCard();
        new BankPage(driver).verifyPageTitle("Bank 24/7");
        System.out.println("truee");
    }
    @AfterMethod
    public void close() {
        if (this.driver != null) {
            this.driver.close();
            this.driver.quit();
        }

    }
}
