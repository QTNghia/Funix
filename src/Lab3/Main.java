package Lab3;

public class Main {
    public static void main(String[] args) {
        MyList list = new MyList();
        int[] a = new int[]{7,2,9,8,6,3};
        list.insertManyAtTail(a);
        System.out.print("Traverse: ");
        list.traverse();
        int x = 8;
        System.out.println();
        list.search(x);
    }
}
