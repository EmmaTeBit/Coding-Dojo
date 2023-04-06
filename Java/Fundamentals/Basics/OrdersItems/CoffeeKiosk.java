import java.util.ArrayList;

public class CoffeeKiosk {
   //Member variables: 
    private ArrayList<Item> menu; 
    private ArrayList<Order> orders; 
    //Constructors:
    public CoffeeKiosk(){
        this.menu = new ArrayList<Item>();
        this.orders = new ArrayList<Order>();
    }
    //methods 
    public void addMenuItem(String name, double price) {
        Item newItem = new Item(name, price);
        menu.add(newItem);
        newItem.setIndex(menu.indexOf(newItem));
    }
    public void displayMenu(){
        for (Item item : menu) {
            System.out.println(item.getIndex() + " " + item.getName() + " : $" + item.getPrice());
        }
    }
    public void newOrder() {
        //Promt message of user
        System.out.println("Please enter a name for new order or q to quit");
        String name = System.console().readLine();
        
        //create new order with given user input
        Order order = new Order(name);
        displayMenu();

        //promt user to enter index item
        System.out.println("Please select an item from the Index Menu or q to quit");
        String itemNumber = System.console().readLine();

        //while loop to collect user's order
        while(!itemNumber.equals("q")) {
            // Get the item object from the menu, and add the item to the order
            try {
                order.addItem(menu.get(Integer.parseInt(itemNumber)));
            } catch(IndexOutOfBoundsException i) {
                System.out.println("Invalid Selection, try again");
            } catch(NumberFormatException n) {
                System.out.println("Invalid Selection, try again");
            }
            System.out.println("Pleae enter a menu item or q to quit");
            itemNumber = System.console().readLine();
        }
        //display collected orers:
        order.display();
    }
}
