package cc.ccoder.selection_sort_performance;

import java.lang.reflect.Method;

/**
 * @author chencong , Created in 2017/12/20 22:29
 */
public class SortTestHelper {

    private SortTestHelper() {
    }

    /**
     * 生成有n个元素的随机数组，每个元素所在范围为[rangeL,rangeR]之间
     *
     * @param n      生成随机数组大小
     * @param rangeL 左边界
     * @param rangeR 右边界
     * @return 生成的数组
     */
    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {
        if (rangeL >= rangeR) {
            throw new IllegalArgumentException("参数不合法,区间" + rangeL + ":" + rangeR);
        }
        Integer[] array = new Integer[n];
        for (int i = 0; i < n; i++) {
            array[i] = (int) (Math.random() * (rangeR - rangeL + 1) + rangeL);
        }
        return array;
    }

    /**
     * 判断数组array是否有序
     *
     * @param array 将要判断的数组
     * @return 返回该数组是否有序
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
     * 测试SortClassName所对应的排序算法对array数组排序所得到的结果的正确性和算法运算时间
     *
     * @param clazz 使用的排序算法
     * @param array 将要测试的算法
     */
    public static void testSort(Class<?> clazz, Comparable[] array) {
        try {
            // 通过sortClassName获得到排序方法的类类型（calss对象）
            //Class sortClass = Class.forName(sortClassName);
            //通过class对象获得到排序方法
            Method sortMethod = clazz.getMethod("sort", Comparable[].class);
            //排序参数只有一个，是将要比较的数组array
            Object[] params = new Object[]{array};
            Long beginTime = System.currentTimeMillis();
            // 调用排序算法
            sortMethod.invoke(null, params);
            Long endTime = System.currentTimeMillis();
            // 判断数组是否已经正确排序
            assert isSorted(array);
            System.out.println(clazz.getSimpleName() + " : " + (endTime - beginTime) + "ms");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
