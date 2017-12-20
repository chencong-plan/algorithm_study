package cc.ccoder.selection_sort_generator;


/**
 * @author chencong , Created in 2017/12/20 21:48
 */
public class SelectionSort {

    /**
     * 泛型选择排序，该泛型应该为能够使用CompareTo比较
     *
     * @param array 将比较数组
     * @param <T>   继承了Comparable借口的类
     */
    public static <T extends Comparable<T>> void sort(T[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            // 寻找区间[i,n)当中最小值
            for (int j = i; j < n; j++) {
                // 使用CompareTo方法比较两个Comparable对象的大小
                if (array[j].compareTo(array[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            //交换位置
            if (i != minIndex) {
                T temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        // 测试排序算法的辅助生成数组函数
        int n = 1000;
        Integer[] array = SortTestHelper.generatorRandomArray(n, 0, 10000);
        SortTestHelper.printArray(array);
        Long beginTime = System.currentTimeMillis();
        sort(array);
        Long endTime = System.currentTimeMillis();
        SortTestHelper.printArray(array);
        System.out.println("共耗时间：" + (endTime - beginTime) + " ms");
    }
}
