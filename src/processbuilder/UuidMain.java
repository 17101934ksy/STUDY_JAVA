package processbuilder;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class UuidMain {

    public static void main() {
        String uuid = UUID.randomUUID().toString();

        System.out.println(uuid);

        File file = new File("/home/koseyun/IdeaProjects/tutorial/src/processbuilder/test2.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}