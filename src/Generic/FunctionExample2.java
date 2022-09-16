package Generic;
import java.util.Arrays;
import java.util.List;
import java.util.function.ToIntFunction;

public class FunctionExample2 {
    private static List<Student> list = Arrays.asList(
            new Student("ttt", 98, 100),
            new Student("zzz", 97, 98),
            new Student("sss", 99, 99)
    );
    public static double avg(ToIntFunction<Student> function){
        int sum = 0;
        for(Student student: list){
            sum += function.applyAsInt(student);
        }
        double avg = (double) sum / list.size();

        return avg;
    }

    public static void main(String[] args){
        double englishAvg = avg(t -> t.getEnglishScore());
        System.out.println("Average English : " + englishAvg);

        double mathAvg = avg(t -> t.getMathScore());
        System.out.println("Average Math : " + mathAvg);

    }

}

