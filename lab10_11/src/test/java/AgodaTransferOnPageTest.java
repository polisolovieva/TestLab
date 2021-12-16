import model.Order;
import org.testng.annotations.Test;
import page.AgodaTransferOnPage;
import service.OrderCreator;
import util.CommonConditions;


public class AgodaTransferOnPageTest extends CommonConditions {

    @Test
    public void testOrderAviaTicketsPageWithCredentialsFromProperty() throws InterruptedException {
        Order testOrder = OrderCreator.withCredentialsFromProperty();
        AgodaTransferOnPage departureAndArrivalCity = new AgodaTransferOnPage(driver)
                .openPage()
                .inputPickUpAndDropOff(testOrder)
                .numberOfTravelers()
                .clickButtonSearch();
    }

    @Test
    public void testOrderAviaTicketsPageWithEmptyDepartureCity() throws InterruptedException {
        Order testOrder = OrderCreator.withEmptyDepartureCity();
        AgodaTransferOnPage departureAndArrivalCity = new AgodaTransferOnPage(driver)
                .openPage()
                .inputPickUpAndDropOff(testOrder)
                .numberOfTravelers()
                .clickButtonSearch();
    }

    @Test
    public void testOrderAviaTicketsPageWithEmptyArrivalCity() throws InterruptedException {
        Order testOrder = OrderCreator.withEmptyArrivalCity();
        AgodaTransferOnPage departureAndArrivalCity = new AgodaTransferOnPage(driver)
                .openPage()
                .inputPickUpAndDropOff(testOrder)
                .numberOfTravelers()
                .clickButtonSearch();
    }
}
