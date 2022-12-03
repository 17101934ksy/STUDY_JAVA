import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        File file = new File("/home/koseyun/IdeaProjects/tutorial/src/processbuilder/Test2.java");
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fileWriter);

            writer.write("package processbuilder;"+"\n");
            writer.write("class Test2{ public void test(){}; }");
            writer.close();

//            file.createNewFile();
        } catch (IOException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}