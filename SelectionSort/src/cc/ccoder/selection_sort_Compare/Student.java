package cc.ccoder.selection_sort_Compare;

/**
 * @author : ChenCong
 * @date : Created in 17:30 2017/12/20
 */
public class Student implements Comparable<Student> {

    private String name;
    private Integer score;

    public Student(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        if (this.score.equals(o.score)) {
            return this.name.compareTo(o.name);
        } else if (this.score < o.score) {
            return -1;
        } else if (this.score > o.score) {
            return 1;
        } else {
            return 0;
        }

    }

    @Override
    public String toString() {
        return "Student:" + this.name + " " + this.score;
    }
}
