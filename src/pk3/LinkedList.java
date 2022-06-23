package pk3;

public class LinkedList {
    private Node head;

    public void insertAtHead(int data){
        Node newNode = new Node(data); // Tạo Node mới
        newNode.setNextNode(this.head); // Trỏ nextNode của Node mới đến head hiện tại
        this.head = newNode; // Trỏ head của LinkedList đến newNode
    }

    public int length(){
        int length = 0;
        Node current = this.head;

        while (current != null){
            length++;
            current = current.getNextNode();
        }
        return length;
    }

    public void deleteFromHead(){
        this.head = this.head.getNextNode(); // Trỏ head của LinkedList tới Node sau của Node đầu tiên.
    }

    public Node find(int data){
        Node current = this.head;

        while (current != null){
            if (current.getData() == data){
                return current;
            }
            current = current.getNextNode();
        }
        return null;
    }

    public int index(int data){
        Node current = this.head;
        Node find = find(data);
        int index = 0;

        if (find != null){
            while (current != null){
                if (current.getData() == data){
                    return index;
                }
                index++;
                current = current.getNextNode();
            }
        }
        return -1;
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
