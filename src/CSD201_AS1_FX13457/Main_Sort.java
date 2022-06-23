package CSD201_AS1_FX13457;

import java.io.IOException;
import java.util.Scanner;

public class Main_Sort {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Algorithm asm1 = new Algorithm();
        String fileNameInput = "D:/Funix/CSD201x_02-A_VN_DN/Phan1/src/CSD201_AS1_FX13457/INPUT.txt";
        String fileNameOutput1 = "D:/Funix/CSD201x_02-A_VN_DN/Phan1/src/CSD201_AS1_FX13457/OUTPUT1.txt";
        String fileNameOutput2 = "D:/Funix/CSD201x_02-A_VN_DN/Phan1/src/CSD201_AS1_FX13457/OUTPUT2.txt";
        String fileNameOutput3 = "D:/Funix/CSD201x_02-A_VN_DN/Phan1/src/CSD201_AS1_FX13457/OUTPUT3.txt";
        String fileNameOutput4 = "D:/Funix/CSD201x_02-A_VN_DN/Phan1/src/CSD201_AS1_FX13457/OUTPUT4.txt";
        String fileNameOutput5 = "D:/Funix/CSD201x_02-A_VN_DN/Phan1/src/CSD201_AS1_FX13457/OUTPUT5.txt";
        float[] arr = new float[0];
        float[] arrBS;
        int n = 0;

        int chose;
        do {
            chose = choseMenu(sc);
            sc.nextLine();
            float value;
            float[] arr1;
            switch (chose) {
                case 1 -> {
                    System.out.println("Write File");
                    arr = inputArr();
                    n = arr.length;
                    asm1.writeFile(fileNameInput, arr, false);
                }
                case 2 -> {
                    System.out.println("Read File");
                    arr1 = asm1.readFile(fileNameInput, arr);
                    asm1.display(arr1);
                }
                case 3 -> {
                    System.out.println("Bubble Sort");
                    arr1 = asm1.readFile(fileNameInput, arr);
                    arrBS = asm1.bubbleSort(fileNameOutput1, arr1);
                    //asm1.writeFile(fileNameOutput1, arrBS, false);
                    asm1.display(arrBS);
                }
                case 4 -> {
                    System.out.println("Select Sort");
                    arr1 = asm1.readFile(fileNameInput, arr);
                    arr1 = asm1.selectSort(fileNameOutput2, arr1);
                    asm1.display(arr1);
                }
                case 5 -> {
                    System.out.println("Insertion Sort");
                    arr1 = asm1.readFile(fileNameInput, arr);
                    arr1 = asm1.insertionSort(fileNameOutput3, arr1);
                    asm1.display(arr1);
                }
                case 6 -> {
                    System.out.println("Linear Search");
                    System.out.print("Input Value = ");
                    value = sc.nextFloat();
                    arr1 = asm1.readFile(fileNameInput, arr);
                    String result = asm1.search(arr1, value);
                    asm1.writeFile(fileNameOutput4, result, false);
                    System.out.println(result);
                }
                case 7 -> {
                    System.out.println("Binary Search");
                    System.out.print("Input Value = ");
                    value = sc.nextFloat();
                    //int left = 0;
                    //int right = n - 1;
                    float[] arrBSearch = asm1.readFile(fileNameOutput1, arr);
                    asm1.display(arrBSearch);
                    //int idx = asm1.binarySearch(arrBSearch, left, right, value);
                    int idx = asm1.binarySortFirst(arrBSearch, value);
                    asm1.writeFile(fileNameOutput5, "Indext of fist element: " + idx, false);
                    System.out.println("Indext of fist element: " + idx);
                }
            }
        } while(chose != 0);

    }

    /**
     * Menu chose
     * @param sc Scanner fun
     * @return int chose
     */
    public static int choseMenu(Scanner sc) {
        System.out.println("Menu");
        System.out.println("1. Input");
        System.out.println("2. Output");
        System.out.println("3. Bubble Sort");
        System.out.println("4. Selection Sort");
        System.out.println("5. Insert Sort");
        System.out.println("6. Search > value");
        System.out.println("7. Search = value");
        System.out.println("0. Exit!");
        System.out.print("Chose: ");
        return sc.nextInt();
    }

    /**
     * Number of element in Array, and element
     * @return float array
     */
    public static float[] inputArr() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of element in Array (n <= 20): ");

        int n;
        for(n = sc.nextInt(); n > 20; n = sc.nextInt()) {
            System.out.print("Again! Number of element in Array (n <= 20): ");
        }

        float[] arr = new float[n];
        System.out.println();

        for(int i = 0; i < arr.length; ++i) {
            System.out.print("Phan tu " + (i + 1) + ": ");
            arr[i] = sc.nextFloat();
        }

        return arr;
    }
}
