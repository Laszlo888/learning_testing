package petrolstation;

public class Station {

  // Create Station and Car classes
  // Station
  // it stores how much gas is available: gasAmount
  // it can refill a car: refill(car):
  // decreases the gasAmount by the capacity of the car (let us suppose that the car is empty)
  // and
  // increases the car's gasAmount
  // Car
  // it stores how much gas is actually present: gasAmount
  // it stores the capacity of the tank: capacity
  // create a constructor for the Car class where you:
  // initialize gasAmount -> 0
  // initialize capacity -> 100

  public static void main(String[] args) {
        Car car = new Car();
    }

    int gasAmount;

    void refill(Car car) {
        gasAmount = gasAmount - car.capacity;
        car.gasAmount = car.capacity;
    }
}
