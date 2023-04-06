public class Bat extends Mammals{
    
    public Bat(){
        super(300);
    }

    //fly-50 energy
    public void fly(){
        System.out.println("Wooosh! -50");
        energyLevel -= 50;
        this.displayEnergy();
    }
    public void eatHumans(){
        System.out.println("I wannna LIVE!!! +25");
        energyLevel += 25;
        displayEnergy();
    }
    public void attackTown(){
        System.out.println("Rawwwrrrr!!! -100");
        energyLevel -= 100;
        displayEnergy();
    }

    
}
