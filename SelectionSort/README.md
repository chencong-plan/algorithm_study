## 选择排序
```
    /**
     * 选择排序
     *
     * @param array 将要进行排序的数组
     */
    public static void sort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            // 寻找区间[i,n) 中最小的数字
            for (int j = i; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }
    
```
#### 随机生成数组排序
随机生成指定长度，指定范围数组进行排序。测试用例进行测试写的方法的健壮性。
在包`selection-sort-generator`当中分别是生成随机数组的类`SortTestHelper`和选择排序算法`SelectionSort` 。具体代码实现如下

```java
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

```

#### 计算排序时间
编写排序测试类，计算排序时间及判断排序是否正确。详细见`selection_sort_performance`当中的`SortTestHelper`类。