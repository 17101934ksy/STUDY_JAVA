package Generic;

public class BoxExample {
    public static void main(String[] args){
        Box<String> box1 = new Box<String>();
        System.out.println(box1.get());
        box1.set("string");
        System.out.println(box1.get());
    }
}