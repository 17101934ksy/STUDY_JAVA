package Collection;
import java.util.*;

public class HashSetExample {
    public static void main(String[] args){
        HashSet<String> set = new HashSet<String>();

        set.add("Java");
        set.add("JDBC");
        set.add("Servlet/JSP");
        set.add("Java");
        set.add("ttt");

        int size = set.size();

        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext()){
            String element = iterator.next();
            System.out.println(element);
        }
        System.out.println("\n");
        set.remove("Java");
        set.remove("tttt");
        System.out.println("\n");
        iterator = set.iterator();
        while(iterator.hasNext()){
            String element = iterator.next();
            System.out.println(element);
        }

        set.clear();
        if(set.isEmpty()) System.out.println("true");

    }
}
