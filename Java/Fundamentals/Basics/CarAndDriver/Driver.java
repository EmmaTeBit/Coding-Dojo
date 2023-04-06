
public class Driver extends Car {

    public void drive(){
        System.out.println("You drive the car");
        gas--; //-gas by 1
        status(); //show gas remaining 
    }
    public void booster(){
        System.out.println("Using boosters!!!");
        gas-=3; //decreae -3 
        status();
    }
    public void refuel(){
        System.out.println("Refueling...");
        gas+=2;
        status();
    }
}
