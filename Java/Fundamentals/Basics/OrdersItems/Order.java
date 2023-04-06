// package Basics.OrdersItems;
import java.util.ArrayList;

public class Order {
//variable:
    private String name;//default to null
    private boolean ready;//default value false
    private ArrayList<Item> items; //default to null
    
    // CONSTRUCTOR
    // No arguments, sets name to "Guest", initializes items as an empty list.
    public Order(){
        this.name = "Guest";
        this.items =new ArrayList<Item>();
    }
    // OVERLOADED CONSTRUCTOR
    // Takes a name as an argument, sets name to this custom name.
    public Order(String name) {
        this.name = name;
        // Initializes items as an empty list.
        this.items =new ArrayList<Item>();
    }
    /*---------------------------------------------------*/
    // ORDER METHODS
    	// Most of your code will go here, 
    	// so implement the getters and setters first!
    public void addItem(Item item) {
        items.add(item);
    }
    public String getStatusMessage(){
        if(this.ready) {
            return "Your order is READY!";
        }
        return "Your order will be ready soon - Thank you for waiting";
    }
    public double getOrderTotal(){
        double total = 0;
        for(Item item : items) {
            total += item.getPrice();
        }
        return total;
    }
    public void display() {
        System.out.println("Customer Name: " + this.name);
        for(Item item : items) {
            System.out.println(item.getName() + " $" + item.getPrice());
        }
        System.out.println("Total: $" + getOrderTotal());
    }
    /*---------------------------------------------------*/
    // GETTERS & SETTERS : Name
    public String getName() { //getter
        return this.name;
    }
    public void setName(String name) { //setter
        this.name = name;
    }
    // GETTERS & SETTERS : Ready
    public boolean getReady() {
        return this.ready;
    }
    public void setReady(boolean ready) {
        this.ready = ready;
    }
    // GETTERS & SETTERS : Item arrays
    public ArrayList<Item> getItems() {
        return this.items;
    }
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
    /*---------------------------------------------------*/

    
}





