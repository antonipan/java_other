package hw2test;

import homework2.Car;
import homework2.Motorcycle;
import homework2.Vehicle;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class VehicleTest {
    Car car = new Car("Mazda", "3", 2020);
    Motorcycle motorcycle = new Motorcycle("Suzuki", "650MX", 2015);

    /**
     * Проверка экземпляра (car) класса Car на принадлежность классу Vehicle
     */
    @Test
    public void testCarInstanceOfVehicle() {
        assertInstanceOf(Vehicle.class, car);
    }

    // Напишите, пожалуйста, можно ли так делать?
    private void testCountWheels(Vehicle object){
        if (object instanceof Car) {
            Car car1 = (Car) object;
            assertEquals(4, car1.getNumWheels());
        } else if (object instanceof Motorcycle) {
            Motorcycle motorcycle1 = (Motorcycle) object;
            assertEquals(2, motorcycle1.getNumWheels());
        }
    }

    /**
     * Тест проверки на количество колёс
     */
    @Test
    public void testWheels (){
        testCountWheels(car);
        testCountWheels(motorcycle);
    }
    @Test
    public void testGainSpeedCar() {
        car.testDrive();
        assertEquals(60, car.getSpeed());
    }
    @Test
    public void testGainSpeedMotorcycle() {
        motorcycle.testDrive();
        assertEquals(75, motorcycle.getSpeed());
    }

    /**
     * Метод проверки скорости авто после парковки
     */
    @Test
    public void testCarStopped(){
        assertEquals(0, car.getSpeed());
        car.testDrive();
        assertEquals(60, car.getSpeed());
        car.park();
        assertEquals(0, car.getSpeed());
    }

    /**
     * Метод проверки скорости Moto после парковки
     * Вопрос: почему здесь заново приходится проверять скорость, ведь в предыдущем методе мы уже записали скорость в
     * экземпляр класса
     */
    @Test
    public void testMotorCycleStopped(){
        assertEquals(0, motorcycle.getSpeed());
        motorcycle.testDrive();
        assertEquals(75, motorcycle.getSpeed());
        motorcycle.park();
        assertEquals(0, motorcycle.getSpeed());
    }


}
