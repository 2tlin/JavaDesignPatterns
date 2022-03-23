package books.refactoring_guru.builder.example.builders;

import books.refactoring_guru.builder.example.cars.CarType;
import books.refactoring_guru.builder.example.components.Engine;
import books.refactoring_guru.builder.example.components.GPSNavigator;
import books.refactoring_guru.builder.example.components.Transmission;
import books.refactoring_guru.builder.example.components.TripComputer;

/**
 * Интерфейс Строителя объявляет все возможные этапы и шаги конфигурации
 * продукта.
 */
public interface Builder {
    void setCarType(CarType type);
    void setSeats(int seats);
    void setEngine(Engine engine);
    void setTransmission(Transmission transmission);
    void setTripComputer(TripComputer tripComputer);
    void setGPSNavigator(GPSNavigator gpsNavigator);
}
