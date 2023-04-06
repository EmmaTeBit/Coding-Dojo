package Basics.MemberVariables;

public class CarTest {
    public static void main(String[] args) {

        //create instance of Car class
        Car emCar = new Car();
        emCar.year = 2020;
        emCar.make = "Tacoma";
        emCar.model = "Toyota";
        emCar.color = "White";

        // create ANOTHER instance of Car class
        Car derekCar = new Car();
        derekCar.year = 2016;
        derekCar.make = "Subaru";
        derekCar.model = "WRX";
        derekCar.color = "Blue";

        // individual data stored together
        System.out.println("Em Car make: " + emCar.make);

    }
}
