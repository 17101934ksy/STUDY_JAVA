package Generic;

public class BoxMethodExample {
    public static void main(String[] args){
        Box<Integer> box1 = Util.<Integer>boxing(100);
        int intvalue = box1.get();

        Box<String> box2 = Util.<String>boxing("hello");
        String strvalue = box2.get();
    }
}
