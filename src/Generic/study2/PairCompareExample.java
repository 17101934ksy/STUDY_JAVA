package Generic.study2;

public class PairCompareExample {
    public static void main(String[] args){
        Pair<String, Integer> p1 = new Pair<String, Integer>("kkk", 100);
        Pair<String, Integer> p2 = new Pair<String, Integer>("kkk", 100);

        boolean pairEqaul = Util.<String, Integer>compare(p1, p2);
        System.out.println(pairEqaul);
    }
}
