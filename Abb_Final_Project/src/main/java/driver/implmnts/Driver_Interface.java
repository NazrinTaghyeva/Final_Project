package driver.implmnts;

import exceptions.DriverNotSupported;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.Config;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;

public interface Driver_Interface {
    WebDriver newDriver() throws DriverNotSupported;

    default void localWebDriver(DriverManagerType driverType) throws DriverNotSupported{
        Config webDriverManagerConfig = WebDriverManager.getInstance().config();
        webDriverManagerConfig.setAvoidBrowserDetection(true);
        String browserVersion = System.getProperty("browser.version", "");
        if (!browserVersion.isEmpty()) {
            switch (driverType) {
                case CHROME:
                    webDriverManagerConfig.setChromeDriverVersion(browserVersion);
                    break;
                case FIREFOX:
                    webDriverManagerConfig.setFirefoxVersion(browserVersion);
                    break;
                case OPERA:
                    webDriverManagerConfig.setOperaDriverVersion(browserVersion);
                    break;
                default:
                    System.out.println(new DriverNotSupported(driverType.name()));
            }
        }

        WebDriverManager.getInstance(driverType).setup();

    }
}
