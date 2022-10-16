package Generic.study2;

public class BoxExample {
    public static void main(String[] args){
        Box<String> box = new Box();
        box.set("test");
        String name = box.get();

    }
}
