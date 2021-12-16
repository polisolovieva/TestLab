package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import model.Order;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AgodaSearchHotelRoomPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private static final String SEARCH_HOTEL_ROOM_PAGE_URL = "https://www.agoda.com/ru-ru/";
    private static final String BANNER = "//div[@class='ab-in-app-message  ab-background ab-modal-interactions ab-modal ab-centered']";
    private static final String BANNER_CLOSE = "//button[@class='ab-close-button']";
    private static final String DEPARTURE_CITY = "//input[@class='SearchBoxTextEditor SearchBoxTextEditor--autocomplete']";
    private static final String DEPARTURE_DROPDOWN_LIST = "//li[1][@class='Suggestion Suggestion__categoryName']";
    private static final String BUTTON_SEARCH = "//button[@class='Buttonstyled__ButtonStyled-sc-5gjk6l-0 hvHHEO Box-sc-kv6pi1-0 fDMIuA']";
    private static final String DEPARTURE_STRING = "//div[@class='SearchBoxTextDescription__title' and @data-selenium='textInput']";
    private static final String DISTANCE_CHECKBOX = "//span[@class='filter-item-info CityCenterDistance-0 ']/span/span[@class='checkbox-icon']";
    private static final String DATA_DROPDOWN_BLOCK= "//div[@class='Popup__content']";
    private static final String BUTTON_DATA= "//div[@class='SearchBoxTextDescription SearchBoxTextDescription--checkIn']";

    @FindBy(xpath = BANNER)
    private WebElement searchBanner;

    @FindBy(xpath = BANNER_CLOSE)
    private WebElement clickBannerClose;

    @FindBy(xpath = DEPARTURE_CITY)
    private WebElement searchInputDepartureCity;

    @FindBy(xpath = DEPARTURE_DROPDOWN_LIST)
    private WebElement clickDropdownList;

    @FindBy(xpath = DATA_DROPDOWN_BLOCK)
    private WebElement searchDataBlock;

    @FindBy(xpath = BUTTON_DATA)
    private WebElement clickButtonData;

    @FindBy(xpath = BUTTON_SEARCH)
    private WebElement searchButton;

    @FindBy(xpath = DEPARTURE_STRING)
    private WebElement searchDepartureString;

    @FindBy(xpath = DISTANCE_CHECKBOX)
    private WebElement searchDistanceCheckbox;

    public AgodaSearchHotelRoomPage(WebDriver driver) {
        super(driver);
    }

    public AgodaSearchHotelRoomPage openPage(){
        driver.navigate().to(SEARCH_HOTEL_ROOM_PAGE_URL);
        logger.info("hotel room page url is open...");
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(BANNER)));
        return this;
    }

    public AgodaSearchHotelRoomPage isBanner() {
        if(searchBanner != null){
            clickBannerClose.click();
            logger.info("banner closed...");
            new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath(DEPARTURE_CITY)));
        }
        return this;
    }

    public AgodaSearchHotelRoomPage searchInputDeparture(Order order) {
        searchInputDepartureCity.sendKeys(order.getDepartureCity());
        logger.info("input departure complete...");
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(DATA_DROPDOWN_BLOCK)));
        return this;
    }

    public AgodaSearchHotelRoomPage isDataBlock() {
        if(searchDataBlock != null){
            clickButtonData.click();
            new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath(BUTTON_SEARCH)));
        }
        return this;
    }

    public String getDepartureString() {
        return searchDepartureString.getText();
    }

    public AgodaSearchHotelRoomPage clickDropdownListDepartures() {
        clickDropdownList.click();
        if(searchDataBlock != null)
            new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath(BUTTON_SEARCH)));
        return this;
    }

    public AgodaSearchHotelRoomPage clickButtonToCheckTheHotelNumber() {
        searchButton.click();
        logger.info("click button check the hotel number is complete...");
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(DISTANCE_CHECKBOX)));
        return this;
    }

    public AgodaSearchHotelRoomPage clickDistanceCheckbox() {
        searchDistanceCheckbox.click();
        logger.info("click distance checkbox is complete...");
        return this;
    }

}