package OnTap;

public class Node {
    int data;
    Node nextNode;

    Node(){}
    Node(int data, Node p){
        this.data = data;
        nextNode = p;
    }
}
