package ThiCuoiKi;

public class MyList {
    private Node head;
    private Node tail;

    public void In(int x, int y){
        if (x <= y){
            System.out.print(x + " ");
            x++;
            In(x, y);
        }
    }

    public void insertAtHead(int info){
        Node newNode = new Node(info, null);
        if (this.head == null){
            this.head = newNode;
            this.tail = newNode;
            return;
        }
        //Node newNode = new Node(info, this.head);
        newNode.next = this.head;
        this.head = newNode;
    }

    public void insertAtTail(int info){
        Node newNode = new Node(info, null);
        if (this.head == null){
            this.head = this.tail = newNode;
            return;
        }
        this.tail.next = newNode;
        this.tail = newNode;
    }

    public void display(){
        Node current = this.head;
        while (current != null){
            System.out.print(current.toString() + " ");
            current = current.next;
        }
    }
}
