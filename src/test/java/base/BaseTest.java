package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

public class BaseTest {
    //Instancia WebDriver
    private WebDriver driver;
    protected HomePage homePage;
    @BeforeClass
    public void setUp(){
        //Se cargar los drivers correspondientes al manejador de chrome y se asigna su correspondiente Objeto
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        goHome();
    }
    @BeforeMethod
    public void goHome(){
        driver.get("https://www.travelocity.com");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void tearDown(){
        //driver.quit();
    }
}
