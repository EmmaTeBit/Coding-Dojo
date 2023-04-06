package Basics.grettings;

public class Test {
    public static void main(String[] args) {
        System.out.println("My name is Coding Dojo");
        System.out.println("I am 100 years old");
        System.out.println("My hometown is Burbank, CA");
        
        Greetings greeterApp = new Greetings();
        String dateMessage = greeterApp.getCurrentDate();
        System.out.println(dateMessage);
    }

}