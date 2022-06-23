import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class InsertionSorter {
    public static void main(String[] args) {
        int[] data = {7,3,6,8,2};
        new InsertionSorter().sort(data);
        System.out.println(Arrays.toString(data));
    }
    public void sort(int @NotNull [] data){
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
}
