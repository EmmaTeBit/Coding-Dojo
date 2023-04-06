// package Basics.OrdersItems;

public class Item {
//variable:
    private String name;
    private double price;
    private int index;
    
    // CONSTRUCTOR
    //   Takes a name and price as arguments 
    public Item (String name, double price)     {
        this.name = name;
        this.price = price;
    }
/*----------------------------------------------------- */
    // GETTERS & SETTERS
public String getName() { //getter
    return this.name;
}
public void setName(String name) { //setter
    this.name = name;
}
public double getPrice() {
    return this.price;
}
public void setPrice(double price) {
    this.price = price;
}
public int getIndex() {
    return this.index;
}
public void setIndex(int index){
    this.index = index;
}
/*----------------------------------------------------- */

}