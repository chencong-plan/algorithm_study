package cc.ccoder.merge_sort;

import java.util.Arrays;

/**
 * @author : ChenCong
 * @date : Created in 10:21 2018/1/3
 * 归并排序，所有过程
 */
public class MergeSort {

    private MergeSort() {

    }

    /**
     * 进行归并排序
     *
     * @param array 将要进行排序的数组
     */
    public static void sort(Comparable[] array) {
        int n = array.length;
        sort(array, 0, n - 1);
    }

    /**
     * 归并排序，将其私有化内部处理
     * 1、判断数组区间是否合法，否则退出
     * 2、算出数组重点位置，一分为二
     * 3、将左区间[l,mid] 进行再次一分为二递归
     * 4、将右区间[mid + 1,r] 进行再次一分为二递归
     * 5、将最后的递归结果进行归并
     *
     * @param array 将要进行排序的数组
     * @param l     数组左区间
     * @param r     数组右区间
     */
    private static void sort(Comparable[] array, int l, int r) {
        // 此处为递归结束的标志，l=r 最后成为一个元素，如果是l>r 出现StackOverflow 异常
        if (l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        // 递归一分为二
        sort(array, l, mid);
        sort(array, mid + 1, r);
        // 将其合并
        merge(array, l, mid, r);
    }

    /**
     * 将array[l,mid] 和 array[mid+1,r]两部分进行归并
     * 1、首先开辟空间，备份一次数组，索引为k(k起始位置为原数组array[l]左边界)
     * 2、初始化左半部分索引为i，右半部分索引为j(mid+1)
     * 3、将索引i,j位置元素进行比较，小者放入k索引位置
     * 4、完成一次归并，移动i,j,k索引
     *
     * @param array 将要进行归并排序的数组
     * @param l     数组左边界
     * @param mid   数组分割点索引
     * @param r     数组右边界位置
     */
    private static void merge(Comparable[] array, int l, int mid, int r) {
        // 1、开辟空间，备份数组，索引为k
        Comparable[] aux = Arrays.copyOfRange(array, l, r + 1);
        // 初始化索引i 和 j
        int i = l, j = mid + 1;
        // 遍历备份数组，索引k为原数组array[l]位置
        for (int k = l; k <= r; k++) {
            // 如果左半部分元素全部处理完毕，k开始为右部分元素
            if (i > mid) {
                array[k] = aux[j - l];
                j++;
            } else if (j > r) {
                // 如果右半部分元素全部处理完毕
                array[k] = aux[i - l];
                i++;
            } else if (aux[i - l].compareTo(aux[j - l]) < 0) {
                // 左半部分索引元素小于右半部分索引元素
                array[k] = aux[i - l];
                i++;
            } else {
                // 左半部分索引元素>= 右半部分元素
                array[k] = aux[j - l];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int N = 10000;
        Integer[] array = {2, 1, 5, 9, 7, 4, 3, 6, 8};
        Long beginTime = System.currentTimeMillis();
        sort(array);
        Long endTime = System.currentTimeMillis();
        for (Integer item : array) {
            System.out.print(item + " ");
        }
        System.out.println((endTime - beginTime) + " ms");
    }
}

