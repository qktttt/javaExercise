package DataStr_Algorithm;

import DataStr_Algorithm.DbLinkedList;

/**
 * Created by Kunting QI on 2018/5/22.
 */
public class DbLinkedListTest {
    public static void main(String[] args) {
        System.out.println("This is the tester of double linked list.");
        DbLinkedList<Integer> newOne = new DbLinkedList<>();
        newOne.addToHead(1);
        newOne.addToHead(2);
        newOne.addToHead(3);
        newOne.addToTail(4);
        newOne.print();
        newOne.removeFromHead();
        newOne.removeFromTail();
        newOne.print();
        newOne.removeFromHead();
        newOne.removeFromHead();
        newOne.print();

        newOne.addToHead(123);
        newOne.addToHead(234);
        newOne.addToHead(456);

        for(int each : newOne)
        {
            System.out.println(each);
        }

        DbLinkedList<String> second = new DbLinkedList<>();
        second.addToTail("123");
        second.addToHead("234");
        second.addToTail("345");
        second.addToHead("456");
        second.print();
    }
}
