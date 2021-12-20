import model.Order;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.SearchAviaTicketsPage;
import service.OrderCreator;
import util.CommonConditions;

public class SearchAviaTicketsPageTest extends CommonConditions {
    @Test
    public void testOrderAviaTicketsPageWithCredentialsFromProperty() throws InterruptedException {
        Order testOrder = OrderCreator.withCredentialsFromProperty();
        SearchAviaTicketsPage departureAndArrivalCity = new SearchAviaTicketsPage(driver)
                .openPage()
                .isBanner()
                .clickAviaTickets()
                .inputDepartureAndArrivalCity(testOrder)
                .inputDepartureAndArrivalDate()
                .clickButtonSearchTickets();
        Assert.assertTrue(true, (testOrder.getArrivalCity() + ", " + testOrder.getDepartureCity()));
    }

    @Test
    public void testOrderAviaTicketsPageWithEmptyDepartureCity() throws InterruptedException {
        Order testOrder = OrderCreator.withEmptyDepartureCity();
        SearchAviaTicketsPage arrivalCity = new SearchAviaTicketsPage(driver)
                .openPage()
                .isBanner()
                .clickAviaTickets()
                .inputDepartureAndArrivalCity(testOrder)
                .inputDepartureAndArrivalDate()
                .clickButtonSearchTickets()
                .closeErrorBanner();
        Assert.assertNotEquals(testOrder.getArrivalCity(), arrivalCity.getArrivalCity());
    }

    @Test
    public void testOrderAviaTicketsPageWithEmptyArrivalCity() throws InterruptedException {
        Order testOrder = OrderCreator.withEmptyArrivalCity();
        SearchAviaTicketsPage departureCity = new SearchAviaTicketsPage(driver)
                .openPage()
                .isBanner()
                .clickAviaTickets()
                .inputDepartureAndArrivalCity(testOrder)
                .inputDepartureAndArrivalDate()
                .clickButtonSearchTickets()
                .closeErrorBanner();
        Assert.assertNotEquals(testOrder.getDepartureCity(), departureCity.getDepartureCity());
    }
}
