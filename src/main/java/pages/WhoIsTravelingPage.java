package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WhoIsTravelingPage extends BasePage{
    private WebDriver driver;

    @FindBy(id = "firstname[0]")
    private WebElement firstNameField;

    @FindBy(id = "middlename[0]")
    private WebElement middleNameField;

    @FindBy(id = "lastname[0]")
    private WebElement lastNameField;

    @FindBy(id = "country_code[0]")
    private WebElement countryBox;

    @FindBy(id = "gender_male[0]")
    private WebElement genderMale;

    @FindBy(id = "gender_female[0]")
    private WebElement genderFemale;

    public WhoIsTravelingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean checkElemenstInPage(){
        boolean areDisplayed = false;
        if(firstNameField.isDisplayed() && middleNameField.isDisplayed() && lastNameField.isDisplayed() && countryBox.isDisplayed() && genderMale.isDisplayed() && genderFemale.isDisplayed()){
            areDisplayed = true;
        }

        return areDisplayed;
    }

}
