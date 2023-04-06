// package Basics.OrdersItems;
// import java.lang.reflect.Array;
import java.util.ArrayList;
// import java.util.Arrays;
// import Basics.OrdersItems.CoffeeKiosk;

public class TestOrders {
    public static void main(String[] args) {

        CoffeeKiosk ck = new CoffeeKiosk();
         ck.addMenuItem("Drip Coffee", 5.99);
         ck.addMenuItem("Capuccino", 7.99);
         ck.addMenuItem("Ice Coffee", 1.99);
         ck.addMenuItem("Mocha", 2.99);


         ck.newOrder();
        
    }
}

        // // Menu items
        // Item item1 = new Item("Drip Coffee", 5.99);
        // Item item2 = new Item("Capuccino", 7.99);
        // Item item3 = new Item("Ice Coffee", 1.99);
        // Item item4 = new Item("Mocha", 2.99);

        // //Create 2 orders for unspecified guests (without specifying a name);
        // Order order1 = new Order();
        // Order order2 = new Order();
        // //Create 3 orders using the overloaded constructor to give each a name for the order.
        // Order order3 = new Order("Emma");
        // Order order4 = new Order("Derek");
        // Order order5 = new Order("Aspen");
        //Add at least 2 items to each of the orders using the addItem method you wrote, for example, 
        //to add item1 to order3 you would need to call the addItem method from the order3 instance like so: order3.addItem(item1);
        // order1.addItem(item2);
        // order1.addItem(item3);

        // order2.addItem(item3);
        // order2.addItem(item4);

        // order3.addItem(item4);
        // order3.addItem(item2);

        // order4.addItem(item1);
        // order4.addItem(item3);

        // order5.addItem(item4);
        // order5.addItem(item2);
        // //Test the results and the display method by calling the display method on all of your orders, like so: order3.display();
        // order1.setReady(true);
        // System.out.println(order1.getStatusMessage());
        // System.out.println(order3.getStatusMessage());

        // System.out.println(order1.getOrderTotal());
        // order5.display();




        //Create 4 item variables of type Item and instantiate each as an Item object. 
        //Name them item1, item2 etc. Set the price and the name for each -- 
        //"mocha", "latte", "drip coffee" and "capuccino" (price is up to you!)
//         Item item1 = new Item();
//         item1.name = "mocha";
//         item1.price = 2.99;

//         Item item2 = new Item();
//         item2.name = "latte";
//         item2.price = 3.99;

//         Item item3 = new Item();
//         item3.name = "drip coffee";
//         item3.price = 5.99;

//         Item item4 = new Item();
//         item4.name = "capuccino";
//         item4.price = 7.99;

//         // Order variables -- order1, order2 etc.
//         //Create 4 order variables of type Order 
//         //and instantiate each as an Order object. Name them order1, order2 etc.
//         Order order1 = new Order();
//         System.out.println(order1.total);
//         order1.name = "Cindhuri";

//         Order order2 = new Order();
//         System.out.println(order2.total);
//         order2.name = "Jimmy";

//         Order order3 = new Order();
//         System.out.println(order3.total);
//         order3.name = "Noah";

//         Order order4 = new Order();
//         System.out.println(order4.total);
//         order4.name = "Sam";

//         //Add item1 to order2's item list and increment the order's total.
//         order2.items.add(item1);
//         order2.total += item1.price;
//         //order3 ordered a cappucino. Add the cappuccino to their order list and to their tab.
//         order3.items.add(item4);
//         order3.total =+ item4.price;
//         //order4 added a latte. Update accordingly.
//         //Sam ordered more drinks - 2 lattes. Update their order as well.
//         order4.items.add(item2);
//         order4.items.add(item2);
//         order4.total += item2.price * 2;
//         // order4.total += item2.price + item3.price;
//         // System.out.println(Arrays.toString(order4));-check this line when can i use it?

//         //Cindhuri’s order is now ready. Update her status.
//         order1.ready = true;
//         //Jimmy’s order is now ready. Update his status.
//         order2.ready = true;

//         //Order 1
//         System.out.printf("Name: %s\n", order1.name);
//         System.out.printf("Total: %s\n", order1.total);
//         System.out.printf("Ready: %s\n", order1.ready);

//         //Order 2
//         System.out.printf("Name: %s\n", order2.name);
//         System.out.printf("Total: %s\n", order2.total);
//         System.out.printf("Ready: %s\n", order2.ready);

//         //Order 3
//         System.out.printf("Name: %s\n", order3.name);
//         System.out.printf("Total: %s\n", order3.total);
//         System.out.printf("Ready: %s\n", order3.ready);

//         //Order 4
//         System.out.printf("Name: %s\n", order4.name);
//         System.out.printf("Total: %s\n", order4.total);
//         System.out.printf("Ready: %s\n", order4.ready);