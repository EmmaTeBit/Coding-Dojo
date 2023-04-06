package Notes;
import java.util.Arrays;
import java.util.ArrayList;

public class AccessingArrays {
    public static void main(String[] args) {

        String[] food = {"Peach", "Apple", "Orange"};
        System.out.printf("Length: %s", food.length);
        System.out.println(Arrays.toString(food));

        ArrayList<String> balls = new ArrayList<String>();
        balls.add("Baseball");
        System.err.println(balls);

    }
    
}
