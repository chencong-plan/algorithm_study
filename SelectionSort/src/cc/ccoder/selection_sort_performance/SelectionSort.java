package cc.ccoder.selection_sort_performance;

/**
 * @author chencong , Created in 2017/12/20 22:29
 */
public class SelectionSort {

    public static void sort(Comparable[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            // 寻找[i, n)区间里的最小值的索引
            for (int j = 0; j < n; j++) {
                // 使用compareTo方法比较两个Comparable对象的大小
                if (array[j].compareTo(array[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            // 调换位置
            if (i != minIndex) {
                Object temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = (Comparable) temp;
            }
        }
    }

    public static void main(String[] args) {
        // 测试SortTestHelper辅助方法
        int N = 10000;
        Integer[] array = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort(SelectionSort.class, array);

    }

}
