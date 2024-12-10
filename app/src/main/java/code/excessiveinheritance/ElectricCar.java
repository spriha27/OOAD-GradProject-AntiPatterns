package code.excessiveinheritance;

public class ElectricCar {
    private Vehicle vehicle;
    private BatteryCharger charger;

    public ElectricCar(Vehicle vehicle, BatteryCharger charger) {
        this.vehicle = vehicle;
        this.charger = charger;
    }

    public void startEngine() {
        vehicle.startEngine();
    }

    public void chargeBattery() {
        charger.charge();
    }

    public static void main(String[] args) {
        Engine engine = new Engine();
        BatteryCharger charger = new BatteryCharger();
        Vehicle vehicle = new Vehicle(engine);
        ElectricCar electricCar = new ElectricCar(vehicle, charger);

        electricCar.startEngine();
        electricCar.chargeBattery();
    }
}

class BatteryCharger {
    public void charge() {
        System.out.println("Battery charging...");
    }
}