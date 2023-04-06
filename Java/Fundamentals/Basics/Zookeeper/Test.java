
public class Test {
    public static void main(String[] args) {
        
        //Create a GorillaTest class to instantiate a 
        //gorilla and have it throw three things, eat bananas twice, and climb once.
        Gorilla g = new Gorilla(100);
        g.throwSomething();
        g.throwSomething();
        g.throwSomething();

        g.eatBananas();
        g.eatBananas();

        g.climb();

        //Create a BatTest class to instantiate a bat 
        //and have it attack three towns, eat two humans, and fly twice.
        Bat b = new Bat();

        b.attackTown();
        b.attackTown();
        b.attackTown();

        b.eatHumans();
        b.eatHumans();

        b.fly();
        b.fly();

    }
    
}
