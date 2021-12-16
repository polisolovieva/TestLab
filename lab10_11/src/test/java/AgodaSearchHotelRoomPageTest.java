import model.Order;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.AgodaSearchHotelRoomPage;
import service.OrderCreator;
import util.CommonConditions;

public class AgodaSearchHotelRoomPageTest extends CommonConditions {
    private static final String DEPARTURE_PLACE = "Милан";

    @Test
    public void testSearchHotelRoom() {
        Order testOrder = OrderCreator.withEmptyArrivalCity();
        AgodaSearchHotelRoomPage searchHotelRoomPage = new AgodaSearchHotelRoomPage(driver)
                .openPage()
                .isBanner()
                .searchInputDeparture(testOrder)
                .clickDropdownListDepartures()
                .clickButtonToCheckTheHotelNumber()
                .clickDistanceCheckbox();

        Assert.assertEquals(searchHotelRoomPage.getDepartureString(), DEPARTURE_PLACE);
    }
}
