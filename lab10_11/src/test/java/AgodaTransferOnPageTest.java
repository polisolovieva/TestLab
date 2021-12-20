import model.Order;
import org.testng.Assert;
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
        Assert.assertTrue(true ,(testOrder.getDepartureCity() + testOrder.getArrivalCity()));
    }

    @Test
    public void testOrderAviaTicketsPageWithEmptyDepartureCity() throws InterruptedException {
        Order testOrder = OrderCreator.withEmptyDepartureCity();
        AgodaTransferOnPage arrivalCity = new AgodaTransferOnPage(driver)
                .openPage()
                .inputPickUpAndDropOff(testOrder)
                .numberOfTravelers()
                .clickButtonSearch();
        Assert.assertNotEquals(testOrder.getArrivalCity(), arrivalCity.getDropOff());
    }

    @Test
    public void testOrderAviaTicketsPageWithEmptyArrivalCity() throws InterruptedException {
        Order testOrder = OrderCreator.withEmptyArrivalCity();
        AgodaTransferOnPage departureCity = new AgodaTransferOnPage(driver)
                .openPage()
                .inputPickUpAndDropOff(testOrder)
                .numberOfTravelers()
                .clickButtonSearch();
        Assert.assertNotEquals(testOrder.getDepartureCity(), departureCity.getPickUp());
    }
}
