package casttest;

public class Test {

    public static void main(String[] args) {

        FileMaker solveFileMaker = new PythonFileMaker();

        String sdd = solveFileMaker.makeFileName("sdd");

        System.out.println("sdd = {}" + sdd);


    }
}
