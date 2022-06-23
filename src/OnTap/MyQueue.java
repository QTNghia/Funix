package OnTap;

/**
 * Queue là hàng đợi, trong đó thêm phần tử sẽ diễn ra ở 1 đầu, và xóa hay đọc phần tử diễn ra ở đầu con lại
 * Các hàm cơ bản trong Queue:
 *      enQueue: thêm phần tử vào cuối hàng đợi
 *      deQueue: xáo 1 phần tử trong hàng đợi, ở đầu hàng đợi
 *      peak: lấy 1 phần tử ở đầu hàng đợi, mà không xóa nó
 */
public class MyQueue {
    Node front;
    Node back;

    public void enQueue(int a){
        Node newNode = new Node(a, null);
        if (front == null){
            this.front = newNode;
            this.back = newNode;
            return;
        }
        this.back.nextNode = newNode;
        this.back = newNode;
    }

    public void deQueue() throws Exception{
        if (front == null) throw new Exception();
        this.front = this.front.nextNode;
    }

    public int peak() throws Exception{
        if (front == null) throw new Exception();
        return this.front.data;
    }
}
