package LinkListAssignment;
public class Test {

    public static void main(String[] args) {
        SinglyLinkList sll = new SinglyLinkList();
        // sll.add(3);
        // sll.add(4);
        // sll.add(10);
        // sll.add(5);
        // sll.add(15);
        // sll.add(2);
        // sll.remove();
        // sll.remove();
        // sll.printValue();

        sll.addBack(1);
        sll.addBack(2);
        sll.addBack(3);
        sll.addBack(4);

        int val = sll.removeBack();
        System.out.println(val);


    }
    
}
