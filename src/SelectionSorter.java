import org.jetbrains.annotations.NotNull;
import java.lang.reflect.Array;
import java.util.Arrays;

public class SelectionSorter {
    public static void main(String[] args) {
        int[] data = {7,3,11,6,8,2,1,5,4};
        selectionSorter(data);
        System.out.println(Arrays.toString(data));
    }

    /** Hàm xắp xếp lựa chọn
     *
     * @param data Mảng int[]
     */
    public static void selectionSorter(int @NotNull [] data){
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
}
