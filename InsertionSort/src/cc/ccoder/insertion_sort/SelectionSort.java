package cc.ccoder.insertion_sort;

/**
 * @author : ChenCong
 * @date : Created in 17:04 2017/12/28
 */
public class SelectionSort {

    private SelectionSort() {

    }

    /**
     * 选择排序，每次寻找数组array[i,n)中的最小值
     *
     * @param array 将要进行排序的数组
     */
    public static void sort(Comparable[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            // 寻找区间[i,n)中的最小值
            for (int j = i; j < n; j++) {
                if (array[j].compareTo(array[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Object temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = (Comparable) temp;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] array = {3, 1, 6, 4, 7, 0, 8, 9, 5, 2};
        sort(array);
        for (Integer item : array) {
            System.out.print(item + " ");
        }
    }
}
