package stream;

import Generic.Student;

import java.util.Arrays;
import java.util.List;

public class StreamEx4 {

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("a", 16, 11),
                new Student("b", 17, 12),
                new Student("c", 18, 13),
                new Student("d", 19, 14));

        double score = students.stream()
                .mapToInt(Student::getMathScore)
                .average()
                .getAsDouble();

        System.out.println("score = " + score);
    }

}
