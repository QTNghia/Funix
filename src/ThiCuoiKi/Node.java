package ThiCuoiKi;

public class Node {
    int info;
    Node next;

    Node() {}
    Node(int x, Node p)
    {info=x;next=p;
    }

    //Them
    public String toString(){
        return info + " ";
    }
}
