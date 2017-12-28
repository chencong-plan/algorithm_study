package cc.ccoder.insertion_sort;

/**
 * @author : ChenCong
 * @date : Created in 17:02 2017/12/27
 */
public class InsertionSort {

    private InsertionSort() {

    }

    /**
     * 插入排序算法,每一次寻找array[i]这个元素合适的插入位置。
     * 内层循环需要进行的条件就是array[j] < array[j-1] ，相对于选择排序这也是插入排序可以进行优化的地方。
     * 根据这个array[j]<array[j-1] 后面比前面大这个条件，就可以产生了第二种写法。
     *
     * @param array 将要进行排序的数组
     */
    public static void sort(Comparable[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            // 寻找元素array[i]合适的插入位置
            // 当前位置和前一个位置进行比较 最多考察到j=1的情况
            // 写法一
            for (int j = i; j > 0; j--) {
                if (array[j].compareTo(array[j - 1]) < 0) {
                    swap(array, j, j - 1);
                } else {
                    break;
                }
            }

            // 写法二
//            for (int j = i; j > 0 && array[j].compareTo(array[j - 1]) < 0; j--) {
//                swap(array, j, j - 1);
//            }

            // 写法三
            // 寻找array[i] 合适的插入位置
            Comparable e = array[i];
            int j = i;
            for (; j > 0 && array[j - 1].compareTo(e) > 0; j--) {
                array[j] = array[j - 1];
            }
            array[j] = e;

        }
    }

    /**
     * 调换顺序
     *
     * @param array 进行操作的数组
     * @param i     数组指定位置
     * @param j     数组指定位置
     */
    private static void swap(Object[] array, int i, int j) {
        Object temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] array = SortTestHelper.generateRandomArray(50000, 0, 100000);
        SortTestHelper.testSort(InsertionSort.class, array);

    }


}
