package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.AgodaSearchHotelRoomPage;

import java.util.Objects;

public class AgodaSearchHotelRoomPageTest
{
    private ChromeDriver driver;
    private static final String DEPARTURE_PLACE = "Милан";


    @BeforeMethod (alwaysRun = true)
    public void browserSetup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage", "--window-size=1920,1080",
                "--disable-extensions", "--proxy-server='direct://'", "--proxy-bypass-list=*", "--start-maximized",
                "--disable-gpu", "--ignore-certificate-errors");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void testSearchHotelRoom() throws InterruptedException {
        AgodaSearchHotelRoomPage searchHotelRoomPage = new AgodaSearchHotelRoomPage(driver)
                .openPage()
                .searchInputDeparture(DEPARTURE_PLACE)
                .clickButtonToCheckTheHotelNumber()
                .clickButtonMeaning()
                .clickFourStarsCheckbox();
        Assert.assertEquals(searchHotelRoomPage.getDepartureString(),"Milan");
    }

    @AfterMethod (alwaysRun = true)
    public void browserQuit() {
        driver.quit();
        driver = null;
    }
}
