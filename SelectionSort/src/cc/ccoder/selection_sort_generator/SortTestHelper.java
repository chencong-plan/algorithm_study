package cc.ccoder.selection_sort_generator;

/**
 * @author chencong , Created in 2017/12/20 21:47
 */
public class SortTestHelper {
    /**
     * 私有构造函数不允许实例化
     */
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
    public static Integer[] generatorRandomArray(int n, int rangeL, int rangeR) {
        if (rangeL >= rangeR) {
            return null;
        }
        Integer[] array = new Integer[n];
        for (int i = 0; i < n; i++) {
            array[i] = new Integer((int) (Math.random() * (rangeR - rangeL + 1) + rangeL));
        }
        return array;
    }

    /**
     * 打印数组内元素
     *
     * @param array 将要打印的数组元素
     */
    public static void printArray(Object[] array) {
        for (Object o : array) {
            System.out.print(o + " ");
        }
        System.out.println();
    }
}
