package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import model.Order;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchAviaTicketsPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();

    private static final String PAGE_URL = "https://www.agoda.com/ru-ru/";

    private static final String AVIA_TICKETS = "//a[@data-element-name='header-flights-links']";

    private static final String DEPARTURE_CITY = "//input[@name='origin']";

    private static final String ARRIVAL_CITY = "//input[@name='destination']";

    private static final String DEPARTURE_DATE = "//div[@aria-label='Departure date input']";

    private static final String BUTTON_SEARCH = "//button[@aria-label='Search flights' and @title='Search flights']";

    private static final String BANNER = "//div[@class='ab-in-app-message  ab-background ab-modal-interactions ab-modal ab-centered']";

    private static final String BANNER_CLOSE = "//button[@class='ab-close-button']";

    private static final String FINAL_DEPARTURE_CITY = "//input[@aria-label='Flight origin input']";

    private static final String FINAL_ARRIVAL_CITY = "//input[@aria-label='Flight destination input']";

    @FindBy(xpath = BANNER)
    private WebElement searchBanner;

    @FindBy(xpath = BANNER_CLOSE)
    private WebElement clickBannerClose;

    @FindBy(xpath = AVIA_TICKETS)
    private WebElement buttonAviaTickets;

    @FindBy(xpath = DEPARTURE_CITY)
    private WebElement inputDeparture;

    @FindBy(xpath = FINAL_DEPARTURE_CITY)
    private WebElement finalDepartureCity;

    @FindBy(xpath = FINAL_ARRIVAL_CITY)
    private WebElement finalArrivalCity;

    @FindBy(xpath = ARRIVAL_CITY)
    private WebElement inputArrival;

    @FindBy(xpath = DEPARTURE_DATE)
    private WebElement buttonThere;

    @FindBy(xpath = BUTTON_SEARCH)
    private WebElement buttonSearch;

    public SearchAviaTicketsPage(WebDriver driver) {
        super(driver);
    }

    public SearchAviaTicketsPage isBanner() {
        if(searchBanner != null){
            clickBannerClose.click();
            logger.info("banner closed...");
            new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath(AVIA_TICKETS)));
        }
        else {
            logger.info("banner not open...");
        }
        return this;
    }

    public SearchAviaTicketsPage clickAviaTickets() {
        buttonAviaTickets.click();
        logger.info("open page with order avia tickets...");
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(DEPARTURE_CITY)));
        return this;
    }

    public SearchAviaTicketsPage inputDepartureAndArrivalCity(Order order) throws InterruptedException {
        inputDeparture.clear();
        inputDeparture.sendKeys(order.getDepartureCity());
        Thread.sleep(4000);
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(ARRIVAL_CITY)));
        Thread.sleep(4000);
        inputArrival.sendKeys(order.getArrivalCity());
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(DEPARTURE_DATE)));
        logger.info("input departure and arrival city is complete...");
        return this;
    }

    public SearchAviaTicketsPage inputDepartureAndArrivalDate() throws InterruptedException {
        Thread.sleep(4000);
        buttonThere.click();
        Thread.sleep(4000);
        buttonThere.sendKeys("12/24/2021\n");
        logger.info("input departure and arrival date is complete...");
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(BUTTON_SEARCH)));
        return this;
    }

    public SearchAviaTicketsPage clickButtonSearchTickets() throws InterruptedException {
        Thread.sleep(4000);
        buttonSearch.click();
        logger.info("search tickets is complete...");
        Thread.sleep(7000);
        return this;
    }

    public String getDepartureCity() { return finalDepartureCity.getAttribute("content"); }
    public String getArrivalCity() { return finalArrivalCity.getAttribute("content"); }
    public String getDepartureAndArrivalCity() { return (finalArrivalCity.getAttribute("content") + ", " + finalArrivalCity.getAttribute("content")); }

    @Override
    public SearchAviaTicketsPage openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("page is open...");
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(BANNER)));
        return this;
    }
}
