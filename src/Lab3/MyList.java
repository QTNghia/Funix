package Lab3;

import org.jetbrains.annotations.NotNull;

public class MyList {
    private Node head;
    private Node tail;

    /**
     * Thêm 1 nút vào cuối LL
     * @param data
     */
    public void insertAtTail(int data){
        Node newNode = new Node(data);
        if (this.head == null){
            this.head = newNode;
            this.tail = newNode;
            return;
        }
        this.tail.setNextNode(newNode);
        this.tail = newNode;

    }

    //Chua hieu lam
    public void insertAtHead(int data){
        Node newNode = new Node(data);
        if (this.head == null){
            this.head = newNode;
            this.tail = newNode;
            return;
        }
        newNode.setNextNode(this.head);
        this.head = newNode;
    }

    /**
     * Thêm nhiều nút vào cuối LL
     * @param data
     */
    public void insertManyAtTail(int @NotNull [] data){
        /*for (int i = 0; i < data.length; i++) {
            insertAtTail(data[i]);
        }*/
        for (int i : data) {
            insertAtTail(i);
        }
    }

    /**
     * Duyệt và in LL
     */
    public void traverse(){
        Node current = this.head;
        while (current != null){
            System.out.print(current.getData() + " ");
            current = current.getNextNode();
        }
    }

    /**
     * Tìm nút có giá trị lớn hơn.
     * @param data
     * @return
     */
    public Node find(int data){
        Node current = this.head;

        while (current != null){
            if (current.getData() > data){
                return current;
            }
            current = current.getNextNode();
        }
        return null;
    }

    /**
     * Hàm tìm kiếm phần tử có giá trị lớn hơn x,
     * nếu tìm thấy thì hiển thị chỉ số của phần tử ra màn hình,
     * giả sử phần tử đầu tiên có chỉ số là 0;
     * @param value
     */
    public void search(int value){
        Node current = this.head;
        Node find = find(value);
        int index = 0;

        if (find != null){
            while (current != null){
                if (current.getData() > value){
                    System.out.println("Index: " + index);
                    return;
                }
                index++;
                current = current.getNextNode();
            }
        }
        System.out.println("Not FOUND!");
    }
}
