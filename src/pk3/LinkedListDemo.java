package pk3;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insertAtHead(5);
        list.insertAtHead(15);
        list.insertAtHead(25);
        list.insertAtHead(35);
        list.insertAtHead(45);

        System.out.println(list);

        System.out.println("Index: " + list.index(45));

    }
}
