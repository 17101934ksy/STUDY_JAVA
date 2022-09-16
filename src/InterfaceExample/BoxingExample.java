package InterfaceExample;

public class BoxingExample{
    public static void main(String[] args){
        Box<Integer> box = Util.<Integer>boxing(100);
        int count = box.get();
        System.out.println(count);
    }
}