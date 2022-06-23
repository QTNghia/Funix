package Lab1;

import java.util.Scanner;

public class SimpleSort {
    static int[] arr;

    public SimpleSort() {
    }

    public static void display(int[] a){
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    //Tim hieu them. Khi mang da xap xep roi thi khong can chay swap nua
    public static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++){
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j + 1] < arr[j]){
                    //boolean
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            display(arr);
        }
    }

    public static void bubbleSortCheckSorted(int[] a){
        int size = a.length;
        // loop to access each array element
        for (int i = 0; i < (size-1); i++) {
            // check if swapping occurs
            boolean swapped = false;
            // loop to compare adjacent elements
            for (int j = 0; j < (size-i-1); j++) {
                // compare two array elements
                // change > to < to sort in descending order
                if (a[j] > a[j + 1]) {
                    // swapping occurs if elements
                    // are not in the intended order
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;

                    swapped = true;
                }
            }
            // no swapping means the array is already sorted
            // so no need for further comparison
            if (!swapped)
                break;
        }
    }

    public static int euclid(int x, int y){
        /*if (y == 0){
            return x;
        }
        return euclid(y, x%y);*/

        while (y != 0){
            int temp = x%y;
            x = y;
            y = temp;
        }
        return x;
    }

    public static int[] input(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of element in Array: ");

        int n;
        for(n = sc.nextInt(); n > 20; n = sc.nextInt()) {
            System.out.print("Again! Number of element in Array: ");
        }

        int[] arr = new int[n];
        System.out.println();

        for(int i = 0; i < arr.length; ++i) {
            System.out.print("Phan tu " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = input();
        System.out.println();
        display(arr);
        System.out.println();
        System.out.println("Bubble Sort");
        bubbleSort(arr);
    }
}
