package lambda;

import Generic.Student;

import java.util.Arrays;
import java.util.List;
import java.util.function.ToIntFunction;

public class FunctionExample2 {

    private static List<Student> list = Arrays.asList(new Student("홍", 20, 21), new Student("세", 40, 12));

    public static double avg(ToIntFunction<Student> function) {
        int sum = 0;

        for (Student student : list) {
            sum += function.applyAsInt(student);
        }

        double avg = (double) sum / list.size();
        return avg;
    }

    public static void main(String[] args) {
        double mathAvg = avg(t -> t.getMathScore());
        double engAvg = avg(t -> t.getEnglishScore());
    }

}
