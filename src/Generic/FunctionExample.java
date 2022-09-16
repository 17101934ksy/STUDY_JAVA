package Generic;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class FunctionExample {
    private static List<Student> list = Arrays.asList(new Student("kkk", 100, 92),
            new Student("ttt", 92, 100), new Student("rrr", 89, 98));

    public static void printString( Function<Student, String> function ){
        for(Student student : list){
            System.out.print(function.apply(student) + " ");
        }
        System.out.println();
    }

    public static void printInt(Function<Student, Integer> function){
        for(Student student : list){
            System.out.println(function.apply(student) + " ");
        }
    }

    public static void main(String[] args){

        System.out.println("Student Name");
        printString(t -> t.getName());

        System.out.println("English Score");
        printInt(t -> t.getEnglishScore());

        System.out.println("Math Score");
        printInt(t -> t.getMathScore());
    }

}
