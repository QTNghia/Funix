package pk3;

public class DoublyEndedListDemo {
    public static void main(String[] args) {
        DoublyEndedList list = new DoublyEndedList();

        list.insertAtTail(8);
        list.insertAtTail(18);
        list.insertAtTail(28);
        list.insertAtTail(38);
        list.insertAtTail(48);

        System.out.println(list);
    }
}
