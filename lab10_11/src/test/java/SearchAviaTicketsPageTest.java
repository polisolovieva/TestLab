import model.Order;
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
        //Assert.assertNotEquals((testOrder.getArrivalCity() + ", " + testOrder.getDepartureCity()), departureAndArrivalCity);
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
                .clickButtonSearchTickets();

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
                .clickButtonSearchTickets();
    }
}
