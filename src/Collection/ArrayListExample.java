package Collection;
import java.util.*;

public class ArrayListExample {
    public static void main(String[] args){
        List<String> list = new ArrayList<String>(40);

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");

        int size = list.size();
        System.out.println(size);

        String skill = list.get(2);
        System.out.println(skill);

        list.remove(2);
        skill = list.get(2);
        System.out.println(skill);
    }
}
