import model.Order;
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
    }
}
