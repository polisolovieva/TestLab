package model;

import java.util.Objects;

public class Order {
    private String departureCity;
    private String arrivalCity;
    private String hotel;

    public Order(String departureCity, String arrivalCity) {
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
    }

    public Order(String hotel) {
        this.hotel = hotel;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    @Override
    public String toString() {
        return "Order{" +
                "departureCity='" + departureCity + '\'' +
                ", arrivalCity='" + arrivalCity + '\'' +
                ", hotel='" + hotel + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(departureCity, order.departureCity) && Objects.equals(arrivalCity, order.arrivalCity) && Objects.equals(hotel, order.hotel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departureCity, arrivalCity, hotel);
    }
}
