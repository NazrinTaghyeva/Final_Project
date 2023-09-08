package driver.implmnts;

import exceptions.DriverNotSupported;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FireFoxDriver implements Driver_Interface{
    @Override
    public WebDriver newDriver() throws DriverNotSupported {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments();
        firefoxOptions.addArguments("--disable-notifications");
        firefoxOptions.addArguments("--no-first-run");
        firefoxOptions.addArguments("--homepage=about:blank");
        firefoxOptions.addArguments("--ignore-certificate-errors");

        localWebDriver(DriverManagerType.FIREFOX);
        return new FirefoxDriver(firefoxOptions);
    }


}
