package CSD201_AS1_FX13457;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Algorithm {

    public Algorithm(){}

    /**
     * Writing the array read from input array arr to file
     * @param fileName The file name of file to write value
     * @param arr The input float array
     * @param isAppend boolean true or false, write new or overwrite
     * @throws IOException Exception
     */
    public void writeFile(String fileName, float[] arr, boolean isAppend) throws IOException {
        FileWriter writerFile = new FileWriter(fileName, isAppend);

        for (float v : arr) {
            writerFile.write(v + " ");
        }

        writerFile.write(System.getProperty("line.separator"));
        writerFile.close();
    }

    /**
     * Writing the array read from input array arr to file
     * @param fileName The file name of file to write value
     * @param data The input String
     * @param isAppend boolean true or false, write new or overwrite
     * @throws IOException Exception
     */
    public void writeFile(String fileName, String data, boolean isAppend) throws IOException{
        FileWriter writerFile = new FileWriter(fileName, isAppend);
        writerFile.write(data);
        writerFile.write(System.lineSeparator());
        writerFile.close();
    }

    /**
     * Reading the file then input to the array arr
     * @param fileName The file name of file to read
     * @param arr Input array using for read
     * @return Returning a array read from the file
     * @throws FileNotFoundException Exception
     */
    public float[] readFile(String fileName, float[] arr) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(fileName));

        for(int i = 0; i < arr.length; ++i) {
            arr[i] = sc.nextFloat();
        }

        sc.close();
        return arr;
    }

    /**
     * Sorting the input array arr using Bubble Sort algorithm.
     * @param fileName The file name of file to read
     * @param arr Input array using for sorting
     * @return Returning a sorted array by using the Bubble Sort algorithm
     * @throws IOException Exception
     */
    public float[] bubbleSort(String fileName, float[] arr) throws IOException {
        for(int i = 0; i < arr.length - 1; ++i) {
            for(int j = 0; j < arr.length - 1 - i; ++j) {
                if (arr[j] > arr[j + 1]) {
                    float temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            this.display(arr);
        }
        this.writeFile(fileName, arr, false);
        return arr;
    }

    /**
     * Sorting the input array arr using Selection Sort algorithm.
     * @param fileName The file name of file to read
     * @param arr Input array using for sorting
     * @return Returning a sorted array by using the Selection Sort algorithm
     * @throws IOException Exception
     */
    public float[] selectSort(String fileName, float[] arr) throws IOException {
        for(int i = 0; i < arr.length - 1; ++i) {
            int min_idx = i;

            for(int j = i + 1; j < arr.length; ++j) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }
            float temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
            this.display(arr);
        }
        this.writeFile(fileName, arr, false);
        return arr;
    }

    /**
     * Sorting the input array arr using Insertion Sort algorithm.
     * @param fileName The file name of file to read
     * @param arr Input array using for searching
     * @return Returning a sorted array by using the Insertion Sort algorithm
     * @throws IOException Exception
     */
    public float[] insertionSort(String fileName, float[] arr) throws IOException {
        for(int i = 1; i < arr.length; ++i) {
            float key = arr[i];

            int j;
            for(j = i - 1; j >= 0 && arr[j] > key; --j) {
                arr[j + 1] = arr[j];
            }

            arr[j + 1] = key;
            this.display(arr);
        }
        this.writeFile(fileName, arr, false);
        return arr;
    }

    /**
     * Searching the indices of elements in array [arr] greater than value. Printing
     * and writing all indices to the console screen and file OUTPUT4.TXT separated by space.
     * @param arr Input array using for searching
     * @param value The value for searching
     * @return String result
     */
    public String search(float[] arr, float value) {
        String result = "";
        for(int i = 0; i < arr.length; ++i) {
            if (arr[i] > value) {
                result += " " + i;
            }
        }
        return "Result: " + result;
    }

/*    *//**
     * Searching by using the Binary Search algorithm. Returning the first index of
     * value if it is present in array arr, otherwise, return -1. The index also
     * written to file OUTPUT5.TXT and shown on the console screen.
     * @param arr Input array using for searching
     * @param left The left index
     * @param right The right index
     * @param value The value for searching
     * @return The index of the element if found, otherwise, return -1
     *//*
    public int binarySearch(float[] arr, int left, int right, float value) {
        while(left <= right) {
            int mid = left + (right - 1) / 2;
            if (arr[mid] == value) {
                return mid;
            }
            if (arr[mid] < value) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }*/

    public int binarySortFirst(float[] a, float value){
        float n = a.length;
        float low = 0;
        float high = n - 1;
        float result = -1;

        while (low <= high){
            // Normal Binary Search Logic
            int mid = (int) ((low + high) / 2);
            if (a[mid] > value){
                high = mid - 1;
            } else if (a[mid] < value){
                low = mid + 1;
            }
            // If a[mid] is same as x, we update result and move to the left half.
            else {
                result = mid;
                high = mid - 1;
            }
        }
        return (int) result;
    }

    /**
     * Show array
     * @param arr float array
     */
    public void display(float[] arr) {
        for (float v : arr) {
            System.out.print(" " + v);
        }

        System.out.println();
    }
}
