package cc.ccoder.insertion_sort_advance;

/**
 * @author : ChenCong
 * @date : Created in 17:32 2017/12/28
 */
public class SelectionSort {

    private SelectionSort() {

    }

    public static void sort(Comparable[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i; j < n; j++) {
                if (array[j].compareTo(array[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(array, i, minIndex);
        }
    }

    private static void swap(Comparable[] array, int i, int minIndex) {
        Object temp = array[i];
        array[i] = array[minIndex];
        array[minIndex] = (Comparable) temp;
    }

    public static void main(String[] args) {
        int n = 1000;
        Integer[] array = SortTestHelper.generateRandomArray(n, 0, 10000);
        SortTestHelper.testSort(SelectionSort.class, array);
    }
}
