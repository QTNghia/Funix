package OnTap;

import java.util.EmptyStackException;

/**
 * Stack là ngăn xếp, trong đó các phần từ được thêm và xóa tại 1 đầu duy nhất, gọi là đỉnh ngăn xếp.
 * Các hàm cơ bản trong Stack
 *      push(): thêm phần tử vào đầu.
 *      pop(): xóa phần tử ở đầu.
 *      peak(): đọc giá trị ở đầu
 * Có thể sử dụng ngăn xếp để lưu trữ giá trị convertToBinary
 */
public class MyStack {
    Node top;

    public void push(int data){
        Node newNode = new Node(data, null);
        newNode.nextNode = this.top;
        this.top = newNode;
    }

    public void pop() throws EmptyStackException
    {
        if (top == null) throw new EmptyStackException();
        this.top = this.top.nextNode;
    }

    public int peak() throws EmptyStackException{
        if (top == null) throw new EmptyStackException();
        return this.top.data;
    }

    public void convertToBinary(int a){
        MyStack list = new MyStack();
        while (a != 0){
            int r = a%2;
            a = a/2;
            list.push(r);
        }
        while (list.top != null){
            System.out.print(list.peak());
            list.pop();
        }
    }
}
