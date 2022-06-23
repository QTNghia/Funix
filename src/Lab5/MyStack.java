package Lab5;

import java.util.EmptyStackException;

public class MyStack {
    private Node head;

    public boolean isEmpty(){
        return (head == null);
    }

    /**
     * Hàm đẩy 1 phần tử vào stack
     * @param info
     */
    public void push(int info){
        head = new Node(info, head);
        /*Node oldHead = head;
        head = new Node();
        head.setInfo(info);
        head.setNextNode(oldHead);*/
    }

    public int pop() throws EmptyStackException{
        if (head == null){
            throw new EmptyStackException();
        }
        int info = head.getInfo();
        head = head.getNextNode();
        return info;
    }

    public int top() throws EmptyStackException{
        if (head == null){
            throw new EmptyStackException();
        }
        return head.getInfo();
    }

    /**
     * Hàm thuật toán chuyển đổi 1 số nguyên ở hệ đếm thập phân sang nhị phân
     * ( Ta chia liên tiếp số nguyên đó cho 2 đến bao giờ
     * thương bằng 0 thì dừng lại,
     * kết quả của phép chuyển đổi là phần dư của các phép chia theo thứ tự ngược lại)
     * @param a
     */
    public void convertToBinary(int a){
        MyStack list = new MyStack();
        while (a != 0){
            int r = a%2;
            a = a/2;
            list.push(r);
        }
        while (!(list.isEmpty())){
            System.out.print(list.pop());
        }
        System.out.println();
    }
}
