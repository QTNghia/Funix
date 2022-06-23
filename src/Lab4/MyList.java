package Lab4;

import org.jetbrains.annotations.NotNull;

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

    /**
     * Hàm thêm 1 người vào đuôi danh sách liên kết
     * @param info
     */
    public void insertAtTail(Person info){
        Node newNode = new Node(info);
        if (this.head == null){
            this.head = this.tail = newNode;
        }
        this.tail.setNextNode(newNode);
        this.tail = newNode;
    }

    /**
     * Hàm thêm nhiều người vào danh sách liên kết,
     * thông tin ( tên và tuổi) của mọi người được lưu trong 2 mảng name và age
     * @param name
     * @param age
     */
    public void insertManyAtTail(String @NotNull [] name, int[] age){
        for (int i = 0; i < name.length; i++) {
            Person newPerson = new Person(name[i], age[i]);
            insertAtTail(newPerson);
        }
    }

    /**
     * Hàm duyệt và in danh sách liên kết
     */
    public void traverse(){
        Node current = this.head;
        while (current != null){
            System.out.println(current.getInfo().toString());
            current = current.getNextNode();
        }
    }

    /**
     * Hàm sắp xếp theo tên
     * interchange sort
     */
    public void sortByName(){
        Node current = this.head;
        while (current != null){
            Node nextCurrent = current.getNextNode();
            while (nextCurrent != null){
                if (current.getInfo().getName().compareTo(nextCurrent.getInfo().getName()) > 0){
                    //swapping
                    String tempName = current.getInfo().getName();
                    int tempAge = current.getInfo().getAge();

                    String tempNextName = nextCurrent.getInfo().getName();
                    int tempNextAge = nextCurrent.getInfo().getAge();

                    current.setInfo(new Person(tempNextName,tempNextAge));
                    nextCurrent.setInfo(new Person(tempName, tempAge));
                }
                nextCurrent = nextCurrent.getNextNode();
            }
            current = current.getNextNode();
        }
    }
}
