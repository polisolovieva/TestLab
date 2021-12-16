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

public class AgodaTransferOnPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();
    private static final String FLIGHTS_PAGE_URL = "https://agoda.mozio.com/en-us/";
    private static final String PICK_UP = "//input[@name='start_address']";
    private static final String DROP_OFF = "//input[@name='end_address']";
    private static final String NUMBER_OF_TRAVELERS = "//input[@name='num_passengers']";
    private static final String SEARCH = "//button[@tabindex='0' and @type='submit']";

    @FindBy(xpath = PICK_UP)
    private WebElement inputPickUp;

    @FindBy(xpath = DROP_OFF)
    private WebElement inputDropOff;

    @FindBy(xpath = NUMBER_OF_TRAVELERS)
    private WebElement inputNumberOfTravelers;

    @FindBy(xpath = SEARCH)
    private WebElement buttonSearch;

    public AgodaTransferOnPage inputPickUpAndDropOff(Order order) throws InterruptedException {
        Thread.sleep(5000);
        inputPickUp.sendKeys(order.getDepartureCity());
        Thread.sleep(2000);
        inputPickUp.sendKeys("\n");
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(DROP_OFF)));
        Thread.sleep(5000);
        inputDropOff.sendKeys(order.getArrivalCity());
        Thread.sleep(2000);
        inputDropOff.sendKeys("\n");
        logger.info("input pick up and drop off is complete...");
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(NUMBER_OF_TRAVELERS)));
        return this;
    }

    public AgodaTransferOnPage numberOfTravelers() throws InterruptedException {
        Thread.sleep(5000);
        inputNumberOfTravelers.clear();
        inputNumberOfTravelers.sendKeys("5");
        logger.info("input number of travelers is complete...");
        return this;
    }

    public AgodaTransferOnPage clickButtonSearch() throws InterruptedException {
        buttonSearch.click();
        logger.info("click button is complete...");
        Thread.sleep(5000);
        return this;
    }

    public AgodaTransferOnPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AgodaTransferOnPage openPage() {
        driver.navigate().to(FLIGHTS_PAGE_URL);
        logger.info("page is open...");
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(PICK_UP)));
        return this;
    }
}
