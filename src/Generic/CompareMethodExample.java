package Generic;

public class CompareMethodExample {
    public static void main(String[] args){
        Pair<String, Integer> p1 = new Pair<String, Integer>("key1", 100);
        Pair<String, Integer> p2 = new Pair<String, Integer>("key1", 100);

        boolean result1 = Util.<String, Integer>compare(p1, p2);
        if (result1){
            System.out.println("p1, p2 equal");
        }

        Pair<String, Integer> p3 = new Pair<String, Integer>("ttt", 120);
        Pair<String, Integer> p4 = new Pair<String, Integer>("t3", 120);

        boolean result2 = Util.<String, Integer>compare(p3, p4);

        if (result2) System.out.println("p3, p4 equal");

    }
}
