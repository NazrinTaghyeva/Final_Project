package driver;

import driver.implmnts.FireFoxDriver;
import exceptions.DriverNotSupported;
import driver.implmnts.ChromeWebDriver;
import io.github.bonigarcia.wdm.managers.OperaDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverFactory implements DriverFactoryInterface{
    private String browserType = System.getProperty("browser").toLowerCase();

    @Override
    public WebDriver getDriver() throws DriverNotSupported {
        switch(this.browserType) {
            case "chrome": {
                return new ChromeWebDriver().newDriver();
            }
            case "firefox":{
                return  new FireFoxDriver().newDriver();
            }
            default:
                throw new DriverNotSupported(this.browserType);
        }

    }
}
