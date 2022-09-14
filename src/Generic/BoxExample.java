package Generic;

public class BoxExample {
    public static void main(String[] args){
        Box<String> box1 = new Box<String>();

        box1.set("hong");
        String str = box1.get();

        Box<Integer> box2 = new Box<Integer>();
        box2.set(3);
        int value = box2.get();
    }
}
