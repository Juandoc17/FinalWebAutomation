package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchDeparturePage extends BasePage{
    private WebDriver driver;

    @FindAll({@FindBy(css = "select[data-test-id=\"sortDropdown\"]"),
            @FindBy(id = "sortDropdown")})
    private WebElement sortSelect;

    @FindAll({@FindBy(css = "option[value=\"DURATION_INCREASING\"]"),
            @FindBy(css = "option[data-opt-id=\"sort-DURATION_INCREASING\"]")})
    private WebElement durationShortest;
    @FindAll({@FindBy(css = "option[data-opt-id=\"sort-DURATION_DECREASING\"]"),
            @FindBy(css = "option[value=\"DURATION_DECREASING\"]")})
    private WebElement durationLongest;

    @FindAll({@FindBy(css = "option[data-opt-id=\"sort-PRICE_INCREASING\"]"),
            @FindBy(css = "option[value=\"PRICE_INCREASING\"]")})
    private WebElement priceLowest;
    @FindAll({@FindBy(css = "option[data-opt-id=\"sort-PRICE_DECREASING\"]"),
            @FindBy(css = "option[value=\"PRICE_DECREASING\"]")})
    private WebElement priceHighest;

    @FindAll({@FindBy(css = "option[data-opt-id=\"sort-DEPARTURE_INCREASING\"]"),
            @FindBy(css = "option[value=\"DEPARTURE_INCREASING\"]")})
    private WebElement departureEarliest;
    @FindAll({@FindBy(css = "option[data-opt-id=\"sort-DEPARTURE_DECREASING\"]"),
            @FindBy(css = "option[value=\"DEPARTURE_DECREASING\"]")})
    private WebElement departureLatest;

    @FindAll({@FindBy(css = "option[data-opt-id=\"sort-ARRIVAL_INCREASING\"]"),
            @FindBy(css = "option[value=\"ARRIVAL_INCREASING\"]")})
    private WebElement arrivalEarliest;
    @FindAll({@FindBy(css = "option[data-opt-id=\"sort-ARRIVAL_DECREASING\"]"),
            @FindBy(css = "option[value=\"ARRIVAL_DECREASING\"]")})
    private WebElement arrivalLatest;

    @FindAll({@FindBy(css = "div[data-test-id=\"listing-main\"]"),
            @FindBy(css = "button[data-test-id=\"select-link\"]")})
    private List<WebElement> flightBoxes;

        @FindAll({@FindBy(css = "button[data-test-id=\"select-button\"]"),
            @FindBy(css = "button[data-test-id=\"select-link\"]")})
    private List<WebElement> selectButtons;

    @FindAll({@FindBy(css = "span[data-test-id=\"duration\"]"),
            @FindBy(css = "div[class=\"uitk-layout-grid-item uitk-layout-grid-item-columnspan-medium-5 uitk-layout-grid-item-columnspan-large-6\"]")})
    private List<WebElement> flightDuration;

    @FindAll({@FindBy(css = "div[data-test-id=\"show-details-link\"]"),
    @FindBy(id = "basic-economy-tray-content-1")})
    private WebElement detailsAndBaggage;

    @FindAll({@FindBy( how = How.CSS, using= "#flightModuleList>li:first-child button"),
            @FindBy(how = How.CSS, using= "#flightModuleList>li:first-child [data-test-id='select-button']:first-child")})
    private WebElement firstResultT;

    @FindAll({@FindBy(xpath = "//*[@id=\"flightModuleList\"]/li[1]"),
            @FindBy(css = "#flightModuleList>li:first-child button"),
            @FindBy(css = "#flightModuleList>li:first-child [data-test-id='select-button']:first-child")})
    private WebElement firstResult;

    /*
        @FindAll({@FindBy(xpath = "//*[@id=\"flightModuleList\"]/li[1]"),
            @FindBy(xpath = "//*[@id=\"flightModuleList\"]/li[1]//div[@class=\"uitk-col standard-col-l-margin all-col-shrink display-larger-screens-only\"]/button")})
    private WebElement firstResult;

    @FindAll({@FindBy( how = How.CSS, using= "#flightModuleList>li:first-child button"),
            @FindBy(how = How.CSS, using= "#flightModuleList>li:first-child [data-test-id='select-button']:first-child")})
    private WebElement firstResultT;

        @FindAll({@FindBy(id = "AQrlAgrPAnY1LXNvcy1hNGE1ODhiYjNkMGU0YmYzOWI3ZWI5YTIyNWU4YTIzOC0xLTEtc3QtdjUtc29zLTQ3NTBlYTlkNjRmNjQxMmVhZDM4NTgxMjU4MTNiODE0LTMxLTJ-Mi5TfkFRb0VDSUh4QkJJSENOUUVFQWNZR3lBSElBRWdEQ0FOSUFrb0FsSUUyUFFCQUZnQ2NBQndBQX5BUW9vQ2lZSTFZSUJFZ1F5TVRZNEdJdVFBU0NMdUFFbzdJenFBVENwamVvQk9FNUFBRmdCYWdKQ1JSSUtDQUVRQVJnQktnSlZRUmdCSWdRSUFSQUJLQUlvQXlnRU1BSS5BUW9qQ2lFSXhuSVNCREl4TmpRWWk3Z0JJSXVRQVNqaDMtb0JNTERnNmdFNFMwQUFXQUVTQ2dnQ0VBRVlBaW9DUmprWUFTSUVDQUVRQVNnQ0tBTW9CREFDEY_C9ShcD09AIgEBKgUSAwoBMRI_ChYKCjIwMjEtMDQtMTcSA0xBUxoDTEFYChYKCjIwMjEtMDQtMjQSA0xBWBoDTEFTEgcSBUNPQUNIGgIQASACGgoIARIGGgAiAggC"),
            @FindBy(css = "//*[@id=\"flightModuleList\"]/li[1]//div[@class=\"uitk-col standard-col-l-margin all-col-shrink display-larger-screens-only\"]/button")})
    private WebElement firstResult;
     */


    @FindAll({
            @FindBy(css = "#basic-economy-tray-content-1 button[data-test-id=\"select-button-1\"]"),
            @FindBy(css = "button[data-test-id=\"select-button\"]")})
    private WebElement confirmFlight;

    public SearchDeparturePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean checkElementsSelect() {
        boolean areDisplayed = false;
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(sortSelect));
        wait.until(ExpectedConditions.elementToBeClickable(durationLongest));
        wait.until(ExpectedConditions.elementToBeClickable(priceHighest));
        wait.until(ExpectedConditions.elementToBeClickable(departureLatest));
        wait.until(ExpectedConditions.elementToBeClickable(arrivalLatest));
        if (durationShortest.isDisplayed() && durationLongest.isDisplayed() && priceLowest.isDisplayed() && priceHighest.isDisplayed() && departureEarliest.isDisplayed() && departureLatest.isDisplayed() && arrivalEarliest.isDisplayed() && arrivalLatest.isDisplayed()) {
            areDisplayed = true;
        }
        return areDisplayed;
    }

    public boolean checkSelectButton() {
        boolean areDisplayed = false;
        if (flightBoxes.size() == selectButtons.size()) {
            areDisplayed = true;
        }
        return areDisplayed;
    }

    public boolean checkFlightDuration() {
        boolean areDisplayed = false;
        if (flightBoxes.size() == flightDuration.size()) {
            areDisplayed = true;
        }
        return areDisplayed;
    }

    public boolean checkDetailAndBaggage() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(detailsAndBaggage));
        boolean areDisplayed = false;
        if(detailsAndBaggage.isDisplayed()){
            areDisplayed = true;
        }
        return areDisplayed;
    }
    //*[@id="flightModuleList"]/li[1]


    public void sortByShortestDuration() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(sortSelect));
        sortSelect.click();
        durationShortest.click();
        sortSelect.click();
        wait.until(ExpectedConditions.visibilityOf(firstResult));
        wait.until(ExpectedConditions.elementToBeClickable(firstResult));
    }
    public void checkShortestOrganization(){
        String noLetters;
        String noLettersNext;
        String noLetters2;
        for (int i = 0; i < flightDuration.size()-1; i++) {

            System.out.println(flightDuration.get(i).getText());
            noLetters = flightDuration.get(i).getText().substring(0,1);
            System.out.println(noLetters);
            noLettersNext = flightDuration.get(i+1).getText().substring(0,1);
            System.out.println(noLetters);
            noLetters2 = flightDuration.get(i).getText().substring(3,4);
            System.out.println(noLetters2);
            System.out.println("-------------------------------");
            if(Integer.parseInt(noLetters)>Integer.parseInt(noLettersNext)){

            }
        }
    }

    public void waitForFlightsOptions(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfAllElements(selectButtons));
        wait.until(ExpectedConditions.elementToBeClickable(firstResult));
    }

    public void clickFirstOption(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfAllElements(selectButtons));
        wait.until(ExpectedConditions.elementToBeClickable(firstResult));
        clickButton(selectButtons.get(0));
        //clickButton(firstResult);
    }

    public void clickOption(int index){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfAllElements(selectButtons));
        wait.until(ExpectedConditions.elementToBeClickable(firstResult));
        clickButton(selectButtons.get(index-1));
        //clickButton(firstResult);
    }


    public SearchReturnPage confirmFlight(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(confirmFlight));
        clickButton(confirmFlight);
        return new SearchReturnPage(driver);
    }

}
