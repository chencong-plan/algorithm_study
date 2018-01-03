package cc.ccoder.insertion_sort;

import java.util.Arrays;

/**
 * @author : ChenCong
 * @date : Created in 17:10 2017/12/28
 */
public class Main {
    private final static int N = 50000;
    private final static int RANGE_L = 0;
    private final static int RANGE_R = 100000;

    public static void main(String[] args) {
        /**
         * 测试选择排序和插入排序对同一个数组的排序性能比较
         */

        Integer[] arraySelection = SortTestHelper.generateRandomArray(N, RANGE_L, RANGE_R);
        // 对上面的数组进行拷贝一份，切记不能够直接复制，避免两个排序算法对数组进行干扰
        Integer[] arrayInsertion = Arrays.copyOf(arraySelection, arraySelection.length);

        // 开始测试两个排序算法
        SortTestHelper.testSort(InsertionSort.class, arrayInsertion);
        SortTestHelper.testSort(SelectionSort.class, arraySelection);

    }
}
