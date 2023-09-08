package pages;

import data.CardsName;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class CardsPage extends AbsBasePage {
    public CardsPage(WebDriver driver) {
        super(driver);
    }

    JavascriptExecutor javascriptExecutor;
    @FindBy(css = "#js-header-s3>.pr-4")
    List<WebElement> cards;
    @FindBy(css = ".row.py-5>.col-lg-4.mb-3.mb-lg-0>div>div>h3")
    List<WebElement> cardsNames;

    public void clickCard() {
        cards.get(3).click();
    }

//    public void cardsTitleShouldBeSameAs(String cardsPageTitle) {
//        clickCard();
//        Assert.assertEquals(cardsPageTitle,
//                driver.getTitle());
//    }

    public void cardsNameShouldBeAs(CardsName cardsData) {
        clickCard();
        System.out.println(cardsData.getName());
        for (WebElement card : cardsNames) {
            System.out.println(card.getText());
            if (card.getText().equalsIgnoreCase(cardsData.getName())) {
                javascriptExecutor = (JavascriptExecutor) driver;
                javascriptExecutor.executeScript("arguments[0].click()", card);
                String name = cardsData.getName();
                break;
            }
            Assert.assertTrue(card.isDisplayed());
        }


    }

}
