package pk3;

public class DoublyEndedList {
    private Node head;
    private Node tail;

    public void insertAtTail(int data){
        Node newNode = new Node(data);

        if (this.head == null){
            this.head = this.tail = newNode;
            return;
        }

        this.tail.setNextNode(newNode);
        this.tail = newNode;
    }

    @Override
    public String toString(){
        String result = "{ ";
        Node current = this.head; // Tạo 1 Node current trở tới head của LinkedList

        while (current != null){
            result += current.toString() + ", ";
            current = current.getNextNode(); // Đi đến nút tiếp theo
        }

        result += "}";
        return result;
    }
}
