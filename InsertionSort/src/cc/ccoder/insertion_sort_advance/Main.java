package cc.ccoder.insertion_sort_advance;

import java.util.Arrays;

/**
 * @author : ChenCong
 * @date : Created in 17:32 2017/12/28
 */
public class Main {

    private static final int N = 100000;
    private static final int RANGE_L = 0;
    private static final int RANGE_R = 1000000;

    public static void main(String[] args) {
        // 生成指定的长度的数组  边界为[RANGE_L,RANGE_R]
        Integer[] arrayInsertion = SortTestHelper.generateRandomArray(N, RANGE_L, RANGE_R);
        Integer[] arraySelection = Arrays.copyOf(arrayInsertion, arrayInsertion.length);
        SortTestHelper.testSort(InsertionSort.class, arrayInsertion);
        SortTestHelper.testSort(SelectionSort.class, arraySelection);
    }
}
