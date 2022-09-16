package Collection;
import java.util.*;

public class HashSetExample2 {
    public static void main(String[] args){
        Set<Member> set = new HashSet<Member>();

        set.add(new Member("hong", 30));
        set.add(new Member("hong", 31));
        set.add(new Member("hong", 31));

        System.out.println(set.size());
    }
}
