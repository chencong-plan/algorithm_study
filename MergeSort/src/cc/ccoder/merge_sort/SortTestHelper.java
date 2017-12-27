package cc.ccoder.merge_sort;

import java.lang.reflect.Method;

/**
 * @author : ChenCong
 * @date : Created in 11:51 2018/1/3
 */
public class SortTestHelper {

    private SortTestHelper() {

    }

    /**
     * 生成指定n长度的数组，边界在[rangeL , rangeR]之间
     *
     * @param n      数组长度
     * @param rangeL 数组左边界
     * @param rangeR 数组右边界
     * @return 生成的数组
     */
    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {
        assert n >= 0;
        assert rangeL < rangeR;
        Integer[] array = new Integer[n];
        for (int i = 0; i < n; i++) {
            array[i] = (int) (Math.random() * ((rangeR - rangeL) + 1)) + rangeL;
        }
        return array;
    }

    /**
     * 反射封装，进行比较排序类当中sort方法对数组array的排序效果，是否完整排序，排序所用时间
     *
     * @param clazz 使用的排序算法种类
     * @param array 将要进行排序的数组
     */
    public static void testSort(Class<?> clazz, Comparable[] array) {
        try {
            Method sortMethod = clazz.getMethod("sort", Comparable[].class);
            // 添加参数
            Object[] params = new Object[]{array};
            // 调用排序算法
            Long beginTime = System.currentTimeMillis();
            sortMethod.invoke(null, params);
            Long endTime = System.currentTimeMillis();
            // 判断是否正确排序
            assert isSort(array);
            // 打印时间
            System.out.println(clazz.getSimpleName() + ":" + (endTime - beginTime) + " ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 判断数组是否是完全排好序,从小到到顺序
     *
     * @param array 将要排序的数组
     * @return 有序为true 否则false
     */
    private static boolean isSort(Comparable[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i - 1].compareTo(array[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 打印数组
     *
     * @param array 将要进行打印的数组
     */
    public static void printArray(Integer[] array) {
        for (Integer item : array) {
            System.out.print(item + " ");
        }
    }
}
