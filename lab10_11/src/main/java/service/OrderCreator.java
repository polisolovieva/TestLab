package service;

import model.Order;

public class OrderCreator {
    public static final String TEST_DATA_DEPARTURE_CITY = "testdata.departure.city";
    public static final String TEST_DATA_ARRIVAL_CITY = "testdata.arrival.city";
    public static final String TEST_DATA_HOTEL = "testdata.hote.name";

    public static Order withTestDataHotel() {
        return new Order(TestDataReader.getTestData(TEST_DATA_HOTEL));
    }

    public static Order withCredentialsFromProperty() {
        return new Order(
                TestDataReader.getTestData(TEST_DATA_DEPARTURE_CITY),
                TestDataReader.getTestData(TEST_DATA_ARRIVAL_CITY)
        );
    }

    public static Order withEmptyDepartureCity() {
        return new Order("", TestDataReader.getTestData(TEST_DATA_ARRIVAL_CITY));
    };

    public static Order withEmptyArrivalCity() {
        return new Order(TestDataReader.getTestData(TEST_DATA_DEPARTURE_CITY), "");
    };
}
