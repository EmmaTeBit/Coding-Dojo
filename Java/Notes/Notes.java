package Notes;

public class Notes {
    public static void main(String[] args) {
        //increase by 1
        for (int i= 0; i<5; i++) {
            System.out.println(i);
            //01234
        }
        //increase by 2
        for (int i= 0; i<5; i+=2) {
            System.out.println(i);
            //024
        }
        //decrease by 1
        for (int i= 5; i>0; i--) {
            System.out.println(i);
            //54321
        }
        
        // While Loop
        int count = 0;
        while(count<5) {
            System.out.println(count);
            count++;
            //01234
        }

        //Enhanced for loop
        String[] fruits = {"banana", "orange", "apple", "kiwi"};
        for(String s : fruits) {
            System.out.println(s);
            // banana
            // orange
            // apple
            // kiwi
        }



    }
}
