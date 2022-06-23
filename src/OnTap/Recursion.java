package OnTap;

public class Recursion {

    int count = 0;
    public void printXToY( int x, int y){
        if (x <= y){
            System.out.print(x + " ");
            printXToY(x + 1, y);
        }
    }

    public void printXToY(int n){
        count++;
        if (count <= n){
            System.out.print(count + " ");
            printXToY(n);
        }
    }

    public int sum1ToN(int n){
        if (n == 1) return 1;
        return n + sum1ToN(n - 1);
    }

    public int di1ToN(int n){
        if (n == 1) return 1;
        return n * di1ToN(n - 1);
    }

    public int UCLN(int x, int y){
        if (y == 0) return x;
        /*int temp = y;
        y = x%y;
        x = temp;*/
        return UCLN(y, x%y);
    }

    public void townOfHN(int n, char A, char C, char B){
        if (n == 1){
            System.out.print(A + " -> " + C);
            return;
        }
        townOfHN(n - 1, A, B, C);
        System.out.print(A + " -> " + C);
        townOfHN(n - 1, B, C, A);
    }
}
