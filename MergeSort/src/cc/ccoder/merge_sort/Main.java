package cc.ccoder.merge_sort;

import java.util.Arrays;

/**
 * @author : ChenCong
 * @date : Created in 13:01 2018/1/3
 */
public class Main {

    public static void main(String[] args) {
        int n = 50000;
        Integer[] mergeArray = SortTestHelper.generateRandomArray(n, 0, n);
        Integer[] insertionArray = Arrays.copyOf(mergeArray, mergeArray.length);
        Integer[] selectionArray = Arrays.copyOf(mergeArray, mergeArray.length);
        SortTestHelper.testSort(MergeSort.class, mergeArray);
        SortTestHelper.testSort(InsertionSort.class, insertionArray);
        SortTestHelper.testSort(SelectionSort.class, selectionArray);


    }
}
