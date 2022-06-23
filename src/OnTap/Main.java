package OnTap;

public class Main {
    public static void main(String[] args) {
        MyList list = new MyList();
        //int a[] = { 6, 7, 0, 2, 8, 1, 3, 9, 4, 5 };
        int[] a = {8, 4, 1, 6, 5};
        //list.bubbleSort(a);
        /**
         * int a[] = { 6x, 7, 0, 2, 8, 1, 3, 9, 4, 5 };
         * 6 0 2 7 1 3 8 4 5 9.
         * 0 2 6 1 3 7 4 5 8. 9.
         * 0 2 1 3 6 4 5 7. 8. 9.
         * 0 1 2 3 4 5 6. 7. 8. 9.
         * 0 1 2 3 4 5. 6. 7. 8. 9.
         */

        //list.insertSort(a);
        /**
         * int a[] = { 6, 7x, 0, 2, 8, 1, 3, 9, 4, 5 };
         * 6 7 0x 2 8 1 3 9 4 5
         * 0 6 7 2x 8 1 3 9 4 5
         * 0 2 6 7 8x 1 3 9 4 5
         * 0 2 6 7 8 1x 3 9 4 5
         * 0 1 2 6 7 8 3x 9 4 5
         * 0 1 2 3 6 7 8 9x 4 5
         * 0 1 2 3 6 7 8 9 4x 5
         * 0 1 2 3 4 6 7 8 9 5x
         * 0 1 2 3 4 5 6 7 8 9
         */

        //list.selectSort(a);
        /**
         * int a[] = { 6x, 7, 0, 2, 8, 1, 3, 9, 4, 5 };
         * 0 7x 6 2 8 1 3 9 4 5
         * 0 1 6x 2 8 7 3 9 4 5
         * 0 1 2 6x 8 7 3 9 4 5
         * 0 1 2 3 8x 7 6 9 4 5
         * 0 1 2 3 4 7x 6 9 8 5
         * 0 1 2 3 4 5 6x 9 8 7
         * 0 1 2 3 4 5 6 9x 8 7
         * 0 1 2 3 4 5 6 7 8x 9
         * 0 1 2 3 4 5 6 7 8 9
         */

        Recursion recursion = new Recursion();
        //recursion.printXToY(1, 5);
        //System.out.println("UCLN: " + recursion.UCLN(12, 30));
        recursion.printXToY(10);
    }
}
