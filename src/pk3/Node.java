package pk3;

public class Node {
    private int data;
    private Node nextNode;

    public Node(int data) {
        this.data = data;
    }

    public void setData(int data) {
        this.data = data;
    }
    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public int getData() {
        return data;
    }
    public Node getNextNode() {
        return nextNode;
    }

    @Override
    public String toString(){
        return "Data: " + this.data;
    }

}
