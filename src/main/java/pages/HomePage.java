package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{
    private WebDriver driver;

    @FindAll({@FindBy(xpath = "//*[@id=\"uitk-tabs-button-container\"]/li[2]/a"),
            @FindBy(xpath = "//*[@data-testid=\"lob-navigation\"]/li[2]")})
    private WebElement flightButton;

    @FindBy(css = "button[data-stid=\"location-field-leg1-origin-menu-trigger\"]")
    private WebElement leavingButton;
    @FindBy(id = "location-field-leg1-origin")
    private WebElement leavingInput;
    @FindBy(xpath = "//*[@class=\"uitk-typeahead-results no-bullet\"]/li[1]/button")
    private WebElement firstOptionleaving;
    @FindBy(css = "button[data-stid=\"location-field-leg1-destination-menu-trigger\"]")
    private WebElement goingButton;
    @FindBy(id = "location-field-leg1-destination")
    private WebElement goingToInput;
    @FindBy(xpath = "//*[@data-stid=\"location-field-leg1-destination-results\"]/li[1]/button")
    private WebElement firstOptionGoingTo;
    @FindBy(id = "d1-btn")
    private WebElement calendarButton;
    @FindBy(css = "button[aria-label=\"Apr 17, 2021.\"]")
    private WebElement firstDate;
    @FindBy(css = "button[aria-label=\"Apr 24, 2021.\"]")
    private WebElement finalDate;
    @FindBy(css = "button[data-stid=\"apply-date-picker\"]")
    private WebElement doneButtonCalendar;
    @FindBy(css = "button[data-testid=\"submit-button\"]")
    private WebElement searchButton;


    public HomePage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void clickFlights(){
        flightButton.click();
    }

    public void clickLeavingFrom(String leaving){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(leavingButton));
        leavingButton.click();
        leavingInput.sendKeys(leaving);
        wait.until(ExpectedConditions.elementToBeClickable(firstOptionleaving));
        leavingInput.sendKeys(Keys.ARROW_DOWN);
        leavingInput.sendKeys(Keys.ENTER);
    }

    public void clickGoingTo(String goingTo){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(goingButton));
        goingButton.click();
        goingToInput.sendKeys(goingTo);
        wait.until(ExpectedConditions.elementToBeClickable(firstOptionGoingTo));
        goingToInput.sendKeys(Keys.ARROW_DOWN);
        goingToInput.sendKeys(Keys.ENTER);
    }

    public void setDates(){
        WebDriverWait wait = new WebDriverWait(driver,30);
        calendarButton.click();
        driver.switchTo().activeElement();
        wait.until(ExpectedConditions.elementToBeClickable(firstDate));
        firstDate.click();
        finalDate.click();
        doneButtonCalendar.click();
    }

    public SearchDeparturePage clickSearchButton(){
        searchButton.click();
        return new SearchDeparturePage(driver);
    }


    private void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }
    private void clickLinkById(String linkId){
        driver.findElement(By.id(linkId)).click();
    }
    private void clickLinkByCssSelector(String cssSelector){
        driver.findElement(By.cssSelector(cssSelector)).click();
    }

}
