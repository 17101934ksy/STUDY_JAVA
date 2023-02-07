package stream;

import Generic.Student;

import java.util.Arrays;
import java.util.List;

public class StreamEx7 {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("a", 10, 20),
                new Student("b", 11, 21),
                new Student("c", 12, 22),
                new Student("d", 13, 23)
        );

        double asDouble = students.stream()
                .mapToInt(Student::getMathScore)
                .average()
                .getAsDouble();
    }
}
