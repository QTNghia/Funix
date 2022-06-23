package Lab2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class SimpleSort {

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

    public static void display(int[] a){
        for (int j : a) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    public static void selecSort(int[] a){
        int lengthA = a.length;
        int[] newA = Arrays.copyOf(a, lengthA);

        for(int i = 0; i < newA.length - 1; ++i) {
            int min_idx = i;
            for(int j = i + 1; j < newA.length; ++j) {
                if (newA[j] < newA[min_idx]) {
                    min_idx = j;
                }
            }
            //Thieu-chua tot
            //Khi i khac j moi swap, du lenh
            if (i != min_idx){
                int temp = newA[min_idx];
                newA[min_idx] = newA[i];
                newA[i] = temp;
            }
            display(a);
        }
    }

    public static void insertSort(int[] a){
        int lengthA = a.length;
        int[] newA = Arrays.copyOf(a, lengthA);

        for(int i = 1; i < newA.length; ++i) {
            int key = newA[i];
            int j;
            for(j = i - 1; j >= 0 && newA[j] > key; --j) {
                newA[j + 1] = newA[j];
            }
            newA[j + 1] = key;
            display(newA);
        }
    }

    public static int searchLinear(int[] a, int value){
        for(int i = 0; i < a.length; i++) {
            if (a[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public static int menu(Scanner sc){
        System.out.println("""
                |    Choose your option:    |
                -----------------------------
                |    1. Display data        |
                |    2. Selection sort      |
                |    3. Insertion sort      |
                |    4. Search              |
                |    0. Exit                |
                """);
        System.out.print("==> Chose: ");
        return sc.nextInt();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = input();
        int chose;
        do {
            chose = menu(sc);
            switch (chose) {
                case 1 -> {
                    display(a);
                    System.out.println();
                }
                case 2 -> {
                    System.out.println("Selection Sort: ");
                    selecSort(a);
                    System.out.println();
                }
                case 3 -> {
                    System.out.println("Insertion Sort: ");
                    insertSort(a);
                    System.out.println();
                }
                case 4 -> {
                    System.out.print("Search value: ");
                    int value = sc.nextInt();
                    int result = searchLinear(a, value);
                    System.out.print("Search (" + value + "): " + result);
                    System.out.println();
                }
            }
        }
        while (chose != 0);
    }
}
