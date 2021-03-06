package cc.ccoder.insertion_sort_advance;

import java.lang.reflect.Method;

/**
 * @author : ChenCong
 * @date : Created in 17:32 2017/12/28
 */
public class SortTestHelper {


    /**
     * 生成有n个元素的数组，每个元素的范围是[rangL,rangR]区间
     *
     * @param n      数组大小长度
     * @param rangeL 数组左区间
     * @param rangeR 数组右区间
     * @return 生成的数组
     */
    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {
        // 判断数组区间是否合法
        assert rangeL <= rangeR;
        assert n >= 0;
        Integer[] array = new Integer[n];
        for (int i = 0; i < n; i++) {
            //随机产生一个[rangL,rangR]之间的元素，填入数组当中
            array[i] = (int) (Math.random() * ((rangeR - rangeL) + 1)) + rangeL;
        }
        return array;
    }

    /**
     * 打印输出指定数组
     *
     * @param array 将要进行打印的数组
     */
    public static void printArray(Object[] array) {
        for (Object o : array) {
            System.out.print(o + " ");
        }
        System.out.println();
    }

    /**
     * 判断指定数组是否有序 array[i-1] < array[i]
     *
     * @param array 将要进行判断的数组
     * @return 返回是否有序
     */
    public static boolean isSorted(Comparable[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].compareTo(array[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 生成一个近乎于有序的数组
     * 首先生成一个含有[0,n-1]的完全有序的数组，之后随机交换swapTimes次
     * swapTimes 定义了数组的无序程度
     * swapTimes == 0 时候数组完全有序
     * swapTimes 越大 数组越趋向于无序
     *
     * @param n         定义数组长度
     * @param swapTimes 数组无序程度
     * @return 返回一个无序程度为swapTimes的数组
     */
    public static Integer[] generateNearlyOrderedArray(int n, int swapTimes) {
        if (n < 0 || swapTimes < 0) {
            throw new IllegalArgumentException("参数不合法," + n + " " + swapTimes);
        }
        Integer[] array = new Integer[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }
        // 随机交换数组当中两个位置的元素
        for (int i = 0; i < swapTimes; i++) {
            int a = (int) (Math.random() * n);
            int b = (int) (Math.random() * n);
            int t = array[a];
            array[a] = array[b];
            array[b] = t;
        }
        return array;

    }

    /**
     * 测试clazz所对应的排序算法排序数组array所得到正确性和算法运行时间
     *
     * @param clazz 将要使用的排序算法
     * @param array 将要进行排序的数组
     */
    public static void testSort(Class<?> clazz, Comparable[] array) {
        try {
            Method sortMethod = clazz.getMethod("sort", Comparable[].class);
            // 参数只有一个，就是将要排序的数组
            Object[] params = new Object[]{array};
            // 开始计数
            Long beginTime = System.currentTimeMillis();
            //调用排序算法
            sortMethod.invoke(null, params);
            //结束计数
            Long endTime = System.currentTimeMillis();
            //判断是否正确排序
            assert isSorted(array);
            //共用时
            System.out.println(clazz.getSimpleName() + " : " + (endTime - beginTime) + " ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
