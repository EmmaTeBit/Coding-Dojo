public class Test {
    public static void main(String[] args) {
        
        Driver d = new Driver();
        //Call the drive method four times, the boost method once, and the refuel method three times
        //drive 4times
        d.drive();
        d.drive();
        d.drive();
        d.drive();

        //use bootst once
        d.booster();

        //refuel 3 time
        d.refuel();
        d.refuel();
        d.refuel();

    }
    
}
