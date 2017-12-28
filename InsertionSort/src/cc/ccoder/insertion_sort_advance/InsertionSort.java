package cc.ccoder.insertion_sort_advance;

/**
 * @author : ChenCong
 * @date : Created in 17:33 2017/12/28
 */
public class InsertionSort {

    private InsertionSort() {

    }

    /**
     * 插入排序的优化
     * 将array[j] 和 array[j-1]的交换 替换成赋值，一次交换就需要三次赋值
     *
     * @param array 将要进行排序的数组
     */
    public static void sort(Comparable[] array) {
        for (int i = 0; i < array.length; i++) {
            // 寻找array[i] 合适的插入位置
            Object temp = array[i];
            int j;
            for (j = i; j > 0 && array[j - 1].compareTo(temp) > 0; j--) {
                array[j] = array[j - 1];
            }
            array[j] = (Comparable) temp;
        }
    }

    public static void main(String[] args) {
        Integer[] array = {2, 3, 9, 6, 3, 4, 5, 0, 1, 8, 7};
        sort(array);
        for (Integer item : array) {
            System.out.print(item);
        }

    }
}
