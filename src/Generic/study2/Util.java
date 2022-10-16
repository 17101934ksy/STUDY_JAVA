package Generic.study2;

public class Util{
    public static <T> Box<T> boxing(T t){
        Box<T> box = new Box<T>();
        box.set(t);
        return box;
    }

    public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2){
        return (p1.getKey().equals(p2.getKey())) && (p1.getValue().equals(p2.getValue()));
    }
}