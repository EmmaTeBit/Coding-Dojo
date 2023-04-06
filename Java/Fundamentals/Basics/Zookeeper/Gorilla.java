public class Gorilla extends Mammals{

    public Gorilla(int energyLevel) {
        super(energyLevel); //super takes it from Mammal class 100
    }
    //throw things at people but will lose energy (-5) 
    public void throwSomething(){
        System.out.println("Look out!");
        energyLevel -=5;
        displayEnergy();
    }
    //eatBananas and regain energy (+10). 
    public void eatBananas(){
        System.out.println("Nom nom Nom");
        energyLevel += 10;
        displayEnergy();
    }
    // climb at the expense of energy (-10).
    public void climb(){
        System.out.println("Weeeeee!");
        energyLevel -= 10;
        displayEnergy();
    }









}