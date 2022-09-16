package Generic;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.ObjIntConsumer;

public class ConsumerExample {
    public static void main(String[] args){
        Consumer<String> consumer = t -> System.out.println(t + "8");
        consumer.accept("java");
        Consumer<Integer> consumer2 = t -> System.out.println(t);
        consumer2.accept(10);

        BiConsumer<String, Integer> biConsumer = (t, v) -> System.out.println(t + v);
        biConsumer.accept("test", 3);

        DoubleConsumer doubleConsumer = d -> System.out.println("Java" + d);
        doubleConsumer.accept(8.0);

        ObjIntConsumer<String> objIntConsumer = (t, i) -> System.out.println( t + i);
        objIntConsumer.accept("java", 8);

    }
}
