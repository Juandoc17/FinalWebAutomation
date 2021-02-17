package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class SearchReturnPage extends BasePage{
    private WebDriver driver;

    @FindAll({@FindBy(id = "AQqWAgr_AXY1LXNvcy1kZGNkNjQ4ODA2Mzg0M2NjOWQxZmY0NjRjNDkwNDBkMy0xNy0xOS0xfjIuU35BUW9FQ0lIeEJCSUhDTlFFRUFjWUd5QUhJQUVnRENBTklBa29BbElFMlBRQkFGZ0NjQUF-QVFvb0NpWUkxWUlCRWdReU1UWTRHSXVRQVNDTHVBRW83SXpxQVRDcGplb0JPRTVBQUZnQmFnSkNSUW9vQ2lZSTFZSUJFZ1F5TXpZMUdJdTRBU0NMa0FFbzY5X3FBVEN1NE9vQk9FNUFBRmdCYWdKQ1JSSUtDQUVRQVJnQktnSlZRUmdCSWdRSUFSQUJLQUlvQXlnRU1BSRGkcD0K1zNTQCICAQIqBRIDCgExEj8KFgoKMjAyMS0wNC0xNxIDTEFTGgNMQVgKFgoKMjAyMS0wNC0yNBIDTEFYGgNMQVMSBxIFQ09BQ0gaAhABIAIaCggBEgYaACICCAIgAQ=="),
            @FindBy(xpath = "//*[@id=\"flightModuleList\"]/li[3]"),
            @FindBy(xpath = "//*[@id=\"flightModuleList\"]/li[1]//div[@class=\"uitk-col standard-col-l-margin all-col-shrink display-larger-screens-only\"]/button")})
    private WebElement thirdResult;

    @FindAll({
            @FindBy(css = "#basic-economy-tray-content-1 button[data-test-id=\"select-button-1\"]"),
            @FindBy(css = "button[data-test-id=\"select-button\"]")})
    private WebElement confirmFlight;

    @FindAll({
            @FindBy(css = "a[data-test-id=\"forcedChoiceNoThanks\"]"),
            @FindBy(id = "forcedChoiceNoThanks")})
    private WebElement noThanksButton;

    @FindAll({@FindBy(css = "button[data-test-id=\"select-button\"]"),
            @FindBy(css = "button[data-test-id=\"select-link\"]")})
    private List<WebElement> selectButtons;

    public SearchReturnPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public void clickThirdFLight(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(thirdResult));
        wait.until(ExpectedConditions.visibilityOfAllElements(selectButtons));
        clickButton(selectButtons.get(2));
        //clickButton(thirdResult);
        clickButton(confirmFlight);
    }

    public void clickOption(int index){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfAllElements(selectButtons));
        wait.until(ExpectedConditions.elementToBeClickable(thirdResult));
        clickButton(selectButtons.get(index-1));
        //clickButton(firstResult);
        //clickButton(confirmFlight);
    }

    public SearchReturnPage confirmFlight(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(confirmFlight));
        clickButton(confirmFlight);
        return new SearchReturnPage(driver);
    }


    public TripDetailsPage clickNoThanks(){
        driver.switchTo().activeElement();
        noThanksButton.click();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return new TripDetailsPage(driver);
    }


}
