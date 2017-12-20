package cc.ccoder.selection_sort_Compare;

/**
 * @author : ChenCong
 * @date : Created in 17:37 2017/12/20
 */
public class SelectionSort {

    public static void sort(Comparable[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i; j < n; j++) {
                if (array[j].compareTo(array[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                Comparable temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {

        // 测试Integer
        Integer[] a = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort(a);
        for (Integer item : a) {
            System.out.print(item + " ");
        }

        System.out.println();

        // 测试Double
        Double[] b = {1.2, 5.2, 3.5, 9.5, 0.8, 4.6};
        sort(b);
        for (Double item : b) {
            System.out.print(item + " ");
        }
        System.out.println();

        String[] c = {"A", "F", "C", "B", "D", "E"};
        sort(c);
        for (String item : c) {
            System.out.print(item + " ");
        }

        System.out.println();
        // 测试Student
        // 测试自定义的类 Student
        Student[] d = new Student[4];
        d[0] = new Student("D", 90);
        d[1] = new Student("C", 100);
        d[2] = new Student("B", 95);
        d[3] = new Student("A", 95);
        for (Student student : d) {
            System.out.println(student);
        }
    }
}
