package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AgodaSearchHotelRoomPage extends AbstractPage {

    private static final String SEARCH_HOTEL_ROOM_PAGE_URL = "https://www.agoda.com/ru-ru/";
    private static final String DEPARTURE_CITY = "//input[@class='SearchBoxTextEditor SearchBoxTextEditor--autocomplete']";
    private static final String BUTTON_SEARCH = "//button[@class='Buttonstyled__ButtonStyled-sc-5gjk6l-0 dXQFPN Box-sc-kv6pi1-0 bjEZDw']";
    private static final String BUTTON_MEANING = "//h3[@class='InterstitialList__title']/a[text() = 'Милан, Италия']";
    private static final String DEPARTURE_STRING = "//div[@class='SearchBoxTextDescription__title' and @data-selenium='textInput']";
    private static final String DISTANCE_CHECKBOX = "//span[@class='filter-item-info CityCenterDistance-0 ']/span/span[@class='checkbox-icon']";




    @FindBy(xpath = DEPARTURE_CITY)
    private WebElement searchInputDepartureCity;

    @FindBy(xpath = BUTTON_SEARCH)
    private WebElement searchButton;

    @FindBy(xpath = BUTTON_MEANING)
    private WebElement searchMeaningButton;

    @FindBy(xpath = DEPARTURE_STRING)
    private WebElement searchDepartureString;

    @FindBy(xpath = DISTANCE_CHECKBOX)
    private WebElement searchDistanceCheckbox;

    public AgodaSearchHotelRoomPage(WebDriver driver)
    {
        super(driver);
    }

    public AgodaSearchHotelRoomPage openPage() {
        driver.get(SEARCH_HOTEL_ROOM_PAGE_URL);
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(DEPARTURE_CITY)));
        return this;
    }

    public AgodaSearchHotelRoomPage  searchInputDeparture(String departureCity) {
        searchInputDepartureCity.sendKeys(departureCity);
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(BUTTON_SEARCH)));
        return this;
    }

    public String getDepartureString() {
        return searchDepartureString.getText();
    }

    public AgodaSearchHotelRoomPage clickButtonToCheckTheHotelNumber() {
        searchButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(BUTTON_MEANING)));
        return this;
    }

    public AgodaSearchHotelRoomPage clickButtonMeaning() {
        searchMeaningButton.click();
        return this;
    }
    public AgodaSearchHotelRoomPage clickDistanceCheckbox() {
        searchDistanceCheckbox.click();
        return this;
    }


}
