package Lab5;

public class Node {
    private int info;
    Node nextNode;

    public Node() {
    }

    public Node(int info) {
        this.info = info;
    }

    public Node(int info, Node nextNode) {
        this.info = info;
        this.nextNode = nextNode;
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}
