package Notes;
import java.util.ArrayList;

public class Array_addAll {
    public static void main(String[] args) {
        // Create first ArrayList
    ArrayList<String> list1 = new ArrayList<String>();

    // Add items to first ArrayList
    list1.add("A");
    list1.add("B");
    list1.add("C");
    list1.add("D");

    // Create second ArrayList
    ArrayList<String> list2 = new ArrayList<String>();

    // Add items to second ArrayList
    list2.add("W");
    list2.add("X");
    list2.add("Y");
    list2.add("Z");

    // Print first ArrayList
    System.out.println("List 1:");
    System.out.println(list1);

    // Print second ArrayList
    System.out.println("List 2:");
    System.out.println(list2);

    // Add second ArrayList to first ArrayList at index 3
    list1.addAll(3, list2);

    // Print the combined ArrayList
    System.out.println("List 1 + List 2:");
    System.out.println(list1);
    }
    
}
