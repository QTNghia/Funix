package Lab4;

public class Main {
    public static void main(String[] args) {
        String[] name = new String[]{"HOA", "HA", "LAN", "NOI", "MUA", "NAY"};
        int[] age = new int[]{25, 17, 26, 19, 23, 21};

        MyList list = new MyList();

        list.insertManyAtTail(name, age);
        list.traverse();
        list.sortByName();
        System.out.println("---");
        list.traverse();
    }
}
