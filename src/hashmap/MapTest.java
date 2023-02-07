package hashmap;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

public class MapTest {

    public static void main(String[] args) throws Exception, IllegalAccessException{

        Person person = new Person("kose", UUID.randomUUID().toString());

        Map<String, String> map = new HashMap<>();
        Field[] fields = person.getClass().getFields();

        for (Field field : fields) {
            System.out.println("field = " + field);
        }

        Field[] declaredFields = person.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("declaredField = " + declaredField.getName());
        }

//        Arrays.stream(declaredFields).map(f -> {
//            try {
//                return map.put(f.getName(), (String) f.get(person));
//            } catch (IllegalAccessException e) {
//                throw new RuntimeException(e);
//            }
//        }).collect(Collectors.toList());


        System.out.println("map.get(\"name\") = " + map.get("name"));

    }
}
