public class Demo {
    
    public static void main(String[] args) {
        Car newCar = new Car("Toacoma", "Toy", "White", 2020);
        String myCar = String.format("This car is a %d %s %s %s", newCar.year,newCar.color,newCar.make,newCar.model);
        System.out.println(myCar);

    }
}