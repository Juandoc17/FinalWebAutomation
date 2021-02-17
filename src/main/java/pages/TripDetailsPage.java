package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TripDetailsPage extends BasePage{
    private WebDriver driver;

    @FindAll({@FindBy(css = "option[value=\"DURATION_INCREASING\"]"),
            @FindBy(css = "option[data-opt-id=\"sort-DURATION_INCREASING\"]")})
    private WebElement durationShortest;

    @FindAll({@FindBy(xpath = "//*[@class=\"uitk-type-heading-300\"]/td[2]"),
            @FindBy(id = "totalPriceForPassenger1-desktopView")})
    private WebElement totalPriceText;

    @FindAll({@FindBy(xpath = "//*[@class=\"uitk-table-body\"]/tr[3]/td[2]"),
            @FindBy(css = "//*[@id=\"importantRules-non-split-coach-N--coach-N---ECOBASIC\"]")})
    private WebElement guaranteeAndTaxesText;

    @FindAll({@FindBy(css = "button[data-test-id=\"goto-checkout-button\"]"),
            @FindBy(id = "bookButton")})
    private WebElement checkOutButton;

    @FindAll({@FindBy(xpath = "//*[@data-test-id=\"flight-review-0\"]/div/h2"),
            @FindBy(xpath = "//*[@class=\"flex-card flex-tile details OD0\"]")})
    private WebElement departureInfoTitle;

    @FindAll({@FindBy(xpath = "//*[@data-test-id=\"flight-review-0\"]/div[2]/div/div/span"),
            @FindBy(xpath = "//*[@class=\"flex-card flex-tile details OD0\"]/div/div/div[5]")})
    private WebElement departureInfoHour;

    @FindAll({@FindBy(xpath = "//*[@data-test-id=\"flight-review-1\"]/div/h2"),
            @FindBy(xpath = "//*[@class=\"flex-card flex-tile details OD1\"]")})
    private WebElement returnInfoTitle;

    @FindAll({@FindBy(xpath = "//*[@data-test-id=\"flight-review-1\"]/div[2]/div/div/span"),
            @FindBy(xpath = "//*[@class=\"flex-card flex-tile details OD1\"]/div/div/div[5]")})
    private WebElement returnInfoHour;


    public TripDetailsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean getTotalPrice(){
        boolean isDisplayed = false;
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfAllElements(totalPriceText));
        if(totalPriceText.isDisplayed()){
            isDisplayed = true;
        }
        return isDisplayed;
    }

    public boolean getGuaranteeText(){
        boolean isDisplayed = false;
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfAllElements(guaranteeAndTaxesText));
        if(guaranteeAndTaxesText.isDisplayed()){
            isDisplayed = true;
        }
        return isDisplayed;
    }

    public boolean getReturnAndDepartureInfo(){
        boolean isDisplayed = false;
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfAllElements(departureInfoTitle));
        wait.until(ExpectedConditions.visibilityOfAllElements(returnInfoTitle));
        if(departureInfoTitle.isDisplayed() && departureInfoHour.isDisplayed() && returnInfoTitle.isDisplayed() && returnInfoHour.isDisplayed()){
            isDisplayed = true;
        }
        return isDisplayed;
    }

    public WhoIsTravelingPage clickCheckOut(){
        clickButton(checkOutButton);
        return new WhoIsTravelingPage(driver);
    }
}
