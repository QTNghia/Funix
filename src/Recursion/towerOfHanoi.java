package Recursion;

public class towerOfHanoi {
    /*public void move(int numberOfDisc, char form_rod, char to_rod, char helper_rod){
        if (numberOfDisc == 1){
            System.out.println("Take disc 1 form rod " + form_rod + " to rod " + to_rod);
            return;
        }
        move((numberOfDisc - 1), form_rod, helper_rod, to_rod);
        System.out.println("Take disc " + numberOfDisc + " from rod " + form_rod + " to rod " + to_rod);
        move((numberOfDisc - 1), helper_rod, to_rod, form_rod);
    }*/

    public void move(int num, char A, char C, char B){
        if (num == 1){
            System.out.println("Move 1 disc " + A + " to " + C);
            return;
        }
        move(num - 1, A, B, C);
        System.out.println("Move " + num + " disc " + A + " to " + C);
        move(num - 1, B, C, A);
    }

    public static void main(String[] args) {
        towerOfHanoi t = new towerOfHanoi();
        t.move(3, 'A', 'C', 'B');
    }
}
