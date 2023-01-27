package lambda;

import Generic.Student;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntBiFunction;
import java.util.function.ToIntFunction;

public class FunctionalExample {

    private static List<Student> list = Arrays.asList(new Student("홍길동", 90, 85), new Student("홍길동", 90, 85));

    public static void printString(Function<Student, String> function) {
        for (Student student : list) {
            System.out.println(function.apply(student));
        }
    }

    public static void printInt(ToIntFunction<Student> function) {
        for (Student student : list) {
            System.out.println(function.applyAsInt(student));
        }
    }

    public static void main(String[] args) {
        System.out.println("학생 이름");
        printString(t -> t.getName());

        System.out.println("영어 점수");
        printInt(t -> t.getEnglishScore());

        System.out.println("수학 점수");
        printInt(t -> t.getMathScore());
    }

}
