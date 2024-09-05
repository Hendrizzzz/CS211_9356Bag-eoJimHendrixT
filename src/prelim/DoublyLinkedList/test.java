package prelim.DoublyLinkedList;

import java.util.Date;

public class test {
    public static void main(String[] args) {
        MyDoublyLinkedList<Integer> integers = new MyDoublyLinkedList<>();
        integers.insert(1);
        integers.insert(2);
        integers.insert(3);
        integers.insert(4);
        integers.insert(5);
        integers.insert(6);
        integers.insert(7);
        integers.insert(8);
        integers.insert(9);
        integers.insert(10);

        System.out.println(integers.head.getData());
        System.out.println(integers.head.getNext().getData());
        System.out.println(integers.head.getNext().getNext().getData());
        System.out.println(integers.head.getNext().getNext().getNext().getData());
        System.out.println(integers.head.getNext().getNext().getNext().getNext().getData());
        System.out.println(integers.head.getNext().getNext().getNext().getNext().getPrevious().getData());
        System.out.println(integers.head.getNext().getNext().getNext().getNext().getPrevious().getPrevious().getData());
        System.out.println(integers.head.getNext().getNext().getNext().getNext().getPrevious().getPrevious().getPrevious().getData());
        System.out.println(integers.head.getNext().getNext().getNext().getNext().getPrevious().getPrevious().getPrevious().getPrevious().getData());


        System.out.println();


        System.out.println("\n\n");

    }
}