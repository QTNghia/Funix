import org.jetbrains.annotations.NotNull;
import java.util.Arrays;
import java.util.Scanner;

public class BubbleSorter {
    public static void main(String[] args) {
        int[] data = input();
        System.out.println(Arrays.toString(data));
        System.out.println();
        sort(data);
    }

    public static void sort(int @NotNull [] data){
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - 1 - i; j++) {
                if (data[j+1] < data[j]){
                    int temp = data[j+1];
                    data[j+1] = data[j];
                    data[j] = temp;
                }
            }
            System.out.println(Arrays.toString(data));
        }
    }

    public static int @NotNull [] input(){
        System.out.print("N = ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < array.length; i++) {
            System.out.print("N" + (i + 1) + " = ");
            array[i] = sc.nextInt();
        }

        return array;
    }
}
