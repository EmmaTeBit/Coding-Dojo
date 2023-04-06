package Basics.MethodsGreeter;
public class Test {
    public static void main(String[] args) {
        //create new instance of Greeter class
        Greeter g = new Greeter();

        String greeting = g.greet();
        String greetingWithName = g.greet();
        // String greetingWithName = g.greet("Emma", "Te");

        System.out.println(greetingWithName);
    }
    }
