public class Mammals {
    
    public int energyLevel = 100;

    public int displayEnergy(){
        System.out.println("Animal Energy Level: " + energyLevel + "/100");
        return energyLevel;
    }
    public Mammals(int energyLevel) {
        this.energyLevel = energyLevel;
    }
    
}
