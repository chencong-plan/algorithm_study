package cc.ccoder.merge_sort;


/**
 * @author : ChenCong
 * @date : Created in 13:07 2018/1/3
 * 选择排序
 */
public class SelectionSort {

    private SelectionSort() {

    }

    /**
     * 选择排序，关键思想每一趟选择[i,n)区间当中最小的
     *
     * @param array 将要排序的数组
     */
    public static void sort(Comparable[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            // 每一趟选择[i,n)当中最小的
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
        Integer[] array = {5, 3, 6, 2, 1, 7, 4, 0, 9, 8};
        sort(array);
        for (Integer item : array) {
            System.out.print(item + " ");
        }
    }
}
