package Basics.Cafe;

public class CafeJava {
    public static void main(String[] args) {
        
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly.";
        String readyMessage = ", your order is ready!";
        String displayTotalMessage = "Your total is $";

        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double dripCofee = 2.99;
        double latte = 5.99;
        double cappucino = 4.99;
    
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";
// ** *******************Cindhuri***************************** //
        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        if (isReadyOrder1) {
            System.out.println(generalGreeting + customer1);
            System.out.println(readyMessage);
            System.out.println(displayTotalMessage + mochaPrice);
        }
        else {
            System.out.println(customer1 + pendingMessage);
        }
// ** *********************Sam*************************** //
        boolean isReadyOrder2 = true;
        if (isReadyOrder2) {
            System.out.println(generalGreeting + customer2);
            System.out.println(readyMessage);
            System.out.println(displayTotalMessage + dripCofee * 2);
        }
        else {
            System.out.println(customer2 + pendingMessage);
        }
// ** ******************Jimmy****************************** //
        boolean isReadyOrder3 = false;
        if (isReadyOrder3) {
            System.out.println(generalGreeting + customer3);
            System.out.println(readyMessage);
            System.out.println(displayTotalMessage + latte);
        }
        else {
            System.out.println(customer3 + pendingMessage);
        }
// ** *********************Noah*************************** //
        boolean isReadyOrder4 = true;
        if (isReadyOrder4) {
            System.out.println(generalGreeting + customer4);
            System.out.println(readyMessage);
            System.out.println(displayTotalMessage + (latte - dripCofee));
        }
        else {
            System.out.println(customer4 + pendingMessage);
        }
    }
    
}
