import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Scanner;

public class SimpleSort {
    public static void main(String[] args) {
        int[] a = input();
        int length = a.length;
        System.out.println("A: " + Arrays.toString(a));
        int[] b = Arrays.copyOf(a, length);
        System.out.println("B: " + Arrays.toString(b));
        int[] c = Arrays.copyOf(a, length);
        System.out.println("C: " + Arrays.toString(c));
        System.out.println();

        selectSort(b);
        System.out.println("Selection Sort: " + Arrays.toString(b));
        System.out.println();

        insertSort(c);
        System.out.println("Insertion Sort: " + Arrays.toString(c));
        System.out.println();

        Scanner sc = new Scanner(System.in);
        System.out.print("Value = ");
        int value = sc.nextInt();
        int index = search(a, value);
        if (index == -1){
            System.out.println("Not FOUND!");
        } else {
            System.out.println("Index = " + index);
        }
    }

    /**
     *
     * @return array
     */
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

    /** Sắp xếp bằng phương pháp lựa chọn
     *
     * @param data
     */
    public static void selectSort(int @NotNull [] data){
        for (int i = 0; i < data.length - 1; i++){
            int minIndex = i;
            for (int j = i + 1; j < data.length; j++){
                if (data[j] < data[minIndex]){
                    minIndex = j;
                }
                int temp = data[minIndex];
                data[minIndex] = data[i];
                data[i] = temp;
            }
        }
    }

    /** Sắp xếp bằng phương pháp chèn
     *
     * @param data
     */
    public static void insertSort(int @NotNull [] data){
        for (int i = 1; i < data.length; i++){ // Bắt đầu bằng vị trí index thứ 2 đến length - 1.
            int current = data[i]; // Lấy giá trị cần xắp xếp.
            int j = i - 1; // Bắt đầu so sánh với phần tử trước đó 1 đơn vị.
            while (j >= 0 && data[j] >= current){ // So sánh phần tử cần xắp xếp với giá trị trước đó
                data[j+1] = data[j]; // Di chuyển phần tử lớn hơn current ra sau 1 đơn vị
                j--; // Giảm j 1 đơn vị, và tiếp tục thực hiện so sánh với current
            }
            data[j+1] = current; // Gán vị trí đích đến vào biến cần xắp xếp.
        }
    }

    /** Search (int value) trả về số nguyên là vị trí đầu tiên của value trong mảng a sử dụng thuật toán tìm kiếm tuyến tính
     *
     * @param data source search
     * @param value search' value
     * @return index or -1
     */
    public static int search(int @NotNull [] data, int value){
        for (int i = 0; i < data.length; i++) {
            if (data[i] == value){
                return i;
            }
        }
        return -1;
    }
}
