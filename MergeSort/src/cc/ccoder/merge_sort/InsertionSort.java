package cc.ccoder.merge_sort;

/**
 * @author : ChenCong
 * @date : Created in 11:39 2018/1/3
 */
public class InsertionSort {

    private InsertionSort() {

    }

//    /**
//     * 插入排序，用空间换时间
//     *
//     * @param array 进行排序数组
//     */
//    public static void sort(Comparable[] array) {
//        int n = array.length;
//        for (int i = 0; i < n; i++) {
//            Object temp = array[i];
//            int j;
//            for (j = i; j > 0 && array[j - 1].compareTo(temp) > 0; j--) {
//                array[j] = array[j - 1];
//            }
//            array[j] = (Comparable) temp;
//        }
//    }

    /**
     * 排序算法，最直观，好理解
     * 寻找array[i]元素的合适插入位置，和前面元素进行比较，如果array[j-1] > array[j] 进行交换
     *
     * @param array 排序数组
     */
    public static void sort(Comparable[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0; j--) {
                // 寻找array[i] 元素合适插入位置，array[j-1] > array[j] 进行交换
                if (array[j].compareTo(array[j - 1]) < 0) {
                    swap(array, j - 1, j);
                }
            }
        }
    }

    /**
     * 辅助方法，进行交换数组当中元素
     *
     * @param array 进行排序的数组
     * @param j     索引
     * @param i     索引
     */
    private static void swap(Comparable[] array, int j, int i) {
        Object temp = array[j];
        array[j] = array[i];
        array[i] = (Comparable) temp;
    }


    public static void main(String[] args) {
        Integer[] array = {6, 7, 5, 3, 2, 0, 9, 1, 4, 8};
        sort(array);
        for (Integer temp : array) {
            System.out.print(temp + " ");
        }
    }
}
