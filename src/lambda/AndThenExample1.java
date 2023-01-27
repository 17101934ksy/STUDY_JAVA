package lambda;
import Generic.Student;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class AndThenExample1 {

    private static List<Student> list = Arrays.asList(
            new Student("홍", 20, 12),
            new Student("안", 20, 12),
            new Student("임", 20, 12),
            new Student("고", 20, 12),
            new Student("김", 20, 12),
            new Student("나", 20, 12)
    );

    public int doCount(Predicate<Student> predicate) {
        int count = 0;
        for (Student student : list) {
            if (predicate.test(student)) {
                count += 1;
            }
        }
        return count;
    };

}
