import driver.DriverFactory;
import exceptions.DriverNotSupported;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.IpotekaPage;

public class IpotekaTest {
    private WebDriver driver;

    @BeforeMethod
    public void init() throws DriverNotSupported {
        this.driver = new DriverFactory().getDriver();
    }

//    @Test
//    public void verifyPage(){
//        new IpotekaPage(driver).openURL("");
//        new IpotekaPage(driver).verifyPageTitle("İpoteka Krediti - 6%-dən Başlayan İpoteka Kreditleri ✔\uFE0F");
//    }

    @Test
    public void checkChoice() {
        new IpotekaPage(driver).openURL("");
        new IpotekaPage(driver).optionForIpoteka();
    }


    @AfterMethod
    public void close() {
        if (this.driver != null) {
            this.driver.close();
            this.driver.quit();
        }

    }
}
