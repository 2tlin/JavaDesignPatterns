package examples.books.refactoring_guru.builder.example.builders;

import examples.books.refactoring_guru.builder.example.cars.Car;
import examples.books.refactoring_guru.builder.example.cars.CarType;
import examples.books.refactoring_guru.builder.example.components.Engine;
import examples.books.refactoring_guru.builder.example.components.GPSNavigator;
import examples.books.refactoring_guru.builder.example.components.Transmission;
import examples.books.refactoring_guru.builder.example.components.TripComputer;

/**
 * Конкретные строители реализуют шаги, объявленные в общем интерфейсе.
 */
public class CarBuilder implements Builder {
    private CarType type;
    private int seats;
    private Engine engine;
    private Transmission transmission;
    private TripComputer tripComputer;
    private GPSNavigator gpsNavigator;

    public void setCarType(CarType type) {
        this.type = type;
    }

    @Override
    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    @Override
    public void setTripComputer(TripComputer tripComputer) {
        this.tripComputer = tripComputer;
    }

    @Override
    public void setGPSNavigator(GPSNavigator gpsNavigator) {
        this.gpsNavigator = gpsNavigator;
    }

    public Car getResult() {
        return new Car(type, seats, engine, transmission, tripComputer, gpsNavigator);
    }
}
