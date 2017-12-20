package cc.ccoder;

/**
 * @author : ChenCong
 * @date : Created in 17:17 2017/12/20
 */
public class SelectionSort {

    /**
     * 选择排序
     *
     * @param array 将要进行排序的数组
     */
    public static void sort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            // 寻找区间[i,n) 中最小的数字
            for (int j = i; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {9,8,7,6,5,4,3,2,1};
        sort(array);
        for (int item : array) {
            System.out.print(item+" ");
        }
    }
}
