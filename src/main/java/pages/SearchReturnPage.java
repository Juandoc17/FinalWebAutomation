package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class SearchReturnPage extends BasePage{
    private WebDriver driver;

    @FindAll({@FindBy(id = "AQqWAgr_AXY1LXNvcy1jNTIyNmU2MDdiM2M0YmQzODEwMzIzNWJlYzBhNjY5Ni0xNy0xOS0xfjIuU35BUW9FQ0lIeEJCSUhDTlFFRUFjWUd5QUhJQUVnRENBTklBa29BbElFMlBRQkFGZ0NjQUF-QVFvb0NpWUkxWUlCRWdReU1UWTRHSXVRQVNDTHVBRW83SXpxQVRDcGplb0JPRTVBQUZnQmFnSkNSUW9vQ2lZSTFZSUJFZ1F5TXpZMUdJdTRBU0NMa0FFbzY5X3FBVEN1NE9vQk9FNUFBRmdCYWdKQ1JSSUtDQUVRQVJnQktnSlZRUmdCSWdRSUFSQUJLQUlvQXlnRU1BSRGkcD0K1zNTQCICAQIqBRIDCgExEj8KFgoKMjAyMS0wNC0xNxIDTEFTGgNMQVgKFgoKMjAyMS0wNC0yNBIDTEFYGgNMQVMSBxIFQ09BQ0gaAhABIAIaCggBEgYaACICCAIgAQ=="),
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

    public SearchReturnPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public void clickThirdFLight(){
        clickButton(thirdResult);
        clickButton(confirmFlight);
    }

    public TripDetailsPage clickNoThanks(){
        driver.switchTo().activeElement();
        noThanksButton.click();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return new TripDetailsPage(driver);
    }


}
