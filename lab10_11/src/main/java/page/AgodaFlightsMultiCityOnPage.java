package page;

import model.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AgodaFlightsMultiCityOnPage extends AbstractPage{

    private final Logger logger = LogManager.getRootLogger();
    private static final String TRANSFER_PAGE_URL = "https://flights.agoda.com/";

    private static final String MULTI_CITY = "//label[@title='Multi-city']";

    private static final String FROM_WHERE = "//input[@name='origin0']";

    private static final String TO_WHERE = "//input[@name='destination0']";

    private static final String DEPART = "//div[@aria-label='Flight 1 - Departure date input']";

    private static final String SEARCH = "//div[@class='buttonBlock']/button[@aria-label='Search flights' and @title='Search flights']";

    private static final String ACROSS = "//button[@title='Remove flight' and  @aria-label='Remove flight 3']";

    @FindBy(xpath = MULTI_CITY)
    private WebElement buttonMultiCity;

    @FindBy(xpath = FROM_WHERE)
    private WebElement inputFromWhere;

    @FindBy(xpath = TO_WHERE)
    private WebElement inputToWhere;

    @FindBy(xpath = DEPART)
    private WebElement inputDepart;

    @FindBy(xpath = SEARCH)
    private WebElement buttonSearch;

    @FindBy(xpath = ACROSS)
    private WebElement buttonAcross;

    public AgodaFlightsMultiCityOnPage clickOnButtonMultiCity() throws InterruptedException {
        Thread.sleep(1000);
        buttonMultiCity.click();
        logger.info("click button multi city is complete...");
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(FROM_WHERE)));
        return this;
    }

    public AgodaFlightsMultiCityOnPage inputFromWhereAndToWhereCity(Order order) throws InterruptedException {
        Thread.sleep(1000);
        inputFromWhere.clear();
        inputFromWhere.sendKeys(order.getDepartureCity());
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(TO_WHERE)));
        Thread.sleep(1000);
        inputToWhere.sendKeys(order.getArrivalCity());
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(DEPART)));
        logger.info("input from where and to where city is complete...");
        return this;
    }

    public AgodaFlightsMultiCityOnPage inputDepartureDate() throws InterruptedException {
        Thread.sleep(1000);
        inputDepart.sendKeys("12/24/2021\n");
        Thread.sleep(1000);
        return this;
    }

    public AgodaFlightsMultiCityOnPage clickOnButtonSearch() throws InterruptedException {
        buttonAcross.click();
        Thread.sleep(1000);
        buttonSearch.click();
        Thread.sleep(1000);
        return this;
    }

    public AgodaFlightsMultiCityOnPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AgodaFlightsMultiCityOnPage openPage() throws InterruptedException {
        driver.navigate().to(TRANSFER_PAGE_URL);
        logger.info("page is open...");
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(MULTI_CITY)));
        return this;
    }
}
