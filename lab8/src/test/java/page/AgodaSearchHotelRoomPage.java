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
    private static final String DEPARTURE_CITY = "//*[@id=\"SearchBoxContainer\"]/div[1]/div/div[2]/div/div/div[1]/div/div/input";
    private static final String BUTTON_SEARCH = "//*[@id=\"SearchBoxContainer\"]/div[2]/button";
    private static final String BUTTON_MEANING = "//*[@id=\"city-0\"]/a/div/h3/a";
    private static final String DEPARTURE_STRING = "//*[@id=\"SearchBoxContainer\"]/div/div/div[1]/div/div/div/div[1]";
    private static final String FOUR_STARS_CHECKBOX = "//*[@id=\"searchPageLeftColumn\"]/div[2]/div[3]/div[2]/ul/li[1]/span/span[1]/span";


    @FindBy(xpath = "//*[@id=\"SearchBoxContainer\"]/div[1]/div/div[2]/div/div/div[1]/div/div/input")
    private WebElement searchInputDepartureCity;

    @FindBy(xpath = "//*[@id=\"SearchBoxContainer\"]/div[2]/button")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"city-0\"]/a/div/h3/a")
    private WebElement searchMeaningButton;

    @FindBy(xpath = "//*[@id=\"SearchBoxContainer\"]/div/div/div[1]/div/div/div/div[1]")
    private WebElement searchDepartureString;

    @FindBy(xpath = "//*[@id=\"searchPageLeftColumn\"]/div[2]/div[3]/div[2]/ul/li[1]/span/span[1]/span")
    private WebElement searchFourStarsCheckbox;

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
    public AgodaSearchHotelRoomPage clickFourStarsCheckbox() {
        searchFourStarsCheckbox.click();
        return this;
    }


}
