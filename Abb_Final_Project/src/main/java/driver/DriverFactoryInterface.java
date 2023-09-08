package driver;

import exceptions.DriverNotSupported;
import org.openqa.selenium.WebDriver;

public interface DriverFactoryInterface {
    WebDriver getDriver() throws DriverNotSupported;

}
