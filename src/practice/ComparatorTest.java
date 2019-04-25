package practice;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorTest {



    static class Student{
        int id;
        int age;
        String name;

        public Student( String name, int id, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }
    }

    static class IdAscendingComparator implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            if (o1.id > o2.id) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    public static void printStudents(Student[] students) {
        for (Student student : students) {
            System.out.println("Name : " + student.name + ", Id : " + student.id + ", Age : " + student.age);
        }
        System.out.println("===========================");
    }

    public static void main(String[] args) {
        Student student1 = new Student("A", 1, 23);
        Student student2 = new Student("B", 2, 21);
        Student student3 = new Student("C", 3, 22);

        Student[] students = new Student[] { student3, student2, student1 };
        printStudents(students);
        Arrays.sort(students, new IdAscendingComparator());
        printStudents(students);
    }
}
