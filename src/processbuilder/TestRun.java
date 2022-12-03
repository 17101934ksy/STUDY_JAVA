package processbuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TestRun {

    public static void main(String[] args) {


        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("/home/koseyun/IdeaProjects/tutorial/src/processbuilder/test.sh");

        try {
            // Run script
            Process process = processBuilder.start();

            // Read output
//            StringBuilder output = new StringBuilder();
//            BufferedReader reader = new BufferedReader(
//                    new InputStreamReader(process.getInputStream()));
//
//            String line;
//            while ((line = reader.readLine()) != null) {
//                output.append(line);
//            }
//
//            System.out.println(output.toString());

        } catch (Exception e) {
            System.out.println("e.getMessage() = " + e.getMessage());
            e.printStackTrace();
        }
    }
}
