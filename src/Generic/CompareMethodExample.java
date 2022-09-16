package Generic;

public class CompareMethodExample {

    public static void main(String[] args){
        Pair<Integer, String> p1 = new Pair<Integer, String>(10, "test1");
        Pair<Integer, String> p2 = new Pair<Integer, String>(11, "test1");

        boolean pairCompare = Util.<Integer, String>compare(p1, p2);

        if (pairCompare){
            System.out.println("equals");
        }else {
            System.out.println("doesn't equal");
        }

        Pair<String, Integer> p3 = new Pair<String, Integer>("test1", 10);
        Pair<String, Integer> p4 = new Pair<String, Integer>("test1", 10);

        boolean pairCompare2 = Util.<String, Integer>compare(p3, p4);

        if (pairCompare2){
            System.out.println("equals");
        }else {
            System.out.println("doesn't equal");
        }
    }
}
