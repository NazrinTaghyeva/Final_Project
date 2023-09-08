package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class BankPage extends AbsBasePage{

    public BankPage(WebDriver driver) {
        super(driver);
    }

    public String pageTitle() {
        return driver.getTitle();
    }

    @FindBy(css = "h1")
    WebElement headerElement;

    @FindBy(css=".color-262626.fw-500.fs-18.fs-lg-22.hover.mt-1.mt-lg-0")
    WebElement abbMobileBank;

    private static String getNewWindowHandle(WebDriver driver) {
        String currentWindowHandle = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(currentWindowHandle)) {
                return windowHandle;
            }
        }
        return null;
    }

    public void clickCard(){
        cards.get(7).click();
    }

    public void pageTitleShouldBeOpenNewWindow(String actualTitle) {
        clickCard();
    abbMobileBank.click();
        driver.switchTo().window(getNewWindowHandle(driver));
//        WebElement headerElement = driver.findElement(By.tagName("h1"));
        String headerText = headerElement.getText();
        System.out.println(headerText);
        Assert.assertEquals(actualTitle,headerText);

    }
}
