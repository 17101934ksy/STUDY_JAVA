package Generic;

public class BoxMethodExample {
    public static void main(String[] args){
        Box<Integer> box1 = Util.<Integer>boxing(100);
        int boxValue = box1.get();

        Box<String> box2 = Util.boxing("hong");
        String boxvalue = box2.get();

    }
}
