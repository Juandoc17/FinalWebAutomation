package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.logging.Logger;

public class BasePage {

    private WebDriver driver;
    protected Logger log;
    protected WebDriverWait  childWait;

    public BasePage(WebDriver driver) {
        log = Logger.getLogger(BasePage.class.getName());
        this.driver = driver;
        childWait = new WebDriverWait(driver,25);
        PageFactory.initElements(driver,this);
    }

    public void clickButton(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver,25);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void sendKeys(WebElement element, CharSequence data) {
        WebDriverWait wait = new WebDriverWait(driver,25);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(data);
    }

    public void selectInTable(List<WebElement> list, int index){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfAllElements(list));
        wait.until(ExpectedConditions.elementToBeClickable(list.get(index-1)));
        clickButton(list.get(index-1));
    }

}