package CSD201_AS2_FX13457;

/**
 * Doubly Ended List
 */
public class MyList {
    private Node head;
    private Node tail;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public MyList() {
    }

    public boolean isEmpty(){
        return this.head == null;
    }

    public int length(){
        Node current = this.head;
        int length = 0;
        while (current != null){
            length++;
            current = current.getNextNode();
        }
        return length;
    }

    /**
     * Insert Node to head
     * @param data info Product
     */
    public void insertToHead(Product data){
        Node newNode = new Node(data);
        newNode.setNextNode(this.head);
        this.head = newNode;
    }

    /**
     * Insert Node to tail
     * @param data info Product
     */
    public void insertAtTail(Product data){
        Node newNode = new Node(data);
        if (this.head == null){
            this.head = newNode;
            this.tail = newNode;
            return;
        }
        this.tail.setNextNode(newNode);
        this.tail = newNode;
        System.out.println("Successfully!");
    }

    public String delete(String bcode){
        Node current = this.head;
        Node nextCurrent = current.getNextNode();
        while (nextCurrent != null){
            // Node cần xóa = head
            if (this.head.getData().getBcode().equals(bcode)){
                this.head = this.head.getNextNode();
                return "Deleted! ID = " + bcode;
            }
            // Node cần xóa = tail
            if ((nextCurrent.getData().getBcode().equals(bcode)) && (nextCurrent.getNextNode() == null)){
                current.setNextNode(null);
                this.tail = current;
                return "Deleted! ID = " + bcode;
            }
            //Node cần xóa nằm giữa
            if (nextCurrent.getData().getBcode().equals(bcode)){
                current.setNextNode(nextCurrent.getNextNode());
                return "Deleted! ID = " + bcode;
            }
            current = current.getNextNode();
            nextCurrent = current.getNextNode();
        }
        return "Not FOUND!";
    }

    public String toString(){
        String result = """
                ID   |  Title   |   Quantity   |   Price
                ----------------------------------------
                """;
        Node current = this.head;

        while (current != null) {
            result += current.toString() + "\n";
            current = current.getNextNode();
        }
        return result;
    }
}
