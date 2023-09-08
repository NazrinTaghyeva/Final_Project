package pages;

import org.openqa.selenium.WebDriver;

public class ABBPage extends AbsBasePage {
    public ABBPage(WebDriver driver) {
        super(driver);
    }

    public String pageTitle() {
        return driver.getTitle();
    }
}
