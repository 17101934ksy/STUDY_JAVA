package stream;

import Generic.Student;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class StreamEx2 {

    public static void main(String[] args) {
        List<Student> list = Arrays.asList(new Student("a", 30, 40), new Student("b", 35, 40));
        Stream<Student> stream = list.stream();

        stream.forEach(m -> System.out.println("m = " + m.getName()));

    }

}
