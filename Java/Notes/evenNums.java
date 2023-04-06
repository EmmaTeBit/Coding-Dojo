package Notes;
import java.util.*;
    class evenNums {

public static void main(String[] args) {
    // Use a for loop to print all odd numbers on the same line
    // Expected output: 13579

    //variables:
    int countEven = 0;
    int even[] = null;
    
    //declare array
    int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    //count even numbers
    for (int i : numbers) {
        if (i % 2 == 0)
        ++countEven;
    }
    //create array to store even numbers
    even = new int[countEven];


    //check each element and insert
    int i = 0;
    for (int num : numbers) {
        if (num % 2 == 0) {
            //even
            even[i++] = num;
        }
    }
        System.out.println(Arrays.toString(even));
    }

}
