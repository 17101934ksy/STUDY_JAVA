package lambda;

import Generic.Student;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {

    private static List<Student> list = Arrays.asList(
            new Student("홍", 90, 32),
            new Student("김", 90, 32),
            new Student("자", 90, 32),
            new Student("박", 90, 32)
    );

    public static double avg(Predicate<Student> predicate) {
        int count = 0, sum = 0;
        for (Student student : list) {
            if (predicate.test(student)) {
                count ++;
                sum += student.getMathScore();
            }
        }
        return (double) sum / count;
    }

    public static void main(String[] args) {
        double result = avg(t -> {
            if (t.getMathScore() > 10) {
                return true;
            }
            return false;
        });

        System.out.println("result = " + result);
    }

}
