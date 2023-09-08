package driver.implmnts;

import exceptions.DriverNotSupported;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeWebDriver implements Driver_Interface {

    @Override
    public WebDriver newDriver() throws DriverNotSupported {
        ChromeOptions optionsForChrome = new ChromeOptions();
//        optionsForChrome.addArguments("--user-data-dir");
//        optionsForChrome.addArguments("--lang");
//        optionsForChrome.addArguments("--disable-extensions");
//        optionsForChrome.addArguments("--no-sandbox");
        optionsForChrome.addArguments("--disable-notifications");
        optionsForChrome.addArguments("--no-first-run");
        optionsForChrome.addArguments("--homepage=about:blank");
        optionsForChrome.addArguments("--ignore-certificate-errors");

        localWebDriver(DriverManagerType.CHROME);
        return new ChromeDriver(optionsForChrome);
    }

}
