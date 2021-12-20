import model.Order;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.AgodaFlightsMultiCityOnPage;
import service.OrderCreator;
import util.CommonConditions;

public class AgodaFlightsMultiCityOnPageTest extends CommonConditions {
    @Test
    public void testOrderAviaTicketsPageWithCredentialsFromProperty() throws InterruptedException {
        Order testOrder = OrderCreator.withCredentialsFromProperty();
        AgodaFlightsMultiCityOnPage departureAndArrivalCity = new AgodaFlightsMultiCityOnPage(driver)
                .openPage()
                .clickOnButtonMultiCity()
                .inputFromWhereAndToWhereCity(testOrder)
                .inputDepartureDate()
                .clickOnButtonSearch();
        Assert.assertNotEquals(testOrder.getDepartureCity(), departureAndArrivalCity.getFromWhere());
    }

    @Test
    public void testOrderAviaTicketsPageWithEmptyDepartureCity() throws InterruptedException {
        Order testOrder = OrderCreator.withEmptyDepartureCity();
        AgodaFlightsMultiCityOnPage departureAndArrivalCity = new AgodaFlightsMultiCityOnPage(driver)
                .openPage()
                .clickOnButtonMultiCity()
                .inputFromWhereAndToWhereCity(testOrder)
                .inputDepartureDate()
                .clickOnButtonSearch();
        Assert.assertNotEquals(testOrder.getArrivalCity(), departureAndArrivalCity.getToWhere());
    }
}