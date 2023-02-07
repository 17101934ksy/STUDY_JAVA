package stream;


import Generic.Student;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class StreamEx9 {

    public static void main(String[] args) {
        IntStream intStream = Arrays.stream(new int[]{5, 4, 1, 2, 3});

        intStream
                .sorted()
                .forEach(n -> System.out.println(n));
        System.out.println();

        List<Student> students = Arrays.asList(
                new Student("a", 32, 31),
                new Student("b", 32, 12),
                new Student("c", 62, 42),
                new Student("a", 22, 52)
        );

        students.stream()
                .sorted(Comparator.comparing(Student::getName))
                .forEach(s -> System.out.println(s.getName()));


        students.stream()
                .sorted((s1, s2) -> s1.getMathScore() - s2.getMathScore())
                .forEach(s -> System.out.println(s.getMathScore()));

        students.stream()
                .sorted(Comparator.comparing(Student::getMathScore))
                .forEach(s -> System.out.println(s.getName()));
    }

}
