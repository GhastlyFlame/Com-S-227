package cs228hw2.tests;
import cs228hw2.AmusingLinkedList;
public class TestiBoi {
    public TestiBoi(){

    }
    public static void main(String[] args) {
        AmusingLinkedList test = new AmusingLinkedList();
        test.add(1);
        test.add(2);
        test.add(3);
        test.remove(1);

        System.out.println(test.getNodeAtIndex(0));
        System.out.println(test.getNodeAtIndex(1));
//        System.out.println(test.getNodeAtIndex(2));




    }

}
