package cc.ccoder.selection_sort_Compare;

/**
 * @author : ChenCong
 * @date : Created in 17:37 2017/12/20
 */
public class SelectionSort {

    public static void sort(Comparable[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i; j < n; j++) {
                if (array[j].compareTo(array[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                Comparable temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {

    }
}
