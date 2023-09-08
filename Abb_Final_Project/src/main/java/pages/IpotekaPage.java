package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class IpotekaPage extends AbsBasePage{
    public IpotekaPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "#js-header-s3>.pr-4")
    List<WebElement> cards;

    @FindBy(linkText = "Daxili ipoteka krediti")
    WebElement linkText;

    @FindBy(css=".pl-lg-3>.d-flex.flex-column.flex-lg-row.flex-md-row.align-items-center.pos-xl-absolute.bottom-0>a")
    List<WebElement> anchorsTag;

    @FindBy(css="label.col.mr-2.form-input.cursor-p.js-form-radio")
    List<WebElement> labels;

    @FindBy(linkText = "Xeyr")
    WebElement noChoice;

//    public boolean verifyPageTitle(String pageTitle){
//        boolean result = false;
//        if (pageTitle.equalsIgnoreCase(driver.getTitle())){
//            result = true;
//        }
//        Assert.assertTrue(result);
//        return result;
//    }

    public void optionForIpoteka(){
        cards.get(1).click();
        anchorsTag.get(0).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",labels.get(1));
         if (labels.get(1).isDisplayed()){
             System.out.println("Xeyr is chose.....");
         }else {
             System.out.println("Xeyr is not chose....");
         }
        Assert.assertTrue(labels.get(1).isDisplayed());
    }
}
